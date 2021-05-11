package es.codeurjc.SeibiExperiencieSpring;

import java.util.Collections;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
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
import com.hazelcast.web.WebFilter;

@SpringBootApplication
@EnableHazelcastHttpSession
@EnableCaching
public class SeibiExperiencieApplication implements CommandLineRunner{

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
    public HazelcastInstance hazelcastInstance() {
		return HazelcastInstanceFactory.newHazelcastInstance(config());
    }
	
	@Bean
	public CacheManager cacheManager() {
		return new HazelcastCacheManager(hazelcastInstance());
		//return new ConcurrentMapCacheManager("seibi");
	}
	
	@Bean
	public WebFilter webFilter(HazelcastInstance hazelcastInstance) {

	    Properties properties = new Properties();
	    properties.put("instance-name", hazelcastInstance.getName());
	    properties.put("sticky-session", "false");
	    properties.put("deferred-write", "true");

	    return new WebFilter(properties);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
