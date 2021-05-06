package es.codeurjc.SeibiExperiencieSpring;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

@SpringBootApplication
@EnableHazelcastHttpSession
public class SeibiExperiencieApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeibiExperiencieApplication.class, args);
	}

	@Bean
	 public Config config() {
		
		 Config config = new Config();
		 JoinConfig joinConfig = config.getNetworkConfig().getJoin();
		 joinConfig.getMulticastConfig().setEnabled(true);
		 //joinConfig.getTcpIpConfig().setEnabled(true);
		 return config;
		 
	 }

}
