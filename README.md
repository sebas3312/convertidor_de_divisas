# ConvertidorDeDivisas

![License](https://img.shields.io/badge/license-MIT-green)
![Java](https://img.shields.io/badge/java-17-blue)
![Build](https://img.shields.io/badge/build-passing-brightgreen)

## Descripción

**ConvertidorDeDivisas** es una aplicación de consola en Java que permite convertir entre varias monedas utilizando tasas de cambio en tiempo real obtenidas de la API de ExchangeRate-API. Además, guarda la respuesta JSON de la API en un archivo local en formato legible.

## Características

- Conversión entre USD, EUR y MXN.
- Obtención de tasas de cambio en tiempo real.
- Guardado de respuestas JSON en un archivo `response.json` con formato legible.
- Manejo de excepciones para garantizar la estabilidad de la aplicación.

## Tabla de Contenidos

- [Instalación](#instalación)
- [Uso](#uso)
- [Dependencias](#dependencias)
- [Contribución](#contribución)
- [Licencia](#licencia)

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu_usuario/ConvertidorDeDivisas.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd ConvertidorDeDivisas
    ```
3. Asegúrate de tener [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) instalado.
4. Compila el proyecto:
    ```bash
    javac ConvertidorDeDivisas.java
    ```
5. Ejecuta la aplicación:
    ```bash
    java ConvertidorDeDivisas
    ```

## Uso

Al ejecutar la aplicación, se te presentará un menú con las siguientes opciones:

1. Convertir de dólares a euros
2. Convertir de euros a dólares
3. Convertir de dólares a pesos mexicanos
4. Convertir de pesos mexicanos a dólares
5. Convertir de euros a pesos mexicanos
6. Convertir de pesos mexicanos a euros
7. Salir

Simplemente ingresa el número de la opción que deseas utilizar y sigue las instrucciones para ingresar la cantidad a convertir.

## Dependencias

Este proyecto utiliza la biblioteca [Gson](https://github.com/google/gson) para manejar JSON. Asegúrate de tenerla configurada en tu entorno de desarrollo.

Si utilizas Maven, agrega la siguiente dependencia a tu `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.9</version>
</dependency>
