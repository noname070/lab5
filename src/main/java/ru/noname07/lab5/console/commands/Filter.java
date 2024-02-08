package ru.noname07.lab5.console.commands;

import java.util.ArrayList;

import ru.noname07.lab5.collection.CollectionManager;
import ru.noname07.lab5.collection.data.Organization;
import ru.noname07.lab5.utils.Printer;

public class Filter extends Command {

    public Filter() {
        super("filters", "[for dev only]");
    }

    static public class FilterByAnnualTurnover extends Command {

        public FilterByAnnualTurnover() {
            super("filter_by_annual_turnover", "display elements where annualTurnover = param");
        }

        @Override
        public void execute(String[] args) {
            ArrayList<Organization> output = CollectionManager.getCollection()
            .filterByAnnualTurnover(Float.parseFloat(args[1]));

            System.out.printf("Collection filtered by annualTurnover=%s :", args[1]);
            Printer.printCollection(output);
        }
        
    }

    static public class FilterByGreaterThanAnnualTurnover extends Command {

        public FilterByGreaterThanAnnualTurnover() {
            super("filter_greater_than_annual_turnover", "display elements where annualTurnover >= param");
        }

        @Override
        public void execute(String[] args) {
            ArrayList<Organization> output = CollectionManager.getCollection()
            .filterGreaterThanAnnualTurnover(Float.parseFloat(args[1]));

            System.out.printf("Collection filtered by annualTurnover=%s :", args[1]); // TODO
            Printer.printCollection(output);
        }

    }

}
