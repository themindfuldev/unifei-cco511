public class CirculoColorido extends Circulo {
	// Atributos
	String corBorda;

	String corInterior;

	// Construtores
	public CirculoColorido(double x, double y, double r, String cb, String ci) {
		super(x, y, r);
		corBorda = cb;
		corInterior = ci;
	}

	// Métodos
	public String getCorBorda() {
		return corBorda;
	}

	public void setCorBorda(String corBorda) {
		this.corBorda = corBorda;
	}

	public String getCorInterior() {
		return corInterior;
	}

	public void setCorInterior(String corInterior) {
		this.corInterior = corInterior;
	}

	public String toString() {
		return super.toString() + ", Cor da borda: " + corBorda
				+ ", Cor do interior: " + corInterior;
	}

}
