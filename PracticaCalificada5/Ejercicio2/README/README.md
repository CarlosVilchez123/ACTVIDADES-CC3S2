- Entonces para el primer metodo lo que se hizo es crear la imagen NGINX usando
el siguiente comando docker image buil -t primer_metodo .

Con esto ya tenemos la imagen NGINX creada

Verificamos que este creada

- Luego para la creacion del conenedor se opto por usar el metodo docker run primer_metodo
; ya que, el comando presentado en la evaluacion no corria.

Verificamos que este creado el contenedor.

Ahora, redirigimos el puerto del contenedor al puerto 80 con el siguiente comando docker run -d -p 8080:80 primer_metodo primer_metodo

con ello ya podemos acceder a la pagina web https://localhost:8080/

Luego como se menciona en la actividad le asignaremos un volumen
