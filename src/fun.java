import ca.justinangue.ttc.TempArray;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class fun {

    private final static fun INSTANCE = new fun();
    private int stopOrder = 0;

    Clicker click = new Clicker();
    Info info = new Info();
    TempArray ta = new TempArray();

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    JPanel leftPanel = new JPanel();
    LogoPanel logoP = new LogoPanel();
    JPanel routeP = new JPanel();

    JPanel midPanel = new JPanel();
    JPanel nsP = new JPanel();
    JPanel currentP = new JPanel();
    JPanel oneP = new JPanel();
    JPanel twoP = new JPanel();

    JPanel rightPanel = new JPanel();
    JPanel timeP = new JPanel();
    JPanel stopP = new JPanel();
    JPanel alertP = new JPanel();

    static Graphics g;
    BufferedImage logo;

    JLabel nextStop = new JLabel();
    JLabel currentL = new JLabel();
    JLabel oneL = new JLabel();
    JLabel twoL = new JLabel();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mma");
    LocalDateTime now = LocalDateTime.now();
    String time = dtf.format(now).toUpperCase(Locale.ROOT);
    JLabel timeL = new JLabel();

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    File nsFF = new File("src/res/font/light.ttf");
    Font nsF;
    File csFF = new File("src/res/font/heavy.ttf");
    Font csF;
    File normalF = new File("src/res/font/normal.ttf");
    Font normal;
    File heavyF = new File("src/res/font/heavy.ttf");
    Font heavy;
    {
        try {
            nsF = Font.createFont(Font.TRUETYPE_FONT, nsFF).deriveFont(30f);
            csF = Font.createFont(Font.TRUETYPE_FONT, csFF).deriveFont(38f);
            normal = Font.createFont(Font.TRUETYPE_FONT, normalF).deriveFont(32f);
            heavy = Font.createFont(Font.TRUETYPE_FONT, heavyF).deriveFont(20f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {

        frame.setSize(1105, 320);
        frame.setContentPane(panel);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLayout(new FlowLayout());

        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.YELLOW);
        panel.setBorder(new LineBorder(Color.YELLOW, 6));

        panel.add(leftPanel);
        panel.add(midPanel);
        panel.add(rightPanel);

        ge.registerFont(nsF);
        ge.registerFont(csF);
        ge.registerFont(normal);
        ge.registerFont(heavy);

        // LEFT PANEL

        logoP.setBounds(175, 175, 80, 32);

        try {
            logo = ImageIO.read(new File("src/res/TTC.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        leftPanel.setLayout(null);
        leftPanel.add(logoP);

        // MIDDLE PANEL

        nextStop.setText("NEXT STOP");
        nextStop.setFont(nsF);
        nextStop.setForeground(Color.WHITE);
        nsP.setBackground(Color.BLACK);


        //currentL.setText(ta.getStop(stopOrder).toUpperCase(Locale.ROOT));
        currentL.setText("pioneer village station".toUpperCase(Locale.ROOT));
        currentL.setFont(csF);
        currentL.setForeground(Color.YELLOW);
        currentP.setBackground(Color.BLACK);
        oneL.setText(ta.getStop(stopOrder + 1).toUpperCase(Locale.ROOT));
        oneL.setFont(null);
        oneL.setForeground(Color.YELLOW);
        oneP.setBackground(Color.BLACK);
        twoL.setText(ta.getStop(stopOrder + 2).toUpperCase(Locale.ROOT));
        twoL.setFont(null);
        twoL.setForeground(Color.YELLOW);
        twoP.setBackground(Color.BLACK);

        midPanel.setLayout(null);
        midPanel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        midPanel.setPreferredSize(new Dimension(800, 300));
        midPanel.setBackground(Color.BLACK);

        //nsP.add(nextStop);
        //currentP.add(currentL);
        //oneP.add(oneL);
        //twoP.add(twoL);

        nextStop.setBounds(110 / 2,100 / 4, 1420 / 4, 145 / 2);
        currentL.setBounds(110 / 2, 190 / 4, 1420, 250 / 2);
        oneL.setBounds(110 / 2, 400 / 4, 710 / 4, 425 / 2);
        twoL.setBounds(110 / 2, 485 / 4, 710 / 4, 515 / 2);

        //midPanel.add(nsP);
        //midPanel.add(currentP);
        //midPanel.add(oneP);
        //midPanel.add(twoP);

        midPanel.add(nextStop);
        midPanel.add(currentL);
        midPanel.add(oneL);
        midPanel.add(twoL);

        // RIGHT PANEL

        timeL.setText(time);
        timeL.setFont(normal);
        timeL.setForeground(Color.WHITE);
        timeP.setBackground(Color.BLACK);
        timeP.add(timeL);


        rightPanel.add(timeP);

        frame.setVisible(true);
    }



    public static void main(String[] args) {
        INSTANCE.init();
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
    public void setBorder(Border border) {
        BorderFactory.createEmptyBorder();
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
