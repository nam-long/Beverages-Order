package orderapp.model.orderdetails;

import orderapp.model.DataObserver;

import java.util.List;

public interface OrderDetailsModel {

    void add(OrderDetails orderDetails);

    void edit(OrderDetails orderDetails);

    void remove(int id);

    List<OrderDetails> getAllOrderDetails();

    void registerObserver(DataObserver<OrderDetails> observer);

    void unregisterObserver(DataObserver<OrderDetails> observer);
}
