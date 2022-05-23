package com.sda.eli.petclinic;

import com.sda.eli.petclinic.controller.ClientController;
import com.sda.eli.petclinic.controller.PetController;
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
        PetController petController =new PetController();
        Scanner scanner = new Scanner(System.in);
        ClientController clientController=new ClientController();

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
                case UPDATE:
                    veterinarianController.update();
                    break;
                case ADD_NEW_PET:
                    petController.addPet();
                  break;
                case VIEW_ALL_VACCINATED:
                    petController.showAllVaccinated();
                    break;
                case VIEW_ALL_PETS_FOR_CLIENT_ID:

                    clientController.viewAllPetsForClient();
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