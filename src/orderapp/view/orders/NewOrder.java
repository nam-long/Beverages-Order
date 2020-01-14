package orderapp.view.orders;

import com.toedter.calendar.JDateChooser;
import orderapp.controller.order.NewOrderController;
import orderapp.controller.order.OrderFactory;
import orderapp.model.beverage.Beverage;
import orderapp.model.beverage.BeverageList;
import orderapp.model.order.OrderModelFactory;
import orderapp.model.orderdetails.OrderDetails;
import orderapp.state.Pane;
import orderapp.state.State;
import orderapp.state.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class NewOrder extends Pane implements OrderView {

    private JPanel rootPanel;

    private JTextField orderIdField;
    private JDateChooser dateChooser;
    private JTable orderDetailsTable;
    private OrderDetailsModel orderDetailsModel;
    private JButton addButton;
    private JButton removeButton;
    private JButton orderButton;
    private JButton cancelButton;
    private JButton editButton;
    private JLabel amountLabel;
    private JTextArea descriptionField;

    private NewOrderController controller;

    public NewOrder() {

        controller = OrderFactory.newNewOrderController(OrderModelFactory.getInstance().getModel(), this);

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

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOrderClicked();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancelClicked();
            }
        });
    }

    private void resetUiComponents() {
        dateChooser.setDate(new Date(System.currentTimeMillis()));
        descriptionField.setText("");
    }

    private void onAddClicked() {

        OrderDetailsInput input = OrderDetailsInput.newOrderDetails(BeverageList.getInstance().getBeverages());

        int option = JOptionPane.showConfirmDialog(
                rootPanel,
                input.getRootPanel(),
                "Add Beverage",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            Beverage beverage = input.getBeverage();
            int quantity = input.getQuantity();

            OrderDetails orderDetails = new OrderDetails(0, beverage.getId(), beverage.getPrice(), quantity);
            controller.addOrderDetails(orderDetails);
        }
    }

    private void onEditClicked() {

        int viewRowIndex = orderDetailsTable.getSelectedRow();
        if (viewRowIndex == -1) {
            return;
        }

        int rowIndex = orderDetailsTable.convertRowIndexToModel(viewRowIndex);
        OrderDetailsInput input = OrderDetailsInput.editOrderDetails(
                BeverageList.getInstance().getBeverages(),
                orderDetailsModel.getOrderDetails(rowIndex));

        int option = JOptionPane.showConfirmDialog(
                rootPanel,
                input.getRootPanel(),
                "Edit Order",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            Beverage beverage = input.getBeverage();
            int quantity = input.getQuantity();

            OrderDetails orderDetails = new OrderDetails(0, beverage.getId(), beverage.getPrice(), quantity);
            controller.editOrderDetails(orderDetails);
        }
    }

    private void onRemoveClicked() {

        int viewRowIndex = orderDetailsTable.getSelectedRow();
        if (viewRowIndex == -1) {
            return;
        }

        int rowIndex = orderDetailsTable.convertRowIndexToModel(viewRowIndex);
        OrderDetails orderDetails = orderDetailsModel.getOrderDetails(rowIndex);
        controller.removeBeverage(orderDetails.getBeverageId());
    }

    private void onOrderClicked() {
        controller.order();
    }

    private void onCancelClicked() {
        StateManager.getInstance().show(State.ORDER);
    }

    @Override
    public void onPaneOpened(Object param) {
        resetUiComponents();
        controller.newOrderInstance();
    }

    @Override
    public void onPaneClosed() {
        controller.releaseOrderInstance();
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public long getTime() {
        return dateChooser.getDate().getTime();
    }

    @Override
    public String getDescription() {
        return descriptionField.getText().trim();
    }
}
