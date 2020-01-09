package orderapp.model.order;

import java.util.List;

public interface OrderDao {

    void insert(Order order);

    void update(Order order);

    void delete(int id);

    List<Order> getAllOrders();
}
