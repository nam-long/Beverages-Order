package orderapp.controller.order;

import orderapp.model.order.ChangedOrderObserver;

public interface OrderController {

    void pullOrders();

    void newOrder();

    void registerObserver(ChangedOrderObserver observer);

    void unregisterObserver(ChangedOrderObserver observer);
}
