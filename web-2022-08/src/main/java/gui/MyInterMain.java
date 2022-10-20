package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import collection.SetFrame;
import thread.ThreadFrame;
import collection.ListFrame;

public class MyInterMain extends JFrame {
	// JInternalFrame을 하나씩만 생성하게 처리
	JInternalFrame mi, ms;
	ScoreInput si;
	ScoreSearch ss;
	
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyInterMain frame = new MyInterMain();
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
	public MyInterMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 477);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getDesktopPane(), BorderLayout.CENTER);
		
		/*
		MemberInput memberInput = new MemberInput();
		memberInput.setSize(437, 223);
		memberInput.setLocation(52, 99);
		desktopPane.add(memberInput);
		desktopPane.updateUI();
		 */
	}

	public JDesktopPane getDesktopPane() {
		if (desktopPane == null) {
			desktopPane = new JDesktopPane();
			
		}
		return desktopPane;
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
			menuBar.add(getMnNewMenu_2());
			menuBar.add(getMnNewMenu_3());
		}
		return menuBar;
	}
	public JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("회원관리");
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
		}
		return mnNewMenu;
	}
	public JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("성적관리");
			mnNewMenu_1.add(getMntmNewMenuItem_6());
			mnNewMenu_1.add(getMntmNewMenuItem_7());
		}
		return mnNewMenu_1;
	}
	public JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("게시판");
		}
		return mnNewMenu_2;
	}
	public JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("회원가입");
			
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(mi ==null) {
						mi = new MemberInput(MyInterMain.this);	//자식객체의 생성자를 가지고 부모객체에 대입(?) 하는것 이것이 다형성
						desktopPane.add(mi);
						desktopPane.updateUI();
						mi.toFront();
					}//창을 가장 위쪽으로 올려줘라. 맨 상단으로 InternalFrame을 올려줌
					//단지 몇개의 코드만가지고도 여러개의 창을 만들수 있다는건 inheritance의 힘.
					//오후엔 회원가입 layout을 만들어보자! db를 연결해서 db에 저장하는것까지 할 예정
				}
			});
		}
		return mntmNewMenuItem;
	}
	public JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("회원조회");
			
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ms==null) {
					
						ms = new MemberSearch(MyInterMain.this);
						desktopPane.add(ms);
						desktopPane.updateUI();
						ms.toFront();
					}
				}
				
			});
		}
		return mntmNewMenuItem_1;
	}
	public JMenu getMnNewMenu_3() {
		if (mnNewMenu_3 == null) {
			mnNewMenu_3 = new JMenu("Util");
			mnNewMenu_3.add(getMntmNewMenuItem_2());
			mnNewMenu_3.add(getMntmNewMenuItem_3());
			mnNewMenu_3.add(getMntmNewMenuItem_4());
			mnNewMenu_3.add(getMntmNewMenuItem_5());
		}
		return mnNewMenu_3;
	}
	public JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("Pattern");
			
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JInternalFrame pf = new PatternFrame();
					desktopPane.add(pf);
					desktopPane.updateUI();
					pf.toFront();
				}
			});
			
		}
		return mntmNewMenuItem_2;
	}
	public JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("List");
			
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListFrame lf = new ListFrame();
					desktopPane.add(lf);
					desktopPane.updateUI();
					lf.toFront();
				}
				
			});
		}
		return mntmNewMenuItem_3;
	}
	public JMenuItem getMntmNewMenuItem_4() {
		if (mntmNewMenuItem_4 == null) {
			mntmNewMenuItem_4 = new JMenuItem("Set");
			
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JInternalFrame set = new SetFrame();
					desktopPane.add(set);
					desktopPane.updateUI();
					set.toFront();
				}
				
			});
		}
		return mntmNewMenuItem_4;
	}
	public JMenuItem getMntmNewMenuItem_5() {
		if (mntmNewMenuItem_5 == null) {
			mntmNewMenuItem_5 = new JMenuItem("Thread");
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame tf = new ThreadFrame();
					desktopPane.add(tf);
					desktopPane.updateUI();
					tf.toFront();
				}
			});
		}
		return mntmNewMenuItem_5;
	}
	public JMenuItem getMntmNewMenuItem_6() {
		if (mntmNewMenuItem_6 == null) {
			mntmNewMenuItem_6 = new JMenuItem("성적 입력");
			
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(si == null) {
						si = new ScoreInput(MyInterMain.this);
						desktopPane.add(si);
						desktopPane.updateUI();
						si.toFront();					}
				}
			});
		}
		return mntmNewMenuItem_6;
	}
	public JMenuItem getMntmNewMenuItem_7() {
		if (mntmNewMenuItem_7 == null) {
			mntmNewMenuItem_7 = new JMenuItem("성적 조회");
			mntmNewMenuItem_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ss == null) {
						ss = new ScoreSearch(MyInterMain.this);
						desktopPane.add(ss);
						desktopPane.updateUI();
						ss.toFront();
					}
				}
			});
		}
		return mntmNewMenuItem_7;
	}
}
