package com.maven.ssm.dao;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

import java.io.Serializable;

/**
 * @author Lee
 * @create 2019/5/7 14:43
 */
public class SessionDAO extends EnterpriseCacheSessionDAO {
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session,sessionId);
        System.out.println(session.getId());
        return session.getId();
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        System.out.println("doReadSession: "+sessionId);
        return null;
    }

    @Override
    protected void doUpdate(Session session) {

        System.out.println("doUpdate: "+session.getId());

    }

    @Override
    protected void doDelete(Session session) {
        System.out.println("doDelete: "+session.getId());
    }
}
