package Graphic;

import javax.swing.*;
import java.awt.*;

public class TextFieldElement implements IGuiElement {

    private JTextField textField;
    /* default text field sizes and coordinates */
    private int defaultX0 = 0,
                defaultY0 = 0,
                defaultWidth = 80,
                defaultHeight = 25;

    public static TextFieldElement GetTextFieldElement() {
        return new TextFieldElement();
    }
    public static TextFieldElement GetTextFieldElement(int x0_, int y0_, int width_, int height_) {
        return new TextFieldElement(x0_, y0_, width_, height_);
    }

    /* override inherited methods */
    @Override
    public void ShowElement() {
        textField.setVisible(true);
    }
    @Override
    public Component GetSourceElement() { return textField; }

    /* default text field constructor */
    private TextFieldElement() {
        textField = new JTextField();
        ConfigTextField(defaultX0, defaultY0, defaultWidth, defaultHeight);
    }
    /* custom text field constructor */
    private TextFieldElement(int x0_, int y0_, int width_, int height_) {
        textField = new JTextField();
        ConfigTextField(x0_, y0_, width_, height_);
    }

    public void ConfigTextField(int x0_, int y0_, int width_, int height_) {
        defaultX0 = x0_;
        defaultY0 = y0_;
        defaultWidth = width_;
        defaultHeight = height_;

        textField.setBounds(defaultX0, defaultY0, defaultWidth, defaultHeight);
    }
}
