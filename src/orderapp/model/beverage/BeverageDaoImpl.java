package orderapp.model.beverage;

import orderapp.model.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BeverageDaoImpl implements BeverageDao {

    @Override
    public void insert(Beverage beverage) {
        Database db = new Database();
        String SQL_INSERT_BEVERAGE = "INSERT INTO Beverages(Name,Price) VALUES(?,?)";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT_BEVERAGE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, beverage.getName());
            ps.setFloat(2, beverage.getPrice());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                beverage.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void update(Beverage beverage) {
        Database db = new Database();
        final String SQL_UPDATE_BEVERAGE_BY_ID = "UPDATE Beverages SET Name=?, Price=? WHERE Id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_BEVERAGE_BY_ID);
            ps.setString(1, beverage.getName());
            ps.setFloat(2, beverage.getPrice());
            ps.setInt(3, beverage.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void delete(int id) {
        Database db = new Database();
        final String SQL_DELETE_BEVERAGE_BY_ID = "DELETE FROM Beverages WHERE Id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE_BEVERAGE_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public List<Beverage> getAllBeverages() {
        List<Beverage> beverages = new ArrayList<>();
        Database db = new Database();

        final String SQL_SELECT_ALL_BEVERAGES = "SELECT * FROM Beverages";
        try {
            Statement statement = db.getConnection().createStatement();

            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_BEVERAGES);
            while (rs.next()) {

                int id = rs.getInt(1);
                String name = rs.getString(2);
                float price = rs.getFloat(3);

                Beverage beverage = new Beverage(id, name, price);
                beverages.add(beverage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.close();
        return beverages;
    }
}
