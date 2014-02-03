import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("serial")
public class DialogoAlterarDisciplina extends JDialog implements ActionListener
{
	// Atributos
	private JLabel lblNomeDisciplina, lblCreditos;
	private JTextField txtNomeDisciplina, txtCreditos;
	private JButton btnAlterar, btnCancelar;
	private JPanel pnlBotoes, pnlAlterar;
	private Controle controle;
	private int codigo;

	// Construtor
	public DialogoAlterarDisciplina(JFrame pai, Controle controle, int codigo)
	{
		// Construtor da superclasse
		super(pai, "Alterar disciplina",
				true);

		// Inicialização dos componentes
		this.controle = controle;
		this.codigo = codigo;
		initComponents();
		initDados();

		// Inicialização
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(400, 150);
		setResizable(false);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);

		// Registro dos listeners
		btnAlterar.addActionListener(this);
		btnCancelar.addActionListener(this);

		// Configuração do layout
		pnlBotoes.setLayout(new FlowLayout());
		pnlBotoes.add(btnAlterar);
		pnlBotoes.add(Box.createRigidArea(new Dimension(30, 0)));
		pnlBotoes.add(btnCancelar);

		pnlAlterar.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		pnlAlterar.add(lblNomeDisciplina, c);
		c.gridx = 1;
		pnlAlterar.add(txtNomeDisciplina, c);
		c.gridy = 1;
		c.gridx = 0;
		pnlAlterar.add(lblCreditos, c);
		c.gridx = 1;
		c.ipadx = 200;
		pnlAlterar.add(txtCreditos, c);
		c.ipadx = 0;
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 2;
		c.ipady = 20;
		pnlAlterar.add(Box.createVerticalGlue(), c);
		c.gridy = 3;
		c.ipady = 0;
		c.fill = GridBagConstraints.NONE;
		pnlAlterar.add(pnlBotoes, c);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(pnlAlterar, BorderLayout.CENTER);

		setVisible(true);
	}

	private void initDados()
	{
		ArrayList<ArrayList<Object>> cons = consultaDisciplinas(" WHERE CODIGO = "
				+ codigo);
		ArrayList<Object> tupla = cons.get(0);
		txtNomeDisciplina.setText(tupla.get(1).toString());
		txtCreditos.setText(tupla.get(2).toString());
	}

	private void initComponents()
	{
		pnlBotoes = new JPanel();
		pnlAlterar = new JPanel();

		lblNomeDisciplina = new JLabel("Nome [*]: ");
		lblCreditos = new JLabel("Créditos [*]: ");

		txtNomeDisciplina = new JTextField(25);
		txtCreditos = new JTextField(2);

		btnAlterar = new JButton("Alterar");
		btnCancelar = new JButton("Cancelar");
	}

	public void actionPerformed(ActionEvent e)
	{
		JButton btn = (JButton) e.getSource();
		// Alterar
		if (btn == btnAlterar)
		{
			if (validarInserirDisciplina())
			{
				String nome = txtNomeDisciplina.getText();
				int creditos = Integer.parseInt(txtCreditos.getText());

				alterarDisciplina(nome, creditos);
				dispose();
			}
			else JOptionPane.showMessageDialog(null, "Há campos em branco",
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		// Cancelar
		else
		{
			dispose();
		}
	}

	// Valida a entrada.
	private boolean validarInserirDisciplina()
	{
		boolean[] checado = new boolean[2];
		checado[0] = !txtNomeDisciplina.getText().equals("");
		checado[1] = !txtCreditos.getText().equals("");

		boolean valido = true;
		for (boolean b : checado)
		{
			valido &= b;
		}

		return valido;
	}

	// Chamada do controle para alteração.	
	private void alterarDisciplina(String nome, int creditos)
	{
		try
		{
			controle.alterarDisciplina(codigo, nome, creditos);
			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (SQLException ex)
		{
			String erro = "Ocorreram os seguintes erros:\n";
			while (ex != null)
			{
				erro += "\n" + ex.getMessage();
				erro += "\nError Code: " + ex.getErrorCode();
				erro += "\nSQL State: " + ex.getSQLState();
				ex = ex.getNextException();
			}
			JOptionPane.showMessageDialog(this, erro, "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

// Chamada do controle para consulta.
	private ArrayList<ArrayList<Object>> consultaDisciplinas(String consulta)
	{
		try
		{
			return controle.consultaDisciplinas(consulta);
		}
		catch (SQLException ex)
		{
			JOptionPane.showMessageDialog(this,
					"Erro inesperado no banco de dados", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

}
