package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class PatternFrame extends JInternalFrame {
	private JLabel lblNewLabel;
	private JTextField emailPattern;
	private JLabel lblNewLabel_1;
	private JTextField emailValue;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JTextField phonePattern;
	private JLabel phoneValue;
	private JTextField textField_3;
	private JButton btnNewButton_1;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatternFrame frame = new PatternFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PatternFrame() {
		super("패턴프레임",true,true,true,true);
		setVisible(true);
		setBounds(100, 100, 629, 392);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getEmailPattern());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getEmailValue());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getPhonePattern());
		getContentPane().add(getPhoneValue());
		getContentPane().add(getTextField_3());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getSeparator());
		getContentPane().add(getScrollPane());
		
		

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이메일 패턴");
			lblNewLabel.setBounds(12, 10, 79, 15);
		}
		return lblNewLabel;
	}
	public JTextField getEmailPattern() {
		if (emailPattern == null) {
			emailPattern = new JTextField();
			emailPattern.setBounds(103, 7, 274, 21);
			emailPattern.setColumns(10);
		}
		return emailPattern;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이메일 입력");
			lblNewLabel_1.setBounds(12, 35, 79, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getEmailValue() {
		if (emailValue == null) {
			emailValue = new JTextField();
			emailValue.setBounds(103, 32, 274, 21);
			emailValue.setColumns(10);
		}
		return emailValue;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("이메일 체크");		//이메일 체크 버튼을 클릭하면 addActionListener
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {		//추상메소드면 중괄호가 없었겠지
					
					String ep =emailPattern.getText();
					String v = emailValue.getText();
					boolean b = Pattern.matches(ep,v);
					textArea.append("이메일 패턴 : " + ep);
					textArea.append("\n이메일 입력 : " + v);
					textArea.append("\n체크 결과 : " + b);
					textArea.append("-".repeat(40) + "\n");
					
					
					
					/*
					String email = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
					  
					String[] test = {
					  "hipwg@", "hipwg@naver", "hipwg@naver.com", 
					  "hipwg@naver.co.kr", "hipwg@naver.com.co.kr", "@naver.com"
					};

					for(String s : test) {
					 boolean b = Pattern.matches(email, s);
					 textArea.append(s + " >>> " + b + "\n");
					 */
					}
				}
			);
			
			btnNewButton.setBounds(389, 6, 97, 44);
		}
		return btnNewButton;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("연락처 패턴");
			lblNewLabel_2.setBounds(12, 74, 79, 15);
		}
		return lblNewLabel_2;
	}
	public JTextField getPhonePattern() {
		if (phonePattern == null) {
			phonePattern = new JTextField();
			phonePattern.setColumns(10);
			phonePattern.setBounds(103, 71, 274, 21);
		}
		return phonePattern;
	}
	public JLabel getPhoneValue() {
		if (phoneValue == null) {
			phoneValue = new JLabel("연락처 입력");
			phoneValue.setBounds(12, 99, 79, 15);
		}
		return phoneValue;
	}
	public JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(103, 96, 274, 21);
		}
		return textField_3;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("연락처 체크");		//정말 편하긴 하다. 국내시장은 너무 web에 편중돼있다.
			
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String pp = phonePattern.getText();
					String pv = phoneValue.getText();
					boolean b = Pattern.matches(pp, pv);
					
					textArea.append("연락처 패턴 : " + pp);
					textArea.append("\n연락처 입력 : " + pv);
					textArea.append("\n체크 결과 : " + b);
					textArea.append("-".repeat(40) + "\n");
					
					/*
					String phone = "\\d{2,3}-\\d{3,4}-\\d{4}$";
					String[] test = {
					  "02-12-1234", "02-123-1234", "02-1234-123", 
					"0321-123-1234","010-6351-3491"
					};
					for(String s : test) {
					 boolean b = Pattern.matches(phone, s);
					 textArea.append(s + " >>> " + b + "\n");
					*/
					}
				}
			);
			
			btnNewButton_1.setBounds(389, 70, 97, 44);
		}
		return btnNewButton_1;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(35, 60, 410, 2);
		}
		return separator;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 138, 477, 214);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	
	
}
