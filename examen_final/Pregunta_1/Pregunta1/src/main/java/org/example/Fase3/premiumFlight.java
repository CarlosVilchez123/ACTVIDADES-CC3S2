package org.example.Fase3;


public class premiumFlight extends Fligth {
    public premiumFlight(String codigo){
        super(codigo);
    }

    /**
     *
     * @param passenger el pasajero debe ser Vip
     *                  para poder ser agregado a PremiumFlight
     * @return
     */
    @Override
    public boolean addPassenger(Passenger passenger){
        if(!passenger.isVip())
            throw new RuntimeException("No se puede inscribir a ese vuelo");
        return passengers.add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger){
        return passengers.remove(passenger);
    }
}
