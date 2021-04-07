package es.codeurjc.SeibiExperiencieServices.PDFService;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lowagie.text.Document;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import javax.activation.*;

@Component
public class MailService {
	public void sendEmail(String to, String subject, String content) {
		// Email de la web en gmail
		String from = "seibiexperience@gmail.com";
		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();

		// Setup
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.user", "localhost");
		properties.put("mail.smtp.password", "seibie1234");

		// Autenticación de la sesion
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(from, "seibi1234");

			}

		});
		session.setDebug(true);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(content);
			// message.setContent(null);
			Transport.send(message);
			System.out.println("Enviado....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public void sendEmail(String to, String subject, String content,byte[] document) {
		// Email de la web en gmail
		String from = "seibiexperience@gmail.com";
		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();

		// Setup
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.user", "localhost");
		properties.put("mail.smtp.password", "seibie1234");
		
		// Autenticación de la sesion
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(from, "seibi1234");

			}

		});
		session.setDebug(true);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			//3) create MimeBodyPart object and set your message text     
		    BodyPart messageBodyPart1 = new MimeBodyPart();  
		    messageBodyPart1.setText("This is message body");  
		    //4) create new MimeBodyPart object and set DataHandler object to this object      
		    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
		    /*
		    String filename = "./pedidoguay.pdf";//change accordingly  
		    DataSource source = new FileDataSource(filename);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName(filename);  
		    */
		    if (document.length > 0) {
		    	System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		    }else {
		    	System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		    }
		    messageBodyPart2.setDataHandler(new DataHandler(new ByteArrayDataSource(document,"application/pdf")));
		    //messageBodyPart2.attachFile(null);
		    //5) create Multipart object and add MimeBodyPart objects to this object      
		    Multipart multipart = new MimeMultipart();  
		    multipart.addBodyPart(messageBodyPart1);  
		    multipart.addBodyPart(messageBodyPart2);  
		  
		    //6) set the multiplart object to the message object  
		    message.setContent(multipart );  
			Transport.send(message);
			System.out.println("Enviado....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}