package org.example.Fase3;

public class BusinessFlight extends Flight{
    public BusinessFlight(String id){
        super(id);
    }
    @Override
    public boolean addPassenger(Passenger passenger){
        return passengers.add(passenger);
    }
    @Override
    public boolean removePassenger(Passenger passenger){
        if(!passenger.isVip())
            return passengers.remove(passenger);
        return false;
    }
}
