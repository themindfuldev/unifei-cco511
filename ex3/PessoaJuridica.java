
public class PessoaJuridica extends Cliente {
	// Atributos
	String cnpj;
	String nomeFantasia;
	
	// Construtores
	public PessoaJuridica(String nome, String endereco, String telefone, String cnpj, String nomeFantasia) {
		super(nome, endereco, telefone);
		// TODO Auto-generated constructor stub
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}

	// Métodos
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String imprimirDados() {
		return "Pessoa Juridica:\n\n" + super.toString() + ", CNPJ: " + cnpj + ", Nome Fantasia: " + nomeFantasia;
	}

}
