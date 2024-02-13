package ru.noname07.lab5;

import java.util.Scanner;

import ru.noname07.lab5.collection.CollectionManager;
import ru.noname07.lab5.console.Console;

/*
 * КЕШИРОВАТЬ КОМАНДЫ И ЗАПИСЫВАТЬ
 * ВЫБОР ЯЗЫКА / ЛОКАЛИЗАЦИЯ
 * ПОФИКСИТЬ КУЧУ С ФАЙЛАМИ ПОСЛЕ ИСПОЛНЕНИЯ ФУЛ СКРИПТА
 * 
 */

public class App {

    public static String FILE_PATH;
    public static CollectionManager collection;
    public static Console console = new Console();
    public static String toScriptSave = "";

    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            FILE_PATH = args[0];
        } else {
            FILE_PATH = "src/main/resources/data.xml";
        }

        collection = new CollectionManager();
        collection.loadData();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(console.getInputStream());

        while (console.isWorking()) {
            System.out.print("|<lab5>| >");
            Console.addCommand(scanner.nextLine());
            console.processStack();
        }
    }

}
