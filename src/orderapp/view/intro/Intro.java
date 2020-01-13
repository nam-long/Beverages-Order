package orderapp.view.intro;

import orderapp.state.Pane;
import orderapp.state.State;
import orderapp.state.StateManager;

import javax.swing.*;

public class Intro extends Pane {

    private JPanel rootPanel;

    public Intro() {
        setComponent(rootPanel);
    }

    @Override
    public void onPaneOpened(Object param) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                StateManager.getInstance().show(State.BEVERAGE);
            }
        });
        thread.start();
    }
}
