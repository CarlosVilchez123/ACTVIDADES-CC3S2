# Pregunta 2

- Lo que estamos haciendo en el SUT es establecer un stub de prueba.
En la clase WordSeleccion se implemento el metodo SeleccionRandom que retorna un mensaje
dependiendo el numero aleatorio que sea ingresado como parametro.
En el Test, se utiliza mockito para que asi, podamos trabajar el stub de
mejor manera, usamos el metodo when para poder simular un repositorio de mesajes.

- El paso arrange corresponde a "var WordRandom = new WordSeleccion(repository)".
El paso act corresponde a "String actual = WordRandom.SeleccionRandom()".
El paso assert "assertThat(actual).isEqualTo("La palabra random es: hola FC")".

- El codigo de prueba pasa, pero depende el numero random que retorne el metodo SelectionRandom de
la clase WordSeleccion. Solamente se tiene que forzar el resutado del numero random.

- En este caso el codigo de cobertura abarca toda la clase WordSeleccion y WordRepository.

- Bueno, en comparacion a lo que se hizo en la actividad TDD2, Y TDD3, esta vez estamos randomizando la obtencion de un mensaje
aleatorio. En el caso de la aplicacion original estabamos adivinando una palabra con word, pero utilizando un score
de tal manera que ayude a la verificacion del adivinanza en guess.

