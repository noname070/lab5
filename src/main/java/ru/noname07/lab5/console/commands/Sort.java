package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.CollectionManager;

public class Sort extends Command {

    public Sort() {
        super("sort", "sort collection in natural order", false);
    }

    @Override
    public void execute() {
        if (!CollectionManager.getCollection().isEmpty()) {
            CollectionManager.getCollection().sort();
            System.out.println("collection was sorted");
        } else {System.err.println("Error: Collection is empty.");}
    }

    
}
