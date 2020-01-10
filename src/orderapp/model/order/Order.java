package orderapp.model.order;

import orderapp.model.orderdetails.OrderDetails;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private long time;
    private String description;
    private List<OrderDetails> orderDetailsList = new ArrayList<>();

    public static Order newInstance() {
        return new Order();
    }

    public static Order newInstance(int id, long time, String description) {
        return new Order(id, time, description);
    }

    private Order() {
    }

    private Order(int id, long time, String description) {
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
        OrderDetails orderDetails = searchOrderDetailsByBeverageId(newOrderDetails.getBeverageId());
        if (orderDetails == null) {
            orderDetailsList.add(newOrderDetails);
        } else {
            float price = orderDetails.getAmount() / orderDetails.getQuantity();
            int quantity = orderDetails.getQuantity() + newOrderDetails.getQuantity();
            orderDetails.setQuantity(quantity);
            orderDetails.setAmount(price * quantity);
        }
    }

    public void editOrderDetails(OrderDetails newOrderDetails) {
        OrderDetails orderDetails = searchOrderDetailsByBeverageId(newOrderDetails.getBeverageId());
        if (orderDetails != null) {
            int quantity = newOrderDetails.getQuantity();
            float oldPrice = orderDetails.getAmount() / orderDetails.getQuantity();
            orderDetails.setQuantity(quantity);
            orderDetails.setAmount(oldPrice * quantity);
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

    private OrderDetails searchOrderDetailsByBeverageId(int beverageId) {
        for (OrderDetails orderDetails : orderDetailsList) {
            if (beverageId == orderDetails.getBeverageId())
                return orderDetails;
        }
        return null;
    }
}
