import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PintorDePanel extends JFrame implements ActionListener {
	// Atributos
	private JPanel panel;
	private JButton botao;

	public PintorDePanel() {
		// Construtor da superclasse
		super("Pintor de Panel");

		// Inicializa��o
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setResizable(false);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);

		// Inicializa��o dos componentes
		panel = new JPanel();
		botao = new JButton("Escolher cor");

		// Configura��es dos componentes
		panel.setBackground(Color.WHITE);

		// Registro dos listeners
		botao.addActionListener(this);
		botao.setMnemonic(KeyEvent.VK_E);

		// Configura��o do layout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		// Adi��o dos componentes
		c.insets = new Insets(10, 0, 0, 0);		
		c.ipady = 200;
		c.ipadx = 200;
		add(panel, c);
		c.gridy = 1;
		c.insets = new Insets(10, 0, 10, 0);
		c.ipady = 0;
		c.ipadx = 0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.PAGE_END;
		add(botao, c);

		// Exibi��o e retirada de foco
		setVisible(true);
		requestFocus();
	}

	// Manipulador de a��es
	public void actionPerformed(ActionEvent e) {
		Object origem = e.getSource();

		// Bot�o
		if (origem == botao) {
			// Escolha da cor
			Color novaCor = JColorChooser.showDialog(this,
					"Escolha a cor do fundo", panel.getBackground());

			// Atribui��o se v�lida
			if (novaCor != null) {
				panel.setBackground(novaCor);
			}	

			// Retirada de foco
			requestFocus();
		}
	}
}
