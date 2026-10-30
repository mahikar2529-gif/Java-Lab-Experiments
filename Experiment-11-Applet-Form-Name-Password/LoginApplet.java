import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 * Experiment 11: Form containing Name and Password fields using Applet as a container.
 * This form is reused in Experiment 12 for database operations.
 */
public class LoginApplet extends Applet implements ActionListener {

    private TextField nameField, passField;
    private Button login, clear;
    private Label message;

    @Override
    public void init() {
        setLayout(new GridLayout(4, 2, 10, 10));
        add(new Label("Name:"));
        nameField = new TextField(20);
        add(nameField);

        add(new Label("Password:"));
        passField = new TextField(20);
        passField.setEchoChar('*');
        add(passField);

        login = new Button("Login");
        clear = new Button("Clear");
        login.addActionListener(this);
        clear.addActionListener(this);
        add(login);
        add(clear);

        message = new Label("");
        add(message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            if (nameField.getText().trim().isEmpty() || passField.getText().isEmpty()) {
                message.setText("Enter name and password!");
            } else {
                message.setText("Welcome, " + nameField.getText().trim() + "!");
            }
        } else {
            nameField.setText("");
            passField.setText("");
            message.setText("");
        }
    }

    public static void main(String[] args) {
        Frame f = new Frame("Login Applet");
        LoginApplet ap = new LoginApplet();
        f.add(ap);
        ap.init();
        f.setSize(380, 220);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { f.dispose(); System.exit(0); }
        });
    }
}
