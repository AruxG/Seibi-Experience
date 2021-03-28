package es.codeurjc.SeibiExperiencieSpring.configuration;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	@Autowired
	RepositoryUserDetailsService userDetailsService;
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}
	@Override
	 protected void configure(HttpSecurity http) throws Exception {

		

	 // Public pages
	 http.authorizeRequests().antMatchers("/").permitAll();
	 http.authorizeRequests().antMatchers("/users/login").permitAll();
	 http.authorizeRequests().antMatchers("/products/{id}").permitAll();
	 http.authorizeRequests().antMatchers("/users/signup").permitAll();
	 http.authorizeRequests().antMatchers("users/logout").permitAll();
	 
	 // Private pages (all other pages)
	 //Productos
	 http.authorizeRequests().antMatchers("/products/{id}/buy").hasAnyRole("USER"); 
	 //Comentarios
	 http.authorizeRequests().antMatchers("/products/{id}/comments/create_comment").hasAnyRole("USER"); 
	 http.authorizeRequests().antMatchers("/products/{id}/comments/comment_created").hasAnyRole("USER"); 
	 http.authorizeRequests().antMatchers("/products/{id}/comments/delete_comment").hasAnyRole("USER"); 
	 
	 http.authorizeRequests().antMatchers("/orders/new").hasAnyRole("USER"); 
	 http.authorizeRequests().antMatchers("/orders/realizar_pago").hasAnyRole("USER"); 
	 http.authorizeRequests().antMatchers("/orders").hasAnyRole("USER"); 
	 http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
	 
	 // Login form
	 http.formLogin().loginPage("/users/login");
	 http.formLogin().usernameParameter("username");
	 http.formLogin().passwordParameter("password");
	 http.formLogin().defaultSuccessUrl("/users/user_loged");
	 http.formLogin().failureUrl("/users/login");
	 
	 // Logout
	 http.logout().logoutUrl("/users/logout");
	 http.logout().logoutSuccessUrl("/");

	 // Disable CSRF at the moment
	 //http.csrf().disable();
	 }
	
	@Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	 }
	
}
