package ru.noname07.lab5.collection;

import java.io.IOException;
import java.util.LinkedList;

import javax.xml.bind.JAXBException;

import ru.noname07.lab5.App;
import ru.noname07.lab5.collection.data.Organization;
import ru.noname07.lab5.utils.IOManager;
import ru.noname07.lab5.utils.Serializer;

public class CollectionManager {
    private static LinkedList<Organization> data = new LinkedList<Organization>();


    public static LinkedList<Organization> getData() {
        return data;
    }

    public static void loadData() { // TODO testing
        try {
            String rawData = IOManager.readFromFile(null);
            data = new Serializer().deserialize(rawData);
        
        } catch (JAXBException e) {
            System.err.println("JAXBException in loadData");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO Error with loadData");
            e.printStackTrace();
        }
        
    }

    public static void saveData() { // TODO testing
        try {
            String rawData = new Serializer().serialize(data);
            IOManager.writeToFile(App.FILE_PATH, rawData);
        
        } catch (JAXBException e) {
            System.err.println("JAXBException in saveData!");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO Error with saveData");
            e.printStackTrace();
        }
    }
}
