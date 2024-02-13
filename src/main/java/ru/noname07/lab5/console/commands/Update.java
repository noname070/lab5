package ru.noname07.lab5.console.commands;

import org.apache.commons.lang3.StringUtils;


import ru.noname07.lab5.App;
import ru.noname07.lab5.collection.data.Organization;
import ru.noname07.lab5.console.CreateNewElement;

public class Update extends Command {

    public Update() {
        super("update", commandsBundle.getString("command.update.description"), true);
    }

    @Override
    public void execute(String[] args) {
        if (!App.collection.getData().isEmpty()) {

            if (StringUtils.isNumeric(args[0])) {
                int id = Integer.parseInt(args[0]);
                if (!(id < Organization.getStartId())) {
                    System.err.println(commandsBundle.getString("command.err.non_existing_element"));
                    return;
                }

                Organization org = CreateNewElement.newElement();
                App.collection.getData().set(id, org);
                System.out.printf(commandsBundle.getString("command.update.execute"), id);
            }

        } else {System.err.println(commandsBundle.getString("command.err.empty"));}
    }

    
}
