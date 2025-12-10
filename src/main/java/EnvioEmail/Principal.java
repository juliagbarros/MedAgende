package EnvioEmail;

public class Principal {
   public static void main (String [] args) { 

	EnvioEmail email = new EnvioEmail();
	
	
	email.enviarEmail(
			"suporteapp2026@gmail.com",
			"suporte2026",
			"emailprojetos01gmail.com",
			"testando",
			"message"
			
	   );
   }
	
}
