package orderapp.model.beverage;

import java.util.List;

public interface BeverageDao {

    void insert(Beverage beverage);

    void update(Beverage beverage);

    void delete(int id);

    List<Beverage> getAllBeverages();
}
