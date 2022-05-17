package com.sda.eli.petclinic;

import com.sda.eli.petclinic.controller.VeterinarianController;
import com.sda.eli.petclinic.utils.SessionManager;

public class Main {
    public static void main(String[] args) {
        // temporary change until we have the repository implementation
        SessionManager.getSessionFactory().openSession();
        SessionManager.getSessionFactory();
        VeterinarianController veterinarianController = new VeterinarianController();
        veterinarianController.create();

    }
}