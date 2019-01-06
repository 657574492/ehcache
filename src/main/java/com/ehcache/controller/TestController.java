package com.ehcache.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

@RestController
public class TestController {
	@Resource
	  private CacheManager cacheManager;

  @RequestMapping(value = {"/testPutCache"}, method={RequestMethod.POST, RequestMethod.GET})
  public String testPutCache(){
	  Cache cache = cacheManager.getCache("userCache");
	  
	  cache.put("key", "123");
        return "test test";
  } 
  @RequestMapping(value = {"/testGetCache"}, method={RequestMethod.POST, RequestMethod.GET})
  public String testGetCache(){
	  Cache cache = cacheManager.getCache("userCache");
	  String res = cache.get("key", String.class);
	  System.out.println(res);
        return "test test";
  }


}
