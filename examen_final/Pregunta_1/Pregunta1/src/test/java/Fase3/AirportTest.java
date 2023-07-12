package Fase3;

import org.example.Fase3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class AirportTest {
    @DisplayName("Hay un vuelo economico")
    @Nested
    class EconomyFlightTest {

        private Fligth ecnomico;
        private Passenger arturo;
        private Passenger canales;

        @BeforeEach
        void setUp() {
            ecnomico = new ecnomoyFlight("1");
            arturo = new Passenger("arturo", false);
            canales = new Passenger("canales", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Luego puede agregarlo y eliminarlo de un vuelo economico")
            public void testEconomyFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo economico",
                        () -> assertEquals("1", ecnomico.getCodigo()),
                        () -> assertEquals(true, ecnomico.addPassenger(arturo)),
                        () -> assertEquals(1, ecnomico.getPassengersList().size()),
                        () -> assertEquals("arturo", ecnomico.getPassengersList().get(0).getName()),
                        () -> assertEquals(true, ecnomico.removePassenger(arturo)),
                        () -> assertEquals(0, ecnomico.getPassengersList().size())
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
                        () -> assertEquals("1", ecnomico.getCodigo()),
                        () -> assertEquals(true, ecnomico.addPassenger(canales)),
                        () -> assertEquals(1, ecnomico.getPassengersList().size()),
                        () -> assertEquals("canales", ecnomico.getPassengersList().get(0).getName()),
                        () -> assertEquals(false, ecnomico.removePassenger(canales)),
                        () -> assertEquals(1, ecnomico.getPassengersList().size())
                );

            }
        }
    }
}
