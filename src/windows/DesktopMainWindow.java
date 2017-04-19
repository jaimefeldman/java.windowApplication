package windows;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import menus.MainMenu;
import toolbar.MainToolBar;

public class DesktopMainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public DesktopMainWindow() {
		super("Business Manager");
		
		JDesktopPane 	desktop = new JDesktopPane();
		JInternalFrame 	internalFrame = new JInternalFrame("Clientes", true, true, true,true);
		
		
		desktop.add(internalFrame);
		internalFrame.setBounds(25, 35, 300, 400);
		
		JLabel label = new JLabel("Clinetes", JLabel.CENTER);
		internalFrame.add(label, BorderLayout.CENTER);
		
		internalFrame.setVisible(true);

		

		
		
		getContentPane().add(new MainToolBar(), BorderLayout.PAGE_START);
		setJMenuBar(new MainMenu());
		
		add(desktop, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(1024, 800);
		setLocationRelativeTo(null);
		
	}
	
}
