package org.example.Nuevo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fligth {
    private String flightType;
    private String codigo;
    private List<Passenger> passengers = new ArrayList<Passenger>();

    public Fligth(String flightType){
        this.flightType=flightType;
    }
    public boolean addPassenger(Passenger passenger){
        passengers.add(passenger);
        return true;
    }

    public boolean removePassenger(Passenger passenger) {
        passengers.remove(passenger);
        return true;
    }



    public List<Passenger> getPassengersList() {
        return Collections.unmodifiableList(passengers);
    }

}
