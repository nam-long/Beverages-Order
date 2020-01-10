package orderapp.controller.order;

import orderapp.model.order.ChangedOrderObserver;
import orderapp.model.order.Order;

public interface OrderController {

    void pullOrders();

    void newOrder();

    void editOrder(Order order);

    void deleteOrder(int id);

    void registerObserver(ChangedOrderObserver observer);

    void unregisterObserver(ChangedOrderObserver observer);
}
