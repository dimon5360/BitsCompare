package Graphic;

import javax.swing.*;
import java.awt.*;

public class ButtonElement implements IGuiElement {

    private JButton button;
    /* default button sizes, coordinates and action cmd */
    private int defaultButtonX0 = 0,
                defaultButtonY0 = 0,
                defaultButtonWidth = 80,
                defaultButtonHeight = 25;
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

    public void ConfigButton(int x0_, int y0_, int width_, int height_, String actionCmd) {

        defaultButtonX0 = x0_;
        defaultButtonY0 = y0_;
        defaultButtonWidth = width_;
        defaultButtonHeight = height_;
        defaultButtonActionCmd = actionCmd;

        button.setBounds(defaultButtonX0, defaultButtonY0, defaultButtonWidth, defaultButtonHeight);
        button.setActionCommand(actionCmd);
    }


    private ButtonElement() {
        button = new JButton("default button");
        ConfigButton(defaultButtonX0, defaultButtonY0, defaultButtonWidth,
                defaultButtonHeight, defaultButtonActionCmd);
    }

    private ButtonElement(String butName) {
        button = new JButton(butName);
        ConfigButton(defaultButtonX0, defaultButtonY0, defaultButtonWidth,
                defaultButtonHeight, defaultButtonActionCmd);
    }
}
