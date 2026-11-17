package exam;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private final JTextField txtInput = new JTextField(15);
    private final JTextArea txtOutput = new JTextArea(10, 35);
    private final JComboBox<String> cmbOption =
            new JComboBox<>(new String[]{"Option 1", "Option 2"});

    public Main() {
        setTitle("Exam Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JButton btnProcess = new JButton("Process");
        JButton btnClear = new JButton("Clear");
        JPanel inputs = new JPanel(new FlowLayout());
        inputs.add(new JLabel("Input:"));
        inputs.add(txtInput);
        inputs.add(cmbOption);
        inputs.add(btnProcess);
        inputs.add(btnClear);

        txtOutput.setEditable(false);
        setLayout(new BorderLayout(8, 8));
        add(inputs, BorderLayout.NORTH);
        add(new JScrollPane(txtOutput), BorderLayout.CENTER);

        btnProcess.addActionListener(e -> process());
        btnClear.addActionListener(e -> clearForm());
        createMenus();
    }

    private void process() {
        // TODO: replace with the actual exam requirements.
        String input = txtInput.getText().trim();
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a value.");
            return;
        }
        txtOutput.setText("Selected: " + cmbOption.getSelectedItem()
                + "\nInput: " + input);
    }

    private void clearForm() {
        txtInput.setText("");
        txtOutput.setText("");
        cmbOption.setSelectedIndex(0);
    }

    private void createMenus() {
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        file.add(exit);

        JMenu tools = new JMenu("Tools");
        JMenuItem process = new JMenuItem("Process");
        process.addActionListener(e -> process());
        JMenuItem clear = new JMenuItem("Clear");
        clear.addActionListener(e -> clearForm());
        tools.add(process);
        tools.add(clear);

        bar.add(file);
        bar.add(tools);
        setJMenuBar(bar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
