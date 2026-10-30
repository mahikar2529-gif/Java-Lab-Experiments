import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 * Experiment 2: Animate a string on an Applet using multithreading.
 * The text scrolls from left to right and wraps around.
 */
public class AnimatedString extends Applet implements Runnable {

    private String message = "Welcome to Java Multithreading!";
    private int x = 0;
    private Thread t;
    private volatile boolean running;

    @Override
    public void init() {
        setBackground(Color.black);
        setForeground(Color.green);
        setFont(new Font("Serif", Font.BOLD, 28));
    }

    @Override
    public void start() {
        running = true;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            x += 5;
            if (x > getWidth()) x = -getFontMetrics(getFont()).stringWidth(message);
            repaint();
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public void update(Graphics g) { // avoids flicker
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(message, x, getHeight() / 2);
    }

    /** Lets the applet run as a normal application on modern JDKs. */
    public static void main(String[] args) {
        Frame f = new Frame("Animated String");
        AnimatedString ap = new AnimatedString();
        f.add(ap);
        f.setSize(600, 200);
        f.setVisible(true);
        ap.init();
        ap.start();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { ap.stop(); f.dispose(); System.exit(0); }
        });
    }
}
