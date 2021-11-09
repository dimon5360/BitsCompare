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

    /* override inherited methods */
    @Override
    public void ShowElement() {
        textField.setVisible(true);
    }
    @Override
    public Component GetSourceElement() { return textField; }

    /* default text field constructor */
    public TextFieldElement() {
        textField = new JTextField();
        ConfigTextField(defaultX0, defaultY0, defaultWidth, defaultHeight);
        // TODO: delete after
        textField.setText("C:/Users/Dmitry/IdeaProjects/BitsCompare/src/MainProgram/MainProgram.java");
    }

    /* custom text field constructor */
    public TextFieldElement(int x0_, int y0_, int width_, int height_) {
        textField = new JTextField();
        ConfigTextField(x0_, y0_, width_, height_);
        // TODO: delete after
        textField.setText("C:/Users/Dmitry/IdeaProjects/BitsCompare/src/Graphic/ButtonElement.java");
    }

    public void ConfigTextField(int x0_, int y0_, int width_, int height_) {
        defaultX0 = x0_;
        defaultY0 = y0_;
        defaultWidth = width_;
        defaultHeight = height_;

        textField.setBounds(defaultX0, defaultY0, defaultWidth, defaultHeight);
    }

    public String GetText() {
        return textField.getText();
    }
    public void RenderText(String text) {
        textField.setText(text);
    }
}
