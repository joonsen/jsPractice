package format;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.ChoiceFormat;
import java.awt.event.ActionEvent;

public class ChoicePanel extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField limit;
	private JTextField grade;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public ChoicePanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLimit());
		add(getGrade());
		add(getBtnNewButton());
		add(getScrollPane());

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("limit");
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("grade");
			lblNewLabel_1.setBounds(12, 35, 57, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getLimit() {
		if (limit == null) {
			limit = new JTextField();
			limit.setBounds(81, 7, 179, 21);
			limit.setColumns(10);
		}
		return limit;
	}
	public JTextField getGrade() {
		if (grade == null) {
			grade = new JTextField();
			grade.setBounds(81, 32, 357, 21);
			grade.setColumns(10);
		}
		return grade;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("실행");
			
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String[] temp = limit.getText().split(",");
					String[] g = grade.getText().split(",");
					double[] d = new double[temp.length];
					
					
					JLabel score = null;
					String[] tempScore = score.getText().split(",");
					int[] s = new int[tempScore.length];
					for(int i=0; i<tempScore.length; i++) {
						s[i] = Integer.parseInt(tempScore[i]);
					}
					
					for(int i=0; i<d.length; i++) {
						d[i] = Double.parseDouble(temp[i]);
					}
					ChoiceFormat cf = new ChoiceFormat(d, g);
					for(int i=0; i<s.length; i++) {
						textArea.append(s[i] + "=" + cf.format(s[i]));
						textArea.append("\n");
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
			scrollPane.setBounds(12, 99, 426, 191);
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
