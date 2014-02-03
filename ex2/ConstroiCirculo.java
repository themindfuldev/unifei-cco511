import javax.swing.*;

public class ConstroiCirculo {

	public static void main(String[] args) {
		// Declara��o de vari�veis
		CirculoColorido circ;
		double x, y;
		int raio, continua;
		String cb, ci;
		String xStr, yStr, raioStr;

		do {
			// Leitura das fra��es
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
					"O estado original do c�rculo �:\n" + circ);

			// Aumentando o raio
			circ.aumentar();
			JOptionPane.showMessageDialog(null,
					"Ap�s aumentar o raio, o c�rculo fica:\n" + circ);

			// Diminuindo o raio
			circ.diminuir();
			circ.diminuir();
			JOptionPane
					.showMessageDialog(null,
							"Ap�s diminuir o raio duas vezes, o c�rculo fica:\n"
									+ circ);

			// Confirmando pr�ximo
			continua = JOptionPane.showConfirmDialog(null,
					"Deseja construir mais c�rculos coloridos?", "Fim",
					JOptionPane.YES_NO_OPTION);

		} while (continua == 0);
		System.exit(0);

	}

}
