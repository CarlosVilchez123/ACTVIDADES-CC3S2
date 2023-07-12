package Fase2;

import org.example.Fase2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {
    bussinnesFligght negocio;
    ecnomoyFlight economico;

    premiumFlight primeum;

    Passenger arturo;
    Passenger canales;
    Passenger carlos;

    @BeforeEach
    void initVuelos(){
        negocio=new bussinnesFligght("1");
        economico = new ecnomoyFlight("2");
        primeum = new premiumFlight("3");

    }

    @BeforeEach
    void initPasajeros(){
        arturo=new Passenger("arturo",false);
        canales = new Passenger("canales",false);
        carlos = new Passenger("carlos",true);

    }

    @Test
    void testPasajerosEcnomicos(){

        assertAll("Verifico las condiciones de los vuelos de los pasajeros regulares",
                ()-> assertEquals("2",economico.getCodigo()),
                ()-> assertEquals(true, economico.addPassenger(arturo) ),
                ()-> assertEquals("arturo",economico.getPassengersList().get(0).getName()),
                ()-> assertEquals(false,economico.getPassengersList().get(0).isVip()));


    }

    @Test
    void testPasajerosNegocio(){
        assertEquals("1",negocio.getCodigo());
        assertEquals(true, negocio.addPassenger(canales));
        assertEquals("canales",negocio.getPassengersList().get(0).getName());
        assertEquals(false,negocio.getPassengersList().get(0).isVip());
    }

    @Test
    void testPasajerosPremium(){

        assertAll("Verifico las condiciones de los vuelos de los pasajeros regulares",
                ()-> assertEquals("3",primeum.getCodigo()),
                ()-> assertEquals(true, primeum.addPassenger(carlos) ),
                ()-> assertEquals("carlos",primeum.getPassengersList().get(0).getName()),
                ()-> assertEquals(true,primeum.getPassengersList().get(0).isVip()));
    }
}
