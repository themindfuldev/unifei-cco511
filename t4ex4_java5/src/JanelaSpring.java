import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class JanelaSpring extends JFrame
{
	// Atributos
	private JLabel[] lbl;
	private JTextField[] txt;
	private String[] campos	= {"Nome: ", "Endereço: ", "Telefone: ", "E-mail: "};
	
	// Construtor
	public JanelaSpring() {		
		// Construtor da superclasse
		super("SpringLayout");
		
		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);

		// Inicialização dos componentes
		initComponents();
		
		// Configuração do layout
		Container c = getContentPane();
		SpringLayout layout = new SpringLayout();
		c.setLayout(layout);

		// Adição dos componentes
		for (int i=0; i < campos.length; i++) {
			c.add(lbl[i]);
			c.add(txt[i]);
		}
		
		// Configuração do layout dos componentes 
		int i=0;
		layout.putConstraint(SpringLayout.WEST, lbl[i], 10, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, lbl[i], 10, SpringLayout.NORTH, c);
		layout.putConstraint(SpringLayout.WEST, txt[i], 10, SpringLayout.EAST, lbl[i]);
		layout.putConstraint(SpringLayout.NORTH, txt[i], 10, SpringLayout.NORTH, c);
		i++;
		for (;i < campos.length; i++) {
			layout.putConstraint(SpringLayout.WEST, lbl[i], 10, SpringLayout.WEST, c);
			layout.putConstraint(SpringLayout.NORTH, lbl[i], 25, SpringLayout.NORTH, lbl[i-1]);
			layout.putConstraint(SpringLayout.WEST, txt[i], 10, SpringLayout.EAST, lbl[i]);
			layout.putConstraint(SpringLayout.NORTH, txt[i], 25, SpringLayout.NORTH, txt[i-1]);
		}

      layout.putConstraint(SpringLayout.EAST, c, 10, SpringLayout.EAST, txt[1]);
      layout.putConstraint(SpringLayout.SOUTH, c, 10, SpringLayout.SOUTH, txt[3]);
		
		// Exibição
      pack();
		setVisible(true);
		requestFocusInWindow();

	}

	private void initComponents()
	{
		int num = campos.length;
		
		lbl = new JLabel[num];
		txt = new JTextField[num];
		
		for (int i=0; i < num; i++) {
		    lbl[i] = new JLabel(campos[i], JLabel.TRAILING);
		    txt[i] = new JTextField(10);
		}
	}
}
