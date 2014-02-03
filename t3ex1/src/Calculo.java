import java.util.*;

public class Calculo {
	private Stack<Double> operandos;
	
	public Calculo(double inicio) {
		operandos = new Stack<Double>();
		operandos.push(inicio);
	}
	
	public double efetuar(Operacoes operacao) {
		double resultado, entrada;
		
		if (operacao == Operacoes.NENHUMA)
			return operandos.peek();	
		
		entrada = operandos.pop();		
		resultado = operandos.pop();
		
		switch (operacao) {
			case SOMA: 
				resultado += entrada;
				break;
			case SUBTRACAO:
				resultado -= entrada;
				break;			
			case MULTIPLICACAO: 
				resultado *= entrada;
				break;
			case DIVISAO: 
				if (entrada == 0.0) throw new ArithmeticException("ERRO: Divisão por zero!");
				resultado /= entrada;
				break;
		}
		
		operandos.push(resultado);	
		operandos.push(entrada);	

		return resultado;
	}

	public void empilhar(double operando) {		
		operandos.push(operando);
	}
	
	public void substituir(double operando) {
		operandos.pop();
		operandos.push(operando);
	}
	
	public void replicar() {
		operandos.push(operandos.peek());
	}
	
	public void limpar() {
		while (!operandos.empty()) {
			operandos.pop();
		}
		operandos.push(0.0);
	}
	
}
