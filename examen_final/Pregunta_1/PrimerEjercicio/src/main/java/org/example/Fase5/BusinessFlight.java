package org.example.Fase5;

import java.util.Map;
import java.util.Random;

public class BusinessFlight extends Flight {
    public BusinessFlight(String id){
        super(id);
    }
    @Override
    public boolean addPassenger(Passenger passenger){
        Random rn = new Random();
        for(Map.Entry<Integer,Passenger> pas: passengersMap.entrySet()){
            if(passenger.getName()==pas.getValue().getName())
            {
                return false;
            }
        }
        if(passenger.isVip()){
            passengersMap.putIfAbsent(rn.nextInt(0,10), passenger);
            return true;
        }

        return false;
    }
    @Override
    public boolean removePassenger(Passenger passenger){
        return false;
    }
}
