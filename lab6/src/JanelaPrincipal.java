import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.*;
import java.sql.SQLException;
import java.util.*;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame
{
	// Atributos
	private JPanel pnlInserirAluno, pnlConsultarAluno, pnlInserirDisciplina,
			pnlConsultarDisciplina, pnlBotoesInserirAluno,
			pnlTabelaConsultarAluno, pnlBotoesConsultarAluno,
			pnlBotoesInserirDisciplina, pnlBotoesConsultarDisciplina,
			pnlTabelaConsultarDisciplina;
	private JTabbedPane tabAbas;
	private JLabel lblNomeAluno, lblRg, lblDataDeNascimento, lblFone,
			lblNomeDisciplina, lblCreditos, lblConsultaAlunos,
			lblConsultaDisciplinas;
	private JTextField txtNomeAluno, txtRg, txtDataDeNascimento, txtFone,
			txtNomeDisciplina, txtCreditos, txtConsultaAlunos,
			txtConsultaDisciplinas;
	private JTable tblAlunos, tblDisciplinas;
	private JButton btnInserirAluno, btnConsultarAlunos, btnAlterarAlunos,
			btnRemoverAlunos, btnLimparAlunos, btnInserirDisciplina,
			btnConsultarDisciplinas, btnAlterarDisciplinas, btnRemoverDisciplinas,
			btnLimparDisciplinas;
	private JRadioButton rbtCodigoAluno, rbtNomeAluno, rbtCodigoDisciplina,
			rbtNomeDisciplina;
	private String ultimaConsulta;

	// Relacionamentos
	private Controle controle;

	// Construtor
	public JanelaPrincipal(Controle controle)
	{
		// Construtor da superclasse
		super("Gerenciamento de alunos e disciplinas de uma universidade");

		// Inicialização dos componentes
		this.controle = controle;
		ultimaConsulta = null;
		initComponents();

		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setResizable(false);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);
		setDefaultLookAndFeelDecorated(true);

		// Configuração dos componentes
		tblAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblDisciplinas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ButtonGroup grpAlunos = new ButtonGroup();
		grpAlunos.add(rbtCodigoAluno);
		grpAlunos.add(rbtNomeAluno);
		rbtNomeAluno.setSelected(true);

		ButtonGroup grpDisciplinas = new ButtonGroup();
		grpDisciplinas.add(rbtCodigoDisciplina);
		grpDisciplinas.add(rbtNomeDisciplina);
		rbtNomeDisciplina.setSelected(true);

		// Registro dos listeners
		BotoesListener lisBotoes = new BotoesListener();

		btnLimparAlunos.addActionListener(lisBotoes);
		btnLimparDisciplinas.addActionListener(lisBotoes);
		btnInserirAluno.addActionListener(lisBotoes);
		btnInserirDisciplina.addActionListener(lisBotoes);
		btnConsultarAlunos.addActionListener(lisBotoes);
		btnConsultarDisciplinas.addActionListener(lisBotoes);
		btnRemoverAlunos.addActionListener(lisBotoes);
		btnRemoverDisciplinas.addActionListener(lisBotoes);
		btnAlterarAlunos.addActionListener(lisBotoes);
		btnAlterarDisciplinas.addActionListener(lisBotoes);

		// Configuração do layout
		pnlBotoesInserirAluno.setLayout(new FlowLayout());
		pnlBotoesInserirAluno.add(btnInserirAluno);
		pnlBotoesInserirAluno.add(Box.createRigidArea(new Dimension(30, 0)));
		pnlBotoesInserirAluno.add(btnLimparAlunos);

		pnlInserirAluno.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		pnlInserirAluno.add(lblNomeAluno, c);
		c.gridx = 1;
		pnlInserirAluno.add(txtNomeAluno, c);
		c.gridy = 1;
		c.gridx = 0;
		pnlInserirAluno.add(lblRg, c);
		c.gridx = 1;
		pnlInserirAluno.add(txtRg, c);
		c.gridy = 2;
		c.gridx = 0;
		pnlInserirAluno.add(lblDataDeNascimento, c);
		c.gridx = 1;
		pnlInserirAluno.add(txtDataDeNascimento, c);
		c.gridy = 3;
		c.gridx = 0;
		pnlInserirAluno.add(lblFone, c);
		c.gridx = 1;
		pnlInserirAluno.add(txtFone, c);
		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 2;
		c.ipady = 20;
		pnlInserirAluno.add(Box.createVerticalGlue(), c);
		c.gridy = 5;
		c.ipady = 0;
		c.fill = GridBagConstraints.NONE;
		pnlInserirAluno.add(pnlBotoesInserirAluno, c);

		pnlTabelaConsultarAluno.setLayout(new BorderLayout());
		JScrollPane scrAlunos = new JScrollPane(tblAlunos);
		pnlTabelaConsultarAluno.add(tblAlunos.getTableHeader(),
				BorderLayout.PAGE_START);
		pnlTabelaConsultarAluno.add(scrAlunos, BorderLayout.CENTER);

		pnlBotoesConsultarAluno.setLayout(new GridLayout(10, 1));
		pnlBotoesConsultarAluno.add(btnConsultarAlunos);
		pnlBotoesConsultarAluno.add(Box.createVerticalGlue());
		pnlBotoesConsultarAluno.add(btnAlterarAlunos);
		pnlBotoesConsultarAluno.add(btnRemoverAlunos);

		pnlConsultarAluno.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 2;
		c.ipadx = 20;
		pnlConsultarAluno.add(lblConsultaAlunos, c);
		c.ipadx = 0;
		c.gridheight = 1;
		c.gridx = 1;
		pnlConsultarAluno.add(rbtCodigoAluno, c);
		c.gridy = 1;
		pnlConsultarAluno.add(rbtNomeAluno, c);
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 2;
		pnlConsultarAluno.add(txtConsultaAlunos, c);
		c.gridwidth = 1;
		c.gridheight = 2;
		c.gridx = 2;
		c.insets = new Insets(0, 10, 0, 0);
		pnlConsultarAluno.add(pnlBotoesConsultarAluno, c);
		c.insets = null;
		c.gridheight = 1;
		c.gridy = 3;
		c.gridx = 0;
		c.gridwidth = 2;
		c.ipadx = 450;
		c.ipady = 220;
		c.insets = new Insets(10, 0, 0, 0);
		pnlConsultarAluno.add(pnlTabelaConsultarAluno, c);

		pnlBotoesInserirDisciplina.setLayout(new FlowLayout());
		pnlBotoesInserirDisciplina.add(btnInserirDisciplina);
		pnlBotoesInserirDisciplina.add(Box.createRigidArea(new Dimension(30, 0)));
		pnlBotoesInserirDisciplina.add(btnLimparDisciplinas);

		pnlInserirDisciplina.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		pnlInserirDisciplina.add(lblNomeDisciplina, c);
		c.gridx = 1;
		pnlInserirDisciplina.add(txtNomeDisciplina, c);
		c.gridy = 1;
		c.gridx = 0;
		pnlInserirDisciplina.add(lblCreditos, c);
		c.gridx = 1;
		pnlInserirDisciplina.add(txtCreditos, c);
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 2;
		c.ipady = 20;
		pnlInserirDisciplina.add(Box.createVerticalGlue(), c);
		c.gridy = 3;
		c.ipady = 0;
		c.fill = GridBagConstraints.NONE;
		pnlInserirDisciplina.add(pnlBotoesInserirDisciplina, c);

		pnlTabelaConsultarDisciplina.setLayout(new BorderLayout());
		JScrollPane scrDisciplinas = new JScrollPane(tblDisciplinas);
		pnlTabelaConsultarDisciplina.add(tblDisciplinas.getTableHeader(),
				BorderLayout.PAGE_START);
		pnlTabelaConsultarDisciplina.add(scrDisciplinas, BorderLayout.CENTER);

		pnlBotoesConsultarDisciplina.setLayout(new GridLayout(10, 1));
		pnlBotoesConsultarDisciplina.add(btnConsultarDisciplinas);
		pnlBotoesConsultarDisciplina.add(Box.createVerticalGlue());
		pnlBotoesConsultarDisciplina.add(btnAlterarDisciplinas);
		pnlBotoesConsultarDisciplina.add(btnRemoverDisciplinas);

		pnlConsultarDisciplina.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 2;
		c.ipadx = 20;
		pnlConsultarDisciplina.add(lblConsultaDisciplinas, c);
		c.ipadx = 0;
		c.gridheight = 1;
		c.gridx = 1;
		pnlConsultarDisciplina.add(rbtCodigoDisciplina, c);
		c.gridy = 1;
		pnlConsultarDisciplina.add(rbtNomeDisciplina, c);
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 2;
		pnlConsultarDisciplina.add(txtConsultaDisciplinas, c);
		c.gridwidth = 1;
		c.gridheight = 2;
		c.gridx = 2;
		c.insets = new Insets(0, 10, 0, 0);
		pnlConsultarDisciplina.add(pnlBotoesConsultarDisciplina, c);
		c.insets = null;
		c.gridheight = 1;
		c.gridy = 3;
		c.gridx = 0;
		c.gridwidth = 2;
		c.ipadx = 450;
		c.ipady = 220;
		c.insets = new Insets(10, 0, 0, 0);
		pnlConsultarDisciplina.add(pnlTabelaConsultarDisciplina, c);

		tabAbas.addTab("Inserir aluno", pnlInserirAluno);
		tabAbas.addTab("Gerenciar alunos", pnlConsultarAluno);
		tabAbas.addTab("Inserir disciplina", pnlInserirDisciplina);
		tabAbas.addTab("Gerenciar disciplinas", pnlConsultarDisciplina);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(tabAbas, BorderLayout.CENTER);

		// Exibição
		setVisible(true);

		getConexao();
	}

	private void initComponents()
	{
		pnlInserirAluno = new JPanel();
		pnlConsultarAluno = new JPanel();
		pnlInserirDisciplina = new JPanel();
		pnlConsultarDisciplina = new JPanel();
		pnlBotoesInserirAluno = new JPanel();
		pnlBotoesConsultarAluno = new JPanel();
		pnlTabelaConsultarAluno = new JPanel();
		pnlBotoesInserirDisciplina = new JPanel();
		pnlBotoesConsultarDisciplina = new JPanel();
		pnlTabelaConsultarDisciplina = new JPanel();

		tabAbas = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

		lblNomeAluno = new JLabel("Nome [*]: ");
		lblRg = new JLabel("RG [*]: ");
		lblDataDeNascimento = new JLabel("Data de nascimento [*]: ");
		lblFone = new JLabel("Fone: ");
		lblNomeDisciplina = new JLabel("Nome [*]: ");
		lblCreditos = new JLabel("Créditos [*]: ");
		lblConsultaAlunos = new JLabel("Consultar por: ");
		lblConsultaDisciplinas = new JLabel("Consultar por: ");

		txtNomeAluno = new JTextField(25);
		txtRg = new JTextField(15);
		txtDataDeNascimento = new JTextField(10);
		txtFone = new JTextField(12);
		txtNomeDisciplina = new JTextField(25);
		txtCreditos = new JTextField(2);
		txtConsultaAlunos = new JTextField(25);
		txtConsultaDisciplinas = new JTextField(25);

		btnInserirAluno = new JButton("Inserir");
		btnConsultarAlunos = new JButton("Consultar");
		btnAlterarAlunos = new JButton("Alterar");
		btnRemoverAlunos = new JButton("Remover");
		btnLimparAlunos = new JButton("Limpar");
		btnInserirDisciplina = new JButton("Inserir");
		btnConsultarDisciplinas = new JButton("Consultar");
		btnAlterarDisciplinas = new JButton("Alterar");
		btnRemoverDisciplinas = new JButton("Remover");
		btnLimparDisciplinas = new JButton("Limpar");

		rbtCodigoAluno = new JRadioButton("Código");
		rbtNomeAluno = new JRadioButton("Nome");
		rbtCodigoDisciplina = new JRadioButton("Código");
		rbtNomeDisciplina = new JRadioButton("Nome");

		String[] columnNames = { "Código", "Nome", "RG", "Data de nascimento",
				"Fone" };
		ArrayList<ArrayList<Object>> data = consultaAlunos(null);
		AbstractTableModel mdlAlunos = new DBTableModel(columnNames, data);
		tblAlunos = new JTable(mdlAlunos);

		columnNames = new String[] { "Código", "Nome", "Créditos" };
		data = consultaDisciplinas(null);
		AbstractTableModel mdlDisciplinas = new DBTableModel(columnNames, data);

		tblDisciplinas = new JTable(mdlDisciplinas);
	}

	// Sinaliza a conexão com o BD.
	private void getConexao()
	{
		if (controle.getConectado()) JOptionPane.showMessageDialog(this,
				"Conexão com o Banco de Dados realizada com sucesso!", "Aviso",
				JOptionPane.INFORMATION_MESSAGE);
		else
		{
			JOptionPane
					.showMessageDialog(
							this,
							"A conexão com o Banco de Dados falhou!\n\nO aplicativo será abortado.",
							"Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	// Chamada do controle para consulta de alunos.
	private ArrayList<ArrayList<Object>> consultaAlunos(String consulta)
	{
		try
		{
			return controle.consultaAlunos(consulta);
		}
		catch (SQLException ex)
		{
			JOptionPane.showMessageDialog(this,
					"Erro inesperado no banco de dados", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

// Chamada do controle para consulta de disciplinas.
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

	// Chamada do controle para inserção de aluno. 
	private void inserirAluno(String nome, String rg, Calendar data, String fone)
	{
		try
		{
			controle.inserirAluno(nome, rg, data, fone);
			JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso!",
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

// Chamada do controle para inserção de disciplina.
	private void inserirDisciplina(String nome, int creditos)
	{
		try
		{
			controle.inserirDisciplina(nome, creditos);
			JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso!",
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

// Chamada do controle para remoção de aluno.
	private void removerAluno(int codigo)
	{
		try
		{
			controle.removerAluno(codigo);
			JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!",
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

// Chamada do controle para remoção de disciplina.
	private void removerDisciplina(int codigo)
	{
		try
		{
			controle.removerDisciplina(codigo);
			JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!",
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

	// Classe listener dos botões
	private class BotoesListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton btn = (JButton) e.getSource();
			// Limpar Inserir Aluno
			if (btn == btnLimparAlunos)
			{
				limparInserirAluno();
			}
			// Limpar Inserir Disciplina			
			else if (btn == btnLimparDisciplinas)
			{
				limparInserirDisciplina();
			}
			// Inserir Aluno
			else if (btn == btnInserirAluno)
			{
				if (validarInserirAluno())
				{
					try
					{
						String nome = txtNomeAluno.getText();
						String rg = txtRg.getText();
						String fone = txtFone.getText();

						DateFormat df = DateFormat.getDateInstance();
						Date nasc = df.parse(txtDataDeNascimento.getText());
						Calendar data = new GregorianCalendar();
						data.setTime(nasc);

						inserirAluno(nome, rg, data, fone);
						((DBTableModel) tblAlunos.getModel())
								.replaceData(consultaAlunos(null));
						limparInserirAluno();
					}
					catch (ParseException e1)
					{
						JOptionPane.showMessageDialog(null,
								"Formato da data incorreto", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				else JOptionPane.showMessageDialog(null,
						"Há campos obrigatórios em branco", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
			// Inserir Disciplina
			else if (btn == btnInserirDisciplina)
			{
				if (validarInserirDisciplina())
				{
					String nome = txtNomeDisciplina.getText();
					int creditos = Integer.parseInt(txtCreditos.getText());

					inserirDisciplina(nome, creditos);
					((DBTableModel) tblDisciplinas.getModel())
							.replaceData(consultaDisciplinas(null));
					limparInserirDisciplina();
				}
				else JOptionPane.showMessageDialog(null, "Há campos em branco",
						"Erro", JOptionPane.ERROR_MESSAGE);
			}
			// Consultar aluno
			else if (btn == btnConsultarAlunos)
			{
				String nome = txtConsultaAlunos.getText();
				String consulta = null;

				if (nome.equals("") == false)
				{
					if (rbtCodigoAluno.isSelected() == true) consulta = " WHERE CODIGO = "
							+ nome;
					else consulta = " WHERE NOME LIKE '" + nome + "%'";
				}

				ArrayList<ArrayList<Object>> cons = consultaAlunos(consulta);
				if (cons.size() > 0)
				{
					((DBTableModel) tblAlunos.getModel()).replaceData(cons);
					txtConsultaAlunos.setText("");
					ultimaConsulta = consulta;
				}
				else JOptionPane.showMessageDialog(null,
						"Nenhuma tupla foi encontrada nesta consulta", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
			// Consultar disciplinas
			else if (btn == btnConsultarDisciplinas)
			{
				String nome = txtConsultaDisciplinas.getText();
				String consulta = null;

				if (nome.equals("") == false)
				{
					if (rbtCodigoDisciplina.isSelected() == true) consulta = " WHERE CODIGO = "
							+ nome;
					else consulta = " WHERE NOME LIKE '" + nome + "%'";
				}

				ArrayList<ArrayList<Object>> cons = consultaDisciplinas(consulta);
				if (cons.size() > 0)
				{
					((DBTableModel) tblDisciplinas.getModel()).replaceData(cons);
					txtConsultaDisciplinas.setText("");
					ultimaConsulta = consulta;
				}
				else JOptionPane.showMessageDialog(null,
						"Nenhuma tupla foi encontrada nesta consulta", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
			// Remover alunos
			else if (btn == btnRemoverAlunos)
			{
				DBTableModel modelo = (DBTableModel) tblAlunos.getModel();
				int linhaAtual = tblAlunos.getSelectedRow();
				int codigo = ((Integer) modelo.getValueAt(linhaAtual, 0))
						.intValue();

				removerAluno(codigo);
				ArrayList<ArrayList<Object>> cons = consultaAlunos(ultimaConsulta);
				modelo.replaceData(cons);
			}
			// Remover disciplina
			else if (btn == btnRemoverDisciplinas)
			{
				DBTableModel modelo = (DBTableModel) tblDisciplinas.getModel();
				int linhaAtual = tblDisciplinas.getSelectedRow();
				int codigo = ((Integer) modelo.getValueAt(linhaAtual, 0))
						.intValue();

				removerDisciplina(codigo);
				ArrayList<ArrayList<Object>> cons = consultaDisciplinas(ultimaConsulta);
				modelo.replaceData(cons);
			}
			// Alterar aluno
			else if (btn == btnAlterarAlunos)
			{
				DBTableModel modelo = (DBTableModel) tblAlunos.getModel();
				int linhaAtual = tblAlunos.getSelectedRow();
				int codigo = ((Integer) modelo.getValueAt(linhaAtual, 0))
						.intValue();

				new DialogoAlterarAluno(null,	controle, codigo);
				ArrayList<ArrayList<Object>> cons = consultaAlunos(ultimaConsulta);
				modelo.replaceData(cons);
			}
			// Alterar disciplinas
			else if (btn == btnAlterarDisciplinas)
			{
				DBTableModel modelo = (DBTableModel) tblDisciplinas.getModel();
				int linhaAtual = tblDisciplinas.getSelectedRow();
				int codigo = ((Integer) modelo.getValueAt(linhaAtual, 0))
						.intValue();

				new DialogoAlterarDisciplina(null,	controle, codigo);
				ArrayList<ArrayList<Object>> cons = consultaDisciplinas(ultimaConsulta);
				modelo.replaceData(cons);
			}
		}

		// Valida Inserir Aluno
		private boolean validarInserirAluno()
		{
			boolean[] checado = new boolean[3];
			checado[0] = !txtNomeAluno.getText().equals("");
			checado[1] = !txtRg.getText().equals("");
			checado[2] = !txtDataDeNascimento.getText().equals("");

			boolean valido = true;
			for (boolean b : checado)
			{
				valido &= b;
			}

			return valido;
		}

		// Valida Inserir disciplina
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

		// Limpa inserir disciplina
		private void limparInserirDisciplina()
		{
			txtNomeDisciplina.setText("");
			txtCreditos.setText("");
		}

		// Limpa inserir aluno
		private void limparInserirAluno()
		{
			txtNomeAluno.setText("");
			txtRg.setText("");
			txtDataDeNascimento.setText("");
			txtFone.setText("");
		}
	}
}

@SuppressWarnings("serial")
// Classe do model dos JTables
class DBTableModel extends AbstractTableModel
{
	private String[] columnNames;
	private ArrayList<ArrayList<Object>> data;

	DBTableModel(String[] columnNames, ArrayList<ArrayList<Object>> data)
	{
		this.columnNames = columnNames;
		this.data = data;
	}

	public boolean isCellEditable(int row, int col)
	{
		return false;
	}

	public int getColumnCount()
	{
		return columnNames.length;
	}

	public int getRowCount()
	{
		return data.size();
	}

	public String getColumnName(int col)
	{
		return columnNames[col];
	}

	public Object getValueAt(int row, int col)
	{
		return data.get(row).get(col);
	}

	public void setValueAt(Object value, int row, int col)
	{
		data.get(row).set(col, value);
		fireTableCellUpdated(row, col);
	}

	// Método para substituir os dados
	public void replaceData(ArrayList<ArrayList<Object>> newData)
	{
		data = newData;
		fireTableStructureChanged();
	}
}
