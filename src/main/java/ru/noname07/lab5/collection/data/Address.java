package ru.noname07.lab5.collection.data;

import ru.noname07.lab5.collection.Valid;

public class Address implements Valid {
    private String street; // Поле может быть null

    public Address(String street) {
        this.street = street;
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
