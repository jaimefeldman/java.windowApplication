package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

public class MainMenu extends JMenuBar {

	
	private static final long serialVersionUID = 1L;

	public MainMenu() {
		
		JMenu mnArchivo = new JMenu("Archivo");
		JCheckBoxMenuItem  chBoxMenuItemShelf = new JCheckBoxMenuItem("Shelf");
		
		mnArchivo.setMnemonic(KeyEvent.VK_A + ActionEvent.ALT_MASK);
		//mnArchivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
		

		chBoxMenuItemShelf.addItemListener(new  ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println("Chequado? :" + chBoxMenuItemShelf.isSelected());
			}
		});
		
		/*chBoxMenuItemShelf.setMnemonic(KeyEvent.VK_C);
		Action chBoxAction = new AbstractAction("Check") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("cambiando estado..");
			}
		};*/
		
		//chBoxAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
		//chBoxMenuItemShelf.setAction(chBoxAction);
		
		KeyStroke keyStrokeToCheck = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.META_DOWN_MASK);
		chBoxMenuItemShelf.setAccelerator(keyStrokeToCheck);
		
		mnArchivo.add(chBoxMenuItemShelf);
		add(mnArchivo);
	}
	
}
