package ru.noname07.lab5.console.commands;

import java.util.LinkedList;

import ru.noname07.lab5.collection.CollectionManager;
import ru.noname07.lab5.collection.data.Organization;

public class Sort extends Command {

    public Sort() {
        super("sort", "sort collection in natural order", false);
    }

    @Override
    public void execute() {
        if (!CollectionManager.getData().isEmpty()) {
            LinkedList<Organization> data = CollectionManager.getData();
            
            for (int i = 1; i < data.size(); i++) {
                Organization key = data.get(i);
                int j = i - 1;

                while (j >= 0 && ((Comparable<Organization>) data.get(j)).compareTo(key) > 0) {
                    data.set(j + 1, data.get(j));
                    j--;
                }

                data.set(j + 1, key);
            }
            System.out.println("collection was sorted");
        } else {
            System.err.println("Error: Collection is empty.");
        }
    }

}
