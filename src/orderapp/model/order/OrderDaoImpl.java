package orderapp.model.order;

import orderapp.model.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public void insert(Order order) {
        Database db = new Database();
        String SQL_INSERT_BEVERAGE = "INSERT INTO Orders(Time,Description) VALUES(?,?)";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT_BEVERAGE, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, order.getTime());
            ps.setString(2, order.getDescription());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                order.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void update(Order order) {
        Database db = new Database();
        final String SQL_UPDATE_ORDER_BY_ID = "UPDATE Orders SET Time=?, Description=? WHERE Id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_ORDER_BY_ID);
            ps.setLong(1, order.getTime());
            ps.setString(2, order.getDescription());
            ps.setInt(3, order.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void delete(int id) {
        Database db = new Database();
        final String SQL_DELETE_ORDER_BY_ID = "DELETE FROM Orders WHERE Id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE_ORDER_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public List<Order> getAllOrders() {

        List<Order> orders = new ArrayList<>();
        Database db = new Database();

        final String SQL_SELECT_ALL_ORDERS = "SELECT * FROM Orders";
        try {
            Statement statement = db.getConnection().createStatement();

            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_ORDERS);
            while (rs.next()) {

                int id = rs.getInt(1);
                long time = rs.getLong(2);
                String description = rs.getString(3);

                Order order = Order.newInstance(id, time, description);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.close();
        return orders;
    }
}
