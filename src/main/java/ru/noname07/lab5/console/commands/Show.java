package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.App;
import ru.noname07.lab5.collection.data.Organization;

public class Show extends Command {

    public Show() {
        super("show", "display all elements of the Collection", false);
    }

    @Override
    public void execute() {
        if (!App.collection.getData().isEmpty()) {
            for (Organization org : App.collection.getData()) {
                System.out.println(org);
            }
        } else {System.err.println("Error: Collection is empty.");}
    }

    
}
