package orderapp.model.orderdetails;

import java.util.Objects;

public class OrderDetails {

    private int id;
    private int orderId;
    private int beverageId;
    private int condimentId;
    private float price;

    public OrderDetails() {
    }

    public OrderDetails(int orderId, int beverageId, int condimentId, float price) {
        internalInit(0, orderId, beverageId, condimentId, price);
    }

    public OrderDetails(int id, int orderId, int beverageId, int condimentId, float price) {
        internalInit(id, orderId, beverageId, condimentId, price);
    }

    private void internalInit(int id, int orderId, int beverageId, int condimentId, float price) {
        this.id = id;
        this.orderId = orderId;
        this.beverageId = beverageId;
        this.condimentId = condimentId;
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

    public int getCondimentId() {
        return condimentId;
    }

    public void setCondimentId(int condimentId) {
        this.condimentId = condimentId;
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
                condimentId == that.condimentId &&
                Float.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, beverageId, condimentId, price);
    }
}
