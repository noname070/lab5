package ru.noname07.lab5.console.commands;

import java.util.ArrayList;
import java.util.Arrays;

import ru.noname07.lab5.App;

public abstract class Command implements ICommand {
    private String name;
    private String description;
    private boolean needArgs = false;

    public Command(String name, String description, boolean needArgs) {
        this.name = name;
        this.description = description;
        this.needArgs = needArgs;
    }

    public void execute() {
        if (!this.needArgs) {
            System.out.println(App.generalBundle.getString("command.command.execute") + this.getClass().getName());
        } else {
            System.err.printf(App.generalBundle.getString("command.command.execute"), this.name);
        }
    }

    public void execute(String[] args) {
        if (this.needArgs) {
            ArrayList<String> localArgs = new ArrayList<String>();
            localArgs.addAll(Arrays.asList(args));
            localArgs.remove(0);

            if (localArgs.size() != 1) {
                System.err.println(App.generalBundle.getString("command.err.no_param"));
            } else
                System.out.printf(App.generalBundle.getString("command.command.executed_with_args"), this.getClass().getName(), args[0]);
        } else {
            System.err.printf(App.generalBundle.getString("command.err.use_without_args"), this.name);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

}