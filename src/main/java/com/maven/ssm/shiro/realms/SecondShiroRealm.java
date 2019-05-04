package com.maven.ssm.shiro.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * @author Lee
 * @create 2019-05-02 17:57
 */
public class SecondShiroRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("second doGetAuthenticationInfo");

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
             password = "ce2f6417c7e1d32c1d81a797ee0b499f87c5de06";
        } else if ("test".equals(username)){
             password = "a11f58b7589e669a5f8e03e34fff71e9006fa6ba";
        }



        String realmName = getName();
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password,credentialsSalt, realmName);

        return simpleAuthenticationInfo;
    }

    public static void main(String[] args) {
        String algorithmName = "SHA1";
        String source = "123456";
        Object salt = "admin";
        int hashIterations = 1024;

        Object result = new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(result);
    }
}
