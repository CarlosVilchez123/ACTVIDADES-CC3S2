import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.print.DocFlavor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;

    public class MockHttpURLConnection extends HttpURLConnection {


        private InputStream inputStream;
        protected MockHttpURLConnection(URL u) {
            super(u);
        }

        public void setupGetInputStream(InputStream inputStream){ this.inputStream=inputStream;}

        public InputStream getInputStream(){return this.inputStream;}


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
