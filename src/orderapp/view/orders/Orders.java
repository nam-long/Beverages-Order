package orderapp.view.orders;

import orderapp.state.Pane;
import orderapp.state.State;
import orderapp.state.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Orders extends Pane {

    private JPanel rootPanel;
    private JTable ordersTable;
    private JButton newButton;
    private JButton editButton;
    private JButton deleteButton;

    public Orders() {

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
        StateManager.getInstance().show(State.NEW_ORDER);
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
