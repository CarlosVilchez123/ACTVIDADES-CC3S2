import org.example.WebClient2;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpTest2 {

    @Test
    public void testGetContentOk() throws Exception {
        MockConnectionFactory mockConnectionFactory =
                new MockConnectionFactory();
        mockConnectionFactory.setData(
                new ByteArrayInputStream("It works".getBytes()));
        WebClient2 client = new WebClient2();
        String result = client.getContent(mockConnectionFactory);
        assertEquals("It works", result);
    }
}
