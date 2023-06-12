package PruebasEspecificaciones;

import org.junit.jupiter.api.Test;
import static PruebaEspecificaciones.StringUtils.substringsBetween;
import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    public StringUtils EMPY_STRING_ARRAY = new StringUtils();
    @Test
    void strIsNullOrEmpty() {
        String str="";
        String open= "a";
        String close = "a";
        assertThat(EMPY_STRING_ARRAY.substringsBetween(str,open,close)).isEqualTo(null);
    }

    @Test
    void openIsNullOrEmpty() {
        // Completa
    }

    @Test
    void closeIsNullOrEmpty() {
        // Completa
    }

    @Test
    void strOfLength1() {
        // Completa
    }

    @Test
    void openAndCloseOfLength1() {
        // Completa
    }

    @Test
    void openAndCloseTagsOfDifferentSizes() {
       // Completa
    }

    @Test
    void noSubstringBetweenOpenAndCloseTags() {
        // Completa
    }

    @Test
    void closeTagAppearingMultipleTimes() {
        // Completa
    }
}
