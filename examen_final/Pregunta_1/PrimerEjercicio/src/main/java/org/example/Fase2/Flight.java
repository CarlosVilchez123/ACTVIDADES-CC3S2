package org.example.Fase2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Flight {
    /*
    Agregamos el atributo passangers
     */
    private String id;
    protected List<Passenger> passengers = new ArrayList<>();

    //contructor
    public Flight(String id) {
        this.id = id;
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);
    //Getters

    public String getId(){
        return id;
    }
    public List<Passenger> getPassengersList() {
        return Collections.unmodifiableList(passengers);
    }
}
