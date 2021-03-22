# Proyectos de Front y Back

 - Consta de dos proyectos uno realizado en Angular 6 que contiene la parte web.
 - El otro contiene la parte de backend y esta construido en spring boot.


## Arquitectura

Esta contruido utilizando el atron de MVC, más conocido como modelo, vista, controlador, para este caso la vista esta realizada en Angular 6, el modelo y 
controlador se encarga el proyecto backend realizado con spring boot.

LA arquitectura de alto nivel la podemos ver en la siguiente imagen:

 <image src="https://github.com/efrozo23/crud-valid/blob/master/Arquitectura-Valid.jpg" />

El proyecto web se ejecuta del lado del cliente, para este caso desde el navegador web, las peticiones las envía al servidos backend que se ejecuta en un 
servidor Apache Tomcat embebido que solo ejecuta el proyecto backend.

La base de datos es en memoria esta utilizando H2 para este caso.
