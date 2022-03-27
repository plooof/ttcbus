import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clicker {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    JButton next = new JButton();
    JButton back = new JButton();

    Interface inter = new Interface();

    public void init(){
        frame.setSize(600,600);
        frame.setContentPane(panel);
        panel.setBackground(Color.BLACK);
        panel.setLayout(new GridLayout(2, 1));
        next.setText("next");
        back.setText("back");
        panel.add(back);
        panel.add(next);
        frame.pack();
    }

    public void displayOn(){
        frame.setVisible(true);

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                inter.setStopOrder(inter.getStopOrder() + 1);
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                inter.setStopOrder(inter.getStopOrder() - 1);
            }
        });
    }


}
