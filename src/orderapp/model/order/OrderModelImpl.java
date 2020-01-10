package orderapp.model.order;

import orderapp.model.orderdetails.*;

import java.util.ArrayList;
import java.util.List;

public class OrderModelImpl implements OrderModel {

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
    }

    @Override
    public void edit(Order order) {
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        return orders;
    }
}
