package orderapp.state;

public interface PaneListener {

    void onPaneOpened();

    void onPaneResume();

    void onPanePaused();

    void onPaneClosed();
}
