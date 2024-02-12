package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.App;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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

        try (FileInputStream commandsStream = new FileInputStream(file)) {
            App.console.setStreams(commandsStream,
                    new PrintStream(new OutputStream() {
                        @Override
                        public void write(int b) throws IOException {
                            return;
                        }
                    }));

            while (App.console.isWorking()) {
                App.console.processCommand();
            }

            System.out.println("Script executed.");
            App.console.setWork();

        } catch (IOException e) {
            System.err.println("Error i/o with script file");
            e.printStackTrace();
        } finally {
            App.console.setStreams(System.in, System.out);
        }
    }

}
