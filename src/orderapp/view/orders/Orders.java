package orderapp.view.orders;

import orderapp.controller.order.OrderController;
import orderapp.controller.order.OrderFactory;
import orderapp.model.order.Order;
import orderapp.model.order.OrderModelFactory;
import orderapp.state.Pane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        ordersTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickCount = e.getClickCount();
                if (clickCount > 1) {
                    editSelectedRow();
                }
            }
        });
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
        editSelectedRow();
    }

    private void editSelectedRow() {
        int rowIndex = getSelectedRowIndex();
        if (rowIndex != -1) {
            Order order = orderTableModel.getOrder(rowIndex);
            controller.editOrder(order);
        }
    }

    private void onDeleteClicked() {
        int rowIndex = getSelectedRowIndex();
        if (rowIndex != -1) {
            Order order = orderTableModel.getOrder(rowIndex);
            controller.deleteOrder(order.getId());
        }
    }

    private int getSelectedRowIndex() {
        int viewRowIndex = ordersTable.getSelectedRow();
        return (viewRowIndex != -1) ? ordersTable.convertRowIndexToModel(viewRowIndex) : -1;
    }

    @Override
    public void onPaneOpened(Object param) {
        controller.pullOrders();
    }
}
