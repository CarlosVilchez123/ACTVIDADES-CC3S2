# Inciso 1
- Como la pregunta menciona, solamente se esta lanzando codigo sin
pensar en nigun pre-requisito o post-requisito. El resultado es el siguiente:

```java
public class CountClumps {
    private int N;
    private int[] nums;

    public CountClumps(int[] nums, int size) {
        this.nums = nums;
        this.N = size;
    }

    public int countClumps(int[] nums) {
        int aux;
        int count_clumps = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            aux = nums[i];
            for (int j = i; j < N; i++) {
                assert nums[j] == aux : count_clumps++;
            }
            assert count_clumps > 1 : result++;
        }

        return result;
    }
}
```

# Inciso 2
- Para la pregunta dos, ya requerimos de de finir nuestras pre y post condiciones.
Para ello nos ayudamos de la explicacion del problema que se menciona al inicio,
- Primero, el array que se vaya a ingresar debe ser no nulo. Segundo, debe tener un tamaño
mayor que 0. Escribimos nuestras pre-condiciones con el formato javadoc.
```java
public class CountClumps {

    /**
     * El metodo lo que hace es contar el numero de clumps que hay en un array.
     *
     * @param nums Es el array donde se efectuara el conteo de clumps, este array debe ser no nulo
     * @param size Es el tamaño del array, el tamaño del array debe ser mayor que 0
     * @return El metodo retorna el conteo de clumps
     */
    public int countClumps(int[] nums, int size){
        if(nums==null) return 0; //T1
        if(size<0) return 0; //T2

        int aux;
        int count_clumps=0;
        int result=0;
        //T3
        for(int i=0; i<size;i++){
            aux=nums[i];
            for(int j=i; j<size;j++) {
                if(nums[j]==aux){
                    count_clumps++;
                }
            }
            if(count_clumps>1){
                result++;
            }
            count_clumps=0;
        }

        return result;
    }
}

```

Luego realizamos los test de acuerdo a las pre y post Condiciones establecidas

```java
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

}
```
# Inciso 3
Todo el codigo de cobertura se encuentra en el archivo HTMLreport
# Inciso 4

Para este inciso se requiere experimentar un poco con los clumps y explicar su
comportamiento dentro de las ramas del programa.

- Probemos con un clump, al inicio

- Probemos con un clump al final

- Probemos con un clump en el medio

- Todos los valores del array son iguales

en los tres casos anteriores el programa logra recorrer todas las ramas
posibles. Mientras que en el caso de todos los valores del array son iguales
solo llega a recorrer un 71% del codigo.

La explicacion de esto es simple, debido a la logica implementada
el array para determinar cuantos clumps en total hay, debe recorrer
los dos bucles for en su totalidad, mientras que en el ultimo caso, esto
ya no es necesario, pues en un primer barrido de datos del array, ya se determina
que todos los valore sdel array son necesarios.