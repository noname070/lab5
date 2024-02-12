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
            super("remove_last", "remove the last element from Collection", false);
        }

        @Override
        public void execute() {
            if (!App.collection.getData().isEmpty()) {
                App.collection.getData().removeLast();
            } else {
                System.err.println("Error: Collection is empty.");
            }
        }

    }

    public static class RemoveGreater extends Command {

        public RemoveGreater() {
            super("remove_greater", "remove from a Collection all elements greater than given", true);
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

                        System.out.printf("Element 'Organization' %s[id:%s hashcode:%s] was removed.",
                                org.getName(), org.getId(), org.hashCode());
                    }
                }
            } else {
                System.err.println("Error: Collection is empty.");
            }
        }

    }

    public static class RemoveById extends Command {

        public RemoveById() {
            super("remove_by_id", "remove element from collection by id", true);
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

                        System.out.printf("Element `Organization` %s[id:%s hashcode:%s] was removed. \n",
                                org.getName(), org.getId(), org.hashCode());
                        break;
                    }
                }
            }
        }

    }

}
