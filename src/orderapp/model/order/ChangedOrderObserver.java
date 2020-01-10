package orderapp.model.order;

import java.util.List;

public interface ChangedOrderObserver {

    void onChangedOrder(List<Order> orders);
}
