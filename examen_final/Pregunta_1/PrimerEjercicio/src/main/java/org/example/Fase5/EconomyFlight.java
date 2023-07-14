package org.example.Fase5;

import java.util.Map;
import java.util.Random;

public class EconomyFlight extends Flight {
    public EconomyFlight(String id){
        super(id);
    }

    /**
     *
     * @param passenger No debe registrarse dos veces un mismo pasajero
     * @return
     */
    @Override
    public boolean addPassenger(Passenger passenger){
        Random rn = new Random();
        for(Map.Entry<Integer,Passenger> pas: passengersMap.entrySet()){
            if(passenger.getName()==pas.getValue().getName())
            {
                return false;
            }
        }

        passengersMap.put(rn.nextInt(0,100),passenger);

        return true;
    }
    @Override
    public boolean removePassenger(Passenger passenger){
        for(Map.Entry<Integer,Passenger> pas: passengersMap.entrySet()){
            if(passenger.getName()==pas.getValue().getName())
            {
                Integer key = pas.getKey();
                if(!passenger.isVip() && (passenger.getName()==pas.getValue().getName()))
                    passengersMap.remove(key);
                return true;
            }
        }
        return false;
    }
}
