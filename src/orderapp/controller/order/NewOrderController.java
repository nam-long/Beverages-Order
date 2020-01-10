package orderapp.controller.order;

import orderapp.model.orderdetails.OrderDetails;

public interface NewOrderController {

    void add(OrderDetails orderDetails);

    void registerObserver(ChangedOrderObserver observer);

    void unregisterObserver(ChangedOrderObserver observer);
}