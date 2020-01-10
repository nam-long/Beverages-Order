package orderapp.model.orderdetails;

import java.util.List;

public interface ChangedOrderDetailsListObserver {

    void onChangedOrder(List<OrderDetails> orderDetailsList);
}
