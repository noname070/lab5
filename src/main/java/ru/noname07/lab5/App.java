package ru.noname07.lab5;

import ru.noname07.lab5.console.Console;

public class App {
    public static void main(String[] args) throws Exception {

        while (Console.isWorking()) {
            Console.processCommand();
        }
    }
}
