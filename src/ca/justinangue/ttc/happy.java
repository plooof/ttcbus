package ca.justinangue.ttc;

import ca.justinangue.ttc.routes.r_939a;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class happy {

    public final static happy INSTANCE = new happy();

    private int stopOrder = 0;
    private boolean stopRequest;

    public boolean oneNeed = true;
    public boolean twoNeed = true;

    private final Route route = new r_939a();

    private final ClassPanel cp = new ClassPanel();

    JFrame frame = new JFrame();
    ClassPanelOuter panel  = new ClassPanelOuter();
    LogoPanel logo = new LogoPanel();

    JLabel nextStop = new JLabel();
    JLabel currentL = new JLabel();
    JLabel oneL = new JLabel();
    JLabel twoL = new JLabel();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mma");
    LocalDateTime now = LocalDateTime.now();
    String time = dtf.format(now).toUpperCase(Locale.ROOT);
    JLabel timeL = new JLabel();

    JLabel stopL = new JLabel();

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    File nsFF = new File("src/res/font/light.ttf");
    Font nsF;
    File csFF = new File("src/res/font/heavy.ttf");
    Font csF;
    File smFF = new File("src/res/font/light.ttf");
    Font smF;
    File tFF = new File("src/res/font/normal.ttf");
    Font tF;
    File srFF = new File("src/res/font/heavy.ttf");
    Font srF;

    {
        try {
            nsF = Font.createFont(Font.TRUETYPE_FONT, nsFF).deriveFont(30f);
            csF = Font.createFont(Font.TRUETYPE_FONT, csFF).deriveFont(38f);
            smF = Font.createFont(Font.TRUETYPE_FONT, smFF).deriveFont(24f);
            tF = Font.createFont(Font.TRUETYPE_FONT, tFF).deriveFont(36f);
            srF = Font.createFont(Font.TRUETYPE_FONT, srFF).deriveFont(23f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    Color yellow = Color.decode("#FFC90D");

    public void init(){


        int delay = 1000;
        ActionListener taskPerformer = evt -> {
            System.out.println("tick");
            LocalDateTime update = LocalDateTime.now();
            panel.remove(timeL);
            timeL.setText(dtf.format(update).toUpperCase(Locale.ROOT));
            panel.add(timeL);
            panel.revalidate();
            panel.repaint();
        };
        new Timer(delay, taskPerformer).start();

        ge.registerFont(nsF);
        ge.registerFont(csF);
        ge.registerFont(smF);
        ge.registerFont(tF);
        
        frame.setSize(1106, 320);
        frame.setLocation(10, 10);
        frame.setResizable(false);
        frame.setContentPane(panel);
        frame.setUndecorated(true);
        frame.setLayout(null);

        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setForeground(yellow);
        panel.setBorder(new LineBorder(yellow, 3));

        logo.setBounds(30, 25, 80, 32);
        panel.add(logo);

        nextStop.setText("NEXT STOP");
        nextStop.setFont(nsF);
        nextStop.setForeground(Color.WHITE);

        currentL.setText(route.getStop(stopOrder, r_939a.INSTANCE.stops).toUpperCase(Locale.ROOT));

        currentL.setFont(csF);
        currentL.setForeground(yellow);

        oneL.setText(Route.INSTANCE.getStop(stopOrder + 1, r_939a.INSTANCE.stops).toUpperCase(Locale.ROOT));
        oneL.setFont(smF);
        oneL.setForeground(yellow);

        twoL.setText(Route.INSTANCE.getStop(stopOrder + 2, r_939a.INSTANCE.stops).toUpperCase(Locale.ROOT));
        twoL.setFont(smF);
        twoL.setForeground(yellow);

        nextStop.setBounds(203, 42, 200, 44);
        currentL.setBounds(203, 82, 1420, 60);
        oneL.setBounds(207, 190, 1420, 36);
        twoL.setBounds(207, 236, 1420, 36);

        timeL.setText(time);
        timeL.setFont(tF);
        timeL.setForeground(Color.WHITE);

        timeL.setBounds(925, 6, 400, 60);

        stopL.setText("STOP REQUESTED");
        stopL.setFont(srF);
        stopL.setForeground(Color.decode("#600E0E"));

        stopL.setBounds(890, 83, 1050, 30);

        panel.add(nextStop);
        panel.add(currentL);
        panel.add(oneL);
        panel.add(twoL);
        panel.add(timeL);
        panel.add(stopL);

        frame.setVisible(true);

    }


    public void controlPanel(){

        JFrame frame = new JFrame();
        JPanel control = new JPanel();
        JButton stop = new JButton();
        JButton next = new JButton();
        JButton back = new JButton();

        frame.setTitle("Control Panel");
        frame.setContentPane(control);

        control.add(stop);
        control.add(next);
        control.add(back);

        control.setLayout(null);
        frame.setSize(900,150);
        frame.setLocation(10, 330);
        frame.setResizable(false);
        frame.setVisible(true);

        stop.setBounds(0, 0, 299, 150);
        next.setBounds(600, 0, 299, 150);
        back.setBounds(300, 0, 299, 150);

        stop.setText("STOP");
        next.setText("NEXT");
        back.setText("BACK");

        stop.addActionListener(e -> {
            stopRequest = !stopRequest;
            System.out.println("stop: " + stopRequest);
            panel.remove(stopL);
            if (stopRequest) {
                stopL.setForeground(Color.decode("#E02321"));
            } else {
                stopL.setForeground(Color.decode("#600E0E"));
            }
            panel.add(stopL);
            panel.revalidate();
            panel.repaint();
            cp.revalidate();
            cp.repaint();
        });

        next.addActionListener(e -> {
            stopOrder++;
            System.out.println("next: " + stopOrder);
            panel.remove(currentL);
            panel.remove(oneL);
            panel.remove(twoL);

            panel.add(currentL);
            panel.add(oneL);
            panel.add(currentL);

            currentL.setText(Route.INSTANCE.getStop(stopOrder, r_939a.INSTANCE.stops).toUpperCase(Locale.ROOT));
            try {
                oneL.setText(Route.INSTANCE.getStop(stopOrder + 1, r_939a.INSTANCE.stops).toUpperCase(Locale.ROOT));
            } catch (ArrayIndexOutOfBoundsException err) {
                oneNeed = false;
                oneL.setText("");
            }
            try {
                twoL.setText(Route.INSTANCE.getStop(stopOrder + 2, r_939a.INSTANCE.stops).toUpperCase(Locale.ROOT));
            } catch (ArrayIndexOutOfBoundsException err) {
                twoNeed = false;
                twoL.setText("");
            }

            panel.add(currentL);
            panel.add(oneL);
            panel.add(twoL);
            panel.revalidate();
            panel.repaint();
            cp.revalidate();
            cp.repaint();
        });

        back.addActionListener(e -> {
            stopOrder--;
            System.out.println("back: " + stopOrder);
            panel.remove(currentL);
            panel.remove(oneL);
            panel.remove(twoL);

            panel.add(currentL);
            panel.add(oneL);
            panel.add(currentL);

            currentL.setText(Route.INSTANCE.getStop(stopOrder, r_939a.INSTANCE.stops).toUpperCase(Locale.ROOT));
            oneL.setText(Route.INSTANCE.getStop(stopOrder + 1, r_939a.INSTANCE.stops).toUpperCase(Locale.ROOT));
            twoL.setText(Route.INSTANCE.getStop(stopOrder + 2, r_939a.INSTANCE.stops).toUpperCase(Locale.ROOT));

            panel.add(currentL);
            panel.add(oneL);
            panel.add(twoL);
            panel.revalidate();
            panel.repaint();
            cp.revalidate();
            cp.repaint();
        });

    }

    public static void main(String[] args) {
        INSTANCE.init();
        INSTANCE.controlPanel();
    }

}

class LogoPanel extends JPanel {

    BufferedImage image;

    public LogoPanel() {
        try {
            image = ImageIO.read(new File("src/res/TTC.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 80, 32,this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(160, 64);
    }

}

class ClassPanel extends JPanel {

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
