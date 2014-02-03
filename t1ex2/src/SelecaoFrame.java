import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class SelecaoFrame extends JFrame implements ItemListener {
	// Atributos
	private JToggleButton botao1, botao2, botao3, botao4;
	
	public SelecaoFrame() {
		// Construtor da superclasse
		super("Sele��o de JToggleButtons");
		
		// Inicializa��o
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setResizable(false);		

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth())/2;
		int posY = (d.height - this.getHeight())/2;
		setLocation(posX, posY);
		
		// Inicializa��o dos componentes
		botao1 = new JToggleButton("Bot�o 1");
		botao2 = new JToggleButton("Bot�o 2");
		botao3 = new JToggleButton("Bot�o 3");
		botao4 = new JToggleButton("Bot�o 4");	

		// Configura��es dos componentes
		botao4.setSelected(true);
		botao1.setMnemonic(KeyEvent.VK_1);
		botao2.setMnemonic(KeyEvent.VK_2);
		botao3.setMnemonic(KeyEvent.VK_3);
		botao4.setMnemonic(KeyEvent.VK_4);
		
		// Registro dos listeners
		botao1.addItemListener(this);
		botao2.addItemListener(this);
		botao3.addItemListener(this);
		botao4.addItemListener(this);
		
		// Configura��o do layout
		Container c = getContentPane();
		c.setLayout(new GridLayout(2, 2));

		// Adi��o dos componentes		
		c.add(botao1);
		c.add(botao2);		
		c.add(botao3);
		c.add(botao4);		
		
		// Exibi��o 
		setVisible(true);
		requestFocusInWindow();
	}
	
	public void itemStateChanged(ItemEvent e) {
		Object src = e.getItemSelectable();
		
		// Bot�o 1
		if (src == botao1) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				botao2.setSelected(false);
				botao3.setSelected(false);
				botao4.setSelected(false);
			}
		}
		
		// Bot�o 2		
		else if (src == botao2) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				botao1.setSelected(false);
				botao3.setSelected(false);
				botao4.setSelected(false);
			}
		}
		
		// Bot�o 3		
		else if (src == botao3) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				botao1.setSelected(false);
				botao2.setSelected(false);
				botao4.setSelected(false);
			}
		} 
		
		// Bot�o 4		
		else if (src == botao4) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				botao1.setSelected(false);
				botao2.setSelected(false);
				botao3.setSelected(false);
			}
		}
	}	
}
