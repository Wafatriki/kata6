# Kata 6

Este proyecto es una aplicación que calcula fechas laborales y días laborales entre dos fechas utilizando la API de Javalin para manejar solicitudes HTTP.

## Descripción

El objetivo de este proyecto es proporcionar un servicio que calcule la siguiente fecha laboral y el número de días laborales entre dos fechas. Utiliza la API de Javalin para manejar solicitudes HTTP y devolver los resultados.

## Estructura del Proyecto

El proyecto contiene las siguientes clases y paquetes:

- `control`
  - `commands`
    - `WorkingDateCommand`: Clase que calcula la siguiente fecha laboral.
    - `WorkingDaysCommand`: Clase que calcula el número de días laborales entre dos fechas.
    - `Command`: Interfaz que define el método `execute`.
    - `CommandFactory`: Clase que registra y construye comandos.
- `model`
  - `Calendar`: Clase que maneja los días laborales.
- `view`
  - `adapters`
    - `WorkingDateRequestAdapter`: Clase que adapta las solicitudes HTTP para el comando `WorkingDateCommand`.
    - `WorkingDaysRequestAdapter`: Clase que adapta las solicitudes HTTP para el comando `WorkingDaysCommand`.
  - `Service`: Interfaz que define los métodos `start` y `stop`.
  - `WorkingDaysService`: Clase que implementa el servicio utilizando Javalin.
- `Main`: Clase principal que ejecuta la aplicación.
