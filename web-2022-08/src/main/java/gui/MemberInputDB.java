package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import iostream.MemberDao;
import jdbc.MemberDto;
import jdbc.MemberVo;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class MemberInputDB extends JInternalFrame {
	// 라디오 버튼을 그룹화
	ButtonGroup bg = new ButtonGroup();
	MyInterMain main;
	Connection conn;
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JTextField tfId;
	private JTextField tfIrum;
	private JTextField tfPhone;
	private JTextField tfPicture;
	private JButton btnSave;
	private JButton btnModify;
	private JButton btnDelete;
	private JRadioButton btnGenderM;
	private JRadioButton btnGenderF;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInputDB frame = new MemberInputDB();
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
	
	public MemberInputDB() {
		super("회원가입DB", true, true, true, true);	//true로 해야 크기도 조절되고, 최대최소도 되고, 아이콘도 되고..
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.midb = null;		//not null 일때만 생성해다오	이코드가 없으면 창이 닫혀지지만 그 이후에 다시 생성되지 않는다
			}
		});
		
			
		setVisible(true);
		setBounds(100, 100, 382, 213);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel1());
		getContentPane().add(getLabel2());
		getContentPane().add(getLabel3());
		getContentPane().add(getLabel4());
		getContentPane().add(getLabel5());
		getContentPane().add(getTfId());
		getContentPane().add(getTfIrum());
		getContentPane().add(getTfPhone());
		getContentPane().add(getTfPicture());
		getContentPane().add(getBtnSave());
		getContentPane().add(getBtnModify());
		getContentPane().add(getBtnDelete());
		getContentPane().add(getBtnGenderM());
		getContentPane().add(getBtnGenderF());
		getContentPane().add(getBtnNewButton());
		
		bg.add(getBtnGenderM());
		bg.add(getBtnGenderF());
		
	}
	public MemberInputDB(MyInterMain main) {
		this();
		this.main = main;		//순서가 바뀌면 안돼오
	}

	public void loadData(MemberVo vo) {
		tfId.setText(vo.getId());
		tfIrum.setText(vo.getIrum());
		tfPhone.setText(vo.getPhone());
		tfPicture.setText(vo.getPicture());
		
		if(vo.getGender().equals('m')) {
			btnGenderM.setSelected(true);
		}else {
			btnGenderF.setSelected(true);
		}
		
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
			label3 = new JLabel("성별");
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
			label5 = new JLabel("증명사진");
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
	public JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(81, 82, 92, 21);
		}
		return tfPhone;
	}
	public JTextField getTfPicture() {
		if (tfPicture == null) {
			tfPicture = new JTextField();
			tfPicture.setColumns(10);
			tfPicture.setBounds(81, 107, 152, 21);
		}
		return tfPicture;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("저장");
			btnSave.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
			
					
					String id = tfId.getText();
					String irum = tfIrum.getText();
					String phone = tfPhone.getText();
					String gender = btnGenderM.isSelected()? "m":"f";
					String picture = tfPicture.getText();		
					
					MemberVo vo = new MemberVo(id, irum, gender,phone, picture);
					MemberDto dto = new MemberDto();
					int cnt = dto.insert(vo);
					if(cnt>0) {
						System.out.println("정상처리됨");
					}else {
						System.out.println("저장중 오류 발생");
					}
				}
			});
			
			btnSave.setBounds(52, 135, 70, 23);
		}
		return btnSave;
	}
	public JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수정");
			
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					String id = tfId.getText();
					String irum = tfIrum.getText();
					String phone = tfPhone.getText();
					String gender = btnGenderM.isSelected()? "m":"f";
					String picture = tfPicture.getText();
					
					MemberVo vo = new MemberVo(id,irum, gender,phone, picture);
					MemberDto dto = new MemberDto();
					int cnt = dto.update(vo);
					if(cnt>0) {
						//성공
					}else {
						//오류
					}
				}
				
			});
			btnModify.setBounds(146, 135, 70, 23);
		}
		return btnModify;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tfId.getText();
					MemberDto dto = new MemberDto();
					int cnt = dto.delete(id);
					if(cnt>0) {
						tfId.setText("");
						tfIrum.setText("");
						tfPhone.setText("");
						tfPicture.setText("");
					}else {
						//오류 처리
					}
				}
				
			});
			btnDelete.setBounds(238, 135, 70, 23);
		}
		return btnDelete;
	}
	public JRadioButton getBtnGenderM() {
		if (btnGenderM == null) {
			btnGenderM = new JRadioButton("늑대");
			btnGenderM.setBounds(77, 56, 57, 23);
		}
		return btnGenderM;
	}
	public JRadioButton getBtnGenderF() {
		if (btnGenderF == null) {
			btnGenderF = new JRadioButton("여우");
			btnGenderF.setBounds(138, 56, 63, 23);
		}
		return btnGenderF;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("이미지 선택");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					int flag = fc.showOpenDialog(MemberInputDB.this);
					if(flag ==JFileChooser.APPROVE_OPTION) {
						String fn = fc.getSelectedFile().getPath();
						tfPicture.setText(fn);
						
					}
				}
			});
			btnNewButton.setBounds(245, 106, 97, 23);
		}
		return btnNewButton;
	}
}
