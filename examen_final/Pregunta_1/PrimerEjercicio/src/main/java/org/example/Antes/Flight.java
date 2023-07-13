package org.example.Antes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flight {
    /*
    Agregamos el atributo passangers
     */
    private List<Passenger> passengers = new ArrayList<>();
    private String flightType;

    public Flight(String flightType) {

        this.flightType = flightType;
    }

    /**
     * Este metodo agregara cada objeto de la clase passenger
     * a la lista de pasajeros de la clase Fligth
     * @param passenger passenger no tiene niguna resitrccion, sin embargo, si
     *                  el pasajero es un pasajero ecnomico este no podra registrarse en vuelos de negocios.
     * @return
     */
    public boolean addPassenger(Passenger passenger) {
        switch (flightType) {
            case "Economico":
                return passengers.add(passenger);
            //implementacion de la restriccion del contrato
            case "Negocios":
                if (passenger.isVip()) {
                    return passengers.add(passenger);
                }
                return false;
            default:
                throw new RuntimeException("Tipo desconocido: " + flightType);
        }

    }


    /**
     * Este metodo remueve cada objeto de la clase passenger
     * a la lista de pasajeros de la clase Fligth
     * @param passenger passenger no tiene niguna resitrccion, sin embargo, si
     *                  el pasajero es un pasajero VIP este no puede ser removido de la lista.
     * @return retorna un valor true si es que el pasajero fue removido de forma exitosa
     *          de lo contrario retornara un false.
     */
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
    /**
     * Este metodo retorna la lista de pasajeros
     * @return
     */
    public List<Passenger> getPassengersList() {
        return Collections.unmodifiableList(passengers);
    }
}
