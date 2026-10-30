import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Experiment 5: A small Notepad clone using Swing.
 * Features: New, Open, Save, Exit, Cut, Copy, Paste, Select All, Word Wrap, Font size.
 */
public class Notepad extends JFrame implements ActionListener {

    private final JTextArea area = new JTextArea();
    private File currentFile = null;

    public Notepad() {
        super("Untitled - Notepad");
        area.setFont(new Font("Monospaced", Font.PLAIN, 16));
        add(new JScrollPane(area));

        JMenuBar bar = new JMenuBar();

        JMenu file = new JMenu("File");
        addItem(file, "New", KeyEvent.VK_N);
        addItem(file, "Open", KeyEvent.VK_O);
        addItem(file, "Save", KeyEvent.VK_S);
        file.addSeparator();
        addItem(file, "Exit", 0);

        JMenu edit = new JMenu("Edit");
        addItem(edit, "Cut", KeyEvent.VK_X);
        addItem(edit, "Copy", KeyEvent.VK_C);
        addItem(edit, "Paste", KeyEvent.VK_V);
        addItem(edit, "Select All", KeyEvent.VK_A);

        JMenu format = new JMenu("Format");
        JCheckBoxMenuItem wrap = new JCheckBoxMenuItem("Word Wrap");
        wrap.addActionListener(e -> {
            area.setLineWrap(wrap.isSelected());
            area.setWrapStyleWord(wrap.isSelected());
        });
        format.add(wrap);
        addItem(format, "Increase Font", 0);
        addItem(format, "Decrease Font", 0);

        bar.add(file);
        bar.add(edit);
        bar.add(format);
        setJMenuBar(bar);

        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addItem(JMenu menu, String label, int key) {
        JMenuItem item = new JMenuItem(label);
        if (key != 0) item.setAccelerator(KeyStroke.getKeyStroke(key, InputEvent.CTRL_DOWN_MASK));
        item.addActionListener(this);
        menu.add(item);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "New":
                area.setText("");
                currentFile = null;
                setTitle("Untitled - Notepad");
                break;
            case "Open": openFile(); break;
            case "Save": saveFile(); break;
            case "Exit": System.exit(0); break;
            case "Cut": area.cut(); break;
            case "Copy": area.copy(); break;
            case "Paste": area.paste(); break;
            case "Select All": area.selectAll(); break;
            case "Increase Font": changeFont(2); break;
            case "Decrease Font": changeFont(-2); break;
        }
    }

    private void changeFont(int delta) {
        Font f = area.getFont();
        area.setFont(f.deriveFont((float) Math.max(8, f.getSize() + delta)));
    }

    private void openFile() {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            currentFile = fc.getSelectedFile();
            try (BufferedReader r = new BufferedReader(new FileReader(currentFile))) {
                area.read(r, null);
                setTitle(currentFile.getName() + " - Notepad");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Cannot open file: " + ex.getMessage());
            }
        }
    }

    private void saveFile() {
        if (currentFile == null) {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
            currentFile = fc.getSelectedFile();
        }
        try (BufferedWriter w = new BufferedWriter(new FileWriter(currentFile))) {
            area.write(w);
            setTitle(currentFile.getName() + " - Notepad");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Cannot save file: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Notepad::new);
    }
}
