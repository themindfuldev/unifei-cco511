import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BotoesCallback extends JFrame implements ItemListener {
	// Atributos
	private AlteraBotao ab;
	private JRadioButton rb1, rb2, rb3, rb4;
	private ButtonGroup grp;
	
	// Construtor
	public BotoesCallback(AlteraBotao ab) {
		// Construtor da superclasse
		super("RadioButtons");
		
		// Atribui��o
		this.ab = ab; 
		
		// Inicializa��o
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setResizable(false);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = d.height/2 - this.getHeight();
		setLocation(posX, posY);

		// Inicializa��o dos componentes
		rb1 = new JRadioButton("Op��o 1");
		rb2 = new JRadioButton("Op��o 2");
		rb3 = new JRadioButton("Op��o 3");
		rb4 = new JRadioButton("Op��o 4");
		grp = new ButtonGroup();
		
		// Configura��es dos componentes
		grp.add(rb1);
		grp.add(rb2);
		grp.add(rb3);
		grp.add(rb4);
		
		// Registro dos listeners
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		rb3.addItemListener(this);
		rb4.addItemListener(this);
		
		// Configura��o do layout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		// Adi��o dos componentes
		c.insets = new Insets(10, 0, 0, 0);		
		add(rb1, c);
		c.gridy = 1;
		add(rb2, c);
		c.gridy = 2;
		add(rb3, c);
		c.gridy = 3;	
		c.insets = new Insets(10, 0, 10, 0);
		add(rb4, c);
		
		// Exibi��o 
		setVisible(true);
		requestFocusInWindow();
	}
	
	// Manipulador de mudan�a de estado dos RadioButtons
	public void itemStateChanged(ItemEvent e) {
		JToggleButton rb = (JToggleButton) e.getSource();
		if (e.getStateChange() == ItemEvent.SELECTED)
			ab.alterar(rb.getText());
	}

}
