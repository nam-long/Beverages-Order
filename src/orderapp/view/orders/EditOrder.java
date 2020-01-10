package orderapp.view.orders;

import com.toedter.calendar.JDateChooser;
import orderapp.state.Pane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class EditOrder extends Pane {

    private JPanel rootPanel;

    private JTextField idField;
    private JDateChooser dateChooser;
    private JTextArea descriptionField;
    private JButton addButton;
    private JButton editButton;
    private JButton removeButton;
    private JTable orderDetailsTable;
    private JButton saveButton;
    private JButton cancelButton;
    private JLabel amountField;

    public EditOrder() {
        initUiComponents();
    }

    private void createUIComponents() {
        dateChooser = new JDateChooser(new Date(System.currentTimeMillis()));
    }

    private void initUiComponents() {

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    private void onNewClicked() {
    }

    private void onEditClicked() {
    }

    private void onRemoveClicked() {
    }

    private void onSaveClicked() {
    }

    @Override
    public void onPaneOpened() {
    }

    @Override
    public void onPaneClosed() {
    }
}
