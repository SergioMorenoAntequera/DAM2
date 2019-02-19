/*
 * AppJavaHelp2019App.java
 */

package appjavahelp2019;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class AppJavaHelp2019App extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new AppJavaHelp2019View(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of AppJavaHelp2019App
     */
    public static AppJavaHelp2019App getApplication() {
        return Application.getInstance(AppJavaHelp2019App.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(AppJavaHelp2019App.class, args);
    }
}
