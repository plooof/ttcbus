import ca.justinangue.ttc.TempArray;

import javax.swing.*;
import java.awt.*;

public class Interface {

    Info info = new Info();
    TempArray ta = new TempArray();

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    JLabel currentStop = new JLabel();
    JLabel oneStop = new JLabel();
    JLabel twoStop = new JLabel();
    JLabel threeStop = new JLabel();

    private int stopOrder = 0;

    public int getStopOrder() {
        return stopOrder;
    }

    public void setStopOrder(int stopOrder) {
        this.stopOrder = stopOrder;
    }

    public void init(){

        System.out.println("Interface init " + info.startId);
        frame.add(panel);
        frame.setSize(1205, 425);
        frame.setResizable(false);
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.YELLOW);
        currentStop.setForeground(Color.YELLOW);
        oneStop.setForeground(Color.YELLOW);
        twoStop.setForeground(Color.YELLOW);
        threeStop.setForeground(Color.YELLOW);
        panel.add(currentStop);
        panel.add(oneStop);
        panel.add(twoStop);
        panel.add(threeStop);

    }

    public void displayOn() {
        System.out.println("displayOn");

        currentStop.setText("Current stop: " + ta.getStop(stopOrder));
        oneStop.setText("One stop ahead: " + ta.getStop(stopOrder + 1));
        twoStop.setText("Two stops ahead: " + ta.getStop(stopOrder + 2));


        frame.setVisible(true);
    }

}
