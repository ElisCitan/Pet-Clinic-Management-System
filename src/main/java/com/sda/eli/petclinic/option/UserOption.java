package com.sda.eli.petclinic.option;

import java.util.Arrays;
import java.util.Optional;

public enum UserOption {
    ADD_NEW_VET("Add new veterinarian", 1),
    EXIT("Exit", 999),

    UNKNOWN("Unknown option, try again ",1000);

    public final String prettyName;
    private final int optionNumber;

    UserOption(String prettyName, int optionNumber) {
        this.prettyName = prettyName;
        this.optionNumber = optionNumber;
    }

    public static void printAllOption() {
        System.out.println("----------------------------------");
        Arrays.stream(UserOption.values())
                .filter(userOption -> !userOption.equals(UserOption.UNKNOWN))
                .forEach(option -> System.out.println(option.prettyName + " -> " + option.getOptionNumber()));
    }

    public String getPrettyName() {
        return prettyName;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public int getOptionalNumber() {
        return optionNumber;
    }

    public static Optional<UserOption> findBy(int optionNumber) {
        return Arrays.stream(UserOption.values())
                .filter(userOption -> userOption.getOptionNumber() == optionNumber)
                .findAny();
    }
}
