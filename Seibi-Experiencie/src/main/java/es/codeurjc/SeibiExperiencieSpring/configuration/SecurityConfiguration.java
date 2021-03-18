package es.codeurjc.SeibiExperiencieSpring.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{

	@Override
	 protected void configure(HttpSecurity http) throws Exception {

	 // Public pages
	 http.authorizeRequests().antMatchers("/").permitAll();
	 http.authorizeRequests().antMatchers("/users/login").permitAll();
	 http.authorizeRequests().antMatchers("/products/{id}").permitAll();
	 http.authorizeRequests().antMatchers("/users/signup").permitAll();
	 
	 // Private pages (all other pages)
	 http.authorizeRequests().anyRequest().authenticated();
	 
	 // Login form
	 http.formLogin().loginPage("/users/login");
	 http.formLogin().usernameParameter("user");
	 http.formLogin().passwordParameter("password");
	 http.formLogin().defaultSuccessUrl("/users/user_loged");
	 http.formLogin().failureUrl("/users/login");
	 
	 // Logout
	 http.logout().logoutUrl("/users/logout");
	 http.logout().logoutSuccessUrl("/");

	 // Disable CSRF at the moment
	 http.csrf().disable();
	 }
	
	@Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	 // User
	 auth.inMemoryAuthentication()
	 .withUser("user").password("pass").roles("USER");
	 
	 }
}
