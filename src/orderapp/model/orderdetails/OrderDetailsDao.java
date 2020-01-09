package orderapp.model.orderdetails;

import java.util.List;

public interface OrderDetailsDao {

    void insert(OrderDetails orderDetails);

    void update(OrderDetails orderDetails);

    void delete(int id);

    List<OrderDetails> getAllOrderDetails();
}
