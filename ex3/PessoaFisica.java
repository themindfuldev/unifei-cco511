public class PessoaFisica extends Cliente {
	// Atributos
	String cpf;

	// Construtores
	public PessoaFisica(String nome, String endereco, String telefone, String cpf) {
		super(nome, endereco, telefone);
		this.cpf = cpf;
	}

	// Métodos
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String imprimirDados() {
		return "Pessoa Fisica:\n\n" + super.toString() + ", CPF: " + cpf;
	}	
	
}
