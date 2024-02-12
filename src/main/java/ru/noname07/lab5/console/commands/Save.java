package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.App;

public class Save extends Command {

    public Save() {
        super("save", "save Collection to file", false);
    }

    @Override
    public void execute() {
        if (!App.collection.getData().isEmpty()) {
            App.collection.saveData();
            System.out.println("Collection saved to file.");
        } else {System.err.println("Error: Collection is empty.");}
    }

}
