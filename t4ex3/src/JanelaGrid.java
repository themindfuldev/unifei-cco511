import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class JanelaGrid extends JFrame
{
	// Atributos
	private JButton b1, b2, b3, b4, b5;
	
	// Construtor
	public JanelaGrid() {		
		// Construtor da superclasse
		super("GridBagLayout");
		
		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 250);
		setResizable(false);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);

		// Inicialização dos componentes
		initComponents();

		// Configuração do layout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		// Adição dos componentes
		c.weightx = 1;
		c.gridwidth = 3;
		add(b1, c);		
		c.gridwidth = 1;
		c.gridy = 1;
		c.weighty = 50;		
		add(b2, c);
		c.weightx = 3;
		c.gridx = 1;
		add(b3, c);
		c.weightx = 2;
		c.gridx = 2;
		add(b4, c);
		c.weightx = 1;
		c.gridwidth = 3;
		c.weighty = 0;
		c.gridy = 2;
		c.gridx = 0;
		c.ipadx = 0;		
		add(b5, c);
		
		// Exibição
		setVisible(true);
		requestFocusInWindow();

	}
	
	// Inicialização dos componentes
	private void initComponents() {
		b1 = new JButton("PAGE_START");
	   b2 = new JButton("LINE_START");
	   b3 = new JButton("CENTER");
	   b4 = new JButton("LINE_END");
	   b5 = new JButton("PAGE_END");
	}
}
