package Graphic;

import javax.swing.*;
import java.awt.*;

public class LabelElement implements IGuiElement {

    private JLabel label;
    private int defaultX0 = 0,
                defaultY0 = 0,
                defaultWidth = 80,
                defaultHeight = 25;

    /* override inherited methods */
    @Override
    public void ShowElement() {
        label.setVisible(true);
    }
    @Override
    public Component GetSourceElement() { return label; }

    /* default panel constructor */
    public LabelElement() {
        label = new JLabel();
    }
    /* default panel constructor */
    public LabelElement(String labelText) {
        label = new JLabel();
        label.setText(labelText);
    }

    public void ConfigLabel(int x0_, int y0_, int width_, int height_) {

        defaultX0 = x0_;
        defaultY0 = y0_;
        defaultWidth = width_;
        defaultHeight = height_;

        label.setBounds(defaultX0, defaultY0, defaultWidth, defaultHeight);
    }
}
