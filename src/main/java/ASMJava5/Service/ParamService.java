package ASMJava5.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ParamService {
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpServletResponse resp;
	public String getString(String name, String defaultValue) {
		String value=req.getParameter(name);
		return value!=null?value:defaultValue;
	}
	public int getInt(String name, int defaultValue) {
		String value= getString(name, String.valueOf(defaultValue));
		return Integer.parseInt(value);
	}
	public Boolean getBoolean(String name, boolean defaultValue) {
		String value=getString(name, String.valueOf(defaultValue));
		return Boolean.parseBoolean(value);
	}
	public Date getDate(String name, String parten) {
		String value= getString(name, "");
		try {
			return new SimpleDateFormat(parten).parse(value);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public File save(MultipartFile file, String path) {
		if(!file.isEmpty()) {
			File dir=new File(req.getServletContext().getRealPath(path));
			if(!dir.exists()) {
				dir.mkdirs();
			}
			try {
				File saveFile= new File(dir, file.getOriginalFilename());
				file.transferTo(saveFile);
				return saveFile;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
