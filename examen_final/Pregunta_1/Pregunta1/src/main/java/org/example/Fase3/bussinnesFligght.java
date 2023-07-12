package org.example.Fase3;



public class bussinnesFligght extends Fligth {
    public bussinnesFligght(String codigo){
        super(codigo);
    }

    @Override
    public boolean addPassenger(Passenger passenger){
        return passengers.add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return passengers.remove(passenger);
    }
}
