package org.example.Fase3;


public class ecnomoyFlight extends Fligth {
    public ecnomoyFlight(String codigo){
        super(codigo);
    }
    public boolean addPassenger(Passenger passenger){
        return passengers.add(passenger);
    }
    public boolean removePassenger(Passenger passenger){
        return passengers.remove(passenger);
    }
}
