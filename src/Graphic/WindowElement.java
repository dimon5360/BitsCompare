package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowElement implements IGuiElement {

    private int sizeX, sizeY, X0, Y0, frameWidth, frameHeight;
    private JFrame frame;
    private PanelElement panel;

    /* override inherited methods */
    @Override
    public void ShowElement() { frame.setVisible(true); }
    @Override
    public Component GetSourceElement() { return frame; }

    /* custom window constructor */
    public WindowElement(int x0_, int y0_, int sizeX_, int sizeY_, String frameHeader) {

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

        /* config other parts of window (panel, buttons, labels, etc.) */
        ConfigWindow();
    }

    private ButtonElement openDocsButton, browseFirstDocPath, browseSecondDocPath;
    private LabelElement firstDocPathLabel;
    private LabelElement secondDocPathLabel;
    private TextFieldElement firstDocPathTextField;
    private TextFieldElement secondDocPathTextField;

    private void ConfigWindow() {
        /* add panel to frame */
        panel = new PanelElement();
        frame.add(panel.GetSourceElement());

        /* add button to open docs */
        openDocsButton = ConfigButton(frameWidth / 2, 3 * frameHeight / 4, "Open");
        openDocsButton.SetActionName("Open docs");
        openDocsButton.AddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpecifyPath(null, e.getActionCommand());
            }
        });
        panel.AddComponent(openDocsButton);

        /* add text fields to specify paths to docs */
        firstDocPathTextField = ConfigTextField(frameWidth / 2 - 140, 3 * frameHeight / 4 - 100);
        panel.AddComponent(firstDocPathTextField);
        secondDocPathTextField = ConfigTextField(frameWidth / 2 - 140, 3 * frameHeight / 4 - 50);
        panel.AddComponent(secondDocPathTextField);

        /* add labels to specify what path is where */
        firstDocPathLabel = ConfigLabel(frameWidth / 2 - 250, 3 * frameHeight / 4 - 100, "Path 1");
        panel.AddComponent(firstDocPathLabel);
        secondDocPathLabel = ConfigLabel(frameWidth / 2 - 250, 3 * frameHeight / 4 - 50, "Path 2");
        panel.AddComponent(secondDocPathLabel);

        /* add button to open docs */
        browseFirstDocPath = ConfigButton(frameWidth / 2 + 250, 3 * frameHeight / 4 - 100,
                "Browse");
        browseFirstDocPath.SetActionName("Specify path to first doc");
        browseFirstDocPath.AddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpecifyPath(firstDocPathTextField, e.getActionCommand());
            }
        });
        panel.AddComponent(browseFirstDocPath);

        browseSecondDocPath = ConfigButton(frameWidth / 2 + 250, 3 * frameHeight / 4 - 50,
                "Browse");
        browseSecondDocPath.SetActionName("Specify path to second doc");
        browseSecondDocPath.AddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpecifyPath(secondDocPathTextField, e.getActionCommand());
            }
        });
        panel.AddComponent(browseSecondDocPath);
    }

    private final int defaultButtonWidth = 80, defaultButtonHeight = 25;
    private ButtonElement ConfigButton(int x0, int y0, String buttonText) {
        ButtonElement button = new ButtonElement(buttonText);
        button.ConfigButton(x0, y0, defaultButtonWidth, defaultButtonHeight);
        return button;
    }

    private final int defaultTextFieldWidth = 360, defaultTextFieldHeight = 25;
    private TextFieldElement ConfigTextField(int x0, int y0) {
        TextFieldElement textField = new TextFieldElement();
        textField.ConfigTextField(x0, y0, defaultTextFieldWidth, defaultTextFieldHeight);
        return textField;
    }

    private final int defaultLabeldWidth = 100, defaultLabelHeight = 25;
    private LabelElement ConfigLabel(int x0, int y0, String labelText) {
        LabelElement label = new LabelElement(labelText);
        label.ConfigLabel(x0, y0, defaultLabeldWidth, defaultLabelHeight);
        return label;
    }

    private void SpecifyPath(TextFieldElement field, String name) {
        if(field != null) {
            field.RenderText(name);
        }
        System.out.println(name);
    }
}
