package ru.noname07.lab5.console.commands;

import org.apache.commons.lang3.StringUtils;


import ru.noname07.lab5.App;
import ru.noname07.lab5.collection.data.Organization;
import ru.noname07.lab5.console.CreateNewElement;

public class Update extends Command {

    public Update() {
        super("update", "update the value of Collection element by id", true);
    }

    @Override
    public void execute(String[] args) {
        if (!App.collection.getData().isEmpty()) {

            if (StringUtils.isNumeric(args[0])) {
                int id = Integer.parseInt(args[0]);
                if (!(id < Organization.getStartId())) {
                    System.err.println("Error: Сan't update a non-existing element");
                    return;
                }

                Organization org = CreateNewElement.newElement();
                App.collection.getData().set(id, org);
                System.out.printf("Element with id %s was updated.\n", id);
            }

        } else {System.err.println("Error: Collection is empty.");}
    }

    
}
