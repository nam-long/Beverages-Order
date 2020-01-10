package orderapp.controller.order;

import orderapp.model.order.Order;
import orderapp.model.order.OrderModel;
import orderapp.model.orderdetails.ChangedOrderDetailsListObserver;
import orderapp.model.orderdetails.OrderDetails;
import orderapp.view.orders.OrderView;

import java.util.ArrayList;
import java.util.List;

class EditOrderControllerImpl implements EditOrderController {

    private List<ChangedOrderDetailsListObserver> observers = new ArrayList<>();

    private Order order;

    private OrderModel model;
    private OrderView view;

    public EditOrderControllerImpl(OrderModel model, OrderView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public void addOrderDetails(OrderDetails newOrderDetails) {
        order.addOrderDetails(newOrderDetails);
        notifyObservers();
    }

    @Override
    public void editOrderDetails(OrderDetails orderDetails) {
        order.editOrderDetails(orderDetails);
        notifyObservers();
    }

    @Override
    public void removeOrderDetails(int id) {
        order.removeOrderDetails(id);
        notifyObservers();
    }

    @Override
    public void removeBeverage(int id) {
        order.removeBeverage(id);
        notifyObservers();
    }

    @Override
    public void registerObserver(ChangedOrderDetailsListObserver observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    @Override
    public void unregisterObserver(ChangedOrderDetailsListObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (ChangedOrderDetailsListObserver observer : observers) {
            observer.onChangedOrder(order.getOrderDetailsList());
        }
    }
}
