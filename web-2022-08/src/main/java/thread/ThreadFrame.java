package thread;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnThread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadFrame frame = new ThreadFrame();
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
	public ThreadFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextField());
		contentPane.add(getBtnNewButton());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnThread());
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(12, 10, 169, 23);
			textField.setColumns(10);
		}
		return textField;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("RUN");
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//1~99999999까지의 수를 1 증가시켜 더하는 로직
					Long sum=0L;
					for(int i=0; i<99999999; i++) {
						sum += (long)i;
					}
					textArea.setText("sum=" + sum);
				}
			});
			btnNewButton.setBounds(193, 10, 76, 23);
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 57, 345, 257);
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
	public JButton getBtnThread() {
		if (btnThread == null) {
			btnThread = new JButton("Thread");
			
			btnThread.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					Thread t = new Thread(new Runnable() {

						@Override
						public void run() {
							//1~99999999까지의 수를 1 증가시켜 더하는 로직
							Long sum=0L;
							for(double i=0; i<999999999; i=i+0.5) {
								sum += (long)i;
							}
							textArea.setText("sum=" + sum);
							
						}
						
					});
					t.start();
				}
			});
			
			
			btnThread.setBounds(281, 10, 76, 23);
		}
		return btnThread;
	}
}








