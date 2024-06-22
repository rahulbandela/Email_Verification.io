package com.tap.verification;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.tap.user.User;

public class Verification {

	public String getRandom()
	{
		Random rand=new Random();
		int number=rand.nextInt(999999);
		return String.format("%06d", number);
	}
	
	public boolean getRandom(User user)
	{
		boolean test = false;
		
		String toEmail = user.getEmail();
		
		String fromEmail = "testmail231oe@gmail.com";
		String password = "rahulanenenu";
				
		
		try
		{
			Properties pr=new Properties();
			pr.setProperty("mail.smtp.host", "smtp.mail.com");
			pr.setProperty("mail.smtp.port", "587");
			pr.setProperty("mail.smtp.auth", "true");
			pr.setProperty("mail.smtp.starttls.enable", "true");
			pr.setProperty("mail.smtp.socketFactory.port", "587");
			pr.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			
			Session session = Session.getInstance(pr, new Authenticator() {
				
				@Override
				
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(fromEmail, password);
				}
			});
			
			Message mess = new MimeMessage(session);
			mess.setFrom(new InternetAddress(fromEmail));
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			mess.setSubject("User Email Verification");
			mess.setText("Registered successfully. Please verify your account using this Verification code :" + user.getCode());
			Transport.send(mess);
			test=true;
		}
		
		
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return test;
	}
}
