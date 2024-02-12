package ru.noname07.lab5.console;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import ru.noname07.lab5.console.commands.*;

public class Console {
    private static final HashMap<String, Command> commandList = new HashMap<String, Command>();
    private boolean isWorking = true;
    private Scanner scanner;
    private InputStream inputStream;
    private PrintStream printStream;

    static {
        commandList.put("help", new Help());
        commandList.put("info", new Info());
        commandList.put("show", new Show());
        commandList.put("add", new Add());
        commandList.put("update", new Update());
        commandList.put("remove_by_id", new Remove.RemoveById());
        commandList.put("clear", new Clear());
        commandList.put("save", new Save());
        commandList.put("execute_script", new ExecureScript());
        commandList.put("exit", new Exit());
        commandList.put("remove_last", new Remove.RemoveLast());
        commandList.put("remove_greater", new Remove.RemoveGreater());
        commandList.put("sort", new Sort());
        commandList.put("filter_by_annual_turnover", new Filter.FilterByAnnualTurnover());
        commandList.put("filter_greater_than_annual_turnover", new Filter.FilterByGreaterThanAnnualTurnover());
        commandList.put("print_field_ascending_official_address", new PrintField());
    }

    public Console(Scanner scanner, InputStream inputStream, PrintStream printStream) {
        this.scanner = scanner;
        this.inputStream = inputStream;
        this.printStream = printStream;
    }

    public void setStreams(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
        this.scanner = new Scanner(inputStream);
    }

    public InputStream getInputStream() {return this.inputStream;}
    public PrintStream getPrintStream() {return this.printStream;}

    public HashMap<String, Command> getCommandList() {
        return Console.commandList;
    }

    public boolean isWorking() {
        return this.isWorking;
    }

    public void setWork() {
        this.isWorking = true;
    }

    public void processCommand() {
        if (!scanner.hasNext()) {
            this.isWorking = false;
            return;
        }
        String commandLine = scanner.nextLine();
        String input[] = commandLine.split(" ");

        if (!(input.length == 0)) {
            if (commandList.containsKey(input[0])) {
                if (input.length == 1) {
                    commandList.get(input[0]).execute();
                } else if (input.length == 2) {
                    commandList.get(input[0]).execute(input);
                }
            }
        }
    }

}
