package orderapp.model.order;

import orderapp.model.orderdetails.*;

import java.util.ArrayList;
import java.util.List;

public class OrderModelImpl implements OrderModel {

    private List<ChangedOrderObserver> observers = new ArrayList<>();

    @Override
    public void pullOrders() {
        notifyObservers();
    }

    @Override
    public void add(Order order) {

        OrderDao orderDao = new OrderDaoImpl();
        orderDao.insert(order);

        OrderDetailsModel model = new OrderDetailsModelImpl();
        List<OrderDetails> orderDetailsList = order.getOrderDetailsList();
        for (OrderDetails orderDetails : orderDetailsList) {
            orderDetails.setOrderId(order.getId());
            model.add(orderDetails);
        }

        notifyObservers();
    }

    @Override
    public void edit(Order order) {
        notifyObservers();
    }

    @Override
    public void remove(int id) {
        notifyObservers();
    }

    @Override
    public List<Order> getAllOrders() {
        OrderDao dao = new OrderDaoImpl();
        return dao.getAllOrders();
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
        List<Order> orders = getAllOrders();
        for (ChangedOrderObserver observer : observers) {
            observer.onChangedOrder(orders);
        }
    }
}
