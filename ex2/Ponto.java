public class Ponto {
	// Atributos
	private double x;
	private double y;

	// Construtores
	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// Métodos
	public void setX(double xVal) {
		x = xVal;
	}

	public void setY(double yVal) {
		y = yVal;
	}

	public double getX() {
		return (x);
	}

	public double getY() {
		return (y);
	}

	public String toString() {
		String str = "(" + x + ", " + y + ")";
		return str;
	}
}
