import java.util.*;
import javax.swing.*;

public class TestaFormaGeo {

	public static void main(String[] args) {
		ArrayList<FormaGeo> formas = new ArrayList<FormaGeo>(3);
		StringBuilder sb = new StringBuilder();
		Formatter resposta = new Formatter(sb);

		formas.add(new Ponto(7, 11));
		formas.add(new Circulo(22, 8, 3.5));
		formas.add(new Cilindro(10, 10, 3.3, 10));

		for (FormaGeo f: formas)
			resposta.format("%s\n", f);
		 
		for (FormaGeo f: formas)
			resposta.format("\n%s\nArea = %.2f\nVolume = %.2f\n", f, f.getArea(), f.getVolume());
		
		JOptionPane.showMessageDialog(null, resposta);
		System.exit(0);

	}

}
