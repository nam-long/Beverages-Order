package orderapp.controller.order;

import orderapp.model.order.Order;
import orderapp.model.orderdetails.ChangedOrderDetailsListObserver;
import orderapp.model.orderdetails.OrderDetails;

public interface EditOrderController {

    void setOrder(Order order);

    void addOrderDetails(OrderDetails orderDetails);

    void editOrderDetails(OrderDetails orderDetails);

    void removeOrderDetails(int id);

    void removeBeverage(int id);

    void registerObserver(ChangedOrderDetailsListObserver observer);

    void unregisterObserver(ChangedOrderDetailsListObserver observer);
}
