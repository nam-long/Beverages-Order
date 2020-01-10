package orderapp.controller.order;

import orderapp.model.orderdetails.OrderDetails;

import java.util.ArrayList;
import java.util.List;

public class NewOrderControllerImpl implements NewOrderController {

    List<ChangedOrderObserver> observers = new ArrayList<>();

    List<OrderDetails> orderDetailsList = new ArrayList<>();

    public NewOrderControllerImpl() {
    }

    @Override
    public void add(OrderDetails newOrderDetails) {
        OrderDetails orderDetails = searchOrderDetails(newOrderDetails.getBeverageId());
        if (orderDetails == null) {
            orderDetailsList.add(newOrderDetails);
        } else {
            int quantity = orderDetails.getQuantity() + newOrderDetails.getQuantity();
            orderDetails.setQuantity(quantity);
        }
        notifyObservers();
    }

    private OrderDetails searchOrderDetails(int beverageId) {
        for (OrderDetails orderDetails : orderDetailsList) {
            if (beverageId == orderDetails.getBeverageId())
                return orderDetails;
        }
        return null;
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
            observer.onChangedOrder(orderDetailsList);
        }
    }
}
