package Fase1;

import org.example.Fase1.Fligth;
import org.example.Fase1.Passenger;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class AirportTest {
    Fligth economico;
    Fligth negocio;
    Passenger arturo;
    Passenger carlos;
    @BeforeEach
    public void economicosPasajeros(){
        economico = new Fligth("economico","1");
        arturo = new Passenger("arturo", false);
    }
    @BeforeEach
    public void negocioPasajeros(){
        negocio = new Fligth("negocio","2");
        carlos = new Passenger("carlos", true);
    }
    @Test
    void vueloEconomicoPasajeroRegular(){

        assertAll("Verifico las condiciones de los vuelos de los pasajeros regulares",
                ()->assertEquals("1",economico.getCodigo()),
                ()->assertEquals(true, economico.addPassenger(arturo) ),
                ()->assertEquals("arturo",economico.getPassengersList().get(0).getName()),
                ()->assertEquals(false,economico.getPassengersList().get(0).isVip()));
    }

    @Test
    void vueloVipPasajeroRegular(){

        assertAll("Verifico las condiciones de los vuelos de los pasajeros regulares",
                ()->assertEquals("2",negocio.getCodigo()),
                ()->assertEquals(true, negocio.addPassenger(carlos) ),
                ()->assertEquals("carlos",negocio.getPassengersList().get(0).getName()),
                ()->assertEquals(true,negocio.getPassengersList().get(0).isVip()));
    }

}
