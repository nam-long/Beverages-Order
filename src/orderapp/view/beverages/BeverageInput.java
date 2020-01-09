package orderapp.view.beverages;

import orderapp.model.beverage.Beverage;

import javax.swing.*;

public class BeverageInput {

    private JPanel rootPanel;

    private JTextField nameField;
    private JTextField priceField;

    public static BeverageInput newBeverage() {
        return new BeverageInput();
    }

    public static BeverageInput editBeverage(Beverage beverage) {
        return new BeverageInput(beverage);
    }

    private BeverageInput() {
    }

    private BeverageInput(Beverage beverage) {
        nameField.setText(beverage.getName());
        priceField.setText(String.valueOf(beverage.getPrice()));
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public String getName() {
        return nameField.getText().trim();
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
}
