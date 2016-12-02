package sample;



        import javax.swing.*;
        import javax.swing.colorchooser.ColorChooserComponentFactory;
        import javax.swing.colorchooser.ColorSelectionModel;
        import javax.swing.event.ChangeEvent;
        import javax.swing.event.ChangeListener;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.Random;

public class Main {
    public static void main(String[] args) {

        new Frame("Start", 1700, 1200);

    }

}

class Frame extends JFrame {
    Frame(String text, int width, int height) {
        super();
        setTitle(text);
        setBounds(50, 50, width, height);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        new Presenter(this);
        setVisible(true);
    }
}

class Presenter {
    Frame frame;
    JTextField jTextField = new JTextField();
    JButton editBtn = new JButton();

    JButton changeBtn = new JButton("Change");
    JButton deleteBtn = new JButton("Exit");
    JColorChooser colorChooser = new JColorChooser();

    Presenter() {
        jTextField.setBounds(200, 20, 1000, 30);
        changeBtn.setBounds(250, 120, 100, 100);
        deleteBtn.setBounds(400, 120, 100, 100);
        colorChooser.setBounds(200, 250, 500, 500);

    }

    Presenter(Frame frame) {

        this();
        this.frame = frame;

        Action action = new Action();
        action.createChangeableButton(editBtn, frame);


        Listener listener = new Listener();
        listener.addChangeActionListener(editBtn, changeBtn);
        listener.addDeleteButtonListener(editBtn, deleteBtn, frame, jTextField);
        listener.addChangableButtonListener(editBtn, jTextField);
        listener.addChooseColotListener(colorChooser,editBtn);


        frame.add(changeBtn);
        frame.add(deleteBtn);
        frame.add(jTextField);
        frame.add(colorChooser);
    }
}

class Action {


    private static void setButtonProperties(JButton btn, String buttonText, Color buttonColor, int buttonSize) {
        btn.setText(buttonText);
        btn.setBounds(20, 20, buttonSize, buttonSize);
        btn.setBackground(buttonColor);
        btn.setEnabled(true);

    }

    void createChangeableButton(JButton btn, Frame frame) {

        setButtonProperties(btn, "Press me", Color.blue, 90);
        frame.add(btn);
        btn.setVisible(true);

    }

    void pressChangeableButton(JButton btn, JTextField jTextField) {

        jTextField.setText(jTextField.getText() + btn.getText());
    }

    void deleteButton(JButton btn, Frame frame, JTextField jTextField) {
        btn.setVisible(false);
        frame.remove(btn);
        jTextField.setText("");
        System.exit(1);
    }

    void changeButton(JButton btn) {
        Frame frame;
        String buttonText;
        Color buttonColor;
        int buttonSize;
        Random random = new Random();
        buttonText = Character.toString((char) (random.nextInt(255)));
        buttonSize = random.nextInt(50) + 50;
        buttonColor = Color.getHSBColor(random.nextInt(255), random.nextInt(255), random.nextInt(255));

        setButtonProperties(btn, buttonText, buttonColor, buttonSize);
    }

    void changeButtonColor(JButton btn, JColorChooser colorChooser) {
        Color newColor = colorChooser.getColor();
        btn.setBackground(newColor);

    }

}

class Listener {

    private Action action = new Action();
    void addChangeActionListener(JButton buttonToChange, JButton buttonToPress) {

        buttonToPress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                action.changeButton(buttonToChange);
            }
        });
    }

    void addDeleteButtonListener(JButton buttonToDelete, JButton buttonToPress, Frame frame, JTextField jTextField) {

        buttonToPress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                action.deleteButton(buttonToDelete, frame, jTextField);
            }
        });
    }

    void addChooseColotListener(JColorChooser colorChooser, JButton btn) {

        colorChooser.getSelectionModel().addChangeListener(
                new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        action.changeButtonColor(btn, colorChooser);
                    }
                }
        );
    }

    void addChangableButtonListener(JButton btn, JTextField jTextField) {

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                action.pressChangeableButton(btn, jTextField);
            }
        });

    }


}