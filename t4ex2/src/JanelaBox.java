import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JanelaBox extends JFrame
{
	// Atributos
	private JPanel pnlT, pnlC, pnlB;
	private JButton btnTL, btnT, btnTR, btnL, btnC, btnR, btnBL, btnB, btnBR;
	
	// Construtor
	public JanelaBox() {		
		// Construtor da superclasse
		super("BoxLayout");
		
		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 200);
		setResizable(false);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);

		// Inicialização dos componentes
		initComponents();

		// Configurações dos componentes
		pnlT.setLayout(new BoxLayout(pnlT, BoxLayout.X_AXIS));
		pnlT.add(btnTL);
		pnlT.add(Box.createHorizontalGlue());
		pnlT.add(btnT);
		pnlT.add(Box.createHorizontalGlue());
		pnlT.add(btnTR);
		pnlC.setLayout(new BoxLayout(pnlC, BoxLayout.X_AXIS));
		pnlC.add(btnL);
		pnlC.add(Box.createHorizontalGlue());
		pnlC.add(btnC);
		pnlC.add(Box.createHorizontalGlue());
		pnlC.add(btnR);
		pnlB.setLayout(new BoxLayout(pnlB, BoxLayout.X_AXIS));
		pnlB.add(btnBL);
		pnlB.add(Box.createHorizontalGlue());
		pnlB.add(btnB);
		pnlB.add(Box.createHorizontalGlue());
		pnlB.add(btnBR);

		// Adição dos componentes
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		c.add(pnlT);
		c.add(Box.createVerticalGlue());
		c.add(pnlC);
		c.add(Box.createVerticalGlue());
		c.add(pnlB);
		
		// Exibição
		setVisible(true);
		requestFocusInWindow();

	}
	
	// Inicialização dos componentes
	private void initComponents() {
		pnlT = new JPanel();
		pnlC = new JPanel();
		pnlB = new JPanel();
		btnTL = new JButton("TOP-LEFT");
		btnT = new JButton("TOP");
		btnTR = new JButton("TOP-RIGHT");
		btnL = new JButton("LEFT");
		btnC = new JButton("CENTER");
		btnR = new JButton("RIGHT");
		btnBL = new JButton("BOTTOM-LEFT");
		btnB = new JButton("BOTTOM");
		btnBR = new JButton("BOTTOM-RIGHT");
	}
}
