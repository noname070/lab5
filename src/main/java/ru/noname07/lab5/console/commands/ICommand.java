package ru.noname07.lab5.console.commands;

/**
 * common command iface
 */
public interface ICommand {
    void execute();

    void execute(String[] arg);

    String getName();

    String getDescription();
}
