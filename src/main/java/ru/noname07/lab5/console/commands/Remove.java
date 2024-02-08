package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.CollectionManager;
import ru.noname07.lab5.collection.Collector;

public class Remove extends Command {

    public Remove() {
        super("remove", "[for dev only]");
    }

    public static class RemoveLast extends Command {

        public RemoveLast() {
            super("remove_last", "remove the last element from collection");
        }

        @Override
        public void execute() {
            CollectionManager.getCollection().removeLast();
        }

    }

    public static class RemoveGreater extends Command {

        public RemoveGreater() {
            super("remove_greater", "remove from a collection all elements greater than given");
        }

        @Override
        public void execute() {
            CollectionManager.getCollection().removeGreater();
        }

    }

    public static class RemoveById extends Command {

        public RemoveById() {
            super("remove_by_id", "remove element from collection by id");
        }

        @Override
        public void execute(String[] args) {
            int id = Integer.parseInt(args[1]);
            CollectionManager.getCollection().removeById(id);
        }

    }

}
