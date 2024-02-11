package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.CollectionManager;
import ru.noname07.lab5.collection.data.Organization;
import ru.noname07.lab5.console.CreateNewElement;

public class Add extends Command {

    public Add() {
        super("add", "add new element in collection", false);
    }

    @Override
    public void execute() {
        Organization element = CreateNewElement.newElement();
        if (element.isValid()) {
            CollectionManager.getData().add(element);
        } else {
            System.err.println("Element invalid. Collection is not updated");
        }
    }

}
