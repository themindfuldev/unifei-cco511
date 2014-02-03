import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;
import javax.swing.*;

@SuppressWarnings("serial")
public class DialogoAlterarAluno extends JDialog implements ActionListener
{
	// Atributos
	private JLabel lblNomeAluno, lblRg, lblDataDeNascimento, lblFone;
	private JTextField txtNomeAluno, txtRg, txtDataDeNascimento, txtFone;
	private JButton btnAlterar, btnCancelar;
	private JPanel pnlBotoes, pnlAlterar;
	private Controle controle;
	private int codigo;

	// Construtor
	public DialogoAlterarAluno(JFrame pai, Controle controle, int codigo)
	{
		// Construtor da superclasse
		super(pai, "Alterar aluno", true);

		// Inicialização dos componentes
		this.controle = controle;
		this.codigo = codigo;
		initComponents();
		initDados();

		// Inicialização
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(400, 200);
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
		pnlAlterar.add(lblNomeAluno, c);
		c.gridx = 1;
		pnlAlterar.add(txtNomeAluno, c);
		c.gridy = 1;
		c.gridx = 0;
		pnlAlterar.add(lblRg, c);
		c.gridx = 1;
		pnlAlterar.add(txtRg, c);
		c.gridy = 2;
		c.gridx = 0;
		pnlAlterar.add(lblDataDeNascimento, c);
		c.gridx = 1;
		pnlAlterar.add(txtDataDeNascimento, c);
		c.gridy = 3;
		c.gridx = 0;
		pnlAlterar.add(lblFone, c);
		c.gridx = 1;
		c.ipadx = 200;
		pnlAlterar.add(txtFone, c);		
		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 2;
		c.ipadx = 0;
		c.ipady = 20;
		pnlAlterar.add(Box.createVerticalGlue(), c);
		c.gridy = 5;
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
		ArrayList<ArrayList<Object>> cons = consultaAlunos(" WHERE CODIGO = " + codigo);
		ArrayList<Object> tupla = cons.get(0);
		txtNomeAluno.setText(tupla.get(1).toString());
		txtRg.setText(tupla.get(2).toString());
		String data = DateFormat.getDateInstance().format((Date)tupla.get(3));
		txtDataDeNascimento.setText(data);
		if (tupla.get(4) != null) txtFone.setText(tupla.get(4).toString());		
	}

	private void initComponents()
	{
		pnlBotoes = new JPanel();
		pnlAlterar = new JPanel();
		
		lblNomeAluno = new JLabel("Nome [*]: ");
		lblRg = new JLabel("RG [*]: ");
		lblDataDeNascimento = new JLabel("Data de nascimento [*]: ");
		lblFone = new JLabel("Fone: ");
		
		txtNomeAluno = new JTextField(25);
		txtRg = new JTextField(15);
		txtDataDeNascimento = new JTextField(10);
		txtFone = new JTextField(12);
		
		btnAlterar = new JButton("Alterar");
		btnCancelar = new JButton("Cancelar");		
	}

	public void actionPerformed(ActionEvent e)
	{
		JButton btn = (JButton) e.getSource();
		// Alterar
		if (btn == btnAlterar)
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

					alterarAluno(nome, rg, data, fone);	
					
					dispose();
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
		// Cancelar
		else
		{
			dispose();
		}		
	}
	
	// Validação da entrada
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
	
	// Chamada do controle para alteração.
	private void alterarAluno(String nome, String rg, Calendar data, String fone)
	{
		try
		{
			controle.alterarAluno(codigo, nome, rg, data, fone);
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
	
}
