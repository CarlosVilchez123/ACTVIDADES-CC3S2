package Fase2;
import org.example.Fase2.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest2 {
     EconomyFlight economyFlight = new EconomyFlight("1");
    BusinessFlight businessFlight = new BusinessFlight("2");

    //pasajero regular
    Passenger arturo = new Passenger("arturo", false);
    //pasajero de negocios
    Passenger carlos = new Passenger("carlos",true);
    @Test
    public void testVueloEconomico(){
        assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo economico",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(arturo)),
                () -> assertEquals(1, economyFlight.getPassengersList().size()),
                () -> assertEquals("arturo", economyFlight.getPassengersList().get(0).getName()),
                () -> assertEquals(true, economyFlight.removePassenger(arturo)),
                () -> assertEquals(0, economyFlight.getPassengersList().size())
        );

        assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo economico",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(carlos)),
                () -> assertEquals(1, economyFlight.getPassengersList().size()),
                () -> assertEquals("carlos", economyFlight.getPassengersList().get(0).getName()),
                () -> assertEquals(false, economyFlight.removePassenger(carlos)),
                () -> assertEquals(1, economyFlight.getPassengersList().size())
        );
    }

    @Test
    public void testVueloNegocios(){
        assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo de negocios",
                () -> assertEquals(false, businessFlight.addPassenger(arturo)),
                () -> assertEquals(0, businessFlight.getPassengersList().size()),
                () -> assertEquals(false, businessFlight.removePassenger(arturo)),
                () -> assertEquals(0, businessFlight.getPassengersList().size())
        );
        assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo de negocios",
                () -> assertEquals(true, businessFlight.addPassenger(carlos)),
                () -> assertEquals(1, businessFlight.getPassengersList().size()),
                () -> assertEquals(false, businessFlight.removePassenger(carlos)),
                () -> assertEquals(1, businessFlight.getPassengersList().size())
        );
    }
}
