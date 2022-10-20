package collection;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SetFrame extends JInternalFrame {
	private JScrollPane scrollPane_1;
	private JTextArea textArea;
	private JButton btnNewButton;
	private JButton btnReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetFrame frame = new SetFrame();
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
	public SetFrame() {
		super("Set을 사용한 로또번호 추출", false, true, false, true);
		setVisible(true);
		
		setBounds(100, 100, 562, 399);
		getContentPane().setLayout(null);
		getContentPane().add(getScrollPane_1());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1_1());

	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(12, 37, 522, 187);
			scrollPane_1.setViewportView(getTextArea());
		}
		return scrollPane_1;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("실  행");
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					Set<Integer> set = new HashSet();
					for(int i=0; i<5; i++) {
						set.clear();
						do {
							int n = (int)(Math.random()*45)+1;
							set.add(n);
						}while(set.size()<6);
						
						textArea.append(set.toString() + "\n");
					}
				}
				
			});
			btnNewButton.setBounds(12, 308, 135, 51);
		}
		return btnNewButton;
	}
	public JButton getBtnNewButton_1_1() {
		if (btnReset == null) {
			btnReset = new JButton("Reset");
			
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText(null);
				}
			});
			
			btnReset.setBounds(399, 308, 135, 51);
		}
		return btnReset;
	}
}
