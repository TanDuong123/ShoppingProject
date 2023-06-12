package ASMJava5.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class InterConfig implements WebMvcConfigurer{
	@Autowired
	AuthIterceptor auth;
	@Autowired
	UserInterceptor user;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(auth)
		.addPathPatterns("/SpaceShope/admin/**")
		.excludePathPatterns("/assets/**");
		
		registry.addInterceptor(user)
		.addPathPatterns("/SpaceShope/cart","/SpaceShope/checkout","/SpaceShope/order/**")
		.excludePathPatterns("/assets/**");
	}
}
