package Graphic;

import javax.swing.*;
import java.awt.*;

public class PanelElement implements IGuiElement {

    private JPanel panel;

    /* override inherited methods */
    @Override
    public void ShowElement() {
        panel.setVisible(true);
    } // by default panel is visible
    @Override
    public Component GetSourceElement() { return panel; }

    public void AddComponent(IGuiElement element) {
        panel.add(element.GetSourceElement());
    }

    /* default panel constructor */
    public PanelElement() {
        panel = new JPanel();
        panel.setLayout(null);
    }
}
