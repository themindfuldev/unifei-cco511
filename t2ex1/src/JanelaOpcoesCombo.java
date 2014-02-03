import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JanelaOpcoesCombo extends JFrame implements ActionListener {
	// Atributos
	private JComboBox cmbCombo;
	private JTextField txtTexto;
	private DefaultComboBoxModel modelo;
	
	// Contrutor
	public JanelaOpcoesCombo() {
		// Construtor da superclasse
		super("Opções JComboBox");
		
		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);
		setResizable(false);		

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth())/2;
		int posY = (d.height - this.getHeight())/2;
		setLocation(posX, posY);
		
		// Inicialização dos componentes
		String[] str = {"Um", "Dois", "Três"};
		modelo = new DefaultComboBoxModel(str);
		cmbCombo = new JComboBox(modelo);
		txtTexto = new JTextField(20);		
		
		// Configurações dos componentes		
		cmbCombo.setSelectedIndex(0);		
		
		// Registro dos listeners
		txtTexto.addActionListener(this);
		
		// Configuração do layout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		// Adição dos componentes
		c.insets = new Insets(10, 0, 0, 0);		
		add(cmbCombo, c);
		c.gridy = 1;
		c.insets = new Insets(10, 0, 10, 0);
		add(txtTexto, c);

		// Exibição 
		setVisible(true);			
		txtTexto.requestFocusInWindow();
	}

	// Manipulador de eventos
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == txtTexto) {
			modelo.addElement(txtTexto.getText());
			cmbCombo.requestFocusInWindow();
			cmbCombo.setSelectedItem(txtTexto.getText());
			txtTexto.setText("");
			cmbCombo.showPopup();
		}
	}
}
