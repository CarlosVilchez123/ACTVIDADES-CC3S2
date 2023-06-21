import org.example.WordRepository;
import org.example.WordSeleccion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WordSelectionTest {

    @Mock
    private WordRepository repository;

    @Test
    void reportsWordNotFound(){
        //creamos el repositorio
        when(repository.fetchWordByNumber(1)).thenReturn("hola FC");
        var WordRandom = new WordSeleccion(repository);

        String actual = WordRandom.SeleccionRandom();

        assertThat(actual).isEqualTo("La palabra random es: hola FC");


        //Nota: no entiendo como usar las excepciones que se muestran en el esqueleto, use los metodos vistos en la actividad de mockito
        //doThrow(new Exception()).when(repository).fetchWordByNumber(anyInt());
        //assertThatExceptionOfType(WordSelectionException.class).isThrownBy(  );
    }
}
