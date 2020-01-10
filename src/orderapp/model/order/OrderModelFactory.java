package orderapp.model.order;

public class OrderModelFactory {

    private static class Singleton {
        static final OrderModelFactory INSTANCE = new OrderModelFactory();
    }

    public static OrderModelFactory getInstance() {
        return Singleton.INSTANCE;
    }

    private OrderModel model = new OrderModelImpl();

    public OrderModel getModel() {
        return model;
    }
}
