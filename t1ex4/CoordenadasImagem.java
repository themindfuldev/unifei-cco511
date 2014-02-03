import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CoordenadasImagem extends JFrame {
	// Atributos
	private JLabel imagemLabel, coordLabel;
	private JPanel imagemPanel;
	
	public CoordenadasImagem() {
		// Construtor da superclasse
		super("Pintor de Panel");

		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 400);
		setResizable(false);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);

		// Inicialização dos componentes
		Icon imagem = new ImageIcon("lib/efei.jpg");
		imagemLabel = new JLabel(imagem);
		coordLabel = new JLabel("Clique com o botão principal do mouse!");
		imagemPanel = new JPanel();

		// Configurações dos componentes
		imagemPanel.add(imagemLabel);
		imagemPanel.setBorder(BorderFactory.createEtchedBorder());

		// Registro dos listeners
		imagemLabel.addMouseListener(new MouseAdapter(){
			 public void mouseClicked(MouseEvent e) {
				 coordLabel.setText("Posição: (" + e.getX() + ", " + e.getY() + ")");
			 }
		});

		// Configuração do layout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		// Adição dos componentes
		c.insets = new Insets(10, 0, 0, 0);		
		add(imagemPanel, c);
		c.gridy = 1;
		c.insets = new Insets(10, 0, 10, 0);
		add(coordLabel, c);

		// Exibição 
		setVisible(true);
	}

}
