package EnvioEmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

public class EmailAPI {
    
	private String mailSMTPServer, mailSMTPServerPort;
	
	
	public void enviarEmail(
			String from,
			String mailSenha,
			String to,
			String subject,
			String message
			
	) {
		Properties props = new Properties();
		
		mailSMTPServer = "smtp.gmail.com";
		mailSMTPServerPort = "587";
		
		props.put("mail.transport.cool)","smtp");
		props.put("mail.starttls.enable","true");
		props.put("mail.smtp.host", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.user", from);
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", mailSMTPServerPort);
		props.put("mail.smtp.socketFactory.port", mailSMTPServerPort);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallbac k","false" );
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory", "465");
		
		Autenticar auth = new Autenticar(from, mailSenha);
		
		Session session = new Session.getDefaultInstance(props,auth);
		session.setDebug(true);
		
		Message msg = new MimeMessage(session);
		
		try {
			
			msg.setRecepient(Message.RecepientType.TO, new InternetAddress(to));
			msg.setFrom(new InternetAddress(from));
			msg.setSubject(subject);
			msg.setContent(message, "text/html");
		} catch (Exception e) {
			System.out.println(e);
			
		}
		
		Transport tr;
		try {
			tr = session.getTransport("smtp");
			tr.connect(mailSMTPServer, from, mailSenha);
			msg.saveChanges();
			tr.sendMessage(msg ,msg.getAllRecipients());
			tr.close();
		}
		
		catch(Exception e) {
			System.out.println(e);

			 
		}
		
	}
			
			
}
