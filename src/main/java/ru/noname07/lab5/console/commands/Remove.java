package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.collection.Collector;

public class Remove extends Command {

    public Remove() {
        super("remove", "[for dev only]");
        // TODO Auto-generated constructor stub
    }

    public static class RemoveLast extends Command {

        public RemoveLast() {
            super("remove_last", "remove the last element from collection");
        }

        @Override
        public void execute() {
            new Collector().removeLast();
        }

    }

    public static class RemoveGreater extends Command {

        public RemoveGreater() {
            super("remove_greater", "remove from a collection all elements greater than given");
        }

        @Override
        public void execute() {
            new Collector().removeGreater();
        }

    }

    public static class RemoveById extends Command {

        public RemoveById() {
            super("remove_by_id", "remove element from collection by id");
        }

        @Override
        public void execute() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'execute'");
        }

        @Override
        public void execute(String[] args) {
            int id = Integer.parseInt(args[1]);
            new Collector().removeById(id);
        }

    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

}
