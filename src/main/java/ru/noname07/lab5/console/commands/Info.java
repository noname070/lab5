package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.CollectionManager;

public class Info extends Command {

    public Info() {
        super("info", "display info about the collection");
    }

    @Override
    public void execute() { // TODO
        if (!CollectionManager.getCollection().isEmpty()) {
            super.execute();
        } else {System.err.println("Error: Collection is empty.");}
    }

    
}
