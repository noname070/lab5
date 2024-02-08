package ru.noname07.lab5.console.commands;


public abstract class Command implements ICommand {
    private String name;
    private String description;

    public Command(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void execute() {
        System.out.println("executed " + this.getClass().getName());
    }

    public void execute(String[] args) {
        System.out.println("executed" + this.getClass().getName() + " with args:" + args);
    }

    public String getName() {return this.name;}

    public String getDescription() {return this.description;}
    
} 