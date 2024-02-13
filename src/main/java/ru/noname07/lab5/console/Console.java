package ru.noname07.lab5.console;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.HashMap;

import ru.noname07.lab5.App;
import ru.noname07.lab5.console.commands.*;
import ru.noname07.lab5.utils.IOManager;

public class Console {
    private static final HashMap<String, Command> commandList = new HashMap<String, Command>();
    private boolean isWorking = true;
    private InputStream inputStream;
    private PrintStream printStream;

    private static ArrayDeque<String> commandLines = new ArrayDeque<String>();

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
        // addition task 3
        commandList.put("start_cache", new Cache.StartCache());
        commandList.put("save_cache", new Cache.SaveCache());
    }

    public Console(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
    }

    public Console() {
        this.inputStream = System.in;
        this.printStream = System.out;
    }

    public HashMap<String, Command> getCommandList() {
        return Console.commandList;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public PrintStream getPrintStream() {
        return this.printStream;
    }

    public static String getLastCommandLine() {
        return Console.commandLines.removeLast();
    }

    public boolean isWorking() {
        return this.isWorking;
    }

    public void setWork() {
        this.isWorking = true;
    }

    public static void addCommand(String inputLine) {
        Console.commandLines.addFirst(inputLine);
    }

    public static void addLast(String lastLine) {
        Console.commandLines.addLast(lastLine);
    }

    public static int getStackSize() {
        return Console.commandLines.size();
    }

    public void processStack() {
        while (!Console.commandLines.isEmpty()) {
            String inputLine = Console.commandLines.removeLast();
            String input[] = inputLine.split(" ");

            // dev
            if (input[0].equals("clFileHeap")) {
                ExecureScript.removeFileFromSet(input[1]);
                return;
            }

            if (!(input.length == 0)) {
                if (commandList.containsKey(input[0])) {
                    if (input.length == 1) {
                        commandList.get(input[0]).execute();
                    } else if (input.length == 2) {
                        commandList.get(input[0]).execute(input);
                    }
                }
            }

            if (!App.toScriptSave.equals("")) {
                try {
                    IOManager.addToFile(App.toScriptSave, inputLine);
                } catch (IOException e) {
                    System.err.println("Can`t i/o with file " + App.toScriptSave);
                    e.printStackTrace();
                }
            }
        }
    }

}
