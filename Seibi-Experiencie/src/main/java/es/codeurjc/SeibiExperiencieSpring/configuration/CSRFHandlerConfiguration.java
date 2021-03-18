package es.codeurjc.SeibiExperiencieSpring.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.ui.Model;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class CSRFHandlerConfiguration extends WebMvcConfigurerAdapter {

	 public void addInterceptors(InterceptorRegistry registry) {
	 registry.addInterceptor(new CSRFHandlerInterceptor());
	 }
	}

	class CSRFHandlerInterceptor extends HandlerInterceptorAdapter {
		

	 public void postHandle(final HttpServletRequest request,
			 final HttpServletResponse response, final Object handler,
			 final Model model) throws Exception {
	 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
	 model.addAttribute("token", token.getToken());
	 
	 }
	 
}
