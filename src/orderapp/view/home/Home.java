package orderapp.view.home;

import orderapp.state.Pane;

import javax.swing.*;

public class Home extends Pane {

    private JPanel rootPanel;

    public Home() {

        setComponent(rootPanel);
    }

    @Override
    public void onPaneOpened(Object bundle) {
    }

    @Override
    public void onPaneClosed() {
    }
}
