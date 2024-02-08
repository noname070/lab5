package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.CollectionManager;
import ru.noname07.lab5.utils.Printer;

public class PrintField extends Command {

    public PrintField() {
        super("print_field_ascending_official_address", "display officialAddress of all elements by ascending order");
    }

    @Override
    public void execute() {
        System.out.println("Current Collection:");
        Printer.printCollection(CollectionManager.getCollection());
    }

}
