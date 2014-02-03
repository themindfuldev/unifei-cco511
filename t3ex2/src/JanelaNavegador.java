import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JanelaNavegador extends JFrame implements ActionListener
{
	// Atributos
	private JTextField endereco;
	private JEditorPane pagina;
	private JLabel status;
	private JScrollPane scroll;

	public JanelaNavegador()
	{
		// Construtor da superclasse
		super("Navegador");

		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);

		// Inicialização dos componentes
		endereco = new JTextField(100);
		pagina = new JEditorPane();
		status = new JLabel("Status.");
		scroll = new JScrollPane(pagina);

		// Configurações dos componentes
		endereco.setText("http://");
		pagina.setEditable(false);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// Registro dos listeners
		endereco.addActionListener(this);

		// Configuração do layout
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		// Adição dos componentes
		c.add(endereco, BorderLayout.PAGE_START);
		c.add(scroll, BorderLayout.CENTER);
		c.add(status, BorderLayout.PAGE_END);

		// Exibição
		setVisible(true);
		requestFocusInWindow();

	}

	public void actionPerformed(ActionEvent arg0)
	{
		Object obj = arg0.getSource();
		if (obj == endereco)
		{
			try
			{
				pagina.setPage(endereco.getText());
				status.setText(endereco.getText() + " carregado com sucesso.");
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(this, "ERRO: URL inválida!", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
