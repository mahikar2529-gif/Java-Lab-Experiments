import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 * Experiment 12: Reuses the Name/Password form (Experiment 11) and performs
 * basic database operations (CRUD) using JDBC.
 *   Create -> Insert    Read -> View All    Update -> Update password    Delete -> Delete by name
 */
public class CrudApplet extends Applet implements ActionListener {

    private static final String URL = "jdbc:mysql://localhost:3306/labdb";
    private static final String USER = "root";
    private static final String PASS = "root";   // change to your MySQL password

    private TextField nameField, passField;
    private Button insert, view, update, delete, clear;
    private TextArea output;
    private Label status;

    @Override
    public void init() {
        setLayout(new BorderLayout(8, 8));

        Panel form = new Panel(new GridLayout(3, 2, 8, 8));
        form.add(new Label("Name:"));
        nameField = new TextField(20);
        form.add(nameField);
        form.add(new Label("Password:"));
        passField = new TextField(20);
        passField.setEchoChar('*');
        form.add(passField);
        status = new Label("Ready");
        form.add(status);
        form.add(new Label(""));
        add(form, BorderLayout.NORTH);

        Panel buttons = new Panel(new FlowLayout());
        insert = new Button("Insert");
        view = new Button("View All");
        update = new Button("Update");
        delete = new Button("Delete");
        clear = new Button("Clear");
        for (Button b : new Button[]{insert, view, update, delete, clear}) {
            b.addActionListener(this);
            buttons.add(b);
        }
        add(buttons, BorderLayout.CENTER);

        output = new TextArea(8, 40);
        output.setEditable(false);
        add(output, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        String n = nameField.getText().trim();
        String p = passField.getText();
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            if (src == clear) {
                nameField.setText("");
                passField.setText("");
                status.setText("Cleared");
            } else if (src == insert) {                                          // CREATE
                try (PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?, ?)")) {
                    ps.setString(1, n);
                    ps.setString(2, p);
                    ps.executeUpdate();
                    status.setText("Inserted: " + n);
                }
            } else if (src == view) {                                            // READ
                try (Statement st = con.createStatement();
                     ResultSet rs = st.executeQuery("SELECT name, password FROM users")) {
                    StringBuilder sb = new StringBuilder(String.format("%-20s %s%n", "NAME", "PASSWORD"));
                    while (rs.next()) {
                        sb.append(String.format("%-20s %s%n", rs.getString(1), rs.getString(2)));
                    }
                    output.setText(sb.toString());
                    status.setText("Records loaded");
                }
            } else if (src == update) {                                          // UPDATE
                try (PreparedStatement ps = con.prepareStatement("UPDATE users SET password=? WHERE name=?")) {
                    ps.setString(1, p);
                    ps.setString(2, n);
                    status.setText(ps.executeUpdate() > 0 ? "Updated: " + n : "No such user: " + n);
                }
            } else if (src == delete) {                                          // DELETE
                try (PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE name=?")) {
                    ps.setString(1, n);
                    status.setText(ps.executeUpdate() > 0 ? "Deleted: " + n : "No such user: " + n);
                }
            }
        } catch (SQLException ex) {
            status.setText("DB error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Frame f = new Frame("CRUD Applet with JDBC");
        CrudApplet ap = new CrudApplet();
        f.add(ap);
        ap.init();
        f.setSize(480, 420);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { f.dispose(); System.exit(0); }
        });
    }
}
