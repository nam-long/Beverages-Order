package orderapp.controller.order;

import orderapp.model.orderdetails.OrderDetails;

import java.util.List;

public interface ChangedOrderDetailsListObserver {

    void onChangedOrder(List<OrderDetails> orderDetailsList);
}
