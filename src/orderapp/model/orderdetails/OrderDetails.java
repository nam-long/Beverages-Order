package orderapp.model.orderdetails;

import java.util.Objects;

public class OrderDetails {

    private int id;
    private int orderId;
    private int beverageId;
    private int quantity;
    private float amount;

    public OrderDetails() {
    }

    public OrderDetails(int orderId, int beverageId, int quantity, float amount) {
        internalInit(0, orderId, beverageId, quantity, amount);
    }

    public OrderDetails(int id, int orderId, int beverageId, int quantity, float amount) {
        internalInit(id, orderId, beverageId, quantity, amount);
    }

    private void internalInit(int id, int orderId, int beverageId, int quantity, float amount) {
        this.id = id;
        this.orderId = orderId;
        this.beverageId = beverageId;
        this.quantity = quantity;
        this.amount = amount;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return id == that.id &&
                orderId == that.orderId &&
                beverageId == that.beverageId &&
                quantity == that.quantity &&
                Float.compare(that.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, beverageId, quantity, amount);
    }
}
