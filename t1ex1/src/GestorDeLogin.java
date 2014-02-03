import java.util.*;

public class GestorDeLogin {
	// Componentes da Aplica��o
	private HashMap<String, char[]> tabela;
	
	// Construtor
	public GestorDeLogin() {	
		// Tabela de usu�rios e senhas
		tabela = new HashMap<String, char[]>();
		tabela.put("Tiago", "1234".toCharArray());
		tabela.put("Andr�", "4321".toCharArray());
		tabela.put("Thiago", "6666".toCharArray());		
	}
	
	// Efetua avalia��o de senha, a partir de uma chave
    public boolean avaliarSenha(String chave, char[] entrada) {
        boolean estaCorreto = true;
        
        // Obt�m a senha correta da chave
        char[] senhaCorreta = tabela.get(chave);

        // Compara a senha correta com a digitada
        if (entrada.length != senhaCorreta.length) {
            estaCorreto = false;
        } else {
            for (int i = 0; i < entrada.length; i++) {
                if (entrada[i] != senhaCorreta[i]) {
                	estaCorreto = false;
                }
            }
        }

        return estaCorreto;
    }

}
