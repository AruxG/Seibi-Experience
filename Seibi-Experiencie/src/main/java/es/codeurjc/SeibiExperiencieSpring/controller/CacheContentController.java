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
    @RequestMapping(value = "/cacheProduct",method=RequestMethod.GET)
    public Map<Object, Object> getCacheProductContent() {
    	/*
    	ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("seibi");
		return cache.getNativeCache();
		*/
		HazelcastCacheManager hazelcastCacheManager = (HazelcastCacheManager) cacheManager;
        HazelcastCache hazelcastCache = (HazelcastCache) hazelcastCacheManager.getCache("products");
        return hazelcastCache.getNativeCache();
    }
    
    @RequestMapping(value = "/cacheOrderzs",method=RequestMethod.GET)
    public Map<Object, Object> getCacheOrderzsContent() {
    	/*
    	ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("seibi");
		return cache.getNativeCache();
		*/
		HazelcastCacheManager hazelcastCacheManager = (HazelcastCacheManager) cacheManager;
        HazelcastCache hazelcastCache = (HazelcastCache) hazelcastCacheManager.getCache("orderzs");
        return hazelcastCache.getNativeCache();
    }

}