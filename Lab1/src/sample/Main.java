package sample;


        import javax.swing.*;
        import java.awt.event.*;

public class Main {

    public static void main(String[] args) {
//        JFrame frame = new JFrame("First");
//        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
//        frame.setSize(400, 400);
//        frame.setVisible(true);
//        JTextField field = new JTextField("enter text");
//        JButton btn = new JButton("Button");
//        btn.setBounds(100, 100, 150, 150);
//        btn.setVisible(true );
//        frame.add(field);
//        frame.add(btn,BorderLayout.EAST);
        new Frame("Start", 500, 400);

    }
}

class Frame extends JFrame {

    Frame(String text, int width, int height) {

        setTitle(text);
        setBounds(50, 50, width, height);
        setLayout(null);

//        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        new Button(this);
        setVisible(true);
    }
}

class Button extends JButton {
    Frame frame;

    Button(Frame frame) {

        this.frame = frame;
        JTextField tf = new JTextField();
        JTextField tf_resoult = new JTextField();
        tf.setBounds(100, 80, 200, 30);
        tf_resoult.setBounds(100, 110, 200, 30);
        JButton btn1 = new JButton("Ok");
        btn1.setBounds(350, 80, 80, 50);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = tf.getText();
                String resoult;
                if (s.length() > 0) {
                    resoult = s.substring(0, s.length() / 2);
                    resoult = resoult.toUpperCase();
                    tf_resoult.setText(resoult);
                } else tf_resoult.setText("Field is empty");

            }
        });
        frame.getContentPane().add(btn1);
        frame.getContentPane().add(tf);
        frame.getContentPane().add(tf_resoult);

    }

}

