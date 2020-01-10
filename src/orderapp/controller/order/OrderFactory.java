package orderapp.controller.order;

import orderapp.model.order.OrderModel;
import orderapp.view.orders.OrderView;

public class OrderFactory {

    public static OrderController newOrderController(OrderModel model) {
        return new OrderControllerImpl(model);
    }

    public static NewOrderController newNewOrderController(OrderModel model, OrderView view) {
        return new NewOrderControllerImpl(model, view);
    }

    public static EditOrderController newEditOrderController(OrderModel model, OrderView view) {
        return new EditOrderControllerImpl(model, view);
    }

    private OrderFactory() {
    }
}
