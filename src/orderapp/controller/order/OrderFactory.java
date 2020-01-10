package orderapp.controller.order;

import orderapp.model.orderdetails.OrderDetails;

public class OrderFactory {

    public static OrderController newOrderController() {
        return new OrderControllerImpl();
    }

    public static NewOrderController newNewOrderController() {
        return new NewOrderControllerImpl();
    }

    private OrderFactory() {
    }
}
