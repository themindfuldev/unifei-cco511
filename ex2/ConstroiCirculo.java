import javax.swing.*;

public class ConstroiCirculo {

	public static void main(String[] args) {
		// Declaração de variáveis
		CirculoColorido circ;
		double x, y;
		int raio, continua;
		String cb, ci;
		String xStr, yStr, raioStr;

		do {
			// Leitura das frações
			xStr = JOptionPane.showInputDialog("Entre com o valor de x");
			yStr = JOptionPane.showInputDialog("Entre com o valor de y");
			raioStr = JOptionPane.showInputDialog("Entre com o raio");
			cb = JOptionPane.showInputDialog("Entre com a cor da borda");
			ci = JOptionPane.showInputDialog("Entre com a cor do interior");

			// Transformando strings para valores
			x = Double.parseDouble(xStr);
			y = Double.parseDouble(yStr);
			raio = Integer.parseInt(raioStr);

			// Instanciando
			circ = new CirculoColorido(x, y, raio, cb, ci);
			JOptionPane.showMessageDialog(null,
					"O estado original do círculo é:\n" + circ);

			// Aumentando o raio
			circ.aumentar();
			JOptionPane.showMessageDialog(null,
					"Após aumentar o raio, o círculo fica:\n" + circ);

			// Diminuindo o raio
			circ.diminuir();
			circ.diminuir();
			JOptionPane
					.showMessageDialog(null,
							"Após diminuir o raio duas vezes, o círculo fica:\n"
									+ circ);

			// Confirmando próximo
			continua = JOptionPane.showConfirmDialog(null,
					"Deseja construir mais círculos coloridos?", "Fim",
					JOptionPane.YES_NO_OPTION);

		} while (continua == 0);
		System.exit(0);

	}

}
