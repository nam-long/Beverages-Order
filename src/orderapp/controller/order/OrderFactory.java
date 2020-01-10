package orderapp.controller.order;

import orderapp.view.orders.OrderView;

public class OrderFactory {

    public static OrderController newOrderController() {
        return new OrderControllerImpl();
    }

    public static NewOrderController newNewOrderController(OrderView view) {
        return new NewOrderControllerImpl(view);
    }

    private OrderFactory() {
    }
}
