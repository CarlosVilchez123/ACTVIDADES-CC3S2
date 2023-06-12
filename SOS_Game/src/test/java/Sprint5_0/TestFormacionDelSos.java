package Sprint5_0;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFormacionDelSos {
    Tablero tablero;
    @Before
    public void initTablero()
    {
        tablero = new Tablero(3,3);
    }

    @Test
    public void FormacionDelSosSimpleGanadorAzul()
    {
        tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,0);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(0,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,2);

        assertEquals("",tablero.getEstadoActual(), Tablero.EstadoDeJuego.AZUL_GANA);

        new GUI_SOS(tablero);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void FormacionDelSosJuegoSimpleRojo()
    {
        tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,0);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(0,1);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,2);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,2);

        assertEquals("",tablero.getEstadoActual(), Tablero.EstadoDeJuego.ROJO_GANA);

        new GUI_SOS(tablero);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void FormacionDelSosJuegoGeneralAzul()
    {
        tablero.setModo(Tablero.ModoDeJuego.GENERAL);
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,0);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(0,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,2);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,2);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,2);


        assertEquals("",tablero.getEstadoActual(), Tablero.EstadoDeJuego.AZUL_GANA);

        new GUI_SOS(tablero);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FormacionDelSosJuegoGeneralRojo()
    {
        tablero.setModo(Tablero.ModoDeJuego.GENERAL);
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,0);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(0,1);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,1);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(0,2);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,2);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,1);

        tablero.setSeleccion('o');
        tablero.RealizarMovimiento(2,2);

        assertEquals("",tablero.getEstadoActual(), Tablero.EstadoDeJuego.ROJO_GANA);

        new GUI_SOS(tablero);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void FormacionDeSosEmpate()
    {
        tablero.setModo(Tablero.ModoDeJuego.GENERAL);
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,0);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(0,1);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,1);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(2,2);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,2);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,1);

        tablero.setSeleccion('o');
        tablero.RealizarMovimiento(1,2);

        assertEquals("",tablero.getEstadoActual(), Tablero.EstadoDeJuego.EMPATE);

        new GUI_SOS(tablero);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCPUSimpleAzul()
    {
        CPU_GAME cpu = new CPU_GAME(3,3,'R');
        cpu.setModo(Tablero.ModoDeJuego.SIMPLE);
        cpu.setSeleccion('S');
        cpu.RealizarMovimiento(0,0);

        cpu.setSeleccion('O');
        cpu.RealizarMovimiento(0,1);

        cpu.setSeleccion('S');
        cpu.RealizarMovimiento(0,2);


        new GUI_SOS(cpu);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
