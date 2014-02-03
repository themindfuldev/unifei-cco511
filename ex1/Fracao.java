public class Fracao {
	// Atributos
	protected int numerador;
	protected int denominador;

	// Construtores
	public Fracao() {
		this(0, 1);
	}

	public Fracao(int numerador, int denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
		
		// Simplifica se n�o foi bem definido
		this.simplifica();		
	}

	// M�todos
	public void adiciona(int nro) {
		// Soma as fra��es
		numerador += nro * denominador;

		// Simplifica o resultado
		this.simplifica();
	}

	public void adiciona(Fracao frac) {
		// Soma as fra��es
		numerador = numerador * frac.denominador + frac.numerador * denominador;
		denominador *= frac.denominador;

		// Simplifica o resultado
		this.simplifica();
	}

	public void simplifica() {
		int maior;

		// Encontra o maior entre numerador e denominador
		maior = numerador > denominador ? numerador : denominador;

		// Busca o divisor que permita a simplifica��o m�xima
		for (int i = maior / 2; i > 1; i--)
			if ((numerador % i == 0) && (denominador % i == 0)) {
				numerador /= i;
				denominador /= i;
			}
	}
	
	public String toString() {
		String retorno;
		
		if (numerador == 0)
			retorno = Integer.toString(0);
		else if (denominador == 1)
			retorno = Integer.toString(numerador);
		else
			retorno = numerador + "/" + denominador; 
			
		return retorno;
	}

	public int getDenominador() {
		return denominador;
	}

	public int getNumerador() {
		return numerador;
	}

}
