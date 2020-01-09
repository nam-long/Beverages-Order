package orderapp.view;

import orderapp.model.Database;
import orderapp.model.beverage.BeverageList;
import orderapp.model.beverage.BeverageModelImpl;
import orderapp.state.State;
import orderapp.state.StateManager;
import orderapp.view.beverages.Beverages;
import orderapp.view.home.Home;
import orderapp.view.intro.Intro;
import orderapp.view.orderdetails.OrderDetails;
import orderapp.view.orders.Orders;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

    private JPanel rootPanel;
    private JPanel contentPanel;

    private final StateManager stateManager;

    public MainFrame() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);

        stateManager = StateManager.getInstance();
        stateManager.initiate(contentPanel);

        initDatabase();
        initModels();
        initComponents();

        stateManager.show(State.INTRO);
    }

    private void initDatabase() {
        Database db = new Database();
        db.initiate();
        db.close();
    }

    private void initModels() {
        BeverageList.getInstance().initiate(new BeverageModelImpl());
    }

    private void initComponents() {

        initAllStates();

        initMenuBar();
    }

    private void initMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        initFileMenu(menuBar);
        initBeveragesMenu(menuBar);
        initOrdersMenu(menuBar);

        setJMenuBar(menuBar);
    }

    private void initFileMenu(JMenuBar menuBar) {

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_X);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);
    }

    private void initBeveragesMenu(JMenuBar menuBar) {

        JMenu beveragesMenu = new JMenu("Beverages");
        beveragesMenu.setMnemonic(KeyEvent.VK_C);

        JMenuItem showMenuItem = new JMenuItem("Show", KeyEvent.VK_S);
        showMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.ALT_MASK));
        showMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.getInstance().show(State.BEVERAGE);
            }
        });
        beveragesMenu.add(showMenuItem);

        menuBar.add(beveragesMenu);
    }

    private void initOrdersMenu(JMenuBar menuBar) {

        JMenu ordersMenu = new JMenu("Orders");
        ordersMenu.setMnemonic(KeyEvent.VK_C);

        JMenuItem showMenuItem = new JMenuItem("Show", KeyEvent.VK_S);
        showMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.ALT_MASK));
        showMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.getInstance().show(State.ORDER);
            }
        });
        ordersMenu.add(showMenuItem);

        menuBar.add(ordersMenu);
    }

    private void initAllStates() {
        stateManager.add(State.INTRO, new Intro());
        stateManager.add(State.HOME, new Home());
        stateManager.add(State.BEVERAGE, new Beverages());
        stateManager.add(State.ORDER, new Orders());
        stateManager.add(State.ORDER_DETAILS, new OrderDetails());
    }
}
