package ru.job4j.car.work;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.models.onannotation.ABody;
import ru.job4j.car.models.onannotation.ACar;
import ru.job4j.car.models.onannotation.AEngine;
import ru.job4j.car.models.onannotation.ATransmission;
import ru.job4j.car.models.onxml.Body;
import ru.job4j.car.models.onxml.Car;
import ru.job4j.car.models.onxml.Engine;
import ru.job4j.car.models.onxml.Transmission;

import static org.junit.Assert.*;

public class WorkTest {
    private static final TransactionWrapper transactionWrapper = new TransactionWrapper();
/*    private Work<Car> work;
    private Car carTest;
    private Body bodyTest;
    private Engine engineTest;
    private Transmission transmissionTest;*/
    private Work<ACar> work;
    private ACar carTest;
    private ABody bodyTest;
    private AEngine engineTest;
    private ATransmission transmissionTest;

    @Before
    public void setParameters() {
/*        this.work = new Work<Car>(transactionWrapper) {};
        this.bodyTest = new Body("bodyTest");
        this.engineTest = new Engine("engineTest");
        this.transmissionTest = new Transmission("transmissionTest");
        this.carTest = new Car("carTest", this.bodyTest, this.engineTest, this.transmissionTest);*/
        this.work = new Work<ACar>(transactionWrapper) {};
        this.bodyTest = new ABody("bodyTest");
        this.engineTest = new AEngine("engineTest");
        this.transmissionTest = new ATransmission("transmissionTest");
        this.carTest = new ACar("carTest", this.bodyTest, this.engineTest, this.transmissionTest);
    }

    @After
    public void clearDB(){
        transactionWrapper.writeAndExecute(session -> {
            session.createQuery("delete from Car where name= 'carTest'").executeUpdate();
            session.createQuery("delete from Car where name= 'carNameTestUpdate'").executeUpdate();
            session.createQuery("delete from Body where color = 'bodyTest'").executeUpdate();
            session.createQuery("delete from Engine where name= 'engineTest'").executeUpdate();
            session.createQuery("delete from Transmission where name= 'transmissionTest'").executeUpdate();
            return null;
        });

    }

    @Test
    public void testAddCar() {
        int id = this.work.add(carTest);
        assertTrue(this.work.findById(id).getName().equals(this.carTest.getName()));
    }

    @Test
    public void testDeleteCar() {
        int id  = this.work.add(this.carTest);
        /*this.work.delete(new Car(id));*/
        this.work.delete(new ACar(id));
        assertNull(this.work.findById(id));
    }

    @Test
    public void testUpdateCar() {
        this.carTest.setName("carNameTest");
        int id = this.work.add(this.carTest);
        this.carTest.setId(id);
        this.carTest.setName("carNameTestUpdate");
        this.work.update(this.carTest);
        assertTrue(this.work.findById(id).getName().equals(this.carTest.getName()));
    }
}