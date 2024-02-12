package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.App;
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
            App.collection.getData().add(element);
        } else {
            System.err.println("Element invalid. Collection is not updated");
        }
    }

    // DEV ONLY
    @Override
    public void execute(String[] args) {
        if (args[1].equals("devrnd")) {
        Organization element = CreateNewElement.genRandom();
        App.collection.getData().add(element);
        System.out.println("[DEV] gen random element to collection.");
        } else {
            System.err.printf("You can`t use add with args\n");
        }
    }

}
