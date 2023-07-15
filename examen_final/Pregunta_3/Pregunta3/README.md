# EJERCICIO 3

- Inciso 1

Implementamos los mock solicitados, solamente agregando los metodos que requieren para que la prueba aparentemente pase.

Ambos mocks deben heredar de las clases padre URLConnection (la clase URL no funcionaba con la herencia) y de MockHttpURLConnection.

De esta forma garantizamos poder utilizar caracteristicas de la clases padre.

```java
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
```

Asi como se presenta el codigo la prueba no pasara; esto puede ser debido a una mal uso de la clase URLConnection, por falta de practica manejando esta libreria resulta algo engorroso trabajar con esta clase.

Test

package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebClient1 {
public String getContent(URL url) {
StringBuffer content = new StringBuffer();
try {
HttpURLConnection connection = obtenerHttp(url);
connection.setDoInput(true);
InputStream is = connection.getInputStream();
byte[] buffer = new byte[2048];
int count;
while (-1 != (count = is.read(buffer))) {
content.append(new String(buffer, 0, count));
}
} catch (IOException e) {
throw new RuntimeException(e);
}
return content.toString();
}

```
public HttpURLConnection obtenerHttp(URL url) throws IOException {
    return (HttpURLConnection) url.openConnection();
}

```

}

```java
public class HtppTest {
    @Test
    public void testGetContentOk() throws Exception{
        URL url = new URL("http://www.baeldung.com");

        MockHttpURLConnection mockConnection = new MockHttpURLConnection(url);
        mockConnection.setupGetInputStream( new ByteArrayInputStream("It works".getBytes()));

        MockURL mockURL = new MockURL(url);
        mockURL.setupOpenConnection(mockConnection);

        WebClient client = new WebClient();
        String workingContent = client.getContent(mockURL.getURL());
        assertEquals("It works", workingContent);
    }
}
```

- Inciso 2

Procedemos a refactorizar y a crear una clase nueva,

Esta parte del codigo “(HttpURLConnection) url.openConnection();” me indica que que esta leyendo la coneccion asociada al URL. Entonces, esto se separá en un metodo a parte

```java
public HttpURLConnection obtenerHttp(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
```

Luego lo acoplamos en el metodo getContent

```java
ppackage org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebClient1 {
    public String getContent(URL url) {
        StringBuffer content = new StringBuffer();
        try {
            HttpURLConnection connection = obtenerHttp(url);
            connection.setDoInput(true);
            InputStream is = connection.getInputStream();
            byte[] buffer = new byte[2048];
            int count;
            while (-1 != (count = is.read(buffer))) {
                content.append(new String(buffer, 0, count));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    public HttpURLConnection obtenerHttp(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
}
```

- Inciso 3

Para este inciso procedemos a hacer la refactorizacion de lo solicitado.

Para aprovechar la interfaz que se esta creando, se esta colocando como parametro de firma para el metodo getClient. 

El metodo getClient queda de la siguiente forma

```java
package org.example;

import java.io.IOException;
import java.io.InputStream;

public class WebClient2 {
    public String getContent(ConnectionFactory connectionFactory){
        StringBuffer content = new StringBuffer();
        try{
            InputStream is = connectionFactory.getData();

            byte[] buffer = new byte[2048];
            int count;
            while (-1 != (count = is.read(buffer))) {
                content.append(new String(buffer, 0, count));
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }
}
```

El metodo refactorizado lo colocamos en una clase nuevo llamado WebClient2.

Diferencias que podemos notar con el codigo anterior es que aprovecha el uso de una interfaz, esto nos da mayor felixibilidad al momento de querer agregar o implementar alguna nueva funcionalidad.

- Inciso 4

Trabajar con interfacez y mocks es más simple porque nos evitamos el engorroso trabajo de importar los metodos y los atributos de las clases padre, entonces creamos la clase HttpURLConnectionFactory e implementamos la interfaz, luego simplemente le agregamos la logica al metodo de la interfaz.

```java
public class HttpURLConnectionFactory implements ConnectionFactory{
    private URL url;

    public HttpURLConnectionFactory(URL url) {
        this.url = url;
    }
    public InputStream getData() throws Exception {
        HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
        return connection.getInputStream();
    }
}
```

- Inciso 5

Reescribimos la prueba, para ello creamos otra clase de test llamada htttp2. Creamos el Mock de prueba.

```java
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
```

Ejecutamos el test y observamos que ahora si pasa con normalidad la prueba

![Untitled](EJERCICIO%202%204750248b50ad46c5bc9b108fb5105974/Untitled.png)

- Inciso 6

Luego nos piden crear algunos metodos como el HttpURLConnectionFactory o el nuevo test HttpTest3 En el cual verificaremos la expectativa del Mock.

Entonces, veamos creemos el test y ejecutamos.

```java
import org.example.WebClient2;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class httptes3 {
    @Test
    public void testGetContentOk() throws Exception {
        MockConnectionFactory mockConnectionFactory =
                new MockConnectionFactory();
        MockInputStream mockStream = new MockInputStream();
        mockStream.setBuffer("It works");
        mockConnectionFactory.setData(mockStream);
        WebClient2 client = new WebClient2();
        String result = client.getContent(mockConnectionFactory);
        assertEquals("It works", result);
        mockStream.verify();
    }
}
```

Observamos que el test no pasa

![Untitled](EJERCICIO%202%204750248b50ad46c5bc9b108fb5105974/Untitled%201.png)

Y es que podemos deducir gracias a veify que el mock no esta siendo llamado por los metodos que lo usan, este mismo error se puede encontrar En el inciso 1.
