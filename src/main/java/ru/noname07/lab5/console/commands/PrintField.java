package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.CollectionManager;

public class PrintField extends Command {

    public PrintField() {
        super("print_field_ascending_official_address", "display officialAddress of all elements by ascending order",
                false);
    }

    @Override
    public void execute() {
        if (!CollectionManager.getData().isEmpty()) {
            System.out.println("Collection officialAddresses:");
                // CollectionManager.getData().printSortedOfficialAddress(); // TODO
        } else {
            System.err.println("Error: Collection is empty.");
        }
    }

}
