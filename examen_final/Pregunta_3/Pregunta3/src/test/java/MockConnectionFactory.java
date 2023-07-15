import org.example.ConnectionFactory;

import java.io.InputStream;

public class MockConnectionFactory implements ConnectionFactory {

    private InputStream inputStream;

    public void setData(InputStream inputStream){
        this.inputStream=inputStream;
    }
    public InputStream getData(){
        return this.inputStream;
    }
}
