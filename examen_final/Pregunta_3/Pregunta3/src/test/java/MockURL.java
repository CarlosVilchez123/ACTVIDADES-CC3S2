import org.example.HttpURLConnectionFactory;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;


class MockURL extends URLConnection {

    private MockHttpURLConnection connection;

    /**
     * Constructs a URL connection to the specified URL. A connection to
     * the object referenced by the URL is not created.
     *
     * @param url the specified URL.
     */
    protected MockURL(URL url) {
        super(url);
    }


    public void setupOpenConnection(MockHttpURLConnection connection) {
        this.connection=connection;
    }

    public InputStream getInputStram(){
        return connection.getInputStream();
    }
    @Override
    public void connect() throws IOException {

    }
}
