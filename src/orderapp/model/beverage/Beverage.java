package orderapp.model.beverage;

import java.util.Objects;

public class Beverage {

    private int id;
    private String name;
    private float price;

    public Beverage() {
    }

    public Beverage(String name, float price) {
        internalInit(0, name, price);
    }

    public Beverage(int id, String name, float price) {
        internalInit(id, name, price);
    }

    private void internalInit(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beverage beverage = (Beverage) o;
        return id == beverage.id &&
                Float.compare(beverage.price, price) == 0 &&
                Objects.equals(name, beverage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
