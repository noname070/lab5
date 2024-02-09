package ru.noname07.lab5.console.commands;

import java.util.LinkedList;

import ru.noname07.lab5.collection.CollectionManager;
import ru.noname07.lab5.collection.data.Organization;

public class Filter {

    static public class FilterByAnnualTurnover extends Command {

        public FilterByAnnualTurnover() {
            super("filter_by_annual_turnover", "display elements where annualTurnover = param", true);
        }

        @Override
        public void execute(String[] args) {
            if (!CollectionManager.getCollection().isEmpty()) {
                LinkedList<Organization> collection = CollectionManager.getCollection()
                        .filterByAnnualTurnover(Float.parseFloat(args[1]));

                System.out.printf("Collection filtered by annualTurnover=%s :", args[1]);
                collection.forEach(System.out::println);

            } else {
                System.err.println("Error: Collection is empty.");
            }
        }

    }

    static public class FilterByGreaterThanAnnualTurnover extends Command {

        public FilterByGreaterThanAnnualTurnover() {
            super("filter_greater_than_annual_turnover", "display elements where annualTurnover >= param", true);
        }

        @Override
        public void execute(String[] args) {
            if (!CollectionManager.getCollection().isEmpty()) {
                LinkedList<Organization> collection = CollectionManager.getCollection()
                        .filterGreaterThanAnnualTurnover(Float.parseFloat(args[1]));

                System.out.printf("Collection filtered by annualTurnover=%s :", args[1]); // TODO
                collection.forEach(System.out::println);
            } else {
                System.err.println("Error: Collection is empty.");
            }

        }

    }

}
