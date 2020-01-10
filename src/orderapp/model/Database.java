package orderapp.model;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private final static String DB_PATH = "OrderApp.db";

    private Connection connection;

    public Database() {

        final String url = "jdbc:sqlite:" + DB_PATH;
        try {
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            connection = DriverManager.getConnection(url, config.toProperties());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void initiate() {

        final String SQL_CREATE_BEVERAGE_TABLE = "CREATE TABLE IF NOT EXISTS Beverages (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    Name text NOT NULL,\n"
                + "    Price real NOT NULL\n"
                + ");";

        final String SQL_CREATE_ORDER_TABLE = "CREATE TABLE IF NOT EXISTS Orders (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    Time integer NOT NULL,\n"
                + "    Description text\n"
                + ");";

        final String SQL_CREATE_ORDER_DETAIL_TABLE = "CREATE TABLE IF NOT EXISTS OrderDetails (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    OrderId integer NOT NULL,\n"
                + "    BeverageId integer NOT NULL,\n"
                + "    Quantity integer NOT NULL,\n"
                + "    Amount real NOT NULL,\n"
                + "    FOREIGN KEY (OrderId)\n"
                + "         REFERENCES Orders(ID)\n"
                + "             ON DELETE CASCADE,\n"
                + "    FOREIGN KEY (BeverageId)\n"
                + "         REFERENCES Beverages(ID)\n"
                + "             ON DELETE CASCADE\n"
                + ");";

        try {
            Statement statement = getConnection().createStatement();
            statement.execute(SQL_CREATE_BEVERAGE_TABLE);
            statement.execute(SQL_CREATE_ORDER_TABLE);
            statement.execute(SQL_CREATE_ORDER_DETAIL_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {

        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
