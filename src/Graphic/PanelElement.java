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
    public void AddComponent(Component component) {
        panel.add(component);
    }

    /* default panel constructor */
    public PanelElement() {
        panel = new JPanel();
        panel.setLayout(null);
    }

    public void RemovePanelComponent(IGuiElement elem) {
        panel.remove(elem.GetSourceElement());
        UpdatePanel();
    }

    public void UpdatePanel() {
        panel.revalidate();
        panel.repaint();
    }
}
