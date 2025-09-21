package calculator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	double first;
	double second;
	double result;
	String operation;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calculator() {
		setTitle("CALCULATOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		// Buttons
		JButton btnBackspace = new JButton("B");
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>0) {
					StringBuilder str = new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length()-1);
					textField.setText(str.toString());
				}
			}
		});
		contentPane.add(btnBackspace);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(e -> textField.setText(textField.getText() + "0"));
		contentPane.add(btn0);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(e -> textField.setText(textField.getText() + "1"));
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(e -> textField.setText(textField.getText() + "2"));
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(e -> textField.setText(textField.getText() + "3"));
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(e -> textField.setText(textField.getText() + "4"));
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(e -> textField.setText(textField.getText() + "5"));
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(e -> textField.setText(textField.getText() + "6"));
		contentPane.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(e -> textField.setText(textField.getText() + "7"));
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(e -> textField.setText(textField.getText() + "8"));
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(e -> textField.setText(textField.getText() + "9"));
		contentPane.add(btn9);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(e -> textField.setText(textField.getText() + "."));
		contentPane.add(btnDot);
		
		JButton btn00 = new JButton("00");
		btn00.addActionListener(e -> textField.setText(textField.getText() + "00"));
		contentPane.add(btn00);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(e -> textField.setText(""));
		contentPane.add(btnClear);
		
		// Operations
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(e -> {
			first = Double.parseDouble(textField.getText());
			textField.setText("");
			operation = "+";
		});
		contentPane.add(btnPlus);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(e -> {
			first = Double.parseDouble(textField.getText());
			textField.setText("");
			operation = "-";
		});
		contentPane.add(btnSub);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(e -> {
			first = Double.parseDouble(textField.getText());
			textField.setText("");
			operation = "*";
		});
		contentPane.add(btnMul);
		
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(e -> {
			first = Double.parseDouble(textField.getText());
			textField.setText("");
			operation = "/";
		});
		contentPane.add(btnDivide);
		
		JButton btnPercent = new JButton("%");
		btnPercent.addActionListener(e -> {
			first = Double.parseDouble(textField.getText());
			textField.setText("");
			operation = "%";
		});
		contentPane.add(btnPercent);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(e -> {
			second = Double.parseDouble(textField.getText());
			switch(operation) {
				case "+": result = first + second; break;
				case "-": result = first - second; break;
				case "*": result = first * second; break;
				case "/": result = first / second; break;
				case "%": result = first % second; break;
			}
			textField.setText(String.valueOf(result));
		});
		contentPane.add(btnEqual);
	}
}
