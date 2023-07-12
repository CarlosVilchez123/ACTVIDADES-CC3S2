package org.example.Fase2;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Fligth {
    private final String codigo;
    public final List<Passenger> passengers = new ArrayList<>();

    public Fligth(String codigo){
        this.codigo=codigo;
    }
    abstract public boolean addPassenger(Passenger passenger);

    abstract public boolean removePassenger(Passenger passenger);

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
