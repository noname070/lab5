package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.console.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExecureScript extends Command {

    public ExecureScript() {
        super("excute script", "read and execute the script from the specified file", true);

    }

    @Override
    public void execute(String[] args) { // 10 iq realisaiton
        File file = new File(args[1]);
        if (!file.exists()) {
            System.err.println("File dose not exist.");
            return;
        }

        PrintStream stdOut = System.out;

        try (FileInputStream commandsStream = new FileInputStream(file)) {
            System.setOut(null);
            Scanner scanner = new Scanner(commandsStream);
            while (scanner.hasNext()) {
                Console.processCommand(scanner);
            }

            stdOut.println("Script executed.");

        } catch (IOException e) {
            System.err.println("Error i/o with script file");
            e.printStackTrace();
        } finally {
            System.setOut(stdOut);
        }

    }

}
