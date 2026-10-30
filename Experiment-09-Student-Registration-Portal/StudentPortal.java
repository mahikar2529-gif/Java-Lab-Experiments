import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

/**
 * Experiment 9: Small portal containing the registration form of students (Swing + JDBC).
 * Register a student and see all registered students in a table.
 */
public class StudentPortal extends JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/labdb";
    private static final String USER = "root";
    private static final String PASS = "root";   // change to your MySQL password

    private final JTextField roll = new JTextField(15), name = new JTextField(15),
            email = new JTextField(15), phone = new JTextField(15);
    private final JComboBox<String> course =
            new JComboBox<>(new String[]{"B.Tech CSE", "B.Tech IT", "BCA", "MCA", "M.Tech"});
    private final DefaultTableModel model =
            new DefaultTableModel(new String[]{"Roll No", "Name", "Course", "Email", "Phone"}, 0);

    public StudentPortal() {
        super("Student Registration Portal");
        JPanel form = new JPanel(new GridLayout(6, 2, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Registration Form"));
        form.add(new JLabel("Roll No:"));  form.add(roll);
        form.add(new JLabel("Name:"));     form.add(name);
        form.add(new JLabel("Course:"));   form.add(course);
        form.add(new JLabel("Email:"));    form.add(email);
        form.add(new JLabel("Phone:"));    form.add(phone);
        JButton register = new JButton("Register");
        JButton clear = new JButton("Clear");
        form.add(register);
        form.add(clear);

        register.addActionListener(e -> register());
        clear.addActionListener(e -> clearForm());

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(new JTable(model)), BorderLayout.CENTER);

        setSize(620, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        loadStudents();
    }

    private void register() {
        if (roll.getText().trim().isEmpty() || name.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Roll No and Name are required.");
            return;
        }
        String sql = "INSERT INTO students(roll_no, name, course, email, phone) VALUES (?,?,?,?,?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, roll.getText().trim());
            ps.setString(2, name.getText().trim());
            ps.setString(3, (String) course.getSelectedItem());
            ps.setString(4, email.getText().trim());
            ps.setString(5, phone.getText().trim());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student registered successfully!");
            clearForm();
            loadStudents();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    private void loadStudents() {
        model.setRowCount(0);
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5)});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Could not load students: " + ex.getMessage());
        }
    }

    private void clearForm() {
        roll.setText(""); name.setText(""); email.setText(""); phone.setText("");
        course.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentPortal::new);
    }
}
