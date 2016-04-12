package com.qsi.utility;

// File Name SendHTMLEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class mail {
	public void doSendVendorMail(String to,String Content) {

		// Recipient's email ID needs to be mentioned.
		String cc = "louie.cheng@qsitw.com";

		// Sender's email ID needs to be mentioned
		String from = "efgp.public@techman1.com.cn";

		// Assuming you are sending email from localhost
		String host = "172.18.10.20";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		// properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(
					cc));			
			// Set Subject: header field
			message.setSubject("信件主旨","UTF-8");

			// Send the actual HTML message, as big as you like
			message.setContent(Content,
					"text/html;charset=UTF-8");
			

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully...."+Content);
		} catch (MessagingException mex) {
			mex.printStackTrace();
			
		}
	}
}