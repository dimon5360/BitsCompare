package Graphic;

import javax.swing.*;
import java.awt.*;

public class ButtonElement implements IGuiElement {

    private JButton button;
    /* default button sizes, coordinates and action cmd */
    private int defaultButtonX0 = 0,
                defaultButtonY0 = 0,
                defaultButtonWidth = 100,
                defaultButtonHeight = 40;
    private String defaultButtonActionCmd = "Button pressed";

    /* override inherited methods */
    @Override
    public void ShowElement() {
        button.setVisible(true);
    } // by default button is visible
    @Override
    public Component GetSourceElement() { return button; }

    public static ButtonElement GetNewButton() {
        return new ButtonElement();
    }
    public static ButtonElement GetNewButton(String butName) {
        return new ButtonElement(butName);
    }

    public void ConfigButton(int x0, int y0, int width, int height, String actionCmd) {

        defaultButtonX0 = x0;
        defaultButtonY0 = y0;
        defaultButtonWidth = width;
        defaultButtonHeight = height;
        defaultButtonActionCmd = actionCmd;

        button.setBounds(x0, y0, width, height);
        button.setActionCommand(actionCmd);
    }


    private ButtonElement() {
        button = new JButton("default button");
        ConfigButton(defaultButtonX0, defaultButtonY0, defaultButtonWidth,
                defaultButtonHeight, defaultButtonActionCmd);
    }

    private ButtonElement(String butName) {
        button = new JButton(butName);
    }
}
