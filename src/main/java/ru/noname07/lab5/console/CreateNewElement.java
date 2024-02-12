package ru.noname07.lab5.console;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

import ru.noname07.lab5.collection.data.*;

public class CreateNewElement {
    public static Organization newElement() {
        Organization org = new Organization();

        String input = "";

        System.out.println("Create new element `Organization`");
        @SuppressWarnings("resource")
        Scanner localScanner = new Scanner(System.in);

        // Name
        String name = "";
        while (true) {
            System.out.print(" name >");
            name = localScanner.nextLine();
            if (!name.isEmpty() && StringUtils.isAlpha(name)) {
                org.setName(name);
                break;
            }
        }

        // Coordinates
        Coordinates coordinates = new Coordinates();
        System.out.println("Create new element `Coordinates`");
        while (true) {
            System.out.print(" x >");
            String x = localScanner.nextLine();

            System.out.print(" y >");
            String y = localScanner.nextLine();

            if (!x.isEmpty() && !y.isEmpty() && StringUtils.isNumeric(x.strip()) && StringUtils.isNumeric(y.strip())) {
                coordinates.setX(Double.parseDouble(x.strip()));
                coordinates.setY(Float.parseFloat(y.strip()));

                break;
            } else {
                System.err.println("Incorrect input. Pls, nums only.");
            }
        }
        System.out.println("New element `Coordinates` created.");
        org.setCoordinates(coordinates);

        // annualTurnover
        while (true) {
            System.out.print(" annualTurnover>");
            input = localScanner.nextLine();
            if (input.equals("")) {
                // org.setAnnualTurnover(null);
                break;
            } else if (StringUtils.isNumeric(input.strip())) {
                org.setAnnualTurnover(Float.parseFloat(input));
                break;
            } else {
                System.err.println("Incorrect value");
            }
        }
        input = "";

        // employeesCount
        while (true) {
            System.out.print(" employeesCount>");
            input = localScanner.nextLine();
            if (!input.equals("")) {
                if (Integer.parseInt(input) <= 0) {
                    System.out.println("Value must be > 0");
                    continue;
                }
                else {
                    org.setEmployeesCount(Integer.parseInt(input));
                    break;
                }
            }
        }
        input = "";

        // type
        while (true) {
            System.out.printf(" orgType [possible vals: %s] >",
                    Arrays.stream(OrganizationType.values())
                            .map(v -> v.toString())
                            .collect(Collectors.joining(" ")));

            input = localScanner.nextLine();
            if (Arrays.stream(OrganizationType.values())
                    .map(v -> v.toString())
                    .toList()
                    .contains(input)) {

                org.setType(OrganizationType.valueOf(input));
                break;

            } else {
                System.err.println("Incorrect type.");
            }
        }
        input = "";

        // address
        System.out.println("Create new element `Address`");
        while (true) {
            System.out.print(" street >");
            input = localScanner.nextLine();
            if (!input.isEmpty()) {
                org.setAddress(new Address(input));
                break;
            }
        }

        return org;
    }

    // DEV ONLY
    public static Organization genRandom() {
        Organization org = new Organization();
        Random rnd = new Random();

        org.setName("genOrg" + rnd.nextInt(9999));
        org.setCoordinates(new Coordinates(rnd.nextDouble(), rnd.nextFloat()));
        org.setAnnualTurnover(rnd.nextFloat());
        org.setEmployeesCount(rnd.nextInt(999));
        org.setAddress(new Address("far far away"));
        return org;
    }
}
