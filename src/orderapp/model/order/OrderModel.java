package orderapp.model.order;

import java.util.List;

public interface OrderModel {

    void add(Order order);

    void edit(Order order);

    void remove(int id);

    List<Order> getAllOrders();
}
