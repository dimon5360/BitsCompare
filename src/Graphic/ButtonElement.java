package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonElement implements IGuiElement {

    private JButton button;
    /* default button sizes, coordinates and action cmd */
    private int defaultButtonX0 = 0,
                defaultButtonY0 = 0,
                defaultButtonWidth = 80,
                defaultButtonHeight = 25;

    @Override
    public void ShowElement() {
        button.setVisible(true);
    }
    @Override
    public Component GetSourceElement() { return button; }

    public void SetActionName(String actionCmd) {
        button.setActionCommand(actionCmd);
    }

    public void ConfigButton(int x0_, int y0_, int width_, int height_) {

        defaultButtonX0 = x0_;
        defaultButtonY0 = y0_;
        defaultButtonWidth = width_;
        defaultButtonHeight = height_;
        button.setBounds(defaultButtonX0, defaultButtonY0, defaultButtonWidth, defaultButtonHeight);
    }

    public ButtonElement(String butName) {
        button = new JButton(butName);
        ConfigButton(defaultButtonX0, defaultButtonY0, defaultButtonWidth,
                defaultButtonHeight);
    }



    public void AddListener(ActionListener e) {
        button.addActionListener(e);
    }
}
