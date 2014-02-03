public class FracaoMista extends Fracao {
	// Atributos
	protected int parteInteira;

	// Construtores
	public FracaoMista() {
		this(0, 0, 1);
	}

	public FracaoMista(int parteInteira, int numerador, int denominador) {
		super(numerador, denominador);
		this.parteInteira = parteInteira;
		
		// Ajusta parte inteira se não foi bem definido
		ajustaParteInteira();
	}

	// Métodos
	public int getParteInteira() {
		return parteInteira;
	}
	
	public String toString() {
		String retorno;
		
		if (parteInteira == 0)
			retorno = super.toString();
		else if (numerador == 0)
			retorno = Integer.toString(parteInteira);
		else
			retorno = parteInteira + " " + super.toString();
		
		return retorno;
	}

	public void transformaParaFracao() {
		numerador += parteInteira * denominador;
		parteInteira = 0;		
	}

	public void ajustaParteInteira() {
		if (numerador >= denominador) {
			parteInteira += numerador / denominador;
			numerador = numerador % denominador;
		}
	}

	public void adiciona(FracaoMista frac) {
		// Transforma as frações de mista para simples
		frac.transformaParaFracao();
		this.transformaParaFracao();
		
		// Realiza a soma
		super.adiciona(frac);

 		// Ajusta a parte inteira
		frac.ajustaParteInteira();
		this.ajustaParteInteira();
	}

	public void adiciona(int nro) {
		// Transforma para fração simples
		this.transformaParaFracao();

		// Realiza a soma
		super.adiciona(nro);

		// Ajusta a parte inteira
		this.ajustaParteInteira();
	}

}
