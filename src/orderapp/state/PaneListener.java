package orderapp.state;

public interface PaneListener {

    void onPaneOpened(Object param);

    void onPaneResume();

    void onPanePaused();

    void onPaneClosed();
}
