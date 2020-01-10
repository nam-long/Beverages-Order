package orderapp.model;

import orderapp.model.order.OrderModel;
import orderapp.model.order.OrderModelImpl;

public class ModelFactory {

    private static class Singleton {
        private static final ModelFactory INSTANCE = new ModelFactory();
    }

    public static ModelFactory getInstance() {
        return Singleton.INSTANCE;
    }

    private OrderModel orderModel = new OrderModelImpl();

    private ModelFactory() {
    }

    public OrderModel getOrderModel() {
        return orderModel;
    }
}
