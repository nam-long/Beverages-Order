package orderapp.model.beverage;

import orderapp.model.DataObserver;

import java.util.ArrayList;
import java.util.List;

public class BeverageList implements DataObserver<Beverage> {

    private static class Singleton {
        private static final BeverageList INSTANCE = new BeverageList();
    }

    public static BeverageList getInstance() {
        return Singleton.INSTANCE;
    }

    private List<Beverage> beverages = new ArrayList<>();

    private BeverageModel model;

    private BeverageList() {
    }

    public void initiate(BeverageModel model) {
        this.model = model;
        this.model.registerObserver(this);
        this.model.pullBeverages();
    }

    public BeverageModel getModel() {
        return model;
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public Beverage getBeverageById(int id) {
        for (Beverage beverage : beverages) {
            if (beverage.getId() == id)
                return beverage;
        }
        return null;
    }

    public Beverage getBeverageByName(String name) {
        return getBeverageByName(beverages, name);
    }

    public static Beverage getBeverageByName(List<Beverage> beverages, String name) {
        for (Beverage beverage : beverages) {
            if (beverage.getName().equalsIgnoreCase(name)) {
                return beverage;
            }
        }
        return null;
    }

    @Override
    public void onChangedData(List<Beverage> beverages) {
        this.beverages.clear();
        this.beverages.addAll(beverages);
    }
}
