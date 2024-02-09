package ru.noname07.lab5.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.IntStream;

import ru.noname07.lab5.collection.data.Organization;

public class Collector {

    private LinkedList<Organization> data;

    public Collector(LinkedList<Organization> data) {
        this.data = data;
    }

    public static Organization createNewElement() {
        Organization element = new Organization();
        return element;
    }

    public void addElement(Organization element) {
        data.addLast(element);
    }

    public void sort() { // TODO test
        for (int i = 1; i < this.data.size(); i++) {
            Organization key = this.data.get(i);
            int j = i - 1;

            while (j >= 0 && ((Comparable<Organization>) this.data.get(j)).compareTo(key) > 0) {
                this.data.set(j + 1, this.data.get(j));
                j--;
            }

            this.data.set(j + 1, key);
        }
    }

    public void removeLast() {
        this.data.removeLast();
        System.out.println("Last element from Collection was removed.");
    }

    public void removeGreater(Organization inputElement) { // TODO test
        Iterator<Organization> iter = this.data.iterator();

        IntStream idxs = this.data
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

    }

    public void removeById(int id) { // TODO test
        Iterator<Organization> iter = this.data.iterator();
        while (iter.hasNext()) {
            Organization org = iter.next();
            if (org.getId().equals(id)) {
                iter.remove();

                System.out.printf("Element `Organization` %s[id:%s hashcode:%s] was removed.",
                        org.getName(), org.getId(), org.hashCode());
            }
        }
    }

    public void clearData() {
        this.data.clear();

        System.out.println("Collection data was cleared.");
    }

    public LinkedList<Organization> filterByAnnualTurnover(float annualTurnover) {
        ArrayList<Organization> localData = new ArrayList<Organization>();
        for (Organization o : this.data) {
            if (o.getAnnualTurnover() == annualTurnover) {
                localData.add(o);
            }
        }
        // return localData;
        System.out.printf("Collection was filtered by annualTurnover=%s", annualTurnover);
        for (Organization org : localData) {
            System.out.println(org.toString());
        }
        return null; // TODO
    }

    public LinkedList<Organization> filterGreaterThanAnnualTurnover(float annualTurnover) {
        ArrayList<Organization> localData = new ArrayList<Organization>();
        for (Organization o : this.data) {
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
        return null; // TODO
    }

    public String[] getAddresses() { // TODO
        return null;
    }

    public Iterator<Organization> getAllElementsIter() {
        return (Iterator<Organization>) this.data.iterator();
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    } 

}
