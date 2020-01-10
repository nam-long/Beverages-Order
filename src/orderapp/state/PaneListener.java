package orderapp.state;

public interface PaneListener {

    void onPaneOpened(Object bundle);

    void onPaneResume();

    void onPanePaused();

    void onPaneClosed();
}
