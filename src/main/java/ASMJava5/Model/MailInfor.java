package ASMJava5.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailInfor {
	String form = "SpaceShope-Online";
	String to;
	String[] cc;
	String[] bcc;
	String subject;
	String body;
	List<File> files=new ArrayList<>();
	public MailInfor(String to, String subject, String body) {
		this.form = "Welcome to Java 5";
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
}
