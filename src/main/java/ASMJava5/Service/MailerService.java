package ASMJava5.Service;

import ASMJava5.Model.MailInfor;
import jakarta.mail.MessagingException;

public interface MailerService {
	void send(MailInfor mail) throws MessagingException;
	
	void send(String to, String subject, String body) throws MessagingException;
	
	void queue(MailInfor mail);
	
	void queue(String to, String subject, String body);
}
