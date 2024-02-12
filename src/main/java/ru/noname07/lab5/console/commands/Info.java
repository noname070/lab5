package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.App;

public class Info extends Command {

    public Info() {
        super("info", "display info about the collection", false);
    }

    @Override
    public void execute() { // TODO ?
        if (!App.collection.getData().isEmpty()) {
            System.out.printf("Information:\n type:%s\n count:%s\n",
                    App.collection.getData().getClass().getName(),
                    App.collection.getData().size());
        } else {
            System.err.println("Error: Collection is empty.");
        }
    }

}
