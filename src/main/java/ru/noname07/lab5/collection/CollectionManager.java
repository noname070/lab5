package ru.noname07.lab5.collection;

import java.io.IOException;
import java.util.LinkedList;

// import javax.xml.bind.JAXBException;

import ru.noname07.lab5.App;
import ru.noname07.lab5.collection.data.Organization;
import ru.noname07.lab5.utils.ExperementalSerializer;
import ru.noname07.lab5.utils.IOManager;
// import ru.noname07.lab5.utils.Serializer;

public class CollectionManager {
    private LinkedList<Organization> data = new LinkedList<Organization>();

    public LinkedList<Organization> getData() {
        return data;
    }

    public void loadData() {
        String rawData;
        int maxId = 0;
        try {
            rawData = IOManager.readFromFile(App.FILE_PATH);
            if (rawData.isEmpty()) {
                System.err.println(String.format("File %s is empty, no data loaded.", App.FILE_PATH));
            } else {
                data = new ExperementalSerializer().deserialize(rawData);
                // id numeration fix
                for (Organization org : data) {
                    maxId = Math.max(org.getId(), maxId);
                }
                Organization.setStartId(maxId);

                System.out.println(String.format("Data from %s was loaded", App.FILE_PATH));
            }

        } catch (IOException e) {
            System.err.println("Can`t i/o with file in " + App.FILE_PATH );
            e.printStackTrace();
        }

    }

    public void saveData() {
        try {
            String rawData = new ExperementalSerializer().serialize(data);
            IOManager.writeToFile(App.FILE_PATH, rawData);
        } catch (IOException e) {
            System.err.println("Can`t i/o with file in " + App.FILE_PATH );
            e.printStackTrace();
        }

    }
}
