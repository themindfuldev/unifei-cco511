import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class JanelaAbas extends JFrame
{
	// Atributos
	private JPanel pnlSelecao, pnlBotoes, pnlTexto;
	private JTabbedPane tabAbas;
	private JComboBox cmbSelecao;
	private JButton btn1, btn2, btn3;
	private JTextField txt1;
	
	// Construtor
	public JanelaAbas() {
		// Construtor da superclasse
		super("Abas");

		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 150);
		setResizable(false);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);

		// Inicialização dos componentes
		initComponents();

		// Configurações dos componentes
		cmbSelecao.addItem("JPanel com JButtons");
		cmbSelecao.addItem("JPanel com JTextField");
		pnlSelecao.add(cmbSelecao);
		pnlBotoes.add(btn1);
		pnlBotoes.add(btn2);
		pnlBotoes.add(btn3);
		pnlTexto.add(txt1);
		tabAbas.addTab("Botões", null, pnlBotoes, "Três botões");
		tabAbas.setMnemonicAt(0, 'B');
		tabAbas.addTab("Texto", null, pnlTexto, "Uma caixa de texto");
		tabAbas.setMnemonicAt(1, 'T');

		// Registro dos listeners
		cmbSelecao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				int aba = cmbSelecao.getSelectedIndex();
				tabAbas.setSelectedIndex(aba);
			}
		});
		tabAbas.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int aba = tabAbas.getSelectedIndex();
				cmbSelecao.setSelectedIndex(aba);
			}
		});

		// Configuração do layout
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		// Adição dos componentes
	   c.add(pnlSelecao, BorderLayout.PAGE_START);
	   c.add(Box.createVerticalGlue(), BorderLayout.CENTER);
	   c.add(tabAbas, BorderLayout.PAGE_END);

		// Exibição
		setVisible(true);
		requestFocusInWindow();

	}
	
	// Inicialização dos componentes
	private void initComponents() {
		pnlSelecao = new JPanel();
		pnlBotoes = new JPanel();
		pnlTexto = new JPanel();
		tabAbas = new JTabbedPane();
		cmbSelecao = new JComboBox();
		btn1 = new JButton("Botão 1");
		btn2 = new JButton("Botão 2");
		btn3 = new JButton("Botão 3");
		txt1 = new JTextField(20);
	}
	
}
