package orderapp.view.orders;

import orderapp.model.order.ChangedOrderObserver;
import orderapp.model.order.Order;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderTableModel extends AbstractTableModel implements ChangedOrderObserver {

    private static final String[] COLUMN_NAMES = {"ID", "Time", "Description"};
    public static final int ID = 0;
    public static final int TIME = 1;
    public static final int DESCRIPTION = 2;

    private List<Order> orders = new ArrayList<>();

    @Override
    public int getRowCount() {
        return orders.size();
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
        Order order = orders.get(rowIndex);
        if (columnIndex == ID)
            return order.getId();
        else if (columnIndex == TIME)
            return new Date(order.getTime());
        else if (columnIndex == DESCRIPTION)
            return order.getDescription();
        return null;
    }

    @Override
    public void onChangedOrder(List<Order> orders) {
        this.orders.clear();
        this.orders.addAll(orders);
        this.fireTableDataChanged();
    }
}
