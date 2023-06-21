import org.example.CountClumps;
import org.junit.jupiter.api.Test;

import java.sql.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountClumpsTest {
    // Para estas pruebas solamente usaremos pruebas de especificacion, no nos apoyaremos de las pruebas parametrizadas
    private CountClumps countClumps = new CountClumps();
    //T1
    @Test
    void testSizeMayorQue0(){
        int[] array = {1,2,2,3,4,4};
        int result = countClumps.countClumps(array,0);
        assertEquals(0,result);
    }

    //T2
    @Test
    void testArrayNull(){
        int[] array = {};
        int result = countClumps.countClumps(array,0);
        assertEquals(0,result);
    }

    //T3
    @Test
    void testCuentaClumps(){
        int[] array = {1,2,2,3,4,4};
        int result = countClumps.countClumps(array,6);
        assertEquals(2,result);
    }

    //T4 prueba limite, tamaño cercano a 0
    @Test
    void testNoHayClumps(){
        int[] array = {1};
        int result = countClumps.countClumps(array,1);
        assertEquals(0,result);
    }

    //PRUEBA DEL COMPORTAMIENTO DEL FLUJO DE RAMAS.

    @Test
    void test1(){
        int[] array = {2,2,1,3,4,5,6,7};
        int result = countClumps.countClumps(array,8);
        assertEquals(1,result);
    }

    @Test
    void test2(){
        int[] array = {2,1,3,4,5,6,7,7};
        int result = countClumps.countClumps(array,8);
        assertEquals(1,result);
    }

    @Test
    void test3(){
        int[] array = {2,1,3,4,4,6,7,2};
        int result = countClumps.countClumps(array,8);
        assertEquals(1,result);
    }

    @Test
    void testArrayTodosIguales(){
        int[] array = {1,1,1,1};
        int result = countClumps.countClumps(array,4);
        assertEquals(1,result);
    }

}
