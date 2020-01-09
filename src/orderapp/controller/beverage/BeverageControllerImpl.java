package orderapp.controller.beverage;

import orderapp.model.DataObserver;
import orderapp.model.beverage.Beverage;
import orderapp.model.beverage.BeverageModel;

class BeverageControllerImpl implements BeverageController {

    private BeverageModel model;

    BeverageControllerImpl(BeverageModel model) {
        this.model = model;
    }

    @Override
    public BeverageModel getModel() {
        return model;
    }

    @Override
    public void registerDataObserver(DataObserver<Beverage> observer) {
        model.registerObserver(observer);
    }

    @Override
    public void pullBeverages() {
        model.pull();
    }

    @Override
    public void add(Beverage beverage) {
        model.add(beverage);
    }

    @Override
    public void edit(Beverage beverage) {
        model.edit(beverage);
    }

    @Override
    public void delete(int id) {
        model.remove(id);
    }
}
