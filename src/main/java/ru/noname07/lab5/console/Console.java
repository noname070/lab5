package ru.noname07.lab5.console;

import java.util.HashMap;
import java.util.Scanner;

import ru.noname07.lab5.console.commands.*;

public class Console {
    private static final HashMap<String, Command> commandList = new HashMap<String, Command>();
    private static boolean isWorking = true;

    static {
        commandList.put("help", new Help());
        commandList.put("info", new Info());
        commandList.put("show", new Show());
        commandList.put("add", new Add());
        commandList.put("update_id", new UpdateID());
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

    public static HashMap<String, Command> getCommandList() {
        return Console.commandList;
    }

    public static boolean isWorking() {
        return isWorking;
    }

    public static void processCommand() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("|<lab5>| > ");
        String commandLine = scanner.nextLine();
        String input[] = commandLine.split(" ");

        try { // TODO args to commands
            if (input.length == 1) {
                commandList.get(input[0]).execute();
            } else if (input.length == 2) {
                commandList.get(input[0]).execute(input);
            } else {
                System.out.println("Smthng wrong........");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
