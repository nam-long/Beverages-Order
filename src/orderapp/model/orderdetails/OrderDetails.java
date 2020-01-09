package orderapp.model.orderdetails;

import java.util.Objects;

public class OrderDetails {

    private int id;
    private int orderId;
    private int beverageId;
    private float price;

    public OrderDetails() {
    }

    public OrderDetails(int orderId, int beverageId, float price) {
        internalInit(0, orderId, beverageId, price);
    }

    public OrderDetails(int id, int orderId, int beverageId, float price) {
        internalInit(id, orderId, beverageId, price);
    }

    private void internalInit(int id, int orderId, int beverageId, float price) {
        this.id = id;
        this.orderId = orderId;
        this.beverageId = beverageId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBeverageId() {
        return beverageId;
    }

    public void setBeverageId(int beverageId) {
        this.beverageId = beverageId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return id == that.id &&
                orderId == that.orderId &&
                beverageId == that.beverageId &&
                Float.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, beverageId, price);
    }
}
