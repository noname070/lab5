package ru.noname07.lab5.console;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import ru.noname07.lab5.App;
import ru.noname07.lab5.collection.data.*;

public class CreateNewElement {

    public static Organization newElement() {
        if (Console.getStackSize() == 1) {
            return CreateNewElement.fromInput();
        } else
            return CreateNewElement.fromStack();
    }

    public static Organization fromStack() { // TODO mistakes??
        Organization org = new Organization();
        org.setName(Console.getLastCommandLine());
        org.setCoordinates(new Coordinates(
                Double.parseDouble(Console.getLastCommandLine()),
                Float.parseFloat(Console.getLastCommandLine())));
        org.setAnnualTurnover(Float.parseFloat(Console.getLastCommandLine()));
        org.setEmployeesCount(Integer.parseInt(Console.getLastCommandLine()));
        org.setType(OrganizationType.valueOf(Console.getLastCommandLine()));
        org.setAddress(new Address(Console.getLastCommandLine()));
        return org;
    }

    public static Organization fromInput() {

        Organization org = new Organization();

        String input = "";

        System.out.println(App.generalBundle.getString("create.organization.new_element"));
        @SuppressWarnings("resource")
        Scanner localScanner = new Scanner(System.in);

        // Name
        String name = "";
        while (true) {
            System.out.print(App.generalBundle.getString("create.organization.name"));
            name = localScanner.nextLine();
            if (!name.isEmpty() && StringUtils.isAlpha(name)) {
                org.setName(name);
                break;
            }
        }

        // Coordinates
        Coordinates coordinates = new Coordinates();
        System.out.println(App.generalBundle.getString("create.coordinates.new_element"));

        while (true) {
            System.out.print(App.generalBundle.getString("create.coordinates.x") + " >");
            String x = localScanner.nextLine();

            System.out.print(App.generalBundle.getString("create.coordinates.y") + " >");
            String y = localScanner.nextLine();

            if (!x.isEmpty() && !y.isEmpty() && StringUtils.isNumeric(x.strip()) && StringUtils.isNumeric(y.strip())) {
                coordinates.setX(Double.parseDouble(x.strip()));
                coordinates.setY(Float.parseFloat(y.strip()));

                break;
            } else {
                System.err.println(App.generalBundle.getString("create.err.nums_only"));
            }
        }
        System.err.println(App.generalBundle.getString("create.coordinates.complete"));
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
                System.err.println(App.generalBundle.getString("create.err.incorrect_value"));
            }
        }
        input = "";

        // employeesCount
        while (true) {
            System.out.print(" employeesCount>");
            input = localScanner.nextLine();
            if (!input.equals("")) {
                if (Integer.parseInt(input) <= 0) {
                    System.err.println(App.generalBundle.getString("create.err.value_greater_than_zero"));
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
            System.out.printf(App.generalBundle.getString("create.organization.orgType"),
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
                System.err.println(App.generalBundle.getString("create.err.incorrect_type"));
            }
        }
        input = "";

        // address
        System.out.println(App.generalBundle.getString("create.address.new_element"));
        while (true) {
            System.out.print(App.generalBundle.getString("create.address.street") + " >");
            input = localScanner.nextLine();
            if (!input.isEmpty()) {
                org.setAddress(new Address(input));
                break;
            }
        }
        System.out.println(App.generalBundle.getString("create.address.complete"));

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
