package Fase3;
import org.example.Fase3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest3 {
    @DisplayName("Hay un vuelo economico")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger carlos;

        private Passenger arturo;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            carlos = new Passenger("carlos",true); //es vip
            arturo = new Passenger("arturo", false);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Luego puede agregarlo y eliminarlo de un vuelo economico")
            public void testEconomyFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(arturo)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("arturo", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(arturo)),
                        () -> assertEquals(0, economyFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {
            @Test
            @DisplayName("Luego puedes agregarlo pero no puedes eliminarlo de un vuelo economico")
            public void testEconomyFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(carlos)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("carlos", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(false, economyFlight.removePassenger(carlos)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size())
                );

            }
        }
    }

    @DisplayName("Dado que hay un vuelo de negocios")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger carlos;

        private Passenger arturo;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            carlos = new Passenger("carlos",true); //es vip
            arturo = new Passenger("arturo", false);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Entonces no puedes agregarlo o eliminarlo de un vuelo de negocios")
            public void testBusinessFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo de negocios",
                        () -> assertEquals(false, businessFlight.addPassenger(arturo)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(arturo)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {

            @Test
            @DisplayName("Luego puedes agregarlo pero no puede eliminarlo de un vuelo de negocios")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo de negocios",
                        () -> assertEquals(true, businessFlight.addPassenger(carlos)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(carlos)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size())
                );
            }
        }
    }


    @DisplayName("Dado un vuelo primeum")
    @Nested
    class PrimeumFlight{
        private PremiumFlight premiumFlight;
        private Passenger carlos;

        private Passenger arturo;

        @BeforeEach
        public void init(){
            premiumFlight = new PremiumFlight("3");
            carlos = new Passenger("carlos",true); //es vip
            arturo = new Passenger("arturo", false);

        }
        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class regularPassenger{
            @Test
            @DisplayName("Un pasajero regular no puede registrarse sa un vuelo Primeum")
            public void testPreimeumFLightRegularPassenger(){
                assertAll("Verfica todas las condiciones para un pasajero Regular",
                        ()-> assertEquals(false, premiumFlight.addPassenger(arturo)),
                        ()->assertEquals(0, premiumFlight.getPassengersList().size())
                        );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero Vip")
        class vipPassenger{
            @Test
            @DisplayName("Un pasajero Vip puede registrarse sa un vuelo Primeum")
            public void testPreimeumFLightRegularPassenger(){
                assertAll("Verfica todas las condiciones para un pasajero Regular",
                        ()-> assertEquals(true, premiumFlight.addPassenger(carlos)),
                        ()->assertEquals(1, premiumFlight.getPassengersList().size()),
                        ()->assertEquals("carlos", premiumFlight.getPassengersList().get(0).getName()),
                        ()->assertEquals(true, premiumFlight.removePassenger(carlos)),
                        ()->assertEquals(0, premiumFlight.getPassengersList().size())
                );
            }
        }
    }
}
