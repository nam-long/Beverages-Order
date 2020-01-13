package orderapp.view.orders;

import com.toedter.calendar.JDateChooser;
import orderapp.controller.order.EditOrderController;
import orderapp.controller.order.OrderFactory;
import orderapp.model.order.Order;
import orderapp.model.order.OrderModelFactory;
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
    }

    private void onEditClicked() {
    }

    private void onRemoveClicked() {
    }

    private void onSaveClicked() {
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
    public void onPaneClosed() {
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public long getTime() {
        return 0;
    }

    @Override
    public void setTime(long time) {

    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setDescription(String description) {
    }
}
