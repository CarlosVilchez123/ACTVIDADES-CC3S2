package org.example.Fase1;

import org.example.Fase1.Passenger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fligth {
    private String flightType;
    private String codigo;
    private List<Passenger> passengers = new ArrayList<Passenger>();

    public Fligth(String flightType, String codigo){
        this.flightType=flightType;
        this.codigo=codigo;
    }
    public boolean addPassenger(Passenger passenger){
        switch (flightType) {
            case "Economica":
                return passengers.add(passenger);
            case "Negocios":
                if (passenger.isVip()) {
                    return passengers.add(passenger);
                }
                return false;
            default:
                throw new RuntimeException("Tipo desconocido: " + flightType);
        }

    }

    public boolean removePassenger(Passenger passenger) {
        switch (flightType) {
            case "Economica":
                if (!passenger.isVip()) {
                    return passengers.remove(passenger);
                }
                return false;
            case "Negocios":
                return false;

            default:

                throw new RuntimeException("Tipo desconocido: " + flightType);
        }
    }

    /*
    Getters and Setters
     */
    public List<Passenger> getPassengersList() {
        return Collections.unmodifiableList(passengers);
    }

    public String getCodigo(){
        return codigo;
    }
}
