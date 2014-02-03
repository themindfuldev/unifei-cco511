import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class JanelaSlider extends JFrame{
	// Atributos
	private JSlider slider;
	private JProgressBar barra;
	private JPanel painel;
	
	// Construtor
	public JanelaSlider() {
		// Construtor da superclasse
		super("Slider e Barra de Progresso");
		
		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 150);
		setResizable(false);		

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth())/2;
		int posY = (d.height - this.getHeight())/2;
		setLocation(posX, posY);
		
		// Inicialização dos componentes
		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		barra = new JProgressBar();
		painel = new JPanel();

		// Configurações dos componentes
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		barra.setStringPainted(true);
		
		// Registro dos listeners
		slider.addChangeListener(new ChangeListener() {;
			public void stateChanged(ChangeEvent e) {
			    barra.setValue(slider.getValue());
			}
		});
		
		// Configuração do layout
		painel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		// Adição dos componentes
		c.weightx = 1;
		c.insets = new Insets(10, 10, 10, 10);
		painel.add(barra, c);
		c.gridy = 1;
		painel.add(slider, c);
		getContentPane().add(painel);
		
		// Exibição 
		setVisible(true);		
	}
}
