package com.maven.ssm.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Lee
 * @create 2019-05-04 22:51
 */
//这里有一个问题要注意：
//　　在Service方法上使用注解 @Transactional 即在方法开始的时候会有事务，这个时候这个Service已经是一个代理对象，
//　　这个是有把 权限注解加到 Service上是不好用的，会发生类型转换异常。需要加到Controller上，因为不能够让Service是代理的代理。
@Service
public class ShiroService {

    @RequiresRoles(value = {"admin"})
    public void testAutoMethod(){
        Session session = SecurityUtils.getSubject().getSession();
        Object key = session.getAttribute("key");
        System.out.println("testAutoMethod: "+new Date()+" session key: "+key);
    }

}
