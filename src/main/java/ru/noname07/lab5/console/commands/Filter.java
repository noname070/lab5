package ru.noname07.lab5.console.commands;

import java.util.LinkedList;
import java.util.ArrayList;

import ru.noname07.lab5.collection.CollectionManager;
import ru.noname07.lab5.collection.data.Organization;

public class Filter {

    static public class FilterByAnnualTurnover extends Command {

        public FilterByAnnualTurnover() {
            super("filter_by_annual_turnover", "display elements where annualTurnover = param", true);
        }

        @Override
        public void execute(String[] args) {
            if (!CollectionManager.getData().isEmpty()) {
                float annualTurnover = Float.parseFloat(args[1]); // TODO

                LinkedList<Organization> data = CollectionManager.getData();
                ArrayList<Organization> localData = new ArrayList<Organization>();
                for (Organization o : data) {
                    if (o.getAnnualTurnover() == annualTurnover) {
                        localData.add(o);
                    }
                }

                System.out.printf("Collection filtered by annualTurnover=%s :", args[1]);
                // collection.forEach(System.out::println); // TODO

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
            if (!CollectionManager.getData().isEmpty()) {
                float annualTurnover = Float.parseFloat(args[1]); // TODO

                LinkedList<Organization> data = CollectionManager.getData();
                ArrayList<Organization> localData = new ArrayList<Organization>();

                for (Organization o : data) {
                    if (o.getAnnualTurnover() > annualTurnover) {
                        localData.add(o);
                    }
                }
                // return localData;
                localData.sort(Organization::compareTo); // TODO ?
                System.out.printf("Collection was filtered by officialAddress=%s", annualTurnover);
                for (Organization org : localData) {
                    System.out.println(org.toString());
                }

                System.out.printf("Collection filtered by annualTurnover=%s :", args[1]); // TODO
                // collection.forEach(System.out::println); // TODO
            } else {
                System.err.println("Error: Collection is empty.");
            }

        }

    }

}
