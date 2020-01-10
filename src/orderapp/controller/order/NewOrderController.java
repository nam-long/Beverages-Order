package orderapp.controller.order;

import orderapp.model.orderdetails.OrderDetails;

public interface NewOrderController {

    void add(OrderDetails orderDetails);

    void order();

    void registerObserver(ChangedOrderDetailsListObserver observer);

    void unregisterObserver(ChangedOrderDetailsListObserver observer);
}
