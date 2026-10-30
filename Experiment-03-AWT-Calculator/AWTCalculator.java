import java.awt.*;
import java.awt.event.*;

/**
 * Experiment 3: Calculator using AWT controls (Frame, Label, Button, GridLayout).
 */
public class AWTCalculator extends Frame implements ActionListener {

    private final TextField display = new TextField("0");
    private double first = 0;
    private String op = "";
    private boolean startNew = true;

    public AWTCalculator() {
        super("AWT Calculator");
        setLayout(new BorderLayout(5, 5));
        display.setEditable(false);
        display.setFont(new Font("Monospaced", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        Panel keys = new Panel(new GridLayout(4, 4, 5, 5));
        String[] labels = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", "=", "+"};
        for (String s : labels) {
            Button b = new Button(s);
            b.setFont(new Font("SansSerif", Font.BOLD, 20));
            b.addActionListener(this);
            keys.add(b);
        }
        add(keys, BorderLayout.CENTER);

        setSize(300, 360);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { dispose(); System.exit(0); }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();
        if (Character.isDigit(c.charAt(0))) {
            display.setText(startNew ? c : display.getText() + c);
            startNew = false;
        } else if (c.equals("C")) {
            display.setText("0");
            first = 0; op = ""; startNew = true;
        } else if (c.equals("=")) {
            if (!op.isEmpty()) {
                display.setText(format(calculate(first, Double.parseDouble(display.getText()), op)));
                op = ""; startNew = true;
            }
        } else { // operator
            first = Double.parseDouble(display.getText());
            op = c;
            startNew = true;
        }
    }

    private double calculate(double a, double b, String o) {
        switch (o) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b == 0 ? Double.NaN : a / b;
            default:  return b;
        }
    }

    private String format(double d) {
        if (Double.isNaN(d)) return "Error";
        return d == (long) d ? String.valueOf((long) d) : String.valueOf(d);
    }

    public static void main(String[] args) {
        new AWTCalculator();
    }
}
