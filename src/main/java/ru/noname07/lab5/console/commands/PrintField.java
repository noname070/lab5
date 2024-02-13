package ru.noname07.lab5.console.commands;

import java.util.ArrayList;
import java.util.Collections;

import ru.noname07.lab5.App;
import ru.noname07.lab5.collection.data.Organization;

public class PrintField extends Command {

    public PrintField() {
        super("print_field_ascending_official_address", commandsBundle.getString("command.print_field_ascending_official_address.description"),
                false);
    }

    @Override
    public void execute() {
        if (!App.collection.getData().isEmpty()) {
            System.out.println( commandsBundle.getString("command.print_field_ascending_official_address.execute"));
            ArrayList<String> addresses = new ArrayList<>();
            for (Organization org : App.collection.getData()) {
                addresses.add(org.getAddress().getStreet());
            }

            Collections.sort(addresses);
            addresses.forEach(System.out::println);

        } else {
            System.err.println( commandsBundle.getString("command.err.empty"));
        }
    }

}
