package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.CollectionManager;
import ru.noname07.lab5.collection.Collector;

import ru.noname07.lab5.collection.data.Organization;

public class Add extends Command {

    public Add() {
        super("add", "add new element in collection", false);
    }

    @Override
    public void execute() { // TODO
        Organization element = Collector.createNewElement();
        if (element.isValid()) {
            CollectionManager.getCollection().addElement(element);
        } else {System.err.println("Element invalid. Collection is not updated");}
    }

}
