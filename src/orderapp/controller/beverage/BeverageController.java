package orderapp.controller.beverage;

import orderapp.model.DataObserver;
import orderapp.model.beverage.Beverage;
import orderapp.model.beverage.BeverageModel;

public interface BeverageController {

    BeverageModel getModel();

    void registerDataObserver(DataObserver<Beverage> observer);

    void pullBeverages();

    void add(Beverage beverage);

    void edit(Beverage beverage);

    void delete(int id);
}
