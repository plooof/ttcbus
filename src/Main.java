import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public String
            NAME = "TTC Bus Interface",
            VERSION = "v1";
    private final static Main INSTANCE = new Main();

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel name = new JLabel();
    JButton startButton = new JButton();

    Interface inter = new Interface();
    Info info = new Info();


    public void init() {
        System.out.println("NAME: " + NAME);
        System.out.println("VERSION: " + VERSION);

        name.setText(NAME);

        frame.setSize(800, 600);
        frame.setTitle(NAME + " " + VERSION);

        startButton.setText("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                info.startId = 1;
                inter.displayOn();
                System.out.println(info.startId);
            }
        });

        panel.setBackground(Color.decode("#E8DDB5"));
        name.setForeground(Color.decode("#EDAFB8"));
        panel.add(name);
        panel.add(startButton);
        frame.setContentPane(panel);

        frame.setVisible(true);

        inter.init();
    }

    public void Main() {
        init();
    }

    public static void main(String[] args) {
        INSTANCE.Main();
    }


}