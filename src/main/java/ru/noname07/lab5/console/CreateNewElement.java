package ru.noname07.lab5.console;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.function.*;

import org.apache.commons.lang3.StringUtils;

import ru.noname07.lab5.App;
import ru.noname07.lab5.collection.data.*;

/**
 * Manager for new elements
 */
public class CreateNewElement {

    /**
     * run new element builder
     * if {@link Console#getStackSize} empty (means that commands are processed from
     * the incoming stream) : build step-by-step from incomming stream
     * else : process stack to load data
     */
    public static Organization newElement() {
        if (Console.getStackSize() == 0) {
            // return CreateNewElement.fromInputEx();
            return CreateNewElement.fromInput();
        } else
            return CreateNewElement.fromStack();
    }

    /**
     * bully loads data from stack
     * 
     * @see {@link CreateNewElement#newElement}
     */
    public static Organization fromStack() { // warning : if stack is not full - runtime error; recomend : redirect the
                                             // stream to .fromInput(), thereby saving checks
        Organization org = new Organization();
        org.setName(Console.getLastCommandLine());
        org.setCoordinates(new Coordinates(
                Double.parseDouble(Console.getLastCommandLine()),
                Float.parseFloat(Console.getLastCommandLine())));
        org.setAnnualTurnover(Float.parseFloat(Console.getLastCommandLine()));
        org.setEmployeesCount(Integer.parseInt(Console.getLastCommandLine()));
        org.setType(OrganizationType.valueOf(Console.getLastCommandLine()));
        org.setAddress(new Address(Console.getLastCommandLine()));
        if (org.isValid()) {
            return org;
        } else {
            System.err.println(App.generalBundle.getString("create.err.incorrect_value"));
            System.exit(-1);
            return null; // for vscode
        }
    }

    /**
     * loads data from console input stream, with all checkings
     * 
     * @see {@link CreateNewElement#newElement}
     */

    public static Organization fromInputEx() {
        Organization org = new Organization();
        Coordinates cords = new Coordinates();

        Scanner localScanner = new Scanner(System.in);

        System.out.println(App.generalBundle.getString("create.organization.new_element"));
        // ?
        while (!checker("create.organization.name", localScanner, org::setName,
                name -> !name.equals(null) && StringUtils.isAlpha(name), name -> String.valueOf(name), null)) {
        }

        System.out.println(App.generalBundle.getString("create.coordinates.new_element"));
        while (!checker("create.coordinates.x", localScanner, cords::setX,
                x -> !x.isEmpty() && StringUtils.isNumeric(x.strip()), x -> Double.valueOf(x),
                "create.err.nums_only")) {
        }
        while (!checker("create.coordinates.y", localScanner, cords::setY,
                y -> !y.isEmpty() && StringUtils.isNumeric(y.strip()), y -> Float.valueOf(y), "create.err.nums_only")) {
        }
        org.setCoordinates(cords);
        System.err.println(App.generalBundle.getString("create.coordinates.complete"));

        while (!checker("create.organization.annualTurnover", localScanner, org::setAnnualTurnover,
                annualTurnover -> StringUtils.isNumeric(annualTurnover.strip()),
                annualTurnover -> Float.valueOf(annualTurnover), "create.err.incorrect_value")) {
        }
        while (!checker("create.organization.employeesCount", localScanner, org::setEmployeesCount,
                employeesCount -> StringUtils.isNumeric(employeesCount.strip()),
                employeesCount -> Integer.valueOf(employeesCount), "create.err.incorrect_value")) {
        }

        // Legacy, too hard to optimize
        String input = "";
        while (true) {
            System.out.printf(App.generalBundle.getString("create.organization.orgType") + " >",
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
        // Legacy end

        System.out.println(App.generalBundle.getString("create.address.new_element"));
        while (!checker("create.address.street", localScanner, org::setAddress, street -> !street.isEmpty(),
                street -> new Address(street), "create.err.incorrect_value")) {
        }
        System.out.println(App.generalBundle.getString("create.address.complete"));

        return org;

    }

    private static <R> boolean checker(String bundleContext, Scanner scannerInput,
            Consumer<R> setter, Predicate<String> condition, Function<String, R> preparing, String errBundle) {
        System.out.print(App.generalBundle.getString(bundleContext) + " >");
        String input = scannerInput.nextLine();

        String err = errBundle != null ? App.generalBundle.getString(errBundle) + "\n" : "";

        try {
            if (condition.test(input)) {
                R out = preparing.apply(input);
                setter.accept(out);
                return true;
            } else
                System.err.print(err);
            return false;
        } catch (Exception e) {
            System.err.print(err);
            return false;
        }

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
            System.out.print(App.generalBundle.getString("create.organization.name") + " >");
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
            if (input.isEmpty()) {
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
            if (!input.isEmpty() & StringUtils.isNumeric(input)) {
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
            System.out.printf(App.generalBundle.getString("create.organization.orgType") + " >",
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
    //cringe
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
