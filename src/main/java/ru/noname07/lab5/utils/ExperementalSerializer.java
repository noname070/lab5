package ru.noname07.lab5.utils;

import ru.noname07.lab5.collection.CollectionManager;
import ru.noname07.lab5.collection.data.*;

import java.util.LinkedList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;


public class ExperementalSerializer {
    private final XStream xstream;

    public ExperementalSerializer() {
        xstream = new XStream();

        xstream.alias("address", Address.class);
        xstream.alias("coordinates", Coordinates.class);
        xstream.alias("organization", Organization.class);
        xstream.alias("organizationType", OrganizationType.class);

        xstream.addImplicitCollection(CollectionManager.class, "data");

        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES); 
        xstream.allowTypeHierarchy(List.class);
        xstream.allowTypeHierarchy(String.class);
        xstream.ignoreUnknownElements();
    
    }
    
    public String serialize(LinkedList<Organization> data) {
        String rawData = xstream.toXML(data);
        return rawData;
    }
    
    public LinkedList<Organization> deserialize(String rawData) {
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES); 
        xstream.allowTypeHierarchy(List.class);
        xstream.allowTypeHierarchy(String.class);
        xstream.ignoreUnknownElements();
        xstream.allowTypes(new Class[] {LinkedList.class, Organization.class});

        @SuppressWarnings("unchecked")
        LinkedList<Organization> data = (LinkedList<Organization>) xstream.fromXML(rawData);
        return data;
    }

    
}
