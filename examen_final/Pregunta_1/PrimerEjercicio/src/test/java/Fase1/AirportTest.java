package Fase1;

import org.example.Fase1.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AirportTest {
    Flight economyFlight = new Flight("1","Economico");
    Flight businessFlight = new Flight("2","Negocios");

    //pasajero regular
    Passenger arturo = new Passenger("arturo", false);
    //pasajero de negocios
    Passenger carlos = new Passenger("carlos",true);
    @Test
    public void testVueloEconomico(){
                assertEquals("1", economyFlight.getId());
                assertEquals(true, economyFlight.addPassenger(arturo));
                assertEquals(1, economyFlight.getPassengersList().size());
                assertEquals("arturo", economyFlight.getPassengersList().get(0).getName());
                assertEquals(true, economyFlight.removePassenger(arturo));
                assertEquals(0, economyFlight.getPassengersList().size());

                assertEquals("1", economyFlight.getId());
                assertEquals(true, economyFlight.addPassenger(carlos));
                assertEquals(1, economyFlight.getPassengersList().size());
                assertEquals("carlos", economyFlight.getPassengersList().get(0).getName());
                assertEquals(false, economyFlight.removePassenger(carlos));
                assertEquals(1, economyFlight.getPassengersList().size());

    }

    @Test
    public void testVueloNegocios(){

                assertEquals(false, businessFlight.addPassenger(arturo));
                assertEquals(0, businessFlight.getPassengersList().size());
                assertEquals(false, businessFlight.removePassenger(arturo));
                assertEquals(0, businessFlight.getPassengersList().size());

                assertEquals(true, businessFlight.addPassenger(carlos));
                assertEquals(1, businessFlight.getPassengersList().size());
                assertEquals(false, businessFlight.removePassenger(carlos));
                assertEquals(1, businessFlight.getPassengersList().size());

    }
}
