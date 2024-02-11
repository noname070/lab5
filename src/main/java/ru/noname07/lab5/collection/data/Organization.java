package ru.noname07.lab5.collection.data;

import java.time.LocalDate;
import java.util.Scanner;

import ru.noname07.lab5.collection.Valid;

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

    public Organization(String[] args) { // TODO take into account all the "mistakes"
        this.id = nextId;
        nextId++;

        System.out.println("Create new element `Organization`");
        @SuppressWarnings("resource")
        Scanner localScanner = new Scanner(System.in);
        
        try {
            //name // TODO name can`t starts with/contain number(s)
            String name = ""; 
            do {
                System.out.print("name >");
                name = localScanner.nextLine();
            } while (name == null || name.isEmpty() || name.matches("[0-9]"));
            this.name = name;

            //coordinates
            this.coordinates = new Coordinates();

            //creationDate
            this.creationDate = java.time.LocalDate.now();

            //annualTurnover // TODO only numbers
            Float annualTurnover = Float.valueOf((float) 0.0);
            do {
                System.out.print("annualTurnover >");
                annualTurnover = Float.parseFloat(localScanner.nextLine());
            } while (annualTurnover <= 0 || annualTurnover.isNaN() || annualTurnover.isInfinite() || annualTurnover.equals(null)); 
            
            this.annualTurnover = annualTurnover;

            //employeesCount
            Integer employeesCount = 0;
            do {
                System.out.print("employeesCount >");
                employeesCount = Integer.parseInt(localScanner.nextLine());
            } while (employeesCount <= 0 || employeesCount.equals(null)); 
            this.employeesCount = employeesCount;

            //type
            OrganizationType type;
            do {
                System.out.println("possible values for `type` : [COMMERCIAL, PUBLIC, GOVERNMENT, PRIVATE_LIMITED_COMPANY, OPEN_JOINT_STOCK_COMPANY]. pls retry.");
                System.out.print("type >");
                type = OrganizationType.valueOf(localScanner.nextLine());

            } while (type == null);
            this.type = type;

            //officialAddress
            // String officialAddress = "";
            // do {
            //     officialAddress = localScanner.nextLine();
            // } while (officialAddress == null || officialAddress.equals("") || officialAddress.matches("^[0-9]") );
            // this.officialAddress = officialAddress;
            this.officialAddress = new Address();

            System.out.println("`Organization` was created");

        } catch (Exception e) {e.printStackTrace();}
        catch (Error e) {e.printStackTrace();} // TODO
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
        if (this.annualTurnover <= 0)
            return false;
        if (this.type == null || !this.officialAddress.isValid())
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
                this.getAddress());

        return output;
    }

    public int compareTo(Organization inputOrg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}
