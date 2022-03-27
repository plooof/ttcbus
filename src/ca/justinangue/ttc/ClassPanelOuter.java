package ca.justinangue.ttc;

import javax.swing.*;
import java.awt.*;

public class ClassPanelOuter extends JPanel {

    Color yellow = Color.decode("#FFC90D");

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        boolean one = happy.INSTANCE.oneNeed;
        boolean two = happy.INSTANCE.twoNeed;

        System.out.println("paint" + one + two);

        g.setColor(yellow);
        g.fillRect(868, 0, 2, 320);
        g.fillRect(868, 70, 236, 2);
        g.fillRect(868, 125, 236, 2);
        g.fillRect(144, 0, 12, 150);
        g.fillRect(144, 150, 2, 170);
        g.fillRect(154, 150, 2, 170);
        if (one) {
            g.fillOval(136, 194, 29, 29);
            System.out.println("on");
        }
        if (two) {
            g.fillOval(136, 240, 29, 29);
            System.out.println("tn");
        }
        g.setColor(Color.WHITE);
        g.fillOval(129,112, 41, 41);
        g.setColor(Color.BLACK);
        g.fillOval(134, 117, 31, 31);
        if (one) {
            g.fillOval(140, 198, 21, 21);
        }
        if (two) {
            g.fillOval(140, 244, 21, 21);
        }


    }


}
