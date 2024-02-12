package ru.noname07.lab5;

import ru.noname07.lab5.collection.CollectionManager;
import ru.noname07.lab5.console.Console;

public class App {

    public static String FILE_PATH;
    public static CollectionManager collection;

    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            FILE_PATH = args[0];
        } else {
            FILE_PATH = "src/main/resources/data.xml";
        }

        collection = new CollectionManager();
        collection.loadData();

        while (Console.isWorking()) {
            System.out.print("|<lab5>| >");
            Console.processCommand();
        }
    }

}
