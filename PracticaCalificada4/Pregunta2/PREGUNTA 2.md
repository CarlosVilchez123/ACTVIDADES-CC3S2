# Pregunta 2

- Lo que estamos haciendo en el SUT es establecer un stub de prueba.
En la clase WordSeleccion se implemento un metodo que retorna un mensaje
dependiendo el numero aleatorio que sea ingresado como parametro.
En el Test, se utiliza mockito para que asi, podamos trabajar el stub de
mejor manera, usamos el metodo when para poder simular un repositorio de mesajes.

- El paso arrange corresponde a "var WordRandom = new WordSeleccion(repository)".
El paso act corresponde a "String actual = WordRandom.SeleccionRandom()".
El paso assert "assertThat(actual).isEqualTo("La palabra random es: hola FC")".

- El codigo de prueba pasa, pero depende el numero random que retorne el metodo SelectionRandom de
la clase WordSeleccion. Solamente se tiene que forzar el resutado del numero random.

- En este caso el codigo de cobertura abarca toda la clase WordSeleccion y WordRepository.

- 