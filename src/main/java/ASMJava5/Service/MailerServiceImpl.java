package ASMJava5.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ASMJava5.Model.MailInfor;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailerServiceImpl implements MailerService{

	@Autowired
	JavaMailSender sender;
	@Override
	public void send(MailInfor mail) throws MessagingException {
		MimeMessage message= sender.createMimeMessage();
		
		MimeMessageHelper helper= new MimeMessageHelper(message,true,"utf-8");
		helper.setFrom(mail.getForm());
		helper.setTo(mail.getTo());
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getBody(),true);
		helper.setReplyTo(mail.getForm());
		
		String[] cc= mail.getCc();
		if(cc !=null && cc.length>0) {
			helper.setCc(cc);
		}
		String[] bcc = mail.getBcc();
		if(bcc !=null && bcc.length>0) {
			helper.setBcc(bcc);
		}
		List<File> files = mail.getFiles();
		if (files.size()>0) {
			for (File file:files) {
				helper.addAttachment(file.getName(), file);
			}
		}
		sender.send(message);
	}

	@Override
	public void send(String to, String subject, String body) throws MessagingException {
		this.send(to, subject, body);
	}
	
	List<MailInfor> list= new ArrayList<>();
	@Override
	public void queue(MailInfor mail) {
		list.add(mail);
		
	}

	@Override
	public void queue(String to, String subject, String body) {
		queue(new MailInfor(to, subject, body));
	}
	
	@Scheduled(fixedDelay = 5000)
	public void run() {
		while (!list.isEmpty()) {
			MailInfor mail=list.remove(0);
			try {
				this.send(mail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public String[] parseStringEmailToArray(String emailString) {
		String[] arrEmail = null;
		if (emailString.length() > 0) {
			emailString = removeSpace(emailString);
			arrEmail = emailString.split(",");
		}
		return arrEmail;
	}

	private String removeSpace(String string) {
		return string.replaceAll(" ", "");
	}

	public File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
		//Tạo 1 thư mục tạm thời để chứa file, sau này có thể xóa thư mục tạm thời đó đi
		File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + multipartFile.getOriginalFilename());
		multipartFile.transferTo(convFile);
		return convFile;
	}
		
}
