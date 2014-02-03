import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JanelaPopUp extends JFrame {
	// Atributos
	private JPopupMenu menu;
	private JMenuItem item1, item2, item3;
	private Icon icone1, icone2, icone3;
	
	// Contrutor
	public JanelaPopUp() {
		// Construtor da superclasse
		super("Menu Pop-up com botão direito");
		
		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setResizable(false);		

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth())/2;
		int posY = (d.height - this.getHeight())/2;
		setLocation(posX, posY);
		
		// Inicialização dos componentes
		menu = new JPopupMenu();
		icone1 = javax.swing.plaf.metal.MetalIconFactory.getFileChooserHomeFolderIcon();		
		icone2 = javax.swing.plaf.metal.MetalIconFactory.getTreeComputerIcon();
		icone3 = javax.swing.plaf.metal.MetalIconFactory.getTreeFloppyDriveIcon();
		item1 = new JMenuItem("Casa", icone1);
		item2 = new JMenuItem("Computador", icone2);
		item3 = new JMenuItem("Disquete", icone3);

		// Configurações dos componentes		
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		
		// Registro dos listeners
		addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent e) {
		        maybeShowPopup(e);
		    }

		    public void mouseReleased(MouseEvent e) {
		        maybeShowPopup(e);
		    }

		    private void maybeShowPopup(MouseEvent e) {
		        if (e.isPopupTrigger()) {
		            menu.show(e.getComponent(), e.getX(), e.getY());
		        }
		    }
		});
		
		// Exibição 
		setVisible(true);
	}

}
