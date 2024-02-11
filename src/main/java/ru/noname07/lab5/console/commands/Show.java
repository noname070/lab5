package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.CollectionManager;

public class Show extends Command {

    public Show() {
        super("show", "display all elements of the collection", false);
    }

    @Override
    public void execute() {
        if (!CollectionManager.getData().isEmpty()) {
            // System.out.println(CollectionManager.getData()); // TODO Printer
        } else {System.err.println("Error: Collection is empty.");}
    }

    
}
