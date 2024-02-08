package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.CollectionManager;

public class Sort extends Command {

    public Sort() {
        super("sort", "sort collection in natural order");
    }

    @Override
    public void execute() {
        CollectionManager.getCollection().sort();
        System.out.println("collection was sorted");
    }

    
}
