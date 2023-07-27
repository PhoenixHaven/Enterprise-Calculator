import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame("Enterprise Calculator v2");
        f.setSize(400, 300);
        f.setLocation(Toolkit.getDefaultToolkit().getScreenResolution() / 2, Toolkit.getDefaultToolkit().getScreenResolution() / 2);
        final JTextField field = new JTextField("input calculation here", 40);
        final JTextArea textArea = new JTextArea(1, 1);
        f.getContentPane().add(BorderLayout.NORTH, field);
        f.getContentPane().add(BorderLayout.CENTER, textArea);
        final JButton button = new JButton("Calculate");
        f.getContentPane().add(BorderLayout.SOUTH, button);

        button.addActionListener(e ->  {
            String toCalc = field.getText();

            if (!toCalc.contains("+") && !toCalc.contains("*") && !toCalc.contains("/") && !toCalc.contains("-") && !toCalc.contains("%")) { // I think this does something
                textArea.setText("The answer is java.lang.ArithmeticException");
                return;
            }
            String something = "";

            for (char c : toCalc.toCharArray()) { // you get far better performance with a for-each loop
                if (!Character.isDigit(c) && !Character.isSpaceChar(c)) {
                    something = String.valueOf(c);
                }
            }


            StringBuilder first = new StringBuilder();
            String second;
            for (char c : toCalc.toCharArray()) { // you get far better performance with a for-each loop
                if (String.valueOf(c).equals(" ")) {
                    break;
                }
                first.append(c);
            }

            second = toCalc.substring(first.length() + 3);

            if (!something.equals("") && !second.equals("") && !first.equals("")) {
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("js");
                String calc = first + " " + something + " " + second;
                try {
                    textArea.setText("The answer is " +  engine.eval(calc).toString().replaceAll("[a-zA-Z]", ""));
                } catch (ScriptException e2) {
                    e2.printStackTrace();
                    textArea.setText("The answer is java.lang.ArithmeticException"); // if shit went wrong here then cope I dont get paid enough
                }
            } else {
                textArea.setText("The answer is java.lang.ArithmeticException");
            }
        });

        f.setVisible(true);
    }
}
