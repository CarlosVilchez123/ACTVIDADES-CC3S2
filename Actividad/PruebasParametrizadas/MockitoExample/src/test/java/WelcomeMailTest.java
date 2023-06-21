import org.example.MailServer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class WelcomeMailTest implements MailServer{
    boolean fueLlamado;
    String actualRecipiente;
    String actualTema;
    String actualTexto;
    @Override
    public void sendEmail(String recipiente, String tema,
                          String texto) {
        fueLlamado= true;
        actualRecipiente = recipiente;
        actualTema = tema;
        actualTexto = texto;
    }

}
