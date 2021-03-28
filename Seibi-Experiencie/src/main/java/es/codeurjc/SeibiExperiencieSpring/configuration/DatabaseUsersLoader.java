package es.codeurjc.SeibiExperiencieSpring.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import es.codeurjc.SeibiExperiencieSpring.model.User;
import es.codeurjc.SeibiExperiencieSpring.repository.UserRepository;
 
@Component
public class DatabaseUsersLoader {
 
    @Autowired
    private UserRepository users;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
 
    @PostConstruct
    private void initDatabase() {
    	if(users.count()==0) {
        	users.save(new User("user", passwordEncoder.encode("pass"), "USER"));
        	users.save(new User("admin", passwordEncoder.encode("adminpass"), "USER", "ADMIN"));
        }
       
    }
}