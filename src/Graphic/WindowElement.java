package Graphic;

import javax.swing.*;
import java.awt.*;

public class WindowElement implements IGuiElement {

    private int sizeX, sizeY, X0, Y0;
    private JFrame frame;
    private PanelElement panel;

    /* override inherited methods */
    @Override
    public void ShowElement() { frame.setVisible(true); }
    @Override
    public Component GetSourceElement() { return frame; }

    public static WindowElement GetWindowElement(int x0, int y0, int x1, int y1, String frameHeader) {
        return new WindowElement(x0, y0, x1, y1, frameHeader);
    }

    /* custom window constructor */
    private WindowElement(int x0_, int y0_, int sizeX_, int sizeY_, String frameHeader) {
        X0 = x0_;
        Y0 = y0_;
        sizeX = sizeX_;
        sizeY = sizeY_;

        frame = new JFrame(frameHeader);
        frame.setBounds(X0, Y0, sizeX, sizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = PanelElement.GetPanelElement();
        frame.add(panel.GetSourceElement());

        ButtonElement button = ButtonElement.GetNewButton();
        button.ConfigButton(X0 + 300, Y0 + 100,
                100, 40, "Button pressed");
        panel.AddComponent(button);
    }
}
