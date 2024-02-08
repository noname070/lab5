package ru.noname07.lab5.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import ru.noname07.lab5.collection.data.Organization;

public class Collector {

    private LinkedList<Organization> data;

    public Collector(LinkedList<Organization> data) {
        this.data = data;
    }

    public void addElement(Organization element) {
        data.addLast(element);
    }

    public ArrayList<Organization> sort() {
        ArrayList<Organization> localData = new ArrayList<Organization>();
        this.getAllElementsIter().forEachRemaining(localData::add);
        localData.sort(this::compareTo);
        return localData;

    }

    public void removeLast() {
        this.data.removeLast();
    }

    public void removeGreater() { // TODO
        int localData[] = new int[data.size()];
        this.getAllElementsIter().forEachRemaining(o -> {

        });
    }

    public void removeById(int id) {
        this.data.remove(id);
    }

    public void clearData() {
        this.data.clear();
    }

    public ArrayList<Organization> filterByAnnualTurnover(float annualTurnover) {
        ArrayList<Organization> localData = new ArrayList<Organization>();
        for (Organization o : this.data) {
            if (o.getAnnualTurnover() == annualTurnover) {
                localData.add(o);
            }
        }
        return localData;
    }

    public ArrayList<Organization> filterGreaterThanAnnualTurnover(float annualTurnover) {
        ArrayList<Organization> localData = new ArrayList<Organization>();
        for (Organization o : this.data) {
            if (o.getAnnualTurnover() > annualTurnover) {
                localData.add(o);
            }
        }
        return localData;
    }

    public String[] getAddresses() { // TODO
        return null;
    }

    public Iterator<Organization> getAllElementsIter() {
        return (Iterator<Organization>) this.data.iterator();
    }

    public int compareTo(Organization o1, Organization o2) { // by default????????
        return o1.getName().compareTo(o2.getName());
    }

}
