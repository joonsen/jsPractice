package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import iostream.ScoreDao;
import iostream.ScoreVo;

public class ScoreInput extends JInternalFrame {
	MyInterMain main;
	
	private JLabel label1;
	private JTextField tfSerial;
	private JLabel label2;
	private JTextField tfId;
	private JLabel lblNewLabel_2;
	private JTextField tfMdate;
	private JLabel lblNewLabel_3;
	private JTextField tfSubject;
	private JLabel lblNewLabel_4;
	private JTextField tfScore;
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
					ScoreInput frame = new ScoreInput();
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
	public ScoreInput(MyInterMain main) {
		this();
		this.main = main;	//생성된 자기자신을 main에 던져
	}
	
	
	public ScoreInput() {
		super("성적입력", false, true, true, true);
		setBorder(new LineBorder(new Color(0,0,0)));
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				main.si = null;
			}
		});
		setVisible(true);
		setBounds(100, 100, 343, 241);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel1());
		getContentPane().add(getTfSerial());
		getContentPane().add(getLabel2());
		getContentPane().add(getTfId());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getTfMdate());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getTfSubject());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getTfScore());
		getContentPane().add(getBtnSave());
		getContentPane().add(getBtnModify());
		getContentPane().add(getBtnDelete());

	}
	public JLabel getLabel1() {
		if (label1 == null) {
			label1 = new JLabel("Serial");
			label1.setBounds(12, 10, 57, 15);
		}
		return label1;
	}
	public JTextField getTfSerial() {
		if (tfSerial == null) {
			tfSerial = new JTextField();
			tfSerial.setBounds(81, 7, 57, 21);
			tfSerial.setColumns(10);
		}
		return tfSerial;
	}
	public JLabel getLabel2() {
		if (label2 == null) {
			label2 = new JLabel("ID");
			label2.setBounds(12, 38, 57, 15);
		}
		return label2;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(81, 35, 68, 21);
		}
		return tfId;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("시험일자");
			lblNewLabel_2.setBounds(12, 66, 57, 15);
		}
		return lblNewLabel_2;
	}
	public JTextField getTfMdate() {
		if (tfMdate == null) {
			tfMdate = new JTextField();
			tfMdate.setColumns(10);
			tfMdate.setBounds(81, 63, 103, 21);
		}
		return tfMdate;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("과목");
			lblNewLabel_3.setBounds(12, 94, 57, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfSubject() {
		if (tfSubject == null) {
			tfSubject = new JTextField();
			tfSubject.setColumns(10);
			tfSubject.setBounds(81, 91, 155, 21);
		}
		return tfSubject;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("성적");
			lblNewLabel_4.setBounds(12, 122, 57, 15);
		}
		return lblNewLabel_4;
	}
	public JTextField getTfScore() {
		if (tfScore == null) {
			tfScore = new JTextField();
			tfScore.setColumns(10);
			tfScore.setBounds(81, 119, 68, 21);
		}
		return tfScore;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("저장");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int serial = Integer.parseInt(tfSerial.getText());
					String id = tfId.getText();
					String mDate = tfMdate.getText();
					String subject = tfSubject.getText();
					int score = Integer.parseInt(tfScore.getText());
					
					ScoreVo vo = new ScoreVo(serial, id, mDate, subject, score);
					ScoreDao dao = new ScoreDao();
					dao.write(vo);
				}
			});
			btnSave.setBounds(41, 147, 68, 23);
		}
		return btnSave;
	}
	public JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수정");
			btnModify.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					//수정된 정보를 가져와 ScoreVo 객체 생성
					int serial = Integer.parseInt(getTfSerial().getText());
					String id = tfId.getText();
					String mDate = getTfMdate().getText();
					String subject = getTfSubject().getText();
					int score = Integer.parseInt(getTfScore().getText());
					ScoreVo vo = new ScoreVo(serial, id, mDate, subject, score);
					
					//ScoreDao.modify(vo) 호출
					ScoreDao dao = new ScoreDao();
					dao.modify(vo);
					
				}
			});
			btnModify.setBounds(139, 150, 68, 23);
		}
		return btnModify;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int serial = Integer.parseInt(getTfSerial().getText());
					ScoreDao dao = new ScoreDao();
					dao.delete(serial);
				}
			});
			btnDelete.setBounds(237, 147, 68, 23);
		}
		return btnDelete;
	}
}
