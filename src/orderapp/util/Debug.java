package orderapp.util;

public class Debug {

    private static final boolean DEBUG = true;

    private Debug() {
    }

    public static void i(String tag, String message) {
        if (DEBUG) {
            System.out.println("[" + tag + "] " + message);
        }
    }

    public static synchronized void t(String message) {
        if (DEBUG) {
            System.out.println("[TRACE] " + message);
            StackTraceElement[] elements = Thread.currentThread().getStackTrace();
            for (int i = 2; i < elements.length; i++) {
                System.out.println("[TRACE] " + elements[i].toString());
            }
            System.out.println("[TRACE] '"+ Thread.currentThread().getName() + "' thread");
        }
    }
}
