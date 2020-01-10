package orderapp.view.orders;

import javax.swing.*;

public class OrderDetailsInput {

    public static OrderDetailsInput newOrderDetails() {
        return new OrderDetailsInput();
    }

    private JPanel rootPanel;

    private JComboBox beverageField;
    private JTextField priceField;
    private JTextField quantityField;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public String getBeverage() {
        return (String) beverageField.getSelectedItem();
    }

    public float getPrice() {
        float price = 0;
        try {
            price = Float.parseFloat(priceField.getText().trim());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return price;
    }

    public int getQuantity() {
        int quantity = 0;
        try {
            quantity = Integer.parseInt(quantityField.getText().trim());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return quantity;
    }
}
