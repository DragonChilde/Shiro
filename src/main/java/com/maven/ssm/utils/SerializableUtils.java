package com.maven.ssm.utils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;

import java.io.*;


/**
 * @author Lee
 * @create 2019/5/7 14:48
 */
public class SerializableUtils {

    public static String serialzie(Session session){
        String str = "";
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(session);
            str= Base64.encodeToString(bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static Session deserialize(String sessionStr){
         Object o =null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Base64.decode(sessionStr));
            ObjectInputStream ois = new ObjectInputStream(bis);

            try {
                 o = ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return (Session)o;
    }
}
