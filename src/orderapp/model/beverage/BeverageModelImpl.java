package orderapp.model.beverage;

import orderapp.model.DataObserver;

import java.util.ArrayList;
import java.util.List;

public class BeverageModelImpl implements BeverageModel {

    private List<DataObserver<Beverage>> observers = new ArrayList<>();

    @Override
    public void add(Beverage beverage) {
        BeverageDao dao = new BeverageDaoImpl();
        dao.insert(beverage);
        notifyObservers();
    }

    @Override
    public void edit(Beverage beverage) {
        BeverageDao dao = new BeverageDaoImpl();
        dao.update(beverage);
        notifyObservers();
    }

    @Override
    public void remove(int id) {
        BeverageDao dao = new BeverageDaoImpl();
        dao.delete(id);
        notifyObservers();
    }

    @Override
    public List<Beverage> getAllBeverages() {
        BeverageDao dao = new BeverageDaoImpl();
        List<Beverage> beverages = dao.getAllBeverages();
        return beverages;
    }

    @Override
    public void pullBeverages() {
        notifyObservers();
    }

    @Override
    public void registerObserver(DataObserver<Beverage> observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    @Override
    public void unregisterObserver(DataObserver<Beverage> observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        List<Beverage> beverages = getAllBeverages();
        for (DataObserver<Beverage> observer: observers) {
            observer.onChangedData(beverages);
        }
    }
}
