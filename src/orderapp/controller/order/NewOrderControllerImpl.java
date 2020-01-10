package orderapp.controller.order;

import orderapp.model.order.Order;
import orderapp.model.order.OrderModel;
import orderapp.model.order.OrderModelImpl;
import orderapp.model.orderdetails.OrderDetails;
import orderapp.state.State;
import orderapp.state.StateManager;

import java.util.ArrayList;
import java.util.List;

public class NewOrderControllerImpl implements NewOrderController {

    private List<ChangedOrderObserver> observers = new ArrayList<>();

    private Order order = new Order();

    private OrderModel model = new OrderModelImpl();

    public NewOrderControllerImpl() {
    }

    @Override
    public void add(OrderDetails newOrderDetails) {
        order.addOrderDetails(newOrderDetails);
        notifyObservers();
    }

    @Override
    public void order() {
        model.add(order);
        StateManager.getInstance().show(State.ORDER);
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
