package ASMJava5.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ASMJava5.Model.MailInfor;
import ASMJava5.Service.MailerServiceImpl;
import jakarta.mail.MessagingException;

@Controller
@RequestMapping("/SendMail/")
public class MailerController {
	@Autowired
	MailerServiceImpl mailer;
	
	@GetMapping("index")
	public String index() {
		return "SendMail";
	}

	@PostMapping("send")
	public String mail(Model model,
			@RequestParam("to") String to,
			@RequestParam("cc") String cc,
			@RequestParam("bcc") String bcc,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("file") MultipartFile multipartFile) throws IOException {
		List<File> files= new ArrayList<>();
		
		String[] emailCc= mailer.parseStringEmailToArray(cc);
		String[] emailBCc= mailer.parseStringEmailToArray(bcc);
		
		MailInfor mail= new MailInfor();
		mail.setTo(to);
		mail.setCc(emailBCc);
		mail.setBcc(emailBCc);
		mail.setSubject(title);
		mail.setBody(content);
		if(!multipartFile.isEmpty()) {
			File file = mailer.convertMultipartFileToFile(multipartFile);
			files.add(file);
			mail.setFiles(files);
		}
		mailer.queue(mail);
		model.addAttribute("message", "Đã gửi mail");
		return "SendMail";
	}
}
