package Graphic;

import javax.swing.*;
import java.awt.*;

public class WindowElement implements IGuiElement {

    private int sizeX, sizeY, X0, Y0, frameWidth, frameHeight;
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

        /* keep size of window */
        X0 = x0_;
        Y0 = y0_;
        sizeX = sizeX_;
        sizeY = sizeY_;

        frameWidth = sizeX - X0;
        frameHeight = sizeY - Y0;

        /* config main frame */
        frame = new JFrame(frameHeader);
        frame.setBounds(X0, Y0, sizeX, sizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* config other parts of window (panel, buttons, labels, etc. */
        ConfigWindow();
    }

    private ButtonElement openDocsButton;
    private LabelElement firstDocPathLabel;
    private LabelElement secondDocPathLabel;
    private TextFieldElement firstDocPathTextField;
    private TextFieldElement secondDocPathTextField;

    private void ConfigWindow() {
        /* add panel to frame */
        panel = PanelElement.GetPanelElement();
        frame.add(panel.GetSourceElement());

        /* add button to open docs */
        openDocsButton = ConfigButton(frameWidth / 2, 3 * frameHeight / 4,
                "Open", "OpenDocs");
        panel.AddComponent(openDocsButton);

        /* add text fields to specify paths to docs */
        firstDocPathTextField = ConfigTextField(frameWidth / 2 - 100, 3 * frameHeight / 4 - 50);
        panel.AddComponent(firstDocPathTextField);
        secondDocPathTextField = ConfigTextField(frameWidth / 2 - 100, 3 * frameHeight / 4 - 100);
        panel.AddComponent(secondDocPathTextField);

    }

    private final int defaultButtonWidth = 80, defaultButtonHeight = 25;
    private ButtonElement ConfigButton(int x0, int y0, String buttonText, String actionCmd) {
        ButtonElement button = ButtonElement.GetNewButton(buttonText);
        button.ConfigButton(x0, y0, defaultButtonWidth, defaultButtonHeight, actionCmd);
        return button;
    }

    private final int defaultTextFieldWidth = 280, defaultTextFieldHeight = 25;
    private TextFieldElement ConfigTextField(int x0, int y0) {
        TextFieldElement textField = TextFieldElement.GetTextFieldElement();
        textField.ConfigTextField(x0, y0, defaultTextFieldWidth, defaultTextFieldHeight);
        return textField;
    }
}
