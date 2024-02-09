package ru.noname07.lab5.collection.data;

import java.util.Scanner;

import ru.noname07.lab5.collection.Valid;

public class Address implements Valid {
    private String street; // Поле может быть null

    public Address(String street) {
        this.street = street;
    }

    public Address() { // TODO take into account all the "mistakes"
        @SuppressWarnings("resource")
        Scanner localScanner = new Scanner(System.in);

        System.out.println("Create new `Address`");

        String street = "";
        do {
            street = localScanner.nextLine();
        } while (street == null || street.equals("") || street.matches("^[0-9]") );
        this.street = street;

        System.err.println("`Address` was created");
    }

    public String getStreet() {
        return this.street;
    }

    @Override
    public boolean isValid() {
        if (this.street.isEmpty())
            return false;

        return true;
    }

}
