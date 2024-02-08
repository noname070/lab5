package ru.noname07.lab5.collection;

import java.util.LinkedList;

import ru.noname07.lab5.collection.data.Organization;

public class CollectionManager {
    private static LinkedList<Organization> data = new LinkedList<Organization>();
    private static final Collector collector = new Collector(data);

    public static Collector getCollection() {
        return collector;
    }

    public static void loadData() {} // TODO
    public static void saveData() {} // TODO
}
