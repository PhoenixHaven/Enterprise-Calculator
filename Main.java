import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame("Enterprise Calculator");
        f.setSize(400, 300);
        f.setLocation(Toolkit.getDefaultToolkit().getScreenResolution() / 2, Toolkit.getDefaultToolkit().getScreenResolution() / 2);
        final JTextField field = new JTextField("input calculation here", 40);
        final JTextArea textArea = new JTextArea(1, 1);
        f.getContentPane().add(BorderLayout.NORTH, field);
        f.getContentPane().add(BorderLayout.CENTER, textArea);
        final JButton button = new JButton("Calculate");
        f.getContentPane().add(BorderLayout.SOUTH, button);

        button.addActionListener(e -> textArea.setText("The answer is java.lang.ArithmeticException\n"));

        f.setVisible(true);
    }
}