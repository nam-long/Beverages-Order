package orderapp.model.order;

import java.util.Objects;

public class Order {

    private int id;
    private long time;
    private String description;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                time == order.time &&
                Objects.equals(description, order.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, description);
    }
}
