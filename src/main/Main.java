package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import windows.DesktopMainWindow;
import windows.ExitPreProceso;


public class Main {
	
	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		if(osName.contains("Mac")) {
			System.out.println("Running on mac os.");
			System.setProperty("apple.eawt.quitStrategy", "CLOSE_ALL_WINDOWS");

		}

		// Listando los Look and Feel disponibles.
		UIManager.LookAndFeelInfo[] looksList = UIManager.getInstalledLookAndFeels();
		System.out.println("** Listando los tipos de Look and feel disponibles **");
		for(UIManager.LookAndFeelInfo looks : looksList) {
			System.out.println(looks.getClassName());
		}
		 
		try {
			//UIManager.setLookAndFeel(looksList[0].getClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Hilo Principal: " + Thread.currentThread().getName());

		SwingUtilities.invokeLater(new Runnable() {
			boolean isClosingInProcess = false;
			
			
			@Override
			public void run() {
				
				
				
				System.out.println("Hilo EDT (Event Dispatch Thread: " + Thread.currentThread().getName());
				DesktopMainWindow mainWindow = new DesktopMainWindow();
				mainWindow.setVisible(true);
				mainWindow.addWindowListener(new WindowListener() {
					
					@Override
					public void windowOpened(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowClosing(WindowEvent e) {
						
						if(!isClosingInProcess) {
							isClosingInProcess = true;
							//int res = JOptionPane.showConfirmDialog(mainWindow, "Are you sure you want to exit the program?", "Quit ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, new String[] {"Si", "No"}, "No");
							Object[] optons = {"Yes", "No"};
							int res = JOptionPane.showOptionDialog(null, "Seguro que desea salir de la aplicación", "Cerrando la Aplicación", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optons, optons[1]);
							
							if (res == JOptionPane.YES_OPTION) {
								mainWindow.setVisible(false);
								mainWindow.dispose();
								ExitPreProceso exitPreProceso = new ExitPreProceso();
								
							} else {
								System.out.println("NO pressed");
								isClosingInProcess = false;
							}
						}
					   
					}
					
					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
											
					}
					
					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
			}
		});
	}
}
