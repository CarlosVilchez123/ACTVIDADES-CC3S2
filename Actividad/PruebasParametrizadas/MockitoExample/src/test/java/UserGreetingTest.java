import org.example.UserGreeting;
import org.example.UserId;
import org.example.UserProfiles;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserGreetingTest {
    /*
    Hemos creado primero un stubs, luego un mock
     */
    //private static final UserId USER_ID = new UserId("1234");

    @Mock
    private UserProfiles profil;
    @Test
    void formatsGreetingWithName() {
        //any indica a mockito que el metodo fethcNicName devuelva el valor esperado kapumota sin importar
        //que parametro se se pase al metodo
        when(profil.fetchNicknameFor(any())).thenReturn("Kapumota");
        var greeting = new UserGreeting(profil);
        String actual = greeting.formatGreeting(new UserId(""));
        assertThat(actual).isEqualTo("Hola y bienvenido, Kapumota");
        /*
        when(profil.fetchNicknameFor(USER_ID)).thenReturn("Kapumota");
        var greeting = new UserGreeting(profil);
        String actual = greeting.formatGreeting(USER_ID);
        assertThat(actual)
                .isEqualTo("Hola y bienvenido, Kapumota");

         */
    }
}
