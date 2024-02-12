package ru.noname07.lab5.console.commands;

import java.util.ArrayList;
import java.util.Collections;

import ru.noname07.lab5.App;
import ru.noname07.lab5.collection.data.Organization;

public class PrintField extends Command {

    public PrintField() {
        super("print_field_ascending_official_address", "display officialAddress of all elements by ascending order",
                false);
    }

    @Override
    public void execute() {
        if (!App.collection.getData().isEmpty()) {
            System.out.println("Collection officialAddresses:");
            ArrayList<String> addresses = new ArrayList<>();
            for (Organization org : App.collection.getData()) {
                addresses.add(org.getAddress().getStreet());
            }

            Collections.sort(addresses);
            addresses.forEach(System.out::println);

        } else {
            System.err.println("Error: Collection is empty.");
        }
    }

}
