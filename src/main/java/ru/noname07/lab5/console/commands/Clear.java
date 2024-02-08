package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.Collector;

public class Clear extends Command {

    public Clear() {
        super("clear", "clear the collection");
    }

    @Override
    public void execute() {
        new Collector().clearData();
    }

    
}
