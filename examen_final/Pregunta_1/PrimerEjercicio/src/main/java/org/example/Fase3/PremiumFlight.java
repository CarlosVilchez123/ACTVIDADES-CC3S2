package org.example.Fase3;

public class PremiumFlight extends Flight{

    private String id;
    public PremiumFlight(String id){
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger){
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger){
        return false;
    }
}
