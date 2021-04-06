package es.codeurjc.SeibiExperiencieServices.PDFService;

import java.util.Properties;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.*;
import org.springframework.mail.javamail.*;

@Configuration
public class MailConfiguration {
  @Bean
  public JavaMailSender getJavaMailSender(MailProperties mailProperties) {
      JavaMailSender mailSender = new JavaMailSenderImpl();
      ((MailProperties) mailSender).setHost(mailProperties.getHost());
      ((MailProperties) mailSender).setPort(mailProperties.getPort());

      ((MailProperties) mailSender).setUsername(mailProperties.getUsername());
      ((MailProperties) mailSender).setPassword(mailProperties.getPassword());

      Properties props = ((JavaMailSenderImpl) mailSender).getJavaMailProperties();
      props.put("mail.transport.protocol", "smtp");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.debug", "true");

      return mailSender;
  }
  
  @Bean
  public SimpleMailMessage templateSimpleMessage() {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setText("This is the test email template for your email:\n%s\n");
    return message;
  }
}