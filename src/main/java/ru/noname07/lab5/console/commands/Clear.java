package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.CollectionManager;

public class Clear extends Command {

    public Clear() {
        super("clear", "clear the collection", false);
    }

    @Override
    public void execute() {
        CollectionManager.getData().clear();
        System.out.println("Collection was cleared.");
    }

}
