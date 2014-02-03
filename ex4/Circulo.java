import java.util.Formatter;

public class Circulo extends Ponto {
	// Atributos
	protected double raio;

	// Construtores
	public Circulo() {
		super(0, 0);
		this.raio = 0;
	}
	
	public Circulo(double x, double y, double raio) {
		super(x, y);
		this.raio = raio;
	}
	
	// Métodos
	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public String getName() {
		return "Círculo";
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter resposta = new Formatter(sb);		
		resposta.format("%s; Raio = %.2f", super.toString(), raio);
		return resposta.toString();		
	}

	public double getArea() {
		return Math.PI * Math.pow(raio, 2);
	}
	
}
