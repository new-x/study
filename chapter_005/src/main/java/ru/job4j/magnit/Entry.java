package ru.job4j.magnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.magnit
 * Create data: 09.07.2018 13:05
 */

@XmlRootElement
public class Entry {
    private List<Field> values;

    public Entry(){
    }

    public Entry(List<Field> values) {
        this.values = values;
    }
    public List<Field> getValues() {
        return values;
    }

    public void setValues(List<Field> values) {
        this.values = values;
    }

    @XmlRootElement
    public static class Field {
        private int value;

        public Field() {
        }

        public Field(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
