package ru.noname07.lab5.console.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import ru.noname07.lab5.App;

public abstract class Command implements ICommand {
    private String name;
    private String description;
    private boolean needArgs = false;
    protected static ResourceBundle commandsBundle = ResourceBundle.getBundle("l18n/CommandsBundle", App.currentLocale);

    public Command(String name, String description, boolean needArgs) {
        this.name = name;
        this.description = description;
        this.needArgs = needArgs;
    }

    public void execute() {
        if (!this.needArgs) {
            System.out.println(commandsBundle.getString("command.command.execute") + this.getClass().getName());
        } else {
            System.err.printf(commandsBundle.getString("command.command.execute"), this.name);
        }
    }

    public void execute(String[] args) {
        if (this.needArgs) {
            ArrayList<String> localArgs = new ArrayList<String>();
            localArgs.addAll(Arrays.asList(args));
            localArgs.remove(0);

            if (localArgs.size() != 1) {
                System.err.println(commandsBundle.getString("command.err.no_param"));
            } else
                System.out.printf(commandsBundle.getString("command.command.executed_with_args"), this.getClass().getName(), args[0]);
        } else {
            System.err.printf(commandsBundle.getString("command.err.use_without_args"), this.name);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

}