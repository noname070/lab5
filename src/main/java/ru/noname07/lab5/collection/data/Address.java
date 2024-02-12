package ru.noname07.lab5.collection.data;

import javax.xml.bind.annotation.XmlRootElement;

import ru.noname07.lab5.collection.Valid;

@XmlRootElement
public class Address implements Valid {
    private String street; // Поле может быть null

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }

    public void setAddress(String street) {
        this.street = street;
    }

    @Override
    public boolean isValid() {
        if (this.street.isEmpty())
            return false;

        return true;
    }

}
