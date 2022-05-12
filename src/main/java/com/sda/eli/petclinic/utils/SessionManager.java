package com.sda.eli.petclinic.utils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager extends AbstractSessionManager {

    private static final SessionManager INSTANCE = new SessionManager();

    private SessionManager(){
    }

    //9-11 singletone <- constanta + contructor default

    public static SessionFactory getSessionFactory(){
        return INSTANCE.getSessionFactory("test_hibernate");
    }

    public static void shutdown(){
        INSTANCE.shutdownSessionManager();
    }

    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
        //model class will be added here

    }
}
