# APUNTES DE ACTVIDAD

- Problema: Indica los problemas que puedan ocurrir debido al entorno.

```
Un problema que se me ocurre que puede haber son errores al momento de hacer las llamadas a la base de datos del sistema
o fallos al llamar a una API.

Fallos al momento de que el cliente no pueda comunicarse con el servidor

El codigo no se ejecute bien, generando problemas con la comunicacion de la base de datos.

Cada uno de las tareas que hace el codigo estan muy juntas, si una genera algun problema, generará que las otras caiga.
```

- Problema: Enuncia algunos desafios que se presentan en este caso.

```
Los problemas que ocurrir utilizando software de terceros, y siendo más especificos, usando sofwtare financiero
es que al momento de el ususario realice el pago de algun producto, dicho pago no sea registrado o que la transaccion
no se concrete,
```

Explica lo que hace en el código siguiente:

```java
@Test 
    void selectsWordAtRandom() { 
        when(repository.highestWordNumber()) 
            .thenReturn(HIGHEST_WORD_NUMBER); 
when(repository.fetchWordByNumber(WORD_NUMBER_SHINE)) 
            .thenReturn("SHINE"); 
        when(random.next(HIGHEST_WORD_NUMBER)) 
            .thenReturn(WORD_NUMBER_SHINE); 
        var selector = new WordSelection(repository, 
                                         random); 
        String actual = selector.chooseRandomWord(); 
        assertThat(actual).isEqualTo("SHINE"); 
    } 
}
```
**Explicacion**
```
lo que estamos haciendo el en el test es usar un doble de prueba al que estamos forzando tener el valor del HIGHEST_WORD_NUMBER cuando usa se llama al metodo highestWordNumber().

LO mismo hacemos con el metodo fetchWordByNumber() y el metodo next();

Luego, realizamos el paso arrange, en el que instanciamos un objeto selector de la clase WordSelection, en el paso act, declaramos un string que se llame actual el cual devolvera
un valor aleatorio del metodo chooseRandomWord().

Por ultimo, solo aseveramos que el valor de actual, solo concuerde con "SHINE".
```

Explica el funcionamiento de la clase WordSelection, de WordRepository, de NumerosAleatorios y el método chooseRandomWord() y de los siguientes códigos:
```
Tenemos las dos interfaces WordRepository y NumerosAleatorios, WordRepository solamente me permitira poder declara 
el puerto por el cual se conectara a la base de datos de palabras, usando el metodo fetchWordByNumber() el cual buscara
una palabra de acuerdo al numero (recordar que los puertos deben tener una interfaz y OBjetos de valor).
NumerosAleatorios, solamente me permitira poder retornar un numero aleatorio.

chooseRandomWord() este metodo solo retornara un numero aleatorio dependiendo el resultado de highestWordNumber()
```
