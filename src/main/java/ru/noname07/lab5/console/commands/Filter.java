package ru.noname07.lab5.console.commands;

public class Filter extends Command {

    public Filter() {
        super("filters", "[for dev only]");
        //TODO Auto-generated constructor stub
    }

    static public class FilterByAnnualTurnover extends Command {

        public FilterByAnnualTurnover() {
            super("filter_by_annual_turnover", "display elements where annualTurnover = param");
            //TODO Auto-generated constructor stub
        }

        
    }

    static public class FilterByGreaterThanAnnualTurnover extends Command {

        public FilterByGreaterThanAnnualTurnover() {
            super("filter_greater_than_annual_turnover", "display elements where annualTurnover >= param");
            //TODO Auto-generated constructor stub
        }

    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Unimplemented method 'execute' in Filter");
    }

}
