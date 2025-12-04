package EnvioEmail;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EnvioEmail {
    public static void main(String[] args) {
        // Configurações
        String host = "smtp.gmail.com"; 
        String port = "587";
        String username = "email do usuário @gmail.com";
        String password = "senha dele"; 
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        
        // Cria sessão com autenticação
        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
        
        try {
            // Cria e envia mensagem
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, 
                InternetAddress.parse("destinatario@exemplo.com")); // Adicione o email do destinatário
            message.setSubject("Assunto");
            message.setText("Corpo do e-mail");
            
            Transport.send(message);
            System.out.println("E-mail enviado!");
            
        } catch (MessagingException e) {
            e.printStackTrace(); // Melhor para debug
            throw new RuntimeException("Erro ao enviar email: " + e.getMessage());
        }
    }
}
