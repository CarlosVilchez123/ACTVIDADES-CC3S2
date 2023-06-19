# APUNTES DEL CURSO

En este readme estaran la mayor cantidad de apuntes de clase que se haran.
# Pruebas Unitarias
Una prueba unitaria es un pequeño codigo que sirve para probar algo en particular con resepecto a alguna funcionalidad o implementación del codigo de producción.
Es una herramienta muy poderosa puesto que permite poder hacer test de forma ordenada y poder separar una implementación en particiones; sin embargo, esto tiene sus desventajas, pues no probamos como es que cada parte se comporta entre si, solo probamos en partes independientes.


Ventajas de usar pruebas unitarias:
- Las pruebas unitarias son rapidas
- las pruebas unitarias son faciles de controlar
- las pruebas unitarias son faciles de escribir

Desventajas de usar pruebas unitarias:

- Las pruebas unitarias carecen de realidad: El gran número de clases en un sistema y su interacción puede causar que el sistema se comporte de manera
diferente en su aplicación real que en las pruebas unitarias.Por lo tanto, las pruebas unitarias no representan a la perfección la ejecución real 
de un sistema de software.
- Algunos tipos de errores no se detectan: Algunos tipos de errores no se pueden detectar en el nivel de prueba unitaria; solo ocurren en la integración
de los diferentes componentes (que no se ejercen en una prueba unitaria pura). 
Piensa en una aplicación web que tiene una interfaz de usuario compleja: es posible que hayas probado el backend y el frontend a fondo, pero es posible
que un error solo se revele cuando se juntan el backend y el frontend.
O imagina un código de subprocesos múltiples: todo puede funcionar a nivel de unidad, pero pueden aparecer errores una vez que los subprocesos se ejecutan juntos.

Definicion dada por Roy Osherove en 2009:  “Una prueba unitaria es una pieza de código automatizada que invoca una unidad de trabajo en el sistema.
Y una unidad de trabajo puede abarcar un solo método, una clase completa o varias clases que trabajan juntas para lograr
un solo propósito lógico que se puede verificar”. 

En caso querramos testear una clase que dependa de otras clase que; a su vez, depende de un base de datos, tendremos que simular dicha base de datos cuando
empecemos el testeo de la clase a probar.

Para ello existen los **STUBS**, los stubs son pequeños trozos de codigo que se utilizan para simular o recrear partes funcionales en un testing.

# PRUEBAS DE INTEGRACIÓN

Las pruebas de integracion son pruebas que se usan cuando las unitarias no pueden ayudar, estan sirven para **integrar** partes del codigo y partes externas
como API's, servidores, etc.

- Ejemplo:

Los sistemas de software se basan en sistemas de bases de datos. Para comunicarse con la base de datos, a menudo crean una clase cuya única responsabilidad
es interactuar con este componente externo (piensa en la clase de objetos de acceso a datos [DAO]). Estos DAO pueden contener codigo SQL complicado.

Por lo tanto, un evualuador tiene siente la necesidad de probar las consultas SQL. El evaluadr no quiere solicitar todo el sistema, solo la integración entre la
base de datos y la clase DAO. El evaluador tampoco quiere probar la clase DAO en completo aislamiento.

Despues de todo, la mejor manera de saber si una consulta SQL funciona es enviarla a la base de datos y ver que
devuelve la base de datos. Este es un ejemplo de una prueba de integración.

Las pruebas de integración tienen como objetivo probar múltiples componentes de un sistema juntos, centrándose en las interacciones entre ellos en lugar de probar el sistema como un todo. ¿Se están comunicando correctamente? ¿Qué sucede si el componente A envía un mensaje X al componente B? ¿Siguen presentando un comportamiento correcto?

Las pruebas de integración se centran en dos partes: el componente a analizar y el componente externo. Escribir una prueba de este tipo es menos complicado que escribir una prueba que atraviese todo el sistema e incluya componentes que no nos interesan.

En comparación con las pruebas unitarias, las pruebas de integración son más difíciles de escribir.
 
# PRUEBAS DEL SISTEMA

Para obtener una vista más realista del software y, por lo tanto, realizar pruebas más realistas, debemos ejecutar todo el sistema de software con todas sus bases de datos, aplicaciones de interfaz y otros componentes. Cuando probamos el sistema en su totalidad, en lugar de probar pequeñas partes del sistema de forma aislada, estamos haciendo pruebas del sistema . No nos importa cómo funciona el sistema desde adentro, no nos importa si fue desarrollado en Java o Ruby, o si utiliza una base de datos relacional.

Solo nos importa que, dada la entrada X, el sistema proporcione la salida Y.

Al probar el sistema, deseas ejercitar todo el sistema en conjunto, incluidas todas sus clases, dependencias, bases de datos, servicios web y cualquier otro componente que pueda tener.

La ventaja obvia de las pruebas del sistema es cuán realistas son las pruebas. Nuestros clientes finales no ejecutarán el método identifyExtremes() de forma aislada. Más bien, visitarán una página web, enviarán un formulario y verán los resultados. Las pruebas del sistema ejercitan el sistema de esa manera precisa. Cuanto más realistas sean las pruebas (es decir, cuando las pruebas realicen acciones similares a las del usuario final), más confianza podremos tener sobre todo el sistema.


