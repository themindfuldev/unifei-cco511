import java.util.Formatter;

public class Cilindro extends Circulo {
	// Atributos
	protected double altura;

	// Construtores
	public Cilindro() {
		super(0, 0, 0);
		this.altura = 0;
	}

	public Cilindro(double x, double y, double raio, double altura) {
		super(x, y, raio);
		this.altura = altura;
	}

	// Métodos
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getArea() {
		return (2 * super.getArea() + 2 * Math.PI * raio * altura);
	}

	public String getName() {
		return "Cilindro";
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter resposta = new Formatter(sb);		
		resposta.format("%s; Altura = %.2f", super.toString(), altura);
		return resposta.toString();				
	}

	public double getVolume() {
		return (super.getArea() * altura);
	}

}
