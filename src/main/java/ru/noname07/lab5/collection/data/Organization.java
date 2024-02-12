package ru.noname07.lab5.collection.data;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

import ru.noname07.lab5.collection.Valid;

@XmlRootElement
public class Organization implements Valid, Comparable<Organization> {

    private static int nextId = 1;

    private int id; // Значение поля должно быть больше 0, Значение этого поля должно быть
                    // уникальным, Значение этого поля должно генерироваться автоматически
    private String name; // Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; // Поле не может быть null
    private java.time.LocalDate creationDate; // Поле не может быть null, Значение этого поля должно генерироваться
                                              // автоматически
    private Float annualTurnover; // Поле может быть null, Значение поля должно быть больше 0
    private Integer employeesCount; // Значение поля должно быть больше 0
    private OrganizationType type; // Поле не может быть null
    private Address officialAddress; // Поле не может быть null

    public Organization(String name, Coordinates coordinates, float annualTurnover, int employeesCount,
            OrganizationType type, Address officialAddress) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.LocalDate.now();
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
        this.type = type;
        this.officialAddress = officialAddress;

    }

    public Organization() {
        this.id = nextId;
        nextId++;

        this.creationDate = java.time.LocalDate.now();
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public Float getAnnualTurnover() {
        return this.annualTurnover;
    }

    public int getEmployeesCount() {
        return this.employeesCount;
    }

    public OrganizationType getOrganizationType() {
        return this.type;
    }

    public Address getAddress() {
        return this.officialAddress;
    }

    public static void setStartId(Integer id) {
        nextId = id+1;
    }

    public static int getStartId() {
        return nextId;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setCoordinates(Coordinates newCoordinates) {
        this.coordinates = newCoordinates;
    }

    public void setAnnualTurnover(float newAnnualTurnover) {
        this.annualTurnover = newAnnualTurnover;
    }

    public void setEmployeesCount(int newEmployeesCount) {
        this.employeesCount = newEmployeesCount;
    }

    public void setOrganizationType(OrganizationType newType) {
        this.type = newType;
    }

    public void setAddress(Address newAddress) {
        this.officialAddress = newAddress;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }


    @Override
    public boolean isValid() {
        if (this.id <= 0)
            return false;
        if (this.name == null || this.name.isEmpty())
            return false;
        if (this.coordinates == null || !this.coordinates.isValid())
            return false;
        if (this.creationDate == null)
            return false;
        if (this.employeesCount == null || this.employeesCount <= 0)
            return false;
        if (this.annualTurnover != null) {
            if (this.annualTurnover < 0) return false;
        }
        if (this.type == null)
            return false;
        if (this.officialAddress == null || !this.officialAddress.isValid())
            return false;

        return true;
    }

    @Override
    public String toString() {
        String output = String.format(
                "`Organization` ID: %s; Name: %s; Coordinates: (%s, %s); CreationDate: %s, EmployeesCount: %s, AnnualTurnover: %s, OrganizationType: %s, Address: %s",
                this.getId(),
                this.getName(),
                this.getCoordinates().getX(), this.getCoordinates().getY(),
                this.getCreationDate().toString(),
                this.getEmployeesCount(),
                this.getAnnualTurnover(),
                this.getOrganizationType(),
                this.getAddress().getStreet());

        return output;
    }

    public int compareTo(Organization org) {
        return org.getEmployeesCount();
    }

}
