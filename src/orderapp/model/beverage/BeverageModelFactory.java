package orderapp.model.beverage;

public class BeverageModelFactory {

    private static class Singleton {
        static final BeverageModelFactory INSTANCE = new BeverageModelFactory();
    }

    public static BeverageModelFactory getInstance() {
        return Singleton.INSTANCE;
    }

    private BeverageModel model = new BeverageModelImpl();

    public BeverageModel getModel() {
        return model;
    }
}
