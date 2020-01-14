package orderapp.view.orders;

import orderapp.model.beverage.Beverage;
import orderapp.model.beverage.BeverageList;
import orderapp.model.orderdetails.OrderDetails;

import javax.swing.*;
import java.util.List;

public class OrderDetailsInput {

    public static OrderDetailsInput newOrderDetails(List<Beverage> beverages) {
        return new OrderDetailsInput(beverages);
    }

    public static OrderDetailsInput editOrderDetails(List<Beverage> beverages, OrderDetails orderDetails) {
        return new OrderDetailsInput(beverages, orderDetails);
    }

    private JPanel rootPanel;

    private JComboBox beverageField;
    private JTextField quantityField;

    private List<Beverage> beverages;

    private OrderDetailsInput(List<Beverage> beverages) {

        initComponents(beverages, null, 1);
    }

    private OrderDetailsInput(List<Beverage> beverages, OrderDetails orderDetails) {

        initComponents(beverages, orderDetails, orderDetails.getQuantity());
    }

    private void initComponents(List<Beverage> beverages, OrderDetails orderDetails, int quantity) {

        this.beverages = beverages;
        for (Beverage beverage : beverages) {
            this.beverageField.addItem(beverage.getName());
        }

        if (orderDetails != null) {
            beverageField.setSelectedItem(BeverageList.getInstance().getBeverageById(orderDetails.getBeverageId()).getName());
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

    public OrderDetails getNewOrderDetails() {
        Beverage beverage = getBeverage();
        int quantity = getQuantity();
        OrderDetails orderDetails = new OrderDetails(0, beverage.getId(), beverage.getPrice(), quantity);
        return orderDetails;
    }
}
