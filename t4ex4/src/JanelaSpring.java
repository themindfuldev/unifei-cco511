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
		SpringUtilities.makeCompactGrid(c, campos.length, 2, 10, 10, 6, 6);
		
		// Compactação
      pack();      

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);
		
		// Exibição
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
		    txt[i] = new JTextField(15);
		}
	}
}
