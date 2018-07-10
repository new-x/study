package ru.job4j.magnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static ru.job4j.magnit.ParserMagnit.IN_FILE;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.magnit
 * Create data: 09.07.2018 13:03
 */

public class StoreXML {
    public List<Entry.Field> fieldList = new LinkedList<>();

    public void save(Entry.Field field) {
        fieldList.add(field);
    }

    public void expotToXML() throws JAXBException {
        File file = new File(IN_FILE);
        JAXBContext jaxbContext = JAXBContext.newInstance(Entry.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(new Entry(ParserMagnit.storeXML.fieldList), file);
    }
}
