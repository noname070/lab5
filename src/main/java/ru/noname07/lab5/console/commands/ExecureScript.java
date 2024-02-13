package ru.noname07.lab5.console.commands;

import java.util.HashSet;
import java.util.Scanner;

import ru.noname07.lab5.console.Console;
import java.io.File;
import java.io.FileInputStream;

public class ExecureScript extends Command {

    private static HashSet<String> filesToExecute = new HashSet<String>();

    public ExecureScript() {
        super("excute script", commandsBundle.getString("command.execute_script.description"), true);

    }

    public static void removeFileFromSet(String filePath) {
        filesToExecute.remove(filePath);
    }

    @Override
    public void execute(String[] args) { // 10 iq realisaiton
        File file = new File(args[1]);
        if (!file.exists()) {
            System.err.println(commandsBundle.getString("command.err.file_not_exists"));
            return;
        }
        if (filesToExecute.contains(file.getAbsolutePath())) {
            System.err.printf(commandsBundle.getString("command.execute_script.recursion"), file.getAbsolutePath());
            System.exit(-1);
        } else {
            filesToExecute.add(file.getAbsolutePath());
        }

        try (FileInputStream commandsStream = new FileInputStream(file)) {
            @SuppressWarnings("resource")
            Scanner localScanner = new Scanner(commandsStream);
            while (localScanner.hasNext()) {
                Console.addCommand(localScanner.nextLine());
            }
            Console.addCommand("clFileHeap " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
