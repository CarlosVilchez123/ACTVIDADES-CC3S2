package org.example.Antes;

public class Airport {
    public static void main(String[] args) {
        Flight economyFlight = new Flight("Economico");
        Flight businessFlight = new Flight("Negocios");

        Passenger checha = new Passenger("Checha", true);
        Passenger lore = new Passenger("Lore", false);


        businessFlight.addPassenger(checha);
        businessFlight.removePassenger(checha);
        businessFlight.addPassenger(lore);
        economyFlight.addPassenger(lore);

        System.out.println(" Lista de pasajeros de vuelos de negocios:");
        for (Passenger passenger : businessFlight.getPassengersList()) {
            System.out.println(passenger.getName());
        }

        System.out.println(" Lista de pasajeros de vuelos economicos:");
        for (Passenger passenger : economyFlight.getPassengersList()) {
            System.out.println(passenger.getName());
        }

    }
}
