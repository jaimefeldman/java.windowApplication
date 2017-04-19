package toolbar;

import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MainToolBar extends JToolBar {
	

	private static final long serialVersionUID = 1L;
	
	public MainToolBar() {
	
		/*
		
		JButton exitButton = new JButton();
		Border  ToolBarButtonBorder = BorderFactory.createEmptyBorder(3,3,3,3);
		
		exitButton.setBorder(ToolBarButtonBorder);
		try {
			BufferedImage imgExit = ImageIO.read(new File("images/toolbar/exit.png"));
			exitButton.setIcon(new ImageIcon(imgExit));

		} catch (IOException e) {
			System.err.println("Imposible cargar las imagenes de los botones.");
		}
	
		exitButton.setSize(200, 200);
		
		*/
		
		JPanel tabMainPanel = new TabbedPanel();
		add(tabMainPanel);
	}
	

}
