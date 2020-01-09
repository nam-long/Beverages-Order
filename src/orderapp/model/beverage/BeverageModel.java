package orderapp.model.beverage;

import orderapp.model.DataObserver;

import java.util.List;

public interface BeverageModel {

    void add(Beverage beverage);

    void edit(Beverage beverage);

    void remove(int id);

    List<Beverage> getAllBeverages();

    void pull();

    void registerObserver(DataObserver<Beverage> observer);

    void unregisterObserver(DataObserver<Beverage> observer);
}
