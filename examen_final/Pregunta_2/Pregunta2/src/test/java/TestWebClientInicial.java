import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

import org.example.WebClient;
import org.junit.jupiter.api.*;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestWebClientInicial {

    @BeforeAll
    public static void setUp() {
    }
    @AfterAll
    public static void tearDown() {
        // Se detiene Jetty.
    }
    private class StubStreamHandlerFactory implements URLStreamHandlerFactory {
        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            return new StubHttpURLStreamHandler();
        }
    }
    private class StubHttpURLStreamHandler extends URLStreamHandler {
        @Override
        protected URLConnection openConnection(URL url)
                throws IOException {
            return new StubHttpURLConnection(url);
        }
    }
    @Test
    public void testGetContentOk() throws MalformedURLException {

        URL url = new URL("http://localhost:8081/testGetContentOk");

        StubHttpURLStreamHandler streamHandler = new StubHttpURLStreamHandler();
        StubStreamHandlerFactory streamHandlerFactory = new StubStreamHandlerFactory();

        
        WebClient client = new WebClient();
        String workingContent = client.getContent(url);
        assertEquals("Esto trabaja", workingContent);
    }

    public class StubHttpURLConnection extends HttpURLConnection {

        protected StubHttpURLConnection(URL u) {
            super(u);
        }
        public InputStream getInputStream() throws IOException {
            ByteArrayInputStream message = new ByteArrayInputStream(new String("It works").getBytes());
            return message;
        }
        @Override
        public void disconnect() {

        }
        @Override
        public boolean usingProxy() {
            return false;
        }
        @Override
        public void connect() throws IOException {

        }
    }
}
