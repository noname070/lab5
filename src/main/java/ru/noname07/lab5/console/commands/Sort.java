package ru.noname07.lab5.console.commands;

import java.util.LinkedList;

import ru.noname07.lab5.App;
import ru.noname07.lab5.collection.data.Organization;

public class Sort extends Command {

    public Sort() {
        super("sort", commandsBundle.getString("command.sort.description"), false);
    }

    @Override
    public void execute() {
        if (!App.collection.getData().isEmpty()) {
            LinkedList<Organization> data = App.collection.getData();
            
            for (int i = 1; i < data.size(); i++) {
                Organization key = data.get(i);
                int j = i - 1;

                while (j >= 0 && ((Comparable<Organization>) data.get(j)).compareTo(key) > 0) {
                    data.set(j + 1, data.get(j));
                    j--;
                }

                data.set(j + 1, key);
            }
            System.out.println(commandsBundle.getString("command.sort.execute"));
        } else {
            System.err.println(commandsBundle.getString("command.err.empty"));
        }
    }

}
