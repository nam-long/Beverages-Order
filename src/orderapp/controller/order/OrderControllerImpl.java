package orderapp.controller.order;

import orderapp.state.State;
import orderapp.state.StateManager;

public class OrderControllerImpl implements OrderController {

    @Override
    public void newOrder() {
        StateManager.getInstance().show(State.NEW_ORDER);
    }
}
