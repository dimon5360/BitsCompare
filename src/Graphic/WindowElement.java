package Graphic;

import org.jetbrains.annotations.Contract;

import javax.swing.*;

public class WindowElement implements IWindowElement{

    private int sizeX, sizeY;
    private JFrame mainFrame;

    public static WindowElement GetWindowElement() {
        return new WindowElement();
    }

    public static WindowElement GetWindowElement(int x0, int y0, int x1, int y1) {
        return new WindowElement(x0, y0, x1, y1);
    }

    @Override
    public void ShowWindow() {
        mainFrame.setVisible(true);
    }

    /* default window */
    private WindowElement() {
        mainFrame = new JFrame();
        mainFrame.setBounds(0, 0, 1000, 600);
    }

    /* custom window */
    private WindowElement(int x0, int y0, int x1, int y1) {
        mainFrame = new JFrame();
        mainFrame.setBounds(x0, y0, x1, y1);
    }

}
