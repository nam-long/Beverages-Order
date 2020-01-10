package orderapp.model.orderdetails;

public class OrderDetailsModelFactory {

    private static class Singleton {
        static final OrderDetailsModelFactory INSTANCE = new OrderDetailsModelFactory();
    }

    public static OrderDetailsModelFactory getInstance() {
        return Singleton.INSTANCE;
    }

    private OrderDetailsModel model = new OrderDetailsModelImpl();

    public OrderDetailsModel getModel() {
        return model;
    }
}
