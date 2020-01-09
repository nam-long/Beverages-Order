package orderapp;

import orderapp.view.MainFrame;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();
        mainFrame.setTitle("Order App");
        mainFrame.setPreferredSize(new Dimension(400, 500));
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
