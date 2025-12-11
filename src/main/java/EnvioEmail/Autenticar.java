package EnvioEmail;

import javax.mail.Authenticator;

public class Autenticar extends Authenticator {

	public String username = null;
	public String password - null;
	
	public Autenticar(String user, String pwd) {
		username = user;
	    password = pwd;
	}
	
	@Override 
	protected PasswordAuthentication getPasswordAuthentication() {
	    return new PasswordAuthentication(username, password);
	}
	
	
}
