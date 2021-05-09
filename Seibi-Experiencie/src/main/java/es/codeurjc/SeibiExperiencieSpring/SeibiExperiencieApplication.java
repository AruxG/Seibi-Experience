package es.codeurjc.SeibiExperiencieSpring;

import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.instance.impl.HazelcastInstanceFactory;
import com.hazelcast.spring.cache.HazelcastCacheManager;

@SpringBootApplication
@EnableHazelcastHttpSession
@EnableCaching
public class SeibiExperiencieApplication {

	private static final Log logger = LogFactory.getLog(SeibiExperiencieApplication.class);
	
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
	

	 @Bean
	    public CacheManager cacheManager() {
	    	logger.info("Activating cache...");
	    	return new ConcurrentMapCacheManager("products");
	    }
}
