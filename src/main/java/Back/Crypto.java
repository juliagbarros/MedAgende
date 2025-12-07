package Back;
import org.mindrot.jbcrypt.*;

public class Crypto {
	
	private String senha;
	private String hash;
	public Crypto() {
	}
	public final void gerarHashBCrypt(String senha) {
		senha = getSenha();
		setHash(BCrypt.hashpw(senha, BCrypt.gensalt()));
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
