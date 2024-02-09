package ru.noname07.lab5.console.commands;

import java.util.ArrayList;
import java.util.Arrays;

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
            System.out.println("executed " + this.getClass().getName());
        } else {
            System.err.printf("You can`t use '%s' with args\n", this.name);
        }
    }

    public void execute(String[] args) {
        if (this.needArgs) {
            ArrayList<String> localArgs = new ArrayList<String>();
            localArgs.addAll(Arrays.asList(args));
            localArgs.remove(0);

            if (localArgs.size() != 1) {
                System.err.println("Error: No parameters passed");
            } else
                System.out.printf("executed %s with args: %s\n", this.getClass().getName(), args[0]);
        } else {
            System.err.printf("You can`t use '%s' without args\n");
        }
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

}