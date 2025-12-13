package Back;
import org.mindrot.jbcrypt.*;

public class Crypto {
	
	private String senha;
	private String hash;
	public Crypto() {
	}
	// Gera o hash para a senha fornecida, armazena internamente e retorna o hash
	public final String gerarHashBCrypt(String senha) {
		// usar o parâmetro recebido (não sobrescrever com getSenha())
		setSenha(senha);
		String generated = BCrypt.hashpw(senha, BCrypt.gensalt());
		setHash(generated);
		return generated;
	}
	
	// Verifica se a senha em texto claro corresponde ao hash armazenado ou fornecido
	public final boolean verificarHashBCrypt(String senha, String hash) {
		if (senha == null || hash == null) return false;
		try {
			return BCrypt.checkpw(senha, hash);
		} catch (IllegalArgumentException e) {
			// hash malformado -> falha na verificação
			return false;
		}
	}
	
	public final void pprint(String ttext) {
		System.out.print(ttext);
	}
	protected final String getSenha() {
		return senha;
	}
	protected final void setSenha(String senha) {
		this.senha = senha;
	}
	public final String getHash() {
		return hash;
	}
	protected final void setHash(String hash) {
		this.hash = hash;
	}
	

}