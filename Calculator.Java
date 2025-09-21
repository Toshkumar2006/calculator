import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {

    private JTextField textField;
    double first;
    double second;
    double result;
    String operation;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "AC", "/", "*", "-",
            "7","8","9","+",
            "4","5","6","=",
            "1","2","3","0",
            ".", "%", "B"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.addActionListener(new ButtonClick());
            panel.add(btn);
        }

        add(panel);

        setVisible(true);
    }

    private class ButtonClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch(command) {
                case "AC":
                    textField.setText("");
                    first = second = result = 0;
                    operation = "";
                    break;
                case "B":
                    String s = textField.getText();
                    if(s.length()>0)
                        textField.setText(s.substring(0, s.length()-1));
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                    first = Double.parseDouble(textField.getText());
                    operation = command;
                    textField.setText("");
                    break;
                case "=":
                    second = Double.parseDouble(textField.getText());
                    switch(operation) {
                        case "+": result = first + second; break;
                        case "-": result = first - second; break;
                        case "*": result = first * second; break;
                        case "/": result = first / second; break;
                        case "%": result = first % second; break;
                    }
                    textField.setText(String.valueOf(result));
                    break;
                default:
                    textField.setText(textField.getText() + command);
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
