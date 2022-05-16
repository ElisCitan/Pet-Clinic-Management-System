package com.sda.eli.petclinic;

import com.sda.eli.petclinic.utils.SessionManager;
import org.hibernate.Session;

public class Main {
    public static  void main(String[] arg){
//temporary
        SessionManager.getSessionFactory().openSession();
    }
}
