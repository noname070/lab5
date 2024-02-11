package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.CollectionManager;

public class Save extends Command {

    public Save() {
        super("save", "save collection to file", false);
    }

    @Override
    public void execute() {
        if (!CollectionManager.getData().isEmpty()) {
            CollectionManager.saveData();
            System.out.println("Collection saved to file.");
        } else {System.err.println("Error: Collection is empty.");}
    }

}
