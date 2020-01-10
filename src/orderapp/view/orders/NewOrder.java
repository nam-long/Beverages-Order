package orderapp.view.orders;

import com.toedter.calendar.JDateChooser;
import orderapp.controller.order.NewOrderController;
import orderapp.controller.order.OrderFactory;
import orderapp.model.ModelFactory;
import orderapp.model.beverage.Beverage;
import orderapp.model.beverage.BeverageList;
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

        controller = OrderFactory.newNewOrderController(ModelFactory.getInstance().getOrderModel(), this);

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
            controller.add(orderDetails);
        }
    }

    private void onEditClicked() {
    }

    private void onRemoveClicked() {
    }

    private void onOrderClicked() {
        controller.order();
    }

    private void onCancelClicked() {
        StateManager.getInstance().show(State.ORDER);
    }

    @Override
    public void onPaneOpened() {
    }

    @Override
    public void onPaneClosed() {
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
