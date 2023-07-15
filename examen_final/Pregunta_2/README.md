# Ejercicio 2

Entonces primero nos aseguramos de importar las librerias del servidor y en poder establecer la conexion con el html.

Codigo compilado

![Untitled](Ejercicio%202%201d8ea109a7fc433987cc6cb7787047c6/Untitled.png)

Conexion HTML

![Untitled](Ejercicio%202%201d8ea109a7fc433987cc6cb7787047c6/Untitled%201.png)

Comprobamos el otro tipo de conexion cambiando el root.setResourceBase(".")

![Untitled](Ejercicio%202%201d8ea109a7fc433987cc6cb7787047c6/Untitled%202.png)

Con respecto al codigo de [Jetty.java](http://Jetty.java) podemos concluir que podemos inciar un servidor local asignandole un puerto de nuestra computadora y con eso poder comunicarnos con un archivo html.

Ahora, implementamos el metodo 

```java
private static class TestGetContentOkHandler extends AbstractHandler {
        @Override
        public void handle(String target, HttpServletRequest request,
                           HttpServletResponse response, int dispatch) throws IOException {
            OutputStream out = response.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It works");
            writer.flush();
            response.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }
```

Dentro de la clase Jetty para poder editar el  archivo html y poder visualizar “It works” en el navegador, con esto casi podriamos asegurar de que la comunicacion entre el cliente y el servidor se ha lgorado. Sin embargo, aún no podemos aseverar nada.

Ahora podemos llamar a la clase TestGetContentOkHandler mediante el siguiente metodo

```java
public class Jetty {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        Context root = new Context(server, "/");

        root.setHandler(new TestGetContentOkHandler());

        server.setStopAtShutdown(true);
        server.start();
    }
    private static class TestGetContentOkHandler extends AbstractHandler {
        @Override
        public void handle(String target, HttpServletRequest request,
                           HttpServletResponse response, int dispatch) throws IOException {
            OutputStream out = response.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It works");
            writer.flush();
            response.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }
}
```

Visualizamos “Its works” en el navegador

![Untitled](Ejercicio%202%201d8ea109a7fc433987cc6cb7787047c6/Untitled%203.png)

Ahora para la implementacion de stubs, como deseamos probar una llamada HTTP, la clase que usaremos para el stub es HttpURLConnection,

Para verificar que el mensaje “It works” es el que se esta enviando, entonces usaremos un metodo que me retorne un InputStream.

Implementacion en codigo.

```java
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
```

Para la implementacion de los stubs no supe como hacerlo