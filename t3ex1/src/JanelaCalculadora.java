import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class JanelaCalculadora extends JFrame implements ActionListener
{
	// Atributos
	private JPanel pnlBotoes, pnlControle;
	private JButton btnUm, btnDois, btnTres, btnQuatro, btnCinco, btnSeis,
			btnSete, btnOito, btnNove, btnZero, btnSoma, btnSubtracao,
			btnMultiplicacao, btnDivisao, btnIgual, btnBackspace,
			btnLimpar;
	private JLabel lblDisplay;
	private double display;
	private Operacoes operacao;
	private Estados estado;

	// Relacionamentos
	private Calculo calculo;

	public JanelaCalculadora()
	{
		// Construtor da superclasse
		super("Calculadora");

		// Inicialização dos relacionamentos
		calculo = new Calculo(0.0);
		display = 0.0;
		operacao = Operacoes.NENHUMA;
		estado = Estados.INICIAL;

		// Inicialização
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(240, 260);
		setResizable(false);

		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);

		// Inicialização dos componentes
		pnlBotoes = new JPanel();
		pnlControle = new JPanel();
		lblDisplay = new JLabel();
		btnUm = new JButton("1");
		btnDois = new JButton("2");
		btnTres = new JButton("3");
		btnQuatro = new JButton("4");
		btnCinco = new JButton("5");
		btnSeis = new JButton("6");
		btnSete = new JButton("7");
		btnOito = new JButton("8");
		btnNove = new JButton("9");
		btnZero = new JButton("0");
		btnSoma = new JButton("+");
		btnSubtracao = new JButton("-");
		btnMultiplicacao = new JButton("*");
		btnDivisao = new JButton("/");
		btnIgual = new JButton("=");
		btnBackspace = new JButton("<-");
		btnLimpar = new JButton("Limpar");

		// Configurações dos componentes
		pnlBotoes.setLayout(new GridLayout(5, 4, 5, 5));
		pnlControle.setLayout(new GridLayout(1, 2, 5, 5));
		Border brdDisplay = BorderFactory.createEtchedBorder();
		lblDisplay.setBorder(brdDisplay);
		lblDisplay.setHorizontalAlignment(JLabel.RIGHT);
		setDisplay(0.0);

		// Mnemônicos
		btnUm.setMnemonic('1');
		btnDois.setMnemonic('2');
		btnTres.setMnemonic('3');
		btnQuatro.setMnemonic('4');
		btnCinco.setMnemonic('5');
		btnSeis.setMnemonic('6');
		btnSete.setMnemonic('7');
		btnOito.setMnemonic('8');
		btnNove.setMnemonic('9');
		btnZero.setMnemonic('0');
		btnSoma.setMnemonic('+');
		btnSubtracao.setMnemonic('-');
		btnMultiplicacao.setMnemonic('*');
		btnDivisao.setMnemonic('/');
		btnIgual.setMnemonic('=');
		
		// Registro dos listeners
		btnUm.addActionListener(this);
		btnDois.addActionListener(this);
		btnTres.addActionListener(this);
		btnQuatro.addActionListener(this);
		btnCinco.addActionListener(this);
		btnSeis.addActionListener(this);
		btnSete.addActionListener(this);
		btnOito.addActionListener(this);
		btnNove.addActionListener(this);
		btnZero.addActionListener(this);
		btnSoma.addActionListener(this);
		btnSubtracao.addActionListener(this);
		btnMultiplicacao.addActionListener(this);
		btnDivisao.addActionListener(this);
		btnIgual.addActionListener(this);
		btnBackspace.addActionListener(this);
		btnLimpar.addActionListener(this);

		// Configuração do layout
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		// Adição dos componentes
		pnlControle.add(btnBackspace);
		pnlControle.add(btnLimpar);
		pnlBotoes.add(btnSete);
		pnlBotoes.add(btnOito);
		pnlBotoes.add(btnNove);
		pnlBotoes.add(btnDivisao);
		pnlBotoes.add(btnQuatro);
		pnlBotoes.add(btnCinco);
		pnlBotoes.add(btnSeis);
		pnlBotoes.add(btnMultiplicacao);
		pnlBotoes.add(btnUm);
		pnlBotoes.add(btnDois);
		pnlBotoes.add(btnTres);
		pnlBotoes.add(btnSubtracao);
		pnlBotoes.add(btnZero);
		pnlBotoes.add(Box.createGlue());
		pnlBotoes.add(btnIgual);
		pnlBotoes.add(btnSoma);

		c.insets = new Insets(20, 0, 0, 0);
		add(lblDisplay, c);
		c.gridy = 1;
		c.insets = new Insets(10, 0, 0, 0);
		add(pnlControle, c);
		c.gridy = 2;
		add(pnlBotoes, c);

		// Exibição
		setVisible(true);
		requestFocusInWindow();
	}

	// Manipulador de eventos
	public void actionPerformed(ActionEvent arg0)
	{
		JButton obj = (JButton) arg0.getSource();

		if (obj == btnUm || obj == btnDois || obj == btnTres || obj == btnQuatro
				|| obj == btnCinco || obj == btnSeis || obj == btnSete
				|| obj == btnOito || obj == btnNove || obj == btnZero)
		{
			entrarNumero(obj);
		}

		else if (obj == btnIgual)
		{
			efetuarCalculo();
		}

		else if (obj == btnSoma)
		{
			prepararSoma();
		}

		else if (obj == btnSubtracao)
		{
			prepararSubtracao();
		}

		else if (obj == btnMultiplicacao)
		{
			prepararMultiplicacao();
		}

		else if (obj == btnDivisao)
		{
			prepararDivisao();
		}

		else if (obj == btnLimpar)
		{
			limpar();
		}

		else if (obj == btnBackspace)
		{
			retroceder();
		}
	}

	private void retroceder()
	{
		String txt = Double.toString(display);
		double num;		
		
		if (display - (int)display == 0) {
			setDisplay((int) display/10);			
		}			
		else {			
			num = Double.parseDouble(txt.substring(0, txt.length()-1));
			setDisplay(num);
		}
	}

	private void setDisplay(double num)
	{		
		int precisao;
		String numero;
		
		display = num;
		numero = Double.toString(num);
		precisao = numero.substring(numero.indexOf(".")).length()-1;
		
		String txt = (num - (int)num == 0) ? String.format("%.1f", num): String.format("%." + precisao + "f", num);
		lblDisplay.setText(txt);		
	}

	private void limpar()
	{
		estado = Estados.INICIAL;
		setDisplay(0.0);
		operacao = Operacoes.NENHUMA;
		calculo.limpar();
	}

	private void prepararDivisao()
	{
		switch (estado) {
			case OPERANDO1: 
				estado = Estados.OPERADOR1;
								
				calculo.substituir(display);
				
				operacao = Operacoes.DIVISAO;
				break;
				
			case OPERANDO2:
				estado = Estados.OPERADOR2;				
				
				calculo.empilhar(display);
				setDisplay(calculo.efetuar(operacao));
				
				operacao = Operacoes.DIVISAO;			
				break;

			case OPERANDO3:
				estado = Estados.OPERADOR2;

				calculo.substituir(display);
				setDisplay(calculo.efetuar(operacao));
				
				operacao = Operacoes.DIVISAO;	
				
			default:
				break;		
		}		
	}

	private void prepararMultiplicacao()
	{
		switch (estado) {
			case OPERANDO1: 
				estado = Estados.OPERADOR1;
								
				calculo.substituir(display);
				
				operacao = Operacoes.MULTIPLICACAO;
				break;
				
			case OPERANDO2:
				estado = Estados.OPERADOR2;				
				
				calculo.empilhar(display);
				setDisplay(calculo.efetuar(operacao));
				
				operacao = Operacoes.MULTIPLICACAO;			
				break;

			case OPERANDO3:
				estado = Estados.OPERADOR2;

				calculo.substituir(display);
				setDisplay(calculo.efetuar(operacao));
				
				operacao = Operacoes.MULTIPLICACAO;	
				
			default:
				break;		
		}		
	}

	private void prepararSubtracao()
	{
		switch (estado) {
			case OPERANDO1: 
				estado = Estados.OPERADOR1;
								
				calculo.substituir(display);
				
				operacao = Operacoes.SUBTRACAO;
				break;
				
			case OPERANDO2:
				estado = Estados.OPERADOR2;				
				
				calculo.empilhar(display);
				setDisplay(calculo.efetuar(operacao));
				
				operacao = Operacoes.SUBTRACAO;			
				break;

			case OPERANDO3:
				estado = Estados.OPERADOR2;

				calculo.substituir(display);
				setDisplay(calculo.efetuar(operacao));
				
				operacao = Operacoes.SUBTRACAO;	
				
			default:
				break;		
		}		
	}

	private void prepararSoma()
	{		
		switch (estado) {
			case OPERANDO1: 
				estado = Estados.OPERADOR1;
								
				calculo.substituir(display);
				
				operacao = Operacoes.SOMA;
				break;
				
			case OPERANDO2:
				estado = Estados.OPERADOR2;				
				
				calculo.empilhar(display);
				setDisplay(calculo.efetuar(operacao));
				
				operacao = Operacoes.SOMA;			
				break;

			case OPERANDO3:
				estado = Estados.OPERADOR2;

				calculo.substituir(display);
				setDisplay(calculo.efetuar(operacao));
				
				operacao = Operacoes.SOMA;	
				
			default:
				break;		
		}		
		
	}

	private void efetuarCalculo()
	{
		try
		{
			switch (estado) {
				case OPERANDO3:			
					calculo.substituir(display);
					setDisplay(calculo.efetuar(operacao));
					
					estado = Estados.OPERADOR2;
					break;
					
				case OPERANDO2:
					calculo.empilhar(display);
					setDisplay(calculo.efetuar(operacao));
					
					estado = Estados.OPERADOR2;
					break;
				
				case OPERANDO1:
					calculo.empilhar(display);
					setDisplay(calculo.efetuar(operacao));
					
					estado = Estados.OPERADOR1;
					break;
					
				case OPERADOR2:
				case OPERADOR1:	
					setDisplay(calculo.efetuar(operacao));
					break;
				
				default:
					break;
			}			

		}
		catch (ArithmeticException e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erro!",
					JOptionPane.WARNING_MESSAGE);
			limpar();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			limpar();
		}
	}

	private void entrarNumero(JButton obj)
	{		
		double res;
		
		switch (estado) {
			case INICIAL: 
				estado = Estados.OPERANDO1;
				display = 0.0;
				break;
				
			case OPERADOR1:
				estado = Estados.OPERANDO2;
				display = 0.0;
				break;

			case OPERADOR2:
				estado = Estados.OPERANDO3;
				display = 0.0;
				break;
				
			default:
				break;
		}		
		
		res = display * 10;	
		res += Double.parseDouble(obj.getText());
		setDisplay(res);
	}
	
}
