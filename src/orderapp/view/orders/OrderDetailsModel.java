package orderapp.view.orders;

import orderapp.model.beverage.BeverageList;
import orderapp.model.orderdetails.OrderDetails;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Beverage", "Price"};
    public static final int BEVERAGE = 0;
    public static final int PRICE = 1;

    private List<OrderDetails> orderDetailsList = new ArrayList<>();

    @Override
    public int getRowCount() {
        return orderDetailsList.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OrderDetails orderDetails = orderDetailsList.get(rowIndex);
        if (columnIndex == BEVERAGE)
            return BeverageList.getInstance().getBeverageById(orderDetails.getBeverageId());
        else if (columnIndex == PRICE)
            return orderDetails.getPrice();
        return null;
    }
}
