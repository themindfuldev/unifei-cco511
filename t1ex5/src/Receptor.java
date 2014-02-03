import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Receptor extends JFrame implements AlteraBotao {
	// Atributos
	private JLabel label;
	
	// Construtor
	public Receptor() {
		// Construtor da superclasse
		super("Receptor");		
	
		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 100);
		setResizable(false);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = d.height/2;// + this.getHeight();
		setLocation(posX, posY);

		// Inicialização dos componentes
		label = new JLabel("Nenhuma opção selecionada!");
		
		// Configuração do layout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		// Adição dos componentes
		add(label, c);
		
		// Exibição 
		setVisible(true);
	}

	public void alterar(String nome) {
		label.setText(nome + " selecionada!");
	}

}
