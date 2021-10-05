package Graphic;

import javax.swing.*;
import java.awt.*;

public class LabelElement implements IGuiElement {

    private JLabel label;

    public static LabelElement GetLabelElement() {
        return new LabelElement();
    }

    /* override inherited methods */
    @Override
    public void ShowElement() {
        label.setVisible(true);
    }
    @Override
    public Component GetSourceElement() { return label; }

    /* default panel constructor */
    private LabelElement() {
        label = new JLabel();
    }
}
