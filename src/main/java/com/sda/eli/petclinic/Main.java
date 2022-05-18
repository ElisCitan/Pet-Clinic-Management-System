package com.sda.eli.petclinic;

import com.sda.eli.petclinic.controller.VeterinarianController;
import com.sda.eli.petclinic.option.UserOption;
import com.sda.eli.petclinic.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // temporary change until we have the repository implementation
        SessionManager.getSessionFactory().openSession();
        SessionManager.getSessionFactory();
        VeterinarianController veterinarianController = new VeterinarianController();
        //veterinarianController.create();
        Scanner scanner = new Scanner(System.in);

        UserOption option = UserOption.UNKNOWN;
        do {
            UserOption.printAllOption();
            System.out.println("Choose an option.");
            String inputOption = scanner.nextLine();
            try {
                int userOption = Integer.parseInt(inputOption);
                option = UserOption.findBy(userOption).orElse(UserOption.UNKNOWN);
            } catch (NumberFormatException e) {
                option = UserOption.UNKNOWN;
            }
            System.out.println(option.getPrettyName());
            switch (option){
                case ADD_NEW_VET:
                    veterinarianController.create();
                    break;
                case SHOW_ALL:
                    veterinarianController.showAllVeterinarian();
                    break;
                case DELETE_ID:
                    veterinarianController.deleteById();
                    break;
                case UNKNOWN:
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("This option is not implemented." );
                    break;
            }
        } while ( !option.equals(UserOption.EXIT));
        SessionManager.shutdown();

    }

}