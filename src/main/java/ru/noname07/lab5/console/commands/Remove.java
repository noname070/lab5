package ru.noname07.lab5.console.commands;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.IntStream;

import ru.noname07.lab5.App;
import ru.noname07.lab5.collection.data.Organization;

public class Remove {

    public static class RemoveLast extends Command {

        public RemoveLast() {
            super("remove_last", commandsBundle.getString("command.remove_last.description"), false);
        }

        @Override
        public void execute() {
            if (!App.collection.getData().isEmpty()) {
                Organization org = App.collection.getData().removeLast();
                System.out.printf(commandsBundle.getString("command.remove_last.execute"),
                                    org.getName(), org.getId(), org.hashCode());
            } else {
                System.err.println(commandsBundle.getString("command.err.empty"));
            }
        }

    }

    public static class RemoveGreater extends Command {

        public RemoveGreater() {
            super("remove_greater", commandsBundle.getString("command.remove_greater.description"), true);
        }

        @Override
        public void execute() {
            if (!App.collection.getData().isEmpty()) {
                Organization inputElement = null;
                // new inputElement
                LinkedList<Organization> data = App.collection.getData();

                Iterator<Organization> iter = data.iterator();

                IntStream idxs = data
                        .stream()
                        .mapToInt(org -> org.compareTo(inputElement))
                        .filter(i -> i >= 0);

                Set<Integer> idxsToRemove = new HashSet<Integer>(idxs.boxed().toList());
                while (iter.hasNext()) {
                    Organization org = iter.next();
                    if (idxsToRemove.contains(org.getId())) {
                        iter.remove();

                        System.out.printf(commandsBundle.getString("command.remove_greater.execute"),
                                org.getName(), org.getId(), org.hashCode());
                    }
                }
            } else {
                System.err.println(commandsBundle.getString("command.err.empty"));
            }
        }

    }

    public static class RemoveById extends Command {

        public RemoveById() {
            super("remove_by_id", commandsBundle.getString("command.remove_by_id.description"), true);
        }

        @Override
        public void execute(String[] args) {
            if (!App.collection.getData().isEmpty()) {
                LinkedList<Organization> data = App.collection.getData();

                int id = Integer.parseInt(args[1]);
                Iterator<Organization> iter = data.iterator();
                while (iter.hasNext()) {
                    Organization org = iter.next();
                    if (org.getId().equals(id)) {
                        iter.remove();

                        System.out.printf(commandsBundle.getString("command.remove_by_id.execute"),
                                org.getName(), org.getId(), org.hashCode());
                        break;
                    }
                }
            }
        }

    }

}
