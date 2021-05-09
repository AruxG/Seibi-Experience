package es.codeurjc.SeibiExperiencieSpring.controller;


import com.hazelcast.spring.cache.HazelcastCache;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CacheContentController {

    @Autowired
    private CacheManager cacheManager;

    // Debug only
    @RequestMapping(value = "/cache",method=RequestMethod.GET)
    public Map<Object, Object> getCacheContent() {
    	ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("seibi");
		return cache.getNativeCache();
    }

}