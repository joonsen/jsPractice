package iostream;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MyTextEditor extends JFrame {
	protected static Editor target;
	
	private JDesktopPane desktopPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyTextEditor frame = new MyTextEditor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void fileSave() {
		try {
			String data = target.getTextArea().getText();
			byte[] bytes = data.getBytes();
			File file = new File(target.getFileName());
			OutputStream os = new FileOutputStream(file);
			os.write(bytes);
			os.close();
		}catch(Exception ex){
			JOptionPane.showMessageDialog(MyTextEditor.this , ex.getMessage());
		}
	}
	
	
	public MyTextEditor() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getDesktopPane_1(), BorderLayout.CENTER);
		setJMenuBar(getMenuBar_1());

	}

	public JDesktopPane getDesktopPane_1() {
		if (desktopPane == null) {
			desktopPane = new JDesktopPane();
			desktopPane.setLayout(null);
		}
		return desktopPane;
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}
	public JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("File");
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_2());
			mnNewMenu.add(getMntmNewMenuItem_3());
		}
		return mnNewMenu;
	}
	public JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("새파일");
			
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JInternalFrame editor = new Editor();
					desktopPane.add(editor);
					desktopPane.updateUI();
					editor.toFront();
					target = (Editor) editor;
				}
				
			});
		}
		return mntmNewMenuItem;
	}
	public JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("열기");
			
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						JFileChooser fc = new JFileChooser();
						int flag = fc.showOpenDialog(MyTextEditor.this);
						if(flag == JFileChooser.APPROVE_OPTION) {
							File f = fc.getSelectedFile();
							StringBuffer sb = new StringBuffer();
							int readCnt = -1;
							byte[] bytes = new byte[4096];
							InputStream is = new FileInputStream(f);
							while( (readCnt = is.read(bytes)) != -1 ) {		//일리가 있는 복잡함
								sb.append(new String(bytes, 0, readCnt));
							}
							Editor editor = new Editor();
							editor.setFileName(f.getPath());		//파일경로를 이름으로 지정
							editor.getTextArea().setText(sb.toString());
							
							desktopPane.add(editor);
							desktopPane.updateUI();
							editor.toFront();
							
							target = editor;
							
						}
					}catch(Exception ex) {
							JOptionPane.showMessageDialog(MyTextEditor.this, ex.getMessage());
						
						}
				}
				
			});
		}
		return mntmNewMenuItem_1;
	}
	public JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("저장");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//파일명 지정 여부
					String fn = target.getFileName();
					if(fn.equals("noname.txt")) {
						JFileChooser fc = new JFileChooser();
						int flag = fc.showSaveDialog(MyTextEditor.this);
						if(flag == JFileChooser.APPROVE_OPTION) {// 확인버튼
							File f = fc.getSelectedFile();
							target.setFileName(f.getPath());
							fileSave();
						}
					}else {
						fileSave();
					}
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	public JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("새이름으로");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					int flag = fc.showSaveDialog(MyTextEditor.this);
					if(flag == JFileChooser.APPROVE_OPTION) {// 확인버튼
						File f = fc.getSelectedFile();
						target.setFileName(f.getPath());
						fileSave();
					}
				}
			});
		}
		return mntmNewMenuItem_3;
	}
	
}
