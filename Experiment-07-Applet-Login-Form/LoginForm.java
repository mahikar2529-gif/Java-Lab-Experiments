import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 * Experiment 7: Form with Name and Password fields using Applet as the container.
 * The entered values are shown below the form when Submit is clicked.
 */
public class LoginForm extends Applet implements ActionListener {

    private TextField nameField, passField;
    private Button submit, reset;
    private Label result;

    @Override
    public void init() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 12));
        add(new Label("Name:     "));
        nameField = new TextField(20);
        add(nameField);

        add(new Label("Password:"));
        passField = new TextField(20);
        passField.setEchoChar('*');
        add(passField);

        submit = new Button("Submit");
        reset = new Button("Reset");
        submit.addActionListener(this);
        reset.addActionListener(this);
        add(submit);
        add(reset);

        result = new Label("                                                  ");
        add(result);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            result.setText("Name: " + nameField.getText() + " | Password length: " + passField.getText().length());
        } else {
            nameField.setText("");
            passField.setText("");
            result.setText("");
        }
    }

    public static void main(String[] args) {
        Frame f = new Frame("Login Form");
        LoginForm ap = new LoginForm();
        f.add(ap);
        ap.init();
        f.setSize(380, 260);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { f.dispose(); System.exit(0); }
        });
    }
}
