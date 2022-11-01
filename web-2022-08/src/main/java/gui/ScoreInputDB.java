package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import jdbc.ScoreDto;
import jdbc.ScoreVo;

public class ScoreInputDB extends JInternalFrame {
	MyInterMain main;
	Connection conn;
	
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
					ScoreInputDB frame = new ScoreInputDB();
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
	public ScoreInputDB(MyInterMain main) {
		this();
		this.main = main;	//생성된 자기자신을 main에 던져
	}
	
	
	public ScoreInputDB() {
		super("성적입력", false, true, true, true);
		setBorder(new LineBorder(new Color(0,0,0)));
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				main.sidb = null;
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
	
	public void loadData(ScoreVo vo) {		//ScoreSearchDB에서 사용하기 위해 declaration
		tfSerial.setText(vo.getSerial()+"");
		tfId.setText(vo.getId());
		tfMdate.setText(vo.getMdate());
		tfSubject.setText(vo.getSubject());
		tfScore.setText(vo.getScore()+"");
					
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
			
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//tfMdate.setText(sdf.format(new Date()));	//날짜출력하기;
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
					
					Integer serial = Integer.parseInt(tfSerial.getText());
					String id = tfId.getText();
					String mdate = tfMdate.getText();
					String subject = tfSubject.getText();		//여기까지 세줄이 전처리
					int score = Integer.parseInt(tfScore.getText());
					
					ScoreVo vo = new ScoreVo(serial, id, mdate, subject, score); //serial은 보통 increment로 되어있다
					ScoreDto dto = new ScoreDto();
					int cnt = dto.insert(vo);		//여기까지 세줄은 후처리
					if(cnt>0) {
						System.out.println("정상처리");		//if~ main.getStauts().setText()
					}else {
						System.out.println("저장중 오류");
					}
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
					int serial = Integer.parseInt(tfSerial.getText());
					String id = tfId.getText();
					String mdate = tfMdate.getText();
					String subject = tfSubject.getText();
					int score = Integer.parseInt(tfScore.getText());
					
					//ScoreDto.modfy(vo) 호출
					ScoreVo vo = new ScoreVo(serial, id, mdate, subject, score);
					ScoreDto dto = new ScoreDto();
					int cnt = dto.update(vo);
					if(cnt>0) {
						
					}else {
						
					}
					
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
					String id = tfId.getText();
					ScoreDto dto = new ScoreDto();
					int cnt = dto.delete(id);
					if(cnt>0) {
						tfSerial.setText("");		//main.getStatus().setText("삭제됨");
						tfId.setText("");			//main.getStatus().setText("삭제중 오류발생"); - 강사님 ver
						tfMdate.setText("");
						tfSubject.setText("");
						tfScore.setText("");
					}else {
						
					}
					
				}
			});
			btnDelete.setBounds(237, 147, 68, 23);
		}
		return btnDelete;
	}
}
