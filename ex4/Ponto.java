import java.util.Formatter;

public class Ponto extends FormaGeo {
	// Atributos
	protected double x, y;
	
	// Construtores
	public Ponto() {
		this.x = 0;
		this.y = 0;
	}	
	
	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// Métodos
	public String getName() {
		return "Ponto";
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setPonto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter resposta = new Formatter(sb);		
		resposta.format("%s: Centro = [%.2f; %.2f]", getName(), x, y);
		return resposta.toString();
	}

}
