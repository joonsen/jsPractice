package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import iostream.Data;
import iostream.MemberDao;

public class MemberInput extends JInternalFrame {
	MyInterMain main;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JTextField tfId;
	private JTextField tfIrum;
	private JTextField tfAddr;
	private JTextField tfPhone;
	private JTextField tfPoint;
	private JButton btnSave;
	private JButton btnModify;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInput frame = new MemberInput();
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
	public MemberInput(MyInterMain main) {
		this();
		this.main = main;
	}
	public MemberInput() {
		super("회원가입", true, true, true, true);	//true로 해야 크기도 조절되고, 최대최소도 되고, 아이콘도 되고..
		addInternalFrameListener(new InternalFrameAdapter() {
			
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.mi = null;
			}
			
		});
		setVisible(true);
		setBounds(100, 100, 298, 215);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel1());
		getContentPane().add(getLabel2());
		getContentPane().add(getLabel3());
		getContentPane().add(getLabel4());
		getContentPane().add(getLabel5());
		getContentPane().add(getTfId());
		getContentPane().add(getTfIrum());
		getContentPane().add(getTfAddr());
		getContentPane().add(getTfPhone());
		getContentPane().add(getTfPoint());
		getContentPane().add(getBtnSave());
		getContentPane().add(getBtnModify());
		getContentPane().add(getBtnDelete());
		
	}
	public JLabel getLabel1() {
		if (label1 == null) {
			label1 = new JLabel("아이디");
			label1.setBounds(12, 10, 57, 15);
		}
		return label1;
	}
	public JLabel getLabel2() {
		if (label2 == null) {
			label2 = new JLabel("성명");
			label2.setBounds(12, 35, 57, 15);
		}
		return label2;
	}
	public JLabel getLabel3() {
		if (label3 == null) {
			label3 = new JLabel("주소");
			label3.setBounds(12, 60, 57, 15);
		}
		return label3;
	}
	public JLabel getLabel4() {
		if (label4 == null) {
			label4 = new JLabel("연락처");
			label4.setBounds(12, 85, 57, 15);
		}
		return label4;
	}
	public JLabel getLabel5() {
		if (label5 == null) {
			label5 = new JLabel("포인트");
			label5.setBounds(12, 110, 57, 15);
		}
		return label5;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(81, 7, 92, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}
	public JTextField getTfIrum() {
		if (tfIrum == null) {
			tfIrum = new JTextField();
			tfIrum.setColumns(10);
			tfIrum.setBounds(81, 32, 116, 21);
		}
		return tfIrum;
	}
	public JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setColumns(10);
			tfAddr.setBounds(81, 57, 187, 21);
		}
		return tfAddr;
	}
	public JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(81, 82, 155, 21);
		}
		return tfPhone;
	}
	public JTextField getTfPoint() {
		if (tfPoint == null) {
			tfPoint = new JTextField();
			tfPoint.setColumns(10);
			tfPoint.setBounds(81, 107, 70, 21);
		}
		return tfPoint;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("저장");
			btnSave.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					MemberDao dao = new MemberDao();
					
					String id = tfId.getText();
					String irum = tfIrum.getText();
					String addr = tfAddr.getText();
					String phone = tfPhone.getText();
					int point = Integer.parseInt(tfPoint.getText());
					
					Data d = new Data(id, irum, addr, phone, point);
					dao.write(d);
				}
			});
			
			btnSave.setBounds(12, 138, 70, 23);
		}
		return btnSave;
	}
	public JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수정");
			
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					MemberDao dao = new MemberDao();
					
					String id = tfId.getText();
					String irum = tfIrum.getText();
					String addr = tfAddr.getText();
					String phone = tfPhone.getText();
					int point = Integer.parseInt(tfPoint.getText());
					
					Data d = new Data(id, irum, addr, phone, point);
					dao.modify(d);
				}
				
			});
			btnModify.setBounds(106, 138, 70, 23);
		}
		return btnModify;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberDao dao = new MemberDao();
					String id = ((MemberInput)main.mi).getTfId().getText();
					dao.delete(id);
				}
				
			});
			btnDelete.setBounds(198, 138, 70, 23);
		}
		return btnDelete;
	}
}
