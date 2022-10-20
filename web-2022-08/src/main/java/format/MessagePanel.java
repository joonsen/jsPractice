package format;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MessagePanel extends JPanel {
	private JLabel lblNewLabel;
	private JTextField members;
	private JLabel lblNewLabel_1;
	private JTextField message;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public MessagePanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getMembers());
		add(getLblNewLabel_1());
		add(getMessage());
		add(getBtnNewButton());
		add(getScrollPane());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("고객명단");
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	public JTextField getMembers() {
		if (members == null) {
			members = new JTextField();
			members.setBounds(81, 7, 357, 21);
			members.setColumns(10);
		}
		return members;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("메시지");
			lblNewLabel_1.setBounds(12, 35, 57, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getMessage() {
		if (message == null) {
			message = new JTextField();
			message.setBounds(81, 32, 357, 21);
			message.setColumns(10);
		}
		return message;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("실  행");
			
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String temp = members.getText();
					String[] m = temp.split(",");
					
					for(String s : m) {
						String f = MessageFormat.format(message.getText(), s);
						textArea.append(f + "\n");
					}
				}
			});
			
			
			btnNewButton.setBounds(81, 63, 97, 23);
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 110, 426, 180);
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
