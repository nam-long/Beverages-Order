package orderapp.view.beverages;

import orderapp.controller.beverage.BeverageController;
import orderapp.controller.beverage.BeverageControllerFactory;
import orderapp.model.beverage.Beverage;
import orderapp.model.beverage.BeverageList;
import orderapp.state.Pane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Beverages extends Pane {

    private JPanel rootPanel;

    private JTable beveragesTable;
    private BeveragesTableModel beveragesTableModel;

    private JButton deleteButton;
    private JButton editButton;
    private JButton newButton;

    private BeverageController controller;

    public Beverages() {

        controller = BeverageControllerFactory.newInstance(BeverageList.getInstance().getModel());

        setComponent(rootPanel);

        initUiComponents();
    }

    private void initUiComponents() {

        beveragesTableModel = new BeveragesTableModel();
        beveragesTable.setModel(beveragesTableModel);

        controller.registerDataObserver(beveragesTableModel);

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onNewClicked();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onEditClicked();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDeleteClicked();
            }
        });
    }

    private void onNewClicked() {
        BeverageInput input = BeverageInput.newBeverage();
        int option = JOptionPane.showConfirmDialog(
                rootPanel,
                input.getRootPanel(),
                "New Beverage",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            String name = input.getName();
            float price = input.getPrice();
            controller.add(new Beverage(name, price));
        }
    }

    private void onEditClicked() {
        int viewRowIndex = beveragesTable.getSelectedRow();
        if (viewRowIndex != -1) {
            int rowIndex = beveragesTable.convertRowIndexToModel(viewRowIndex);
            Beverage beverage = beveragesTableModel.getDataRow(rowIndex);
            BeverageInput input = BeverageInput.editBeverage(beverage);

            int option = JOptionPane.showConfirmDialog(
                    rootPanel,
                    input.getRootPanel(),
                    "Edit Beverage",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (option == JOptionPane.OK_OPTION) {
                String name = input.getName();
                float price = input.getPrice();
                controller.edit(new Beverage(beverage.getId(), name, price));
            }
        }
    }

    private void onDeleteClicked() {
        int rowIndex = beveragesTable.getSelectedRow();
        if (rowIndex != -1) {
            int modelIndex = beveragesTable.convertRowIndexToModel(rowIndex);
            Beverage beverage = beveragesTableModel.getDataRow(modelIndex);
            controller.delete(beverage.getId());
        }
    }

    @Override
    public void onPaneOpened(Object bundle) {
        controller.pullBeverages();
    }

    @Override
    public void onPaneClosed() {
    }
}
