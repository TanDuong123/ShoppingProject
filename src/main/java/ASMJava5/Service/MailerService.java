package ASMJava5.Service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;

@Service
public class MailerService {
	@Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String to, String cc, String bcc, String title, String content) throws IOException, MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();

        // Thiết lập thông tin người nhận
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

        // Kiểm tra và thiết lập thông tin cc và bcc (nếu tồn tại)
        if (cc != null && !cc.isEmpty()) {
            message.setRecipient(Message.RecipientType.CC, new InternetAddress(cc));
        }
        if (bcc != null && !bcc.isEmpty()) {
            message.setRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
        }

        // Thiết lập tiêu đề và nội dung
        message.setSubject(title);
        message.setText(content);

        
    	File filePath= new File("C:\\Users\\Dell\\eclipse-workspace\\ASMJava5\\src\\main\\resources\\static\\img\\LogoBlueTigers.png");
    	MimeBodyPart attachment = new MimeBodyPart();
	    attachment.setDataHandler(new DataHandler(new FileDataSource(filePath)));
	    attachment.setFileName(filePath.getName());

	    Multipart multipart = new MimeMultipart();
	    multipart.addBodyPart(attachment);

	    message.setContent(multipart);
        

        // Gửi email
        javaMailSender.send(message);
    }
}
