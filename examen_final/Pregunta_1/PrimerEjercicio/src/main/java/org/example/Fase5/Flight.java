package org.example.Fase5;


import java.util.*;

public abstract class Flight {
    /*
Agregamos el atributo passangers
 */
    private String id;
    protected Map<Integer, Passenger> passengersMap = new HashMap<Integer, Passenger>();

    //contructor
    public Flight(String id) {
        this.id = id;
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);
    public Map<Integer, Passenger> getPassengersList() {
        return passengersMap;
    }

    //Getters
    public String getId(){
        return id;
    }


}
