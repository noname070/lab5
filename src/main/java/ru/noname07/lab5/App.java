package ru.noname07.lab5;

import ru.noname07.lab5.console.Console;

public class App {

    public static final String FILE_PATH = "src/main/resources/data.xml";

    public static void main(String[] args) throws Exception {

        while (Console.isWorking()) {
            Console.processCommand();
        }
    }

}
