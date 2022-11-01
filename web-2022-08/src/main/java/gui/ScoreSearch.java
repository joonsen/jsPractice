package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import iostream.ScoreDao;
import iostream.ScoreVo;

public class ScoreSearch extends JInternalFrame {
	MyInterMain main;
	
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
					ScoreSearch frame = new ScoreSearch();
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
	public ScoreSearch(MyInterMain main) {
		this();
		this.main = main;
	}
	
	
	public ScoreSearch() {
		super("성적조회", true, true, true, true);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.ss = null;
			}
		});
		setVisible(true);
		setBounds(100, 100, 528, 447);
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);

	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 24));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getFindStr(), BorderLayout.CENTER);
			panel.add(getBtnNewButton(), BorderLayout.EAST);
		}
		return panel;
	}
	public JTextField getFindStr() {
		if (findStr == null) {
			findStr = new JTextField();
			findStr.setColumns(10);
		}
		return findStr;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("검색");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String find = findStr.getText().trim();
					ScoreDao dao = new ScoreDao();
					List<ScoreVo> list = dao.read();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for(ScoreVo vo : list) {
						if(vo.getId().contains(find) || vo.getSubject().contains(find)) {
							model.addRow(vo.getVector());
						}
					}
					table.updateUI();
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
			DefaultTableModel model = new DefaultTableModel();
			String[] header = {"순번","아이디","시험일자","과목","점수"};
			model.setDataVector(null, header);
			
			table = new JTable(model);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					if(main.si == null) {
						main.si = new ScoreInput(main);
						main.getDesktopPane().add(main.si);
						main.getDesktopPane().updateUI();
						main.si.toFront();
						
					}
					Integer serial = (Integer)table.getValueAt(row,0);
					String id = (String)table.getValueAt(row,1);
					String mDate = (String)table.getValueAt(row,2);
					String subject = (String)table.getValueAt(row,3);
					int score = (Integer)table.getValueAt(row, 4);
					
					main.si.getTfSerial().setText(serial.toString());
					main.si.getTfId().setText(id);
					main.si.getTfMdate().setText(mDate);;
					main.si.getTfSubject().setText(subject);;
					main.si.getTfScore().setText(score+"");
					
				}
			});

		}
		return table;
	}
}






