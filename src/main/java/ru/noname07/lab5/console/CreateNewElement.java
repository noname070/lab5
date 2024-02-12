package ru.noname07.lab5.console;

import java.util.Scanner;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import ru.noname07.lab5.App;
import ru.noname07.lab5.collection.data.*;

public class CreateNewElement {
    public static Organization newElement() {

        InputStream inputStream = App.console.getInputStream();
        PrintStream printStream = App.console.getPrintStream();

        Organization org = new Organization();

        String input = "";

        printStream.println("Create new element `Organization`");
        @SuppressWarnings("resource")
        Scanner localScanner = new Scanner(inputStream);

        // Name
        String name = "";
        while (true) {
            printStream.print(" name >");
            name = localScanner.nextLine();
            if (!name.isEmpty() && StringUtils.isAlpha(name)) {
                org.setName(name);
                break;
            }
        }

        // Coordinates
        Coordinates coordinates = new Coordinates();
        printStream.println("Create new element `Coordinates`");
        while (true) {
            printStream.print(" x >");
            String x = localScanner.nextLine();

            printStream.print(" y >");
            String y = localScanner.nextLine();

            if (!x.isEmpty() && !y.isEmpty() && StringUtils.isNumeric(x.strip()) && StringUtils.isNumeric(y.strip())) {
                coordinates.setX(Double.parseDouble(x.strip()));
                coordinates.setY(Float.parseFloat(y.strip()));

                break;
            } else {
                System.err.println("Incorrect input. Pls, nums only.");
            }
        }
        printStream.println("New element `Coordinates` created.");
        org.setCoordinates(coordinates);

        // annualTurnover
        while (true) {
            printStream.print(" annualTurnover>");
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
            printStream.print(" employeesCount>");
            input = localScanner.nextLine();
            if (!input.equals("")) {
                if (Integer.parseInt(input) <= 0) {
                    System.err.println("Value must be > 0");
                    continue;
                } else {
                    org.setEmployeesCount(Integer.parseInt(input));
                    break;
                }
            }
        }
        input = "";

        // type
        while (true) {
            printStream.printf(" orgType [possible vals: %s] >",
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
        printStream.println("Create new element `Address`");
        while (true) {
            printStream.print(" street >");
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
