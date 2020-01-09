package orderapp.model.orderdetails;

import orderapp.model.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDaoImpl implements OrderDetailsDao {

    @Override
    public void insert(OrderDetails orderDetails) {

        Database db = new Database();
        String SQL_INSERT_ORDER_DETAILS = "INSERT INTO OrderDetails(OrderId,BeverageId,Price) VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT_ORDER_DETAILS, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, orderDetails.getOrderId());
            ps.setInt(2, orderDetails.getBeverageId());
            ps.setFloat(3, orderDetails.getPrice());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                orderDetails.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void update(OrderDetails orderDetails) {

        Database db = new Database();
        final String SQL_UPDATE_ORDER_DETAILS_BY_ID = "UPDATE OrderDetails SET OrderId=?, BeverageId=?,Price=? WHERE Id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_ORDER_DETAILS_BY_ID);
            ps.setInt(1, orderDetails.getOrderId());
            ps.setInt(2, orderDetails.getBeverageId());
            ps.setFloat(3, orderDetails.getPrice());
            ps.setInt(4, orderDetails.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void delete(int id) {

        Database db = new Database();
        final String SQL_DELETE_ORDER_DETAILS_BY_ID = "DELETE FROM OrderDetails WHERE Id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE_ORDER_DETAILS_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {

        List<OrderDetails> orderDetailsList = new ArrayList<>();
        Database db = new Database();

        final String SQL_SELECT_ALL_ORDER_DETAILS = "SELECT * FROM OrderDetails";
        try {
            Statement statement = db.getConnection().createStatement();

            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_ORDER_DETAILS);
            while (rs.next()) {

                int id = rs.getInt(1);
                int orderId = rs.getInt(2);
                int beverageId = rs.getInt(3);
                float price = rs.getFloat(4);

                OrderDetails orderDetails = new OrderDetails(id, orderId, beverageId, price);
                orderDetailsList.add(orderDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.close();
        return orderDetailsList;
    }
}