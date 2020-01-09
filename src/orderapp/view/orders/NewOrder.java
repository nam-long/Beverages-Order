package orderapp.view.orders;

import com.toedter.calendar.JDateChooser;
import orderapp.state.Pane;
import orderapp.state.State;
import orderapp.state.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class NewOrder extends Pane {

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

    public NewOrder() {

        setComponent(rootPanel);

        initUiComponents();
    }

    private void createUIComponents() {
        dateChooser = new JDateChooser(new Date(System.currentTimeMillis()));
    }

    private void initUiComponents() {

        orderDetailsModel = new OrderDetailsModel();
        orderDetailsTable.setModel(orderDetailsModel);

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
    }

    private void onEditClicked() {
    }

    private void onRemoveClicked() {
    }

    private void onOrderClicked() {
        StateManager.getInstance().show(State.ORDER);
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
}
