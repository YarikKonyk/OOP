package sample;



        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.Random;

public class Main {
    public static void main(String[] args) {

        new Frame("Start", 700, 500);

    }

}

class Frame extends JFrame {
    Frame(String text, int width, int height) {
        super();
        setTitle(text);
        setBounds(50, 50, width, height);
        setLayout(null);
        setVisible(true);
//        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        new Button(this);
    }
}

class Button extends JButton {
    Frame frame;
    String buttonText;
    Color buttonColor;
    int buttonSize;
    boolean buttonServiceability;
    double buttonElasticity;
    JTextField jTextField = new JTextField();
    JButton btn1 = new JButton(buttonText);
    JButton btn2 = new JButton("Create");
    JButton btn3 = new JButton("Change");
    JButton btn4 = new JButton("Delete");

    private void setProperties() {
        btn1.setText(buttonText);
        btn1.setBounds(20, 20, buttonSize, buttonSize);
        btn1.setBackground(buttonColor);
        btn1.setEnabled(buttonServiceability);
    }

    Button(Frame frame) {
        this.frame = frame;
        buttonColor = Color.black;
        buttonText = "a";
        buttonSize = 50;
        buttonServiceability = true;
        buttonElasticity = 0.5;
        jTextField.setBounds(200, 20, 100, 30);
        btn2.setBounds(100, 120, 100, 100);
        btn3.setBounds(250, 120, 100, 100);
        btn4.setBounds(400, 120, 100, 100);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createButton();
            }
        });
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeButton();
            }
        });
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteButton();
            }
        });
        pressButton();
        frame.getContentPane().add(btn2);
        frame.getContentPane().add(btn3);
        frame.getContentPane().add(btn4);
        frame.getContentPane().add(jTextField);
    }

    public void createButton() {

        setProperties();
        frame.add(btn1);
        btn1.setVisible(true);

    }

    public void pressButton() {
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextField.setText(jTextField.getText() + btn1.getText());
            }
        });

    }

    public void deleteButton() {
        btn1.setVisible(false);
        frame.remove(btn1);

        jTextField.setText("");
    }

    public void changeButton() {
        Random random = new Random();
        buttonText = Character.toString((char) (random.nextInt(255)));
        buttonSize = random.nextInt(100);
        buttonServiceability = random.nextBoolean();
        buttonColor = Color.getHSBColor(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        buttonElasticity = random.nextDouble();
        setProperties();
    }

}