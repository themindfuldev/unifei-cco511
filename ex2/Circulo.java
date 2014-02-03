public class Circulo {
	// Atributos
	protected Ponto centro;

	protected double raio;

	// Construtores	
	public Circulo(double x, double y, double r) {
		x = x < 0 ? 0 : x;
		y = y < 0 ? 0 : y;
		centro = new Ponto(x, y);
		raio = r > 0 ? r : 1;
	}

	// Métodos
	public void mover(double x, double y) {
		centro.setX(x);
		centro.setY(y);
	}

	public void aumentar() {
		raio++;
	}

	public void diminuir() {
		raio--;
	}

	public double getX() {
		return centro.getX();
	}

	public double getY() {
		return centro.getY();
	}

	public double getRaio() {
		return raio;
	}

	public String toString() {
		return "Centro: " + centro + ", Raio: " + raio;
	}
}
