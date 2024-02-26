package ru.noname07.lab5.console.commands;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

import ru.noname07.lab5.App;
import ru.noname07.lab5.collection.data.Organization;

public class Filter {

    static public class FilterByAnnualTurnover extends Command {

        public FilterByAnnualTurnover() {
            super("filter_greater_than_annual_turnover", App.generalBundle.getString("command.filter_greater_than_annual_turnover.description"), true);
        }

        @Override
        public void execute(String[] args) {
            if (!App.collection.getData().isEmpty()) {
                if (!StringUtils.isNumeric(args[1].replace(".", ""))) {
                    System.err.println(App.generalBundle.getString("command.err.incorrect_value"));
                    return;
                }

                float annualTurnover = Float.parseFloat(args[1]);
                ArrayList<Organization> localData = new ArrayList<Organization>();
                for (Organization o : App.collection.getData()) {
                    if (!(o.getAnnualTurnover() == null)) {
                        if (o.getAnnualTurnover().equals(annualTurnover)) {
                            localData.add(o);
                        }
                    }
                }

                System.out.printf(App.generalBundle.getString("command.filter_greater_than_annual_turnover.execute"), args[1]);
                localData.forEach(System.out::println);

            } else {
                System.err.println(App.generalBundle.getString("command.err.empty"));
            }
        }

    }

    static public class FilterByGreaterThanAnnualTurnover extends Command {

        public FilterByGreaterThanAnnualTurnover() {
            super("filter_greater_than_annual_turnover", App.generalBundle.getString("command.filter_greater_than_annual_turnover.description"), true);
        }

        @Override
        public void execute(String[] args) {
            if (!App.collection.getData().isEmpty()) {
                if (!StringUtils.isNumeric(args[1])) {
                    System.err.println(App.generalBundle.getString("command.err.incorrect_value"));
                    return;
                }
                float annualTurnover = Float.parseFloat(args[1]);
                ArrayList<Organization> localData = new ArrayList<Organization>();

                for (Organization o : App.collection.getData()) {
                    if (!(o.getAnnualTurnover() == null)) {
                        if (o.getAnnualTurnover() > annualTurnover) {
                            localData.add(o);
                        }
                    }
                }

                System.out.printf("Collection was filtered by officialAddress=%s:\n", annualTurnover);
                localData.forEach(System.out::println);

            } else {
                System.err.println(App.generalBundle.getString("command.err.empty"));
            }

        }

    }

}
