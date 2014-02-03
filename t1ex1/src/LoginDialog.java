import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class LoginDialog extends JDialog implements ActionListener,
		CaretListener {
	// Atributos
	private JLabel usuarioLabel, senhaLabel;
	private JTextField usuarioField;
	private JPasswordField senhaField;
	private JButton loginButton, limparButton, sairButton;

	// Componentes da Aplica��o
	private GestorDeLogin gestorDeLogin;

	// Construtor
	public LoginDialog(JFrame parent, GestorDeLogin gl) {
		// Construtor da superclasse
		super(parent, "Login", true);

		// Inicializa��o da aplica��o
		gestorDeLogin = gl;

		// Inicializa��o
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setSize(220, 130);
		setResizable(false);		

		// Posicionamento		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = d.width/2 - this.getWidth();
		int posY = d.height/2 - this.getHeight();
		setLocation(posX, posY);

		// Inicializa��o dos componentes
		usuarioLabel = new JLabel("Usu�rio:");
		senhaLabel = new JLabel("Senha:");
		usuarioField = new JTextField(10);
		senhaField = new JPasswordField(10);
		loginButton = new JButton("Login");
		limparButton = new JButton("Limpar");

		// Configura��es dos componentes
		loginButton.setMnemonic(KeyEvent.VK_G);
		limparButton.setMnemonic(KeyEvent.VK_L);
		limparButton.setEnabled(false);
		usuarioField.requestFocusInWindow();

		// Registro dos listeners
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				sair();
			}
		});
		loginButton.addActionListener(this);
		limparButton.addActionListener(this);
		usuarioField.addActionListener(this);
		senhaField.addActionListener(this);
		usuarioField.addCaretListener(this);
		senhaField.addCaretListener(this);

		// Configura��o do layout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.NONE;
		
		// Adi��o dos componentes
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.LINE_END;
		add(usuarioLabel, c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.CENTER;
		add(usuarioField, c);		
		c.gridy = 1;
		c.gridx = 0;
		c.anchor = GridBagConstraints.LINE_END;
		add(senhaLabel, c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.CENTER;
		add(senhaField, c);
		c.gridy = 2;
		c.gridx = 0;
		c.insets = new Insets(10,0,0,0);
		c.anchor = GridBagConstraints.LINE_END;
		add(loginButton, c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.CENTER;		
		add(limparButton, c);		
	
		// Exibi��o 
		setVisible(true);
	}

	// Manipulador de a��es
	public void actionPerformed(ActionEvent e) {
		Object origem = e.getSource();

		// Login
		if (origem == loginButton || origem == senhaField)
			login();

		// Limpar
		if (origem == limparButton)
			limpar();

		// Sair
		if (origem == sairButton)
			sair();
		
		// Saltar para o pr�ximo campo
		if (origem == usuarioField)
			senhaField.requestFocusInWindow();
	}

	// Limpar os campos
	private void limpar() {
		usuarioField.setText("");
		senhaField.setText("");
	}

	// Efetuar login
	private void login() {
		String resposta = "Login ";
		int tipo;

		// Verifica��o de login e impress�o dos resultados
		if (gestorDeLogin.avaliarSenha(usuarioField.getText(), senhaField
				.getPassword())) {
			resposta += "correto!";
			tipo = JOptionPane.INFORMATION_MESSAGE;
		} else {
			resposta += "incorreto!";
			tipo = JOptionPane.ERROR_MESSAGE;
		}
		JOptionPane.showMessageDialog(null, resposta, "Resultado", tipo);
		
		// Seleciona o campo Senha e foca
		senhaField.selectAll();
		senhaField.requestFocusInWindow();
	}

	// Confirma sa�da
	private void sair() {
		int op = JOptionPane.showConfirmDialog(null, "Sair?", "Confirma��o",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (op == 0)
			System.exit(0);
	}

	// Manipulador dos campos
	public void caretUpdate(CaretEvent arg0) {
		if (usuarioField.getText().equals("")
				&& String.valueOf(senhaField.getPassword()).equals(""))
			limparButton.setEnabled(false);
		else
			limparButton.setEnabled(true);		
	}

}
