package com.sda.eli.petclinic.controller;

import com.sda.eli.petclinic.service.PetService;
import com.sda.eli.petclinic.service.PetServiceImpl;
import com.sda.eli.petclinic.service.exception.InvalidParameterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PetController {

    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(DATE_FORMAT);
    private final PetService petService;
    private final Scanner scanner;

    public PetController() {
        this.petService = new PetServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void addPet() {
        try {

            System.out.println("Please insert race.");
            String raceInput = scanner.nextLine();

            System.out.println("Please insert date of birth.");
            String dateInput = scanner.nextLine();
            Date birthdate = FORMATTER.parse(dateInput);

            System.out.println("Please insert true if the pet is vaccinated of false otherwise.");
            boolean isVaccinateState = Boolean.parseBoolean(scanner.nextLine());

            System.out.println("Please insert the owner's first name ");
            String firstName = scanner.nextLine();

            System.out.println("Please insert the owner's last name ");
            String lastName = scanner.nextLine();

            petService.create(raceInput, birthdate, isVaccinateState, firstName, lastName);

        } catch (ParseException e) {
            System.out.println("Please insert a correct date of birth " + DATE_FORMAT + ".");
        } catch (
                InputMismatchException e) {
            System.out.println("Please insert tru or false for the vaccinated status");

        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Internal server error.");
        }
    }

    public void showAllVaccinated() {
        petService
                .findAllVaccinated()
                .stream()
                .forEach(pet -> System.out.println("Race " + pet.getRace() +
                        "Date of birth: " + FORMATTER.format(pet.getDateOfBirth())
                        + pet.getDateOfBirth() +
                        "Is vaccinated: " + (pet.getVaccinated()?" YES:":" NO")));
    }
}
