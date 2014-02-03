import javax.swing.*;

public class TestaFracao {

	public static void main(String[] args) {
		// Declara��o de vari�veis
		FracaoMista f1, f2, fSoma;
		int pi1, num1, den1, pi2, num2, den2, continua;
		String piStr1, numStr1, numStr2, piStr2, denStr1, denStr2;

		try {
			do {
				// Leitura das fra��es
				piStr1 = JOptionPane
						.showInputDialog("Entre com a parte inteira do 1� numero");
				numStr1 = JOptionPane
						.showInputDialog("Entre com o numerador do 1� numero");
				denStr1 = JOptionPane
						.showInputDialog("Entre com o denominador do 1� numero");
				piStr2 = JOptionPane
						.showInputDialog("Entre com a parte inteira do 2� numero");
				numStr2 = JOptionPane
						.showInputDialog("Entre com o numerador do 2� numero");
				denStr2 = JOptionPane
						.showInputDialog("Entre com o denominador do 2� numero");

				// Transformando strings para int
				pi1 = Integer.parseInt(piStr1);
				num1 = Integer.parseInt(numStr1);
				den1 = Integer.parseInt(denStr1);
				pi2 = Integer.parseInt(piStr2);
				num2 = Integer.parseInt(numStr2);
				den2 = Integer.parseInt(denStr2);

				// Realizando a soma e exibindo a resposta
				f1 = new FracaoMista(pi1, num1, den1);
				f2 = new FracaoMista(pi2, num2, den2);
				fSoma = new FracaoMista();
				fSoma.adiciona(f1);
				fSoma.adiciona(f2);
				JOptionPane.showMessageDialog(null, "O valor da soma �:\n" + f1
						+ " + " + f2 + " = " + fSoma);

				// Confirmando pr�ximo
				continua = JOptionPane.showConfirmDialog(null,
						"Deseja calcular mais somas de fra��es?", "Fim",
						JOptionPane.YES_NO_OPTION);

			} while (continua == 0);
			System.exit(0);
		} catch (ArithmeticException ex) {
			JOptionPane.showMessageDialog(null,
					"Erro na entrada!\nO programa ser� finalizado.");
		}
	}
}
