package orderapp.view.orders;

import orderapp.controller.order.OrderController;
import orderapp.controller.order.OrderFactory;
import orderapp.state.Pane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Orders extends Pane {

    private JPanel rootPanel;
    private JTable ordersTable;
    private JButton newButton;
    private JButton editButton;
    private JButton deleteButton;

    private OrderController controller;

    public Orders() {

        controller = OrderFactory.newOrderController();

        setComponent(rootPanel);

        initUiComponents();
    }

    private void initUiComponents() {

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
    }

    private void onDeleteClicked() {
    }

    @Override
    public void onPaneOpened() {
    }

    @Override
    public void onPaneClosed() {
    }
}
