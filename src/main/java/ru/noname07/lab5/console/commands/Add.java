package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.CollectionManager;
import ru.noname07.lab5.collection.Collector;

import ru.noname07.lab5.collection.data.Organization;

public class Add extends Command {

    public Add() {
        super("add", "add new element in collection");
    }

    @Override
    public void execute() { // TODO
        Organization element = Collector.createNewElement();
        CollectionManager.getCollection().addElement(element);

        System.out.println("New element was added.");
    }

    
}
