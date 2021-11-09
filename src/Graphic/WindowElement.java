package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

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
        ConfigStartWindow(OpenButtonActionListener);
    }


    private ButtonElement openDocsButton, browseFirstDocPathBut, browseSecondDocPathBut;
    private LabelElement mainLabelinfo;
    private TextFieldElement firstDocPathTextField;
    private TextFieldElement secondDocPathTextField;

    private void RemoveUnusedComponents() {

        panel.RemovePanelComponent(firstDocPathTextField);
        panel.RemovePanelComponent(secondDocPathTextField);
        panel.RemovePanelComponent(browseFirstDocPathBut);
        panel.RemovePanelComponent(browseSecondDocPathBut);
        panel.RemovePanelComponent(mainLabelinfo);
    }

    private JTextArea[] OpenAndRenderDocs() {

        try {
            String firstDocPath = firstDocPathTextField.GetText();
            String secondDocPath = secondDocPathTextField.GetText();

            ClassLoader classLoader = getClass().getClassLoader();;
            DataInputStream dataInputStream;
            dataInputStream = new DataInputStream(new FileInputStream(firstDocPath));
            byte [] dataFirstDoc = dataInputStream.readAllBytes();;
            dataInputStream = new DataInputStream(new FileInputStream(secondDocPath));
            byte [] dataSecondDoc = dataInputStream.readAllBytes();

            JTextArea areaLeft = new JTextArea(1, 1);
            areaLeft.setBounds(100, 100, 500, 800);
            areaLeft.append(new String(dataFirstDoc, StandardCharsets.UTF_8));

            JTextArea areaRight = new JTextArea(1, 1);
            areaRight.setBounds(700, 100, 500, 800);
            areaRight.append(new String(dataSecondDoc, StandardCharsets.UTF_8));

            RemoveUnusedComponents();
            return new JTextArea [] {areaLeft, areaRight};

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private enum docs { firstDoc, secondDoc };

    private void ConfigMainWorkWindow() {

        JTextArea[] areas = OpenAndRenderDocs();
        if(areas[docs.firstDoc.ordinal()] != null && areas[docs.secondDoc.ordinal()] != null) {
            frame.resize(1400, 1200);

            for(JTextArea area : areas) {
                panel.AddComponent(area);
            }
            panel.UpdatePanel();
        }
    }

    private ActionListener OpenButtonActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ConfigMainWorkWindow();
        }
    };

    private void ConfigStartWindow(ActionListener userButtonAction) {

        panel = new PanelElement();
        frame.add(panel.GetSourceElement());

        firstDocPathTextField = ConfigTextField(1 * frameWidth / 6, 3 * frameHeight / 4 - 100);
        panel.AddComponent(firstDocPathTextField);
        secondDocPathTextField = ConfigTextField(1 * frameWidth / 6, 3 * frameHeight / 4 - 50);
        panel.AddComponent(secondDocPathTextField);

        mainLabelinfo = ConfigLabel(3 * frameWidth / 7, 3 * frameHeight / 5 - 100,
                200, 20, "Specify repository paths");
        panel.AddComponent(mainLabelinfo);

        browseFirstDocPathBut = ConfigButton(frameWidth / 2 + 250, 3 * frameHeight / 4 - 100,
                "Browse");
        browseFirstDocPathBut.AddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    String filePath = fc.getSelectedFile().getAbsolutePath();
                    SpecifyPath(firstDocPathTextField, filePath);
                }
            }
        });
        panel.AddComponent(browseFirstDocPathBut);

        browseSecondDocPathBut = ConfigButton(frameWidth / 2 + 250, 3 * frameHeight / 4 - 50,
                "Browse");
        browseSecondDocPathBut.AddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    String filePath = fc.getSelectedFile().getAbsolutePath();
                    SpecifyPath(secondDocPathTextField, filePath);
                }
            }
        });
        panel.AddComponent(browseSecondDocPathBut);

        openDocsButton = ConfigButton(3 * frameWidth / 7, 3 * frameHeight / 4, "Open");
        openDocsButton.SetActionName("Open docs");
        openDocsButton.AddListener(userButtonAction);
        panel.AddComponent(openDocsButton);
    }

    private final int defaultButtonWidth = 80, defaultButtonHeight = 25;
    private ButtonElement ConfigButton(int x0, int y0, String buttonText) {
        ButtonElement button = new ButtonElement(buttonText);
        button.ConfigButton(x0, y0, defaultButtonWidth, defaultButtonHeight);
        return button;
    }
    private ButtonElement ConfigButton(int x0, int y0, int x1, int y1, String buttonText) {
        ButtonElement button = new ButtonElement(buttonText);
        button.ConfigButton(x0, y0, x1, y1);
        return button;
    }

    private final int defaultTextFieldWidth = 400, defaultTextFieldHeight = 25;
    private TextFieldElement ConfigTextField(int x0, int y0) {
        TextFieldElement textField = new TextFieldElement();
        textField.ConfigTextField(x0, y0, defaultTextFieldWidth, defaultTextFieldHeight);
        return textField;
    }
    private TextFieldElement ConfigTextField(int x0, int y0, int x1, int y1) {
        TextFieldElement textField = new TextFieldElement();
        textField.ConfigTextField(x0, y0, x1, y1);
        return textField;
    }

    private final int defaultLabeldWidth = 100, defaultLabelHeight = 25;
    private LabelElement ConfigLabel(int x0, int y0, String labelText) {
        LabelElement label = new LabelElement(labelText);
        label.ConfigLabel(x0, y0, defaultLabeldWidth, defaultLabelHeight);
        return label;
    }
    private LabelElement ConfigLabel(int x0, int y0, int x1, int y1, String labelText) {
        LabelElement label = new LabelElement(labelText);
        label.ConfigLabel(x0, y0, x1, y1);
        return label;
    }

    private void SpecifyPath(TextFieldElement field, String path) {
        if(field != null) {
            field.RenderText(path);
        }
        System.out.println(path);
    }
}
