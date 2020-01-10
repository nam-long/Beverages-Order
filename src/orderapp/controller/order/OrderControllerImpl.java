package orderapp.controller.order;

import orderapp.model.order.ChangedOrderObserver;
import orderapp.model.order.OrderModel;
import orderapp.state.State;
import orderapp.state.StateManager;

public class OrderControllerImpl implements OrderController {

    private OrderModel model;

    public OrderControllerImpl(OrderModel model) {
        this.model = model;
    }

    @Override
    public void pullOrders() {
        model.pullOrders();
    }

    @Override
    public void newOrder() {
        StateManager.getInstance().show(State.NEW_ORDER);
    }

    @Override
    public void deleteOrder(int id) {
        model.remove(id);
    }

    @Override
    public void registerObserver(ChangedOrderObserver observer) {
        model.registerObserver(observer);
    }

    @Override
    public void unregisterObserver(ChangedOrderObserver observer) {
        model.unregisterObserver(observer);
    }
}
