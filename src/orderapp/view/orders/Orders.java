package orderapp.view.orders;

import orderapp.controller.order.OrderController;
import orderapp.controller.order.OrderFactory;
import orderapp.model.order.Order;
import orderapp.model.order.OrderModelFactory;
import orderapp.state.Pane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Orders extends Pane {

    private JPanel rootPanel;
    private JTable ordersTable;
    private OrderTableModel orderTableModel;
    private JButton newButton;
    private JButton editButton;
    private JButton deleteButton;

    private OrderController controller;

    public Orders() {

        controller = OrderFactory.newOrderController(OrderModelFactory.getInstance().getModel());

        setComponent(rootPanel);

        initUiComponents();
    }

    private void initUiComponents() {

        orderTableModel = new OrderTableModel();
        ordersTable.setModel(orderTableModel);
        controller.registerObserver(orderTableModel);

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onNewClicked();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onEditClicked();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDeleteClicked();
            }
        });
    }

    private void onNewClicked() {
        controller.newOrder();
    }

    private void onEditClicked() {
        int viewRowIndex = ordersTable.getSelectedRow();
        if (viewRowIndex != -1) {
            int rowIndex = ordersTable.convertRowIndexToModel(viewRowIndex);
            Order order = orderTableModel.getOrder(rowIndex);
            controller.editOrder(order);
        }
    }

    private void onDeleteClicked() {
        int viewRowIndex = ordersTable.getSelectedRow();
        if (viewRowIndex != -1) {
            int rowIndex = ordersTable.convertRowIndexToModel(viewRowIndex);
            Order order = orderTableModel.getOrder(rowIndex);
            controller.deleteOrder(order.getId());
        }
    }

    @Override
    public void onPaneOpened(Object param) {
        controller.pullOrders();
    }

    @Override
    public void onPaneClosed() {
    }
}
