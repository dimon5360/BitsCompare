package MainProgram;

import Graphic.WindowElement;

public class MainProgram {

    private static final String version = "0.0.2";

    /* start main window of program */
    public static void main(String[] args) {

        /* construct main program window */
        WindowElement mainWindow = WindowElement.GetWindowElement(100, 100, 800, 500,
                "BitsCompare v." + version);
        mainWindow.ShowElement();

        // TODO:  Call WindowElement methods to add buttons, lines, etc.

    }
}
