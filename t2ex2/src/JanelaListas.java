import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class JanelaListas extends JFrame implements ListSelectionListener {
	// Atributos
	private JList lstLista1, lstLista2;
	private JScrollPane scroll1, scroll2;
	private DefaultListModel modelo1, modelo2;

	// Contrutor
	public JanelaListas() {
		// Construtor da superclasse
		super("Listas");

		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setResizable(false);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);

		// Inicialização dos modelos
		modelo1 = new DefaultListModel();
		modelo1.addElement("Um");
		modelo1.addElement("Dois");
		modelo1.addElement("Três");
		modelo1.addElement("Quatro");
		modelo1.addElement("Cinco");

		modelo2 = new DefaultListModel();
		modelo2.addElement("1");
		modelo2.addElement("2");
		modelo2.addElement("3");
		modelo2.addElement("4");
		modelo2.addElement("5");

		// Inicialização dos componentes
		lstLista1 = new JList(modelo1);
		lstLista2 = new JList(modelo2);
		scroll1 = new JScrollPane(lstLista1,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2 = new JScrollPane(lstLista2,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Configurações dos componentes
		lstLista1.setSize(100, 100);
		lstLista2.setSize(100, 100);
		lstLista1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstLista2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Registro dos listeners
		lstLista1.addListSelectionListener(this);
		lstLista2.addListSelectionListener(this);

		// Configuração do layout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		// Adição dos componentes
		c.weightx = 1;
		c.insets = new Insets(10, 10, 10, 10);
		add(scroll1, c);
		c.gridx = 1;
		add(scroll2, c);

		// Exibição
		setVisible(true);
	}

	// Manipulador de eventos
	public void valueChanged(ListSelectionEvent e) {
		JList lista = (JList) e.getSource();
		Object elemento;

		if (lista == lstLista1) {
			elemento = lista.getSelectedValue();
			if (elemento != null) {
				modelo1.removeElement(elemento);
				modelo2.addElement(elemento);
			}
			requestFocusInWindow();
		} else if (lista == lstLista2) {
			elemento = lista.getSelectedValue();
			if (elemento != null) {
				modelo2.removeElement(elemento);
				modelo1.addElement(elemento);
			}
			requestFocusInWindow();
		}
	}

}
