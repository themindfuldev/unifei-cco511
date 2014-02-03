import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class SelecaoFrame extends JFrame implements ItemListener {
	// Atributos
	private JToggleButton botao1, botao2, botao3, botao4;
	
	public SelecaoFrame() {
		// Construtor da superclasse
		super("Seleção de JToggleButtons");
		
		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setResizable(false);		

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth())/2;
		int posY = (d.height - this.getHeight())/2;
		setLocation(posX, posY);
		
		// Inicialização dos componentes
		botao1 = new JToggleButton("Botão 1");
		botao2 = new JToggleButton("Botão 2");
		botao3 = new JToggleButton("Botão 3");
		botao4 = new JToggleButton("Botão 4");	

		// Configurações dos componentes
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
		
		// Configuração do layout
		Container c = getContentPane();
		c.setLayout(new GridLayout(2, 2));

		// Adição dos componentes		
		c.add(botao1);
		c.add(botao2);		
		c.add(botao3);
		c.add(botao4);		
		
		// Exibição 
		setVisible(true);
		requestFocusInWindow();
	}
	
	public void itemStateChanged(ItemEvent e) {
		Object src = e.getItemSelectable();
		
		// Botão 1
		if (src == botao1) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				botao2.setSelected(false);
				botao3.setSelected(false);
				botao4.setSelected(false);
			}
		}
		
		// Botão 2		
		else if (src == botao2) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				botao1.setSelected(false);
				botao3.setSelected(false);
				botao4.setSelected(false);
			}
		}
		
		// Botão 3		
		else if (src == botao3) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				botao1.setSelected(false);
				botao2.setSelected(false);
				botao4.setSelected(false);
			}
		} 
		
		// Botão 4		
		else if (src == botao4) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				botao1.setSelected(false);
				botao2.setSelected(false);
				botao3.setSelected(false);
			}
		}
	}	
}
