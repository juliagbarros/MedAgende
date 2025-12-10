package EnvioEmail;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

//email do sistema: suporteapp2026@gmail.com senha: "lbmb fpcn ctmi jhwh" 
//email do destinatário: emailprojetos01@gmail.com usar a seguinte senha: vzyw lush aydc jawv 
public class EnvioEmail {
    public static void main(String[] args) {
        // Configurações
        String host = "smtp.gmail.com"; 
        String port = "587";
        String username = "emailprojetos01@gmail.com";
        String password = "vzyw lush aydc jawv"; 
        
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
                InternetAddress.parse("emailprojetos01@gmail.com")); // Adicione o email do destinatário
            message.setSubject("Assunto: Recuperação de Senha");
            message.setText("Olá,\\n\\nSua consulta foi agendada com sucesso!\\n\\nDetalhes do agendamento:\\n + detalhes_agendamento + '\\n\\nAgradecemos por escolher nosso serviço.\\n\\nAtenciosamente,\\nEquipe de Agendamento");
            
            Transport.send(message);
            System.out.println("E-mail enviado!");
            
        } catch (MessagingException e) {
            e.printStackTrace(); // Melhor para debug
            throw new RuntimeException("Erro ao enviar email: " + e.getMessage());
        }
    }
}
