import org.example.FizzBuzz;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.management.ConstructorParameters;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class test {

    /*
    aqui lo que estamos haciendo es crear una lista con todos los
    parametros que queremos testear, con la clase Arguments colocamos los parametros a probar en el lado izquierdo
    y los resultados deseados a la derecha
     */
    private static Stream<Arguments> inputsAndResults() {
        return Stream.of(
                Arguments.of(-1, "N/A"),
                Arguments.of(0, "N/A"),
                Arguments.of(1001, "N/A"),
                Arguments.of(1, "1"),
                Arguments.of(2, "2"),
                Arguments.of(3, "Fizz"),
                Arguments.of(4, "4"),
                Arguments.of(5, "Buzz"),
                Arguments.of(6, "Fizz"),
                Arguments.of(10, "Buzz"),
                Arguments.of(15, "FizzBuzz"),
                Arguments.of(30, "FizzBuzz"),
                Arguments.of(33, "Fizz"),
                Arguments.of(45, "FizzBuzz")
        );
    }

    /*
    Luego usamos la etiqueta MethodSource(), el parametro de entrada que usa esta etiqueta debe ser un String
    con el mismo nombre que la lista de stream que creamos anteriormente
     */
    @ParameterizedTest
    @MethodSource("inputsAndResults")
    public void convert(int input, String expectedResult) {
        var sut = new FizzBuzz();
        assertEquals(expectedResult, sut.convert(input));
    }

    /*
    Todos los test que estan abajo de este comentario, cumplen la misma funcion que el test de arriba, es lo mismo.
    la diferencia radica en que usando una lista de stream, nos evitamos el estar copiando codigo.

     */
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 1001})
    public void convert_invalidInputResultsInNonApplicableResponse(int input) {

        var sut = new FizzBuzz();

        assertEquals("N/A", sut.convert(input));

    }

    @ParameterizedTest

    @ValueSource(ints = {3, 6, 9, 12, 33, 36, 39, 42})

    public void convert_multiplesOfThreeResultsInFizz(int input) {

        var sut = new FizzBuzz();

        assertEquals("Fizz", sut.convert(input));

    }

    @ParameterizedTest

    @ValueSource(ints = {5, 10, 20, 25, 35, 40, 50 })

    public void convert_multiplesOfFiveResultsInBuzz(int input) {

        var sut = new FizzBuzz();

        assertEquals("Buzz", sut.convert(input));

    }

    @ParameterizedTest

    @ValueSource(ints = {15, 30, 45, 60, 75, 90 })

    public void convert_multiplesOfFifteenResultsInBuzz(int input) {

        var sut = new FizzBuzz();

        assertEquals("FizzBuzz", sut.convert(input));

    }

    @ParameterizedTest

    @ValueSource(ints = {1, 2, 4, 7, 8, 11, 13, 14})

    public void convert_otherNumbersResultInTheNumbersThemselves(int input) {

        var sut = new FizzBuzz();

        assertEquals(Integer.toString(input), sut.convert(input));

    }
}

