package orderapp.controller.order;

import orderapp.model.orderdetails.ChangedOrderDetailsListObserver;
import orderapp.model.orderdetails.OrderDetails;

public interface NewOrderController {

    void newOrderInstance();

    void releaseOrderInstance();

    void addOrderDetails(OrderDetails orderDetails);

    void editOrderDetails(OrderDetails orderDetails);

    void removeOrderDetails(int id);

    void removeBeverage(int id);

    void order();

    void registerObserver(ChangedOrderDetailsListObserver observer);

    void unregisterObserver(ChangedOrderDetailsListObserver observer);
}
