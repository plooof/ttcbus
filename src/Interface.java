import javax.swing.*;
import java.awt.*;

public class Interface {

    Info info = new Info();

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    JLabel currentStop = new JLabel();
    JLabel oneStop = new JLabel();
    JLabel twoStop = new JLabel();
    JLabel threeStop = new JLabel();


    public void init(){

        System.out.println("Interface init " + info.startId);
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setResizable(false);
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.YELLOW);
        currentStop.setForeground(Color.YELLOW);
        panel.add(currentStop);
        panel.add(oneStop);
        panel.add(twoStop);
        panel.add(threeStop);

    }

    public void displayOn() {
        System.out.println("displayOn");

        currentStop.setText("Current stop");
        oneStop.setText("One stop ahead");
        twoStop.setText("Two stops ahead");


        frame.setVisible(true);
    }

}
