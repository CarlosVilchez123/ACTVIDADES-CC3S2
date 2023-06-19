package PruebasEspecificaciones;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Estas pruebas son realizados en la fase de exploracion (paso 2)
 */
public class StringUtilsExplorationTest {

    @Test
    void simpleCase() {
        assertThat(
                StringUtils.substringsBetween("abcd", "a", "d")
        ).isEqualTo(new String[] { "bc" });
    }

    @Test
    void manySubstrings() {
        assertThat(
                StringUtils.substringsBetween("abcdabcdad", "a", "d")
        ).isEqualTo(new String[] { "bc","bc"});
    }

    @Test
    void openAndCloseTagsThatAreLongerThan1Char() {
        assertThat(
                StringUtils.substringsBetween("aabcddaabfddaab", "aa", "dd")
        ).isEqualTo(new String[] { "bc","bf"});
    }

}
