package orderapp.controller.beverage;

import orderapp.model.beverage.BeverageModel;

public class BeverageControllerFactory {

    public static BeverageController newInstance(BeverageModel model) {
        return new BeverageControllerImpl(model);
    }

    private BeverageControllerFactory() {
    }
}
