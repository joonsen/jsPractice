package format;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class SimpleDatePanel extends JPanel {
	private JLabel lblNewLabel;
	private JTextField format;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public SimpleDatePanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getFormat());
		add(getBtnNewButton());
		add(getScrollPane());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("포멧");
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	public JTextField getFormat() {
		if (format == null) {
			format = new JTextField();
			format.setBounds(81, 7, 357, 21);
			format.setColumns(10);
		}
		return format;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("실  행");
			
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					SimpleDateFormat sdf = 
							new SimpleDateFormat(format.getText());	
					//java패키지에 SimpleDateFormat을 import시켜야함
					String r = sdf.format(new Date());
					//sql이 아니라 util에 있는 class를 import 해야함
					textArea.append("format : " + format.getText());
					textArea.append("result : " + r + "\n");
					
				}
			});
			//현재 이시간을 기준으로 해서 시간을 format 했다
			
			
			btnNewButton.setBounds(81, 38, 97, 23);
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 90, 426, 200);
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
