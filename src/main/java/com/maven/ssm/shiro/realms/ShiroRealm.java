package com.maven.ssm.shiro.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.scheduling.concurrent.ScheduledExecutorTask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Lee
 * @create 2019-05-02 17:57
 */
public class ShiroRealm extends AuthorizingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("first doGetAuthenticationInfo");

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        if ("unknown".equals(username)){
            throw new UnknownAccountException("unknown account: "+username);
        }

        if("monster".equals(username)){
            throw new LockedAccountException("lock account : "+ username);
        }
        String password = "";
        if("admin".equals(username)) {
             password = "038bdaf98f2037b31f1e75b5b4c9b26e";
        } else if ("test".equals(username)){
             password = "4292bb58be34c59d28a0dcbd11932d49";
        }



        String realmName = getName();
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password,credentialsSalt, realmName);

        return simpleAuthenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();

        Set<String> set = new HashSet<>();
        set.add("test");
        if ("admin".equals(primaryPrincipal)){
            set.add("admin");
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(set);
        return info;
    }

    public static void main(String[] args) {

//        String algorithmName = "MD5";
//        String source = "123456";
//        Object salt = "test";
//        int hashIterations = 1024;
//
//        Object result = new SimpleHash(algorithmName, source, salt, hashIterations);
//        System.out.println(result);
        String decode = Base64.decodeToString("4AvVhmFLUsOKTA3Kprsdag==");
        System.out.println(decode);
    }
}
