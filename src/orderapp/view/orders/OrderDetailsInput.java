package orderapp.view.orders;

import orderapp.model.beverage.Beverage;
import orderapp.model.beverage.BeverageList;

import javax.swing.*;
import java.util.List;

public class OrderDetailsInput {

    public static OrderDetailsInput newOrderDetails(List<Beverage> beverages) {
        return new OrderDetailsInput(beverages);
    }

    private JPanel rootPanel;

    private JComboBox beverageField;
    private JTextField quantityField;

    private List<Beverage> beverages;

    private OrderDetailsInput(List<Beverage> beverages) {

        initComponents(beverages, 1);
    }

    private void initComponents(List<Beverage> beverages, int quantity) {

        this.beverages = beverages;
        for (Beverage beverage : beverages) {
            this.beverageField.addItem(beverage.getName());
        }

        this.quantityField.setText(String.valueOf(quantity));
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public Beverage getBeverage() {
        String name =  (String) beverageField.getSelectedItem();
        return BeverageList.getBeverageByName(beverages, name);
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
