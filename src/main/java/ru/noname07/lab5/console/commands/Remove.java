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
            if (!CollectionManager.getCollection().isEmpty()) {
                CollectionManager.getCollection().removeLast();
            } else {System.err.println("Error: Collection is empty.");}
        }

    }

    public static class RemoveGreater extends Command {

        public RemoveGreater() {
            super("remove_greater", "remove from a collection all elements greater than given");
        }

        @Override
        public void execute() {
            if (!CollectionManager.getCollection().isEmpty()) {
                CollectionManager.getCollection()
                        .removeGreater(
                                Collector.createNewElement());
            } else {System.err.println("Error: Collection is empty.");}
        }

    }

    public static class RemoveById extends Command {

        public RemoveById() {
            super("remove_by_id", "remove element from collection by id");
        }

        @Override
        public void execute(String[] args) {
            if (!CollectionManager.getCollection().isEmpty()) {
                int id = Integer.parseInt(args[1]);
                CollectionManager.getCollection().removeById(id);
            }
        }

    }

}
