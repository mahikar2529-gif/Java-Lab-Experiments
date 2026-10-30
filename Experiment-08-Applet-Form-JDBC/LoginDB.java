import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 * Experiment 8: Applet form (Name, Password) whose data is stored in a database via JDBC.
 * Database: MySQL, schema in schema.sql.
 */
public class LoginDB extends Applet implements ActionListener {

    private static final String URL = "jdbc:mysql://localhost:3306/labdb";
    private static final String USER = "root";
    private static final String PASS = "root";   // change to your MySQL password

    private TextField nameField, passField;
    private Button save;
    private Label status;

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
        save = new Button("Save to Database");
        save.addActionListener(this);
        add(save);
        status = new Label("                                                    ");
        add(status);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String n = nameField.getText().trim();
        String p = passField.getText();
        if (n.isEmpty() || p.isEmpty()) {
            status.setText("Please fill both fields.");
            return;
        }
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement("INSERT INTO users(name, password) VALUES (?, ?)")) {
            ps.setString(1, n);
            ps.setString(2, p);
            ps.executeUpdate();
            status.setText("Record saved successfully.");
            nameField.setText("");
            passField.setText("");
        } catch (SQLException ex) {
            status.setText("DB error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Frame f = new Frame("Login Form with JDBC");
        LoginDB ap = new LoginDB();
        f.add(ap);
        ap.init();
        f.setSize(420, 260);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { f.dispose(); System.exit(0); }
        });
    }
}
