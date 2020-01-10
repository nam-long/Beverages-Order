package orderapp.model.order;

import orderapp.model.orderdetails.OrderDetails;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private long time;
    private String description;
    private List<OrderDetails> orderDetailsList = new ArrayList<>();

    public Order() {
    }

    public Order(long time, String description) {
        internalInit(0, time, description);
    }

    public Order(int id, long time, String description) {
        internalInit(id, time, description);
    }

    private void internalInit(int id, long time, String description) {
        this.id = id;
        this.time = time;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    public void addOrderDetails(OrderDetails newOrderDetails) {
        OrderDetails orderDetails = searchOrderDetails(newOrderDetails.getBeverageId());
        if (orderDetails == null) {
            orderDetailsList.add(newOrderDetails);
        } else {
            int quantity = orderDetails.getQuantity() + newOrderDetails.getQuantity();
            orderDetails.setQuantity(quantity);
        }
    }

    public void editOrderDetails(OrderDetails editedOrderDetails) {
        OrderDetails orderDetails = searchOrderDetails(editedOrderDetails.getBeverageId());
        if (orderDetails != null) {
            int quantity = editedOrderDetails.getQuantity();
            float price = orderDetails.getAmount() / orderDetails.getQuantity();
            orderDetails.setQuantity(quantity);
            orderDetails.setAmount(editedOrderDetails.getQuantity() * price);
        }
    }

    public void removeOrderDetails(int id) {
        for (OrderDetails orderDetails : orderDetailsList) {
            if (orderDetails.getId() == id) {
                orderDetailsList.remove(orderDetails);
                return;
            }
        }
    }

    public void removeBeverage(int id) {
        for (OrderDetails orderDetails : orderDetailsList) {
            if (orderDetails.getBeverageId() == id) {
                orderDetailsList.remove(orderDetails);
                return;
            }
        }
    }

    private OrderDetails searchOrderDetails(int beverageId) {
        for (OrderDetails orderDetails : orderDetailsList) {
            if (beverageId == orderDetails.getBeverageId())
                return orderDetails;
        }
        return null;
    }
}
