package Calculators;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Window.Type;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.TextArea;


public class CalculatorX {

	private JFrame frmCalculatorMadeWith;
	private JTextField txtDisplay;
	
	double firstNum;
	double secondNum;
	double result;
	String operations;
	String answer;
	Color transparent = new Color(((float) 0.0), ((float) 0.0), ((float) 0.0), ((float) 0.52));
	
    private int framePositionX, framePositionY, mousePositionX, mousePositionY, newMousePositionX, newMousePositionY;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorX window = new CalculatorX();
					window.frmCalculatorMadeWith.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorX() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculatorMadeWith = new JFrame();
		
		frmCalculatorMadeWith.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				framePositionX = e.getComponent().getX();
				framePositionY = e.getComponent().getY();
				mousePositionX = e.getX();
				mousePositionY = e.getY();
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				framePositionX = e.getComponent().getX();
				framePositionY = e.getComponent().getY();
				mousePositionX = e.getX();
				mousePositionY = e.getY();
			}
			
			@Override public void mouseReleased(MouseEvent mouseEvent) { }
            @Override public void mouseEntered(MouseEvent mouseEvent) { }
            @Override public void mouseExited(MouseEvent mouseEvent) { }
			
		});
		
		frmCalculatorMadeWith.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				newMousePositionX = e.getX();
				newMousePositionY = e.getY();
				int newFramePositionX = (newMousePositionX - mousePositionX)+ framePositionX;
				int newFramePositionY = (newMousePositionY - mousePositionY)+ framePositionY;
				e.getComponent().setLocation(newFramePositionX, newFramePositionY);
			}
		});
		frmCalculatorMadeWith.setAlwaysOnTop(true);
		frmCalculatorMadeWith.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dev Black\\Documents\\my_website_clean\\images\\j-logo.png"));
		frmCalculatorMadeWith.setResizable(true);
		frmCalculatorMadeWith.setLocationRelativeTo(null);
		frmCalculatorMadeWith.setUndecorated(true);
		
		frmCalculatorMadeWith.setTitle("Calculator Made with Java +Swing by Ioannis Lazaridis");
		frmCalculatorMadeWith.getContentPane().setBackground(new Color(0, 0, 0));
		frmCalculatorMadeWith.setBackground(transparent);
		frmCalculatorMadeWith.setForeground(SystemColor.textText);
		frmCalculatorMadeWith.getContentPane().setForeground(Color.BLACK);
		frmCalculatorMadeWith.setBounds(100, 100, 252, 435);
		frmCalculatorMadeWith.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculatorMadeWith.getContentPane().setLayout(null);
		
		
		txtDisplay = new JTextField();
		txtDisplay.setForeground(SystemColor.controlLtHighlight);
		txtDisplay.setBackground(SystemColor.menuText);
		txtDisplay.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 39));
		txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDisplay.setBounds(0, 27, 251, 105);
		frmCalculatorMadeWith.getContentPane().add(txtDisplay);

		
		//Bottom Row
		JButton btnNegation  = new JButton("±");
		btnNegation.setForeground(SystemColor.controlLtHighlight);
		btnNegation.setBackground(transparent);
		btnNegation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = ops * (-1);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnNegation.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btnNegation.setBounds(0, 385, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btnNegation);
		
		JButton btn0 = new JButton("0");
		btn0.setForeground(SystemColor.controlLtHighlight);
		btn0.setBackground(transparent);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn0.getText();
				txtDisplay.setText(EnterNumber );
			}
		});
		btn0.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btn0.setBounds(67, 385, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btn0);
		
		JButton btnInterput  = new JButton(".");
		btnInterput.setForeground(SystemColor.controlLtHighlight);
		btnInterput.setBackground(transparent);
		btnInterput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btnInterput.getText();
				txtDisplay.setText(EnterNumber );
			}
		});
		btnInterput.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btnInterput.setBounds(134, 385, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btnInterput);
		
		//Row #1
		JButton btn1 = new JButton("1");
		btn1.setForeground(SystemColor.controlLtHighlight);
		btn1.setBackground(transparent);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn1.getText();
				txtDisplay.setText(EnterNumber );
			}
		});
		btn1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btn1.setBounds(0, 321, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setForeground(SystemColor.controlLtHighlight);
		btn2.setBackground(transparent);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn2.getText();
				txtDisplay.setText(EnterNumber );
			}
		});
		btn2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btn2.setBounds(67, 321, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setForeground(SystemColor.controlLtHighlight);
		btn3.setBackground(transparent);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn3.getText();
				txtDisplay.setText(EnterNumber );
			}
		});
		btn3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btn3.setBounds(134, 321, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btn3);
		
		//Row #2
		JButton btn4 = new JButton("4");
		btn4.setForeground(SystemColor.controlLtHighlight);
		btn4.setBackground(transparent);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn4.getText();
				txtDisplay.setText(EnterNumber );
			}
		});
		btn4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btn4.setBounds(0, 256, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setForeground(SystemColor.controlLtHighlight);
		btn5.setBackground(transparent);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn5.getText();
				txtDisplay.setText(EnterNumber );
			}
		});
		btn5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btn5.setBounds(67, 256, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setForeground(SystemColor.controlLtHighlight);
		btn6.setBackground(transparent);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn6.getText();
				txtDisplay.setText(EnterNumber );
			}
		});
		btn6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btn6.setBounds(134, 256, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btn6);
		
		//Row #3
		JButton btn7 = new JButton("7");
		btn7.setBackground(transparent);
		btn7.setForeground(SystemColor.controlLtHighlight);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn7.getText();
				txtDisplay.setText(EnterNumber );
			}
		});
		btn7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btn7.setBounds(0, 191, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setForeground(SystemColor.controlLtHighlight);
		btn8.setBackground(transparent);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn8.getText();
				txtDisplay.setText(EnterNumber );
			}
		});
		btn8.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btn8.setBounds(67, 191, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setForeground(SystemColor.controlLtHighlight);
		btn9.setBackground(transparent);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btn9.getText();
				txtDisplay.setText(EnterNumber );
			}
		});
		btn9.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btn9.setBounds(134, 191, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btn9);
		
		
		//Top Row
		
		JButton btnBackSpace = new JButton("C");
		btnBackSpace.setForeground(SystemColor.controlLtHighlight);
		btnBackSpace.setBackground(transparent);
		btnBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String backspace = null;
				
				if(txtDisplay.getText().length() > 0) {
					StringBuilder strB = new StringBuilder(txtDisplay.getText());
					strB.deleteCharAt(txtDisplay.getText().length() -1);
					backspace = strB.toString();
					txtDisplay.setText(backspace);
				}
			}
		});
		btnBackSpace.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btnBackSpace.setBounds(67, 130, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btnBackSpace);
		
		JButton btnClear = new JButton("CE");
		btnClear.setForeground(SystemColor.controlLtHighlight);
		btnClear.setBackground(transparent);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = txtDisplay.getText() + btnClear.getText();
				txtDisplay.setText(null);
			}
		});
		btnClear.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btnClear.setBounds(0, 130, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btnClear);
		
		JButton btnPercentage = new JButton("%");
		btnPercentage.setForeground(SystemColor.controlLtHighlight);
		btnPercentage.setBackground(transparent);
		btnPercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "%";
			}
		});
		btnPercentage.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btnPercentage.setBounds(134, 130, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btnPercentage);
		
	
		
		//Column with Math Operations
		JButton btnAddition = new JButton("+");
		btnAddition.setForeground(SystemColor.controlLtHighlight);
		btnAddition.setBackground(transparent);
		btnAddition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "+";
			}
		});
		btnAddition.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btnAddition.setBounds(201, 322, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btnAddition);
		
		JButton btnSubtraction = new JButton("-");
		btnSubtraction.setForeground(SystemColor.controlLtHighlight);
		btnSubtraction.setBackground(transparent);
		btnSubtraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "-";
			}
		});
		btnSubtraction.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btnSubtraction.setBounds(201, 257, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btnSubtraction);
		
		JButton btnMultiplication = new JButton("×");
		btnMultiplication.setForeground(SystemColor.controlLtHighlight);
		btnMultiplication.setBackground(transparent);
		btnMultiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "*";
			}
		});
		btnMultiplication.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btnMultiplication.setBounds(201, 192, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btnMultiplication);
		
		JButton btnDivision = new JButton("÷");
		btnDivision.setForeground(SystemColor.controlLtHighlight);
		btnDivision.setBackground(transparent);
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "/";
			}
		});
		btnDivision.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btnDivision.setBounds(201, 130, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btnDivision);
		
		JButton btnEquals = new JButton("=");
		btnEquals.setForeground(SystemColor.controlLtHighlight);
		btnEquals.setBackground(transparent);
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String answer;
				secondNum = Double.parseDouble(txtDisplay.getText());
				if (operations == "+") {
					result = firstNum + secondNum;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				else if (operations == "-") {
					result = firstNum - secondNum;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				else if (operations == "*") {
					result = firstNum * secondNum;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				else if (operations == "/") {
					result = firstNum / secondNum;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				else if (operations == "%") {
					result = firstNum % secondNum;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				
			}
		});
		btnEquals.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btnEquals.setBounds(201, 385, 50, 50);
		frmCalculatorMadeWith.getContentPane().add(btnEquals);
		
		JButton btnClose = new JButton("X");
		btnClose.setBackground(transparent);
		btnClose.setForeground(SystemColor.controlLtHighlight);


		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCalculatorMadeWith.dispose();
			}
		});
		btnClose.setFont(new Font("Verdana", Font.PLAIN, 8));
		btnClose.setBounds(211, 0, 40, 30);
		frmCalculatorMadeWith.getContentPane().add(btnClose);
		
		
		
		JButton btnMinimize = new JButton("-");
		btnMinimize.setBackground(transparent);
		btnMinimize.setForeground(SystemColor.controlLtHighlight);


		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCalculatorMadeWith.dispose();
				frmCalculatorMadeWith.setState(frmCalculatorMadeWith.ICONIFIED);

			}
		});
		btnMinimize.setFont(new Font("Verdana", Font.BOLD, 8));
		btnMinimize.setBounds(171, 0, 40, 30);
		frmCalculatorMadeWith.getContentPane().add(btnMinimize);
	}
}
