package ru.noname07.lab5;

import java.util.Scanner;

import ru.noname07.lab5.collection.CollectionManager;
import ru.noname07.lab5.console.Console;

public class App {

    public static String FILE_PATH;
    public static CollectionManager collection;
    public static Console console = new Console(new Scanner(System.in), System.in, System.out);

    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            FILE_PATH = args[0];
        } else {
            FILE_PATH = "src/main/resources/data.xml";
        }

        collection = new CollectionManager();
        collection.loadData();

        while (console.isWorking()) {
            System.out.print("|<lab5>| >");
            console.processCommand();
        }
    }

}
