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

    public static PanelElement GetPanelElement() {
        return new PanelElement();
    }

    public void AddComponent(IGuiElement element) {
        panel.add(element.GetSourceElement());
    }

    /* default panel constructor */
    private PanelElement() {
        panel = new JPanel();
    }

}
