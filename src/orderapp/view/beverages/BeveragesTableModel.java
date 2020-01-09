package orderapp.view.beverages;

import orderapp.model.DataObserver;
import orderapp.model.beverage.Beverage;
import orderapp.model.beverage.BeverageList;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BeveragesTableModel extends AbstractTableModel implements DataObserver<Beverage> {

    private static String[] COLUMN_NAMES = {"Name", "Price"};
    public static final int NAME = 0;
    public static final int PRICE = 1;

    private List<Beverage> beverages = BeverageList.getInstance().getBeverages();

    @Override
    public int getRowCount() {
        return beverages.size();
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
        Beverage beverage = getDataRow(rowIndex);
        if (columnIndex == NAME)
            return beverage.getName();
        else if (columnIndex == PRICE)
            return beverage.getPrice();
        return null;
    }

    @Override
    public void onChangedData(List<Beverage> beverages) {
        fireTableDataChanged();
    }

    public Beverage getDataRow(int rowIndex) {
        return beverages.get(rowIndex);
    }
}
