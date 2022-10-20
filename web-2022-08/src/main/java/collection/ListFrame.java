package collection;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListFrame extends JInternalFrame {
	List<Data> list = new ArrayList<Data>();	//ctrl + shift + o
	int index=-1;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField id;
	private JTextField irum;
	private JTextField age;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_1_1_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListFrame frame = new ListFrame();
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
	public ListFrame() {
		super("리스트프레임",true,true,true,true);
		setVisible(true);
		setBounds(100, 100, 549, 375);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getId());
		getContentPane().add(getIrum());
		getContentPane().add(getAge());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_1_1());
		getContentPane().add(getBtnNewButton_1_1_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getScrollPane());
		getContentPane().add(getSeparator());

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디");
			lblNewLabel.setBounds(12, 10, 46, 15);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("성명");
			lblNewLabel_1.setBounds(12, 35, 46, 15);
		}
		return lblNewLabel_1;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("나이");
			lblNewLabel_2.setBounds(12, 60, 46, 15);
		}
		return lblNewLabel_2;
	}
	public JTextField getId() {
		if (id == null) {
			id = new JTextField();
			id.setBounds(70, 7, 126, 21);
			id.setColumns(10);
		}
		return id;
	}
	public JTextField getIrum() {
		if (irum == null) {
			irum = new JTextField();
			irum.setBounds(70, 32, 126, 21);
			irum.setColumns(10);
		}
		return irum;
	}
	public JTextField getAge() {
		if (age == null) {
			age = new JTextField();
			age.setBounds(70, 57, 126, 21);
			age.setColumns(10);
		}
		return age;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("조회");
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String mId = id.getText();
					Data temp = new Data(mId, null, 0);
					index = list.indexOf(temp);
					if(index >=0 ) {
						Data d = list.get(index);
						irum.setText(d.getIrum());
						age.setText(d.getAge()+"");
					}else {
						JOptionPane.showMessageDialog(ListFrame.this, "찾는 데이터 無");
						irum.setText("");
						age.setText("");
						
					}
					Data d = list.get(index);
				}
			});
			
			btnNewButton.setBounds(219, 6, 70, 23);
		}
		return btnNewButton;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("저장");
			
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String mId = id.getText();
					String mIrum = irum.getText();
					int mAge = Integer.parseInt( age.getText());	//문자열로 되어있는걸 소괄호를 써서 casting 할수가 없어요. wrapper class사용해야함
					Data data = new Data(mId, mIrum, mAge);
					list.add(data);		//저장과 관련된 process다 
					//각종 crud를 처리하는 class들을 DTO. DAO라 부름. 보통은 UI와 DTO를 분리한다. MVC pattern이라고 한다. 지금은 숙련도가 낮으니 같이함
				
					id.requestFocus();
					id.selectAll();
				}
			});
			
			btnNewButton_1.setBounds(12, 97, 81, 23);
		}
		return btnNewButton_1;
	}
	public JButton getBtnNewButton_1_1() {
		if (btnNewButton_1_1 == null) {
			btnNewButton_1_1 = new JButton("수정");
			
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(index >=0) {
						String mId = id.getText();
						String mIrum = irum.getText();
						int mAge = Integer.parseInt(age.getText());
						Data d = new Data(mId, mIrum, mAge);
						list.set(index,  d);
						
					}else {
						JOptionPane.showMessageDialog(ListFrame.this, "수정할 자료를 먼저 검색해 주세요");
					}
					
				}
			});
			
			btnNewButton_1_1.setBounds(115, 97, 81, 23);
		}
		return btnNewButton_1_1;
	}
	public JButton getBtnNewButton_1_1_1() {
		if (btnNewButton_1_1_1 == null) {
			btnNewButton_1_1_1 = new JButton("삭제");
			
			btnNewButton_1_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(index>=0) {
						list.remove(index);
						id.setText("");
						irum.setText("");
						age.setText("");
						textArea.setText("");
						id.requestFocus();
						
					}else {
						JOptionPane.showMessageDialog(ListFrame.this , "삭제할 데이터를 검색해 주세요");
					}
				}
				
			});
			btnNewButton_1_1_1.setBounds(208, 97, 81, 23);
		}
		return btnNewButton_1_1_1;
	}
	public JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("전체출력");
			
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText("");
					for(Data d : list) {
						textArea.append(d.toString());
					}
				}
			});
			
			btnNewButton_2.setBounds(419, 6, 102, 23);
		}
		return btnNewButton_2;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(301, 35, 220, 300);
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 85, 253, 2);
		}
		return separator;
	}
	public JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
