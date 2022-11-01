package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import jdbc.MemberDto;
import jdbc.MemberVo;


public class MemberSearchDB extends JInternalFrame {
	MyInterMain main;
	Connection conn;
	private JPanel panel;
	private JTextField findStr;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberSearchDB frame = new MemberSearchDB();
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
	public MemberSearchDB(MyInterMain main) {
		this();		//이름없는 학도병이에요
		this.main = main;
	}
	public MemberSearchDB() {
		super("회원조회",true,true,true,true);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setVisible(true);
		//setTitle("회원조회");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);
		
	}
	
	public void select() {
		//검색어 가져와 MemberDto.select 호출
		String f = findStr.getText();
		MemberDto dto = new MemberDto();
		Vector<Vector> list = dto.select(f);
		
		// DefaultTableModel에 있는 모든 data를 삭제
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		
		// DefaultTableModel에 return받은 Vector data를 추가
		for(Vector v : list) {
			model.addRow(v);
		}
		
	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 35));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getFindStr(), BorderLayout.CENTER);
			panel.add(getBtnNewButton(), BorderLayout.EAST);
		}
		return panel;
	}
	public JTextField getFindStr() {
		if (findStr == null) {
			findStr = new JTextField();
			findStr.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						select();
					}
				}
			});
			findStr.setColumns(10);
		}
		return findStr;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("검색");
						
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					select();
				}
			});
			
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {		//테이블에서 마우스가 클릭되면
					
					int row = table.getSelectedRow();
					String id = (String)table.getValueAt(row, 0);
					MemberDto dto = new MemberDto();
					MemberVo vo  = dto.selectOne(id);
					
					if(main.midb==null) {
						main.midb = new MemberInputDB(main);
						main.getDesktopPane().add(main.midb);
					}
					main.midb.loadData(vo);
					main.midb.toFront();
					
					
				}
			});
			String[] header = {"아이디","성명","성별","연락처","등록일"};
			DefaultTableModel model = new DefaultTableModel(null, header);
			table.setModel(model);
		}
		return table;
	}
}













