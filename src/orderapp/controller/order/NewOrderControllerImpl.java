package orderapp.controller.order;

import orderapp.model.order.Order;
import orderapp.model.orderdetails.OrderDetails;

import java.util.ArrayList;
import java.util.List;

public class NewOrderControllerImpl implements NewOrderController {

    private List<ChangedOrderObserver> observers = new ArrayList<>();

    private Order order = new Order();

    public NewOrderControllerImpl() {
    }

    @Override
    public void add(OrderDetails newOrderDetails) {
        order.addOrderDetails(newOrderDetails);
        notifyObservers();
    }

    @Override
    public void registerObserver(ChangedOrderObserver observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    @Override
    public void unregisterObserver(ChangedOrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (ChangedOrderObserver observer : observers) {
            observer.onChangedOrder(order.getOrderDetailsList());
        }
    }
}
