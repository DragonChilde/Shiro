package com.maven.ssm.factory;

import java.util.LinkedHashMap;

/**
 * @author Lee
 * @create 2019-05-04 23:39
 */
public class FilterChainDefinitionMapBuilder {

    public LinkedHashMap<String,String> buildFilterChainDefinitionMap(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();



       map.put("/login","anon");
        map.put("/checklogin","anon");
        map.put("/logout","logout");
       map.put("/user","roles[test]");
        map.put("/admin","authc,roles[admin]");
        map.put("/success","user");
        map.put("/**","authc");


        return map;
    }
}
