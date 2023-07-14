# EJERCICIO 1

- Fase Antes

En esta fase solamente debemos ir escribiendo codigo sin seguir alguna metodologia.

Creamos las maquetas de las clases Fligth, Passenger y Airport. Luego implementamos la logica de negocio solicitada en esta fase. Para poder tener mejor documentado las implementaciones trabajaremos este Ejercicio escribiendo los contratos de cada implementacion.

**Clase Fligth**

Para esta clase seguimos el diagrama de clases mostrado, creamos los metodos addPassenger y removePassenger y agregamos un atributo extra el cual es **passengers**, este metodo repesentará la lista de todos los pasajeros que pertenezcan a un vuelo.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled.png)

Tambien implementamos la logica de nogocio a los metodos addPassenger y removePassenger, 

**Metodo addPassenger**

segun lo indicado, los pasajeros vip y regulares pueden estar en un vuelo economico, pero los pasajeros regulares no pueden estar en un vuelo de negocios, esto lo implementamos con el siguiente codigo.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%201.png)

**Metodo removePassenger**

De manera analoga, la logica de negocio nos dice que los psajeros vip no pueden ser removidos de nigun tipo de vuelo. A continuacion se muestra la implementacion en codigo.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%202.png)

**Clase Airport y Passenger**

La clase passenger es muy simple de entender, solamente le agregamos los atributos que un pasajero tendria e implementamos unos getter’s para poder mostrar un listado de los pasajeros y un atributos que nos ayudará para determinar si el pasajero es Vip o no y, tambien es agregado un atributo que representa el nombre del pasajero.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%203.png)

La clase Airport solamente es usada para hacerle funcion de “Test” y poder probar el codigo que hemos realizado.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%204.png)

Finalmente mostramos los resultados en la terminal.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%205.png)

- Fase 1

Antes que nada cambiamos a Jacoco para poder realizar la prueba de cobertura.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%206.png)

Entonces, para esta fase hemos empezado a trabajar siguiendo la metodologia de TDD.

Por lo que, debemos usar RGR para poder trabajar de manera eficiente los test que vayamos implementando, primero escribamos las pruebas.

Antes de escribir las pruebas creamos las instancias necesarias que nos ayudaran a escribir de manera más intuitiva las pruebas.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%207.png)

Escribimos los Test que nos van a permitir pobrar toda la logica de negocio que se nos ha solicitado implementar hasta ahora.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%208.png)

Como podemos apreciar, niguna prueba va a pasar, pues aún no hemos implementado niguna tipo de logica.

Procedemos ahora a realizar la logica negocio. Para ello usaremos lo trabajado en la fase Antes.

Sin embargo, agregamos un atributo y un metodo a la clase Flight.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%209.png)

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2010.png)

Ahora con esto ya implmentado observamos que las pruebas pasan.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2011.png)

El paso de refactorizacion se realizará en las siguientes fases; por lo que, aún no es necesario hacer la refactorizacion.

Veamos cuanto codigo han cubierto las pruebas.

**Clase Flight**

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2012.png)

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2013.png)

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2014.png)

Observamos que en el metodo addPassenger no recorre la parte de codigo en la que retorna un false o en la que retorna una excepcion, esto es debido a que no hubieron casos en las que se instanciara un vuelo con parametros que no sea “Economico” o “Negocios”.

En el caso de la prueba removePassenger, vemos que no se ha habido una gran cobertura en el codigo, esto puede ser debido al uso de la sentencia switch; ya que, esta sentencia dirige directamente al caso en concreto que tome el parametro de su condicion y genera que parte del codigo no se cubierto.

- Fase 2

Para esta fase aplicaremos primero refactorizacion, el problema que tiene el codigo original es que esta cerrado a nuevas implementaciones, si quiero crear un nuevo tipo de vuelo tengo que forsozamente implementar cada logica de negocio dentro de la misma clase y estariamos violando el principio de responsabilidad unica.

Para ello convertiremos a la clase Fligth en una clase asbtracta y crearemos clases nuevas que representaran cada tipo de vuelo.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2015.png)

Luego, hacemos que estas clases extiendan de Flight y modificamos los metodos add y remove de la clase Flight para que estos puedan ser implementados en cada clase que representa un tipo de vuelo.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2016.png)

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2017.png)

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2018.png)

Ahora, implementamos la logica de negocio en los metodos add y remove de cada una de las nuevas clases y corremos las pruebas.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2019.png)

Esta ves vemos que las pruebas han recorrido un 100% de los metodos probados

Como ya se hbia mencionado esto ayuda a que el codigo sea abierto a nuevas modificaciones, si queremos agrefar un nuevo tipo de vuelo, podemos hacerlo sin ningun problema. El codigo ha mejorado su calidad.

- Fase 3

Como se indica en esta fase primero refactorizaremos la clase AirportTest, seguiremos aplicando la metodologia del TDD.

Primero mostramos la clase refactorizado

```java
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
                        ()->assertEquals(0, premiumFlight.getPassengersList().getSize())
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
                        ()-> assertEquals(false, premiumFlight.addPassenger(carlos)),
                        ()->assertEquals(1, premiumFlight.getPassengersList().getSize()),
                        ()->assertEquals("carlos", premiumFlight.getPassengersList().get(0).getName()),
                        ()->assertEquals(true, premiumFlight.removePassenger(carlos)),
                        ()->assertEquals(0, premiumFlight.getPassengersList().getSize())
                );
            }
        }
    }
}
```

Hacemos el paso Red del RGR. implementamos los test con la nueva clase a crear.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2020.png)

Luego, implementamos la logica de negocio y pasamos las pruebas a verde

---

nota: En este caso se nos pide que cualquier tipo de pasajero sea removido inherentemente del

tipo de pasajero que sea. 

Se hicieron los cambios pertinentes al metodo removePassenger de cada subclase del codigo de producción.

---

Como vemos todas las pruebas pasan.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2021.png)

- Fase 4

En la fase 3 ya se solicito implementar la logica de negocio de la clase PrimeumFlight y se aplicaron las tecnicas del TDD, con excepecion de algunos cambios; los cuales son que niguno de los metodos addPessenger y removePessenger no hagan nada, solamente deben retornar false. Ademas que ya no es necesario probar para las condiciones del pasajero regular.

Realizamos el respectivo cambio

```java
@DisplayName("Dado un vuelo primeum")
    @Nested
    class PrimeumFlight{
        private PremiumFlight premiumFlight;
        private Passenger carlos;
        @BeforeEach
        public void init(){
            premiumFlight = new PremiumFlight("3");
            carlos = new Passenger("carlos",true); //es vip

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
```

Ahora los cambios de los metodos de PrimeumFlight.

```java
package org.example.Fase4;

public class PremiumFlight extends Flight {

    private String id;
    public PremiumFlight(String id){
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger){return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger){
        return false;
    }
}
```

Probamos el codigo y observamos que el codigo de cobertura es del 100%

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2022.png)

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2023.png)

- Fase 5

Para esta fase ya solo nos piden implementar la siguiente logica de negocio: Dos pasajeros no deben registrarse dos veces en un vuelo.

Para ello, volvemos a trabajar el TDD, primero creamos los test en rojo

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2024.png)

---

por practicidad se decidio trabajar con la subclase Economocyflight, pero las implementaciones de más adelantes se trabajaron de manera correcta.

---

Ahora, trabajamos la implementacion de que un pasajero no debe registrarse dos veces en un mismo vuelo. Cambiamos la lista de pasajeros de la clase Flight y la cambiamos por un Map.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2025.png)

Luego implementamos la logica de negocio en las subclases.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2026.png)

Todas las pruebas pasan

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2027.png)

Y observamos que el codigo de cobertura ahora es del 71% y 95% en otras clases.

![Untitled](EJERCICIO%201%20ae57f714c6cd47b8ad81c7d0b67d9545/Untitled%2028.png)

La explicacion de esto este suceso es bastante sencillo, como en el test no se ha testeado todos los tipos de vuelos en los que no se admiten un doble registro, ese trozo de codigo es el que no se ha terminado de cubrir.
