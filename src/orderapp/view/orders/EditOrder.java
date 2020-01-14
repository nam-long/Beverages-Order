package orderapp.view.orders;

import com.toedter.calendar.JDateChooser;
import orderapp.controller.order.EditOrderController;
import orderapp.controller.order.OrderFactory;
import orderapp.model.beverage.Beverage;
import orderapp.model.beverage.BeverageList;
import orderapp.model.order.Order;
import orderapp.model.order.OrderModelFactory;
import orderapp.model.orderdetails.OrderDetails;
import orderapp.state.Pane;
import orderapp.state.State;
import orderapp.state.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class EditOrder extends Pane implements OrderView {

    private JPanel rootPanel;

    private JTextField idField;
    private JDateChooser dateChooser;
    private JTextArea descriptionField;
    private JButton addButton;
    private JButton editButton;
    private JButton removeButton;
    private JTable orderDetailsTable;
    private OrderDetailsModel orderDetailsModel;
    private JButton saveButton;
    private JButton cancelButton;
    private JLabel amountField;

    private EditOrderController controller;

    public EditOrder() {
        controller = OrderFactory.newEditOrderController(OrderModelFactory.getInstance().getModel(), this);
        setComponent(rootPanel);
        initUiComponents();
    }

    private void createUIComponents() {
        dateChooser = new JDateChooser(new Date(System.currentTimeMillis()));
    }

    private void initUiComponents() {

        orderDetailsModel = new OrderDetailsModel();
        orderDetailsTable.setModel(orderDetailsModel);

        controller.registerObserver(orderDetailsModel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddClicked();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onEditClicked();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRemoveClicked();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSaveClicked();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancelClicked();
            }
        });
    }

    private void onAddClicked() {
        OrderDetailsInput input = OrderDetailsInput.newOrderDetails(BeverageList.getInstance().getBeverages());

        int option = JOptionPane.showConfirmDialog(
                rootPanel,
                input.getRootPanel(),
                "Add Beverage",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            int orderId = Integer.parseInt(idField.getText());
            Beverage beverage = input.getBeverage();
            int quantity = input.getQuantity();

            controller.addOrderDetails(new OrderDetails(orderId, beverage.getId(), beverage.getPrice(), quantity));
        }
    }

    private void onEditClicked() {
        int rowIndex = getSelectedRowIndex();
        if (rowIndex != -1) {
            OrderDetailsInput input = OrderDetailsInput.editOrderDetails(
                    BeverageList.getInstance().getBeverages(),
                    orderDetailsModel.getOrderDetails(rowIndex));

            int option = JOptionPane.showConfirmDialog(
                    rootPanel,
                    input.getRootPanel(),
                    "Edit Order",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (option == JOptionPane.OK_OPTION) {
                OrderDetails orderDetails = input.getNewOrderDetails();
                controller.editOrderDetails(orderDetails);
            }
        }
    }

    private void onRemoveClicked() {
        int rowIndex = getSelectedRowIndex();
        if (rowIndex != -1) {
            OrderDetails orderDetails = orderDetailsModel.getOrderDetails(rowIndex);
            controller.removeBeverage(orderDetails.getBeverageId());
        }
    }

    private int getSelectedRowIndex() {
        int viewRowIndex = orderDetailsTable.getSelectedRow();
        return viewRowIndex != -1 ? orderDetailsTable.convertRowIndexToModel(viewRowIndex) : -1;
    }

    private void onSaveClicked() {
        controller.save();
    }

    private void onCancelClicked() {
        StateManager.getInstance().show(State.ORDER);
    }

    @Override
    public void onPaneOpened(Object param) {

        Order order = (Order) param;

        idField.setText(String.valueOf(order.getId()));
        dateChooser.setDate(new Date(order.getTime()));
        descriptionField.setText(order.getDescription());

        controller.setOrder(order);
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public long getTime() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
