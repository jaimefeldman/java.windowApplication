package toolbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

public class TabbedPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private JButton exitButton;

	public TabbedPanel() {
		loadButtons();
		ImageIcon icon = new ImageIcon("/images/tab/usuariosTab.png");
		JTabbedPane jtbExample = new JTabbedPane(JTabbedPane.SCROLL_TAB_LAYOUT);
		JPanel pjlInnerPanel1  = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pjlInnerPanel1.add(exitButton);
		
		jtbExample.addTab("Cuentas", icon, pjlInnerPanel1, "Tab 1");
		jtbExample.setSelectedIndex(0);
		
		JPanel pjlInnerPanel2 = createInnerPanel("Tab 2 Contiene otra cosa");
		jtbExample.addTab("Configuracion", icon, pjlInnerPanel2, "Tab2");
		
		JPanel pjlInnerPanel3 = createInnerPanel("Tab 2 Contiene otra cosa");
		jtbExample.addTab("Factoring", icon, pjlInnerPanel3, "Tab2");

		setLayout(new GridLayout(1, 1));
		jtbExample.setPreferredSize(new Dimension(400, 125));
		add(jtbExample);
	}
	
	
	protected JPanel createInnerPanel(String text) {
		JPanel contentPanel	 = new JPanel();
		JLabel displayLabel  = new JLabel(text);
		displayLabel.setHorizontalAlignment(JLabel.CENTER);	
		displayLabel.setLayout(new GridLayout(1, 1));
		contentPanel.add(displayLabel);
		return contentPanel;
	}
	
	private void loadButtons() {
		
		Border  ToolBarButtonBorder = BorderFactory.createEmptyBorder(3,3,3,3);

		exitButton = new JButton();
		exitButton.setBorder(ToolBarButtonBorder);
		try {
			BufferedImage imgExit = ImageIO.read(new File("images/toolbar/exit.png"));
			exitButton.setIcon(new ImageIcon(imgExit));

		} catch (IOException e) {
			System.err.println("Imposible cargar las imagenes de los botones.");
		}
	
		//exitButton.setSize(200,200);
		
	}
}
