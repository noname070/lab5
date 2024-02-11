package ru.noname07.lab5.console;

import java.util.Scanner;
import java.util.Arrays;
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
        while (name != null && !name.isEmpty()) {
            System.out.print("name >");
            name = localScanner.nextLine();
        }
        org.setName(name);

        // Coordinates
        Coordinates coordinates = new Coordinates();
        System.out.println("Create new element `Coordinates`");
        while (true) {
            System.out.print("x >");
            String x = localScanner.nextLine();

            System.out.print("y >");
            String y = localScanner.nextLine();

            if (!x.isEmpty() && !y.isEmpty() && StringUtils.isNumeric(x.strip()) && StringUtils.isNumeric(y.strip())) {
                coordinates.setX(Double.parseDouble(x.strip()));
                coordinates.setY(Float.parseFloat(y.strip()));

                break;
            } else {
                System.err.println("Incorrect input. Pls, nums only.");
            }
        }
        org.setCoordinates(coordinates);

        // annualTurnover
        while (StringUtils.isNumeric(input.strip()) == false) {
            System.out.print(" annualTurnover>");
            input = localScanner.nextLine();
        }
        org.setAnnualTurnover(Float.parseFloat(input));
        input = "";

        // employeesCount
        while (StringUtils.isNumeric(input.strip()) == false) {
            System.out.print(" employeesCount>");
            input = localScanner.nextLine();
            if (Integer.parseInt(input) <= 0) {
                System.out.println("Value must be > 0");
                continue;
            }
        }
        org.setEmployeesCount(Integer.parseInt(input));
        input = "";

        // type
        while (true) {
            System.out.printf("orgType [possible vals: %s]>",
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
        while (input.isEmpty()) {
            //TODO
            break;
        }

        return org;
    }

    public static Organization genRandom() { // dev TODO
        return new Organization(); 
    }
}
