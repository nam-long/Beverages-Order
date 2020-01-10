package orderapp.model.orderdetails;

import orderapp.model.DataObserver;

import java.util.ArrayList;
import java.util.List;

class OrderDetailsModelImpl implements OrderDetailsModel {

    private List<DataObserver<OrderDetails>> observers = new ArrayList<>();

    @Override
    public void add(OrderDetails orderDetails) {
        OrderDetailsDao dao = new OrderDetailsDaoImpl();
        dao.insert(orderDetails);
        notifyObservers();
    }

    @Override
    public void edit(OrderDetails orderDetails) {
        OrderDetailsDao dao = new OrderDetailsDaoImpl();
        dao.update(orderDetails);
        notifyObservers();
    }

    @Override
    public void remove(int id) {
        OrderDetailsDao dao = new OrderDetailsDaoImpl();
        dao.delete(id);
        notifyObservers();
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        OrderDetailsDao dao = new OrderDetailsDaoImpl();
        return dao.getAllOrderDetails();
    }

    @Override
    public void registerObserver(DataObserver<OrderDetails> observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    @Override
    public void unregisterObserver(DataObserver<OrderDetails> observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        List<OrderDetails> orderDetails = getAllOrderDetails();
        for (DataObserver<OrderDetails> observer : observers) {
            observer.onChangedData(orderDetails);
        }
    }
}
