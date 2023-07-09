# DESARROLLO DE SOFTWARE

**Arquitectura hexagonal:** es un tipo de arquitectura que usa puertos y adaptadores

![Untitled](DESARROLLO%20DE%20SOFTWARE%20cd9b056c14be44b58c662fb0318f0bab/Untitled.png)

Los conceptos necesarios para entender la arquitectura hexagonal es que es engloba y separa todos los modulo e implementaciones de una aplicacion.

- El dominio contiene la logica de aplciacion, libre de detalles de sistemas externos. Se trata de
    
    todas las funcionalidades que requiere el usuario.
    
- Los puertos son asbtracciones de la applicacion que necesita del sistema externo, son interfaces.
- Los adaptadores son implementaciones de una API en especifico para poder generar la comuncacion con el sistema externo.
- Los sistemas externos pueden; por ejemplo, un browser, una base de datos, entre otros sistemas informaticos.

Con respecto a los adaptadores, estos estan unicamente enfocados en comunicar el codgio de dominio con los sistemas externos, los sistemas externos no deben estar presentes en el codigo.

Por otra parte los puertos usan el principio de Inversión de Dependencia para aislar el código de dominio de conocer cualquier detalle sobre los adaptadores. Están escritos puramente en términos de el modelo de dominio.

adaptadores →puertos → modelo de dominio

**La regla de oro** : el dominio nunca se conecta directamente a los adaptadores.

**La forma de crear una abstracción de base de datos es pensar en qué datos se deben almacenar y no en cómo se almacenarán.**

Un puerto de base de datos tiene dos componentes:

- **Una interfaz** para invertir la dependencia de la base de datos.
- La interfaz a menudo se conoce como repositorio y tiene la función de aislar el modelo de dominio de cualquier parte de la base de datos y su tecnología de acceso.
- **Objetos de valor** que representan los datos en sí mismos, en términos de modelo de dominio.

Existe un objeto de valor para transferir datos de un lugar a otro. Dos objetos de valor que contienen los mismos valores de datos se consideran iguales. Son ideales para transferir datos entre la base de datos y el código.