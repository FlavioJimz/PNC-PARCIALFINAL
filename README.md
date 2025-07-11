# Parcial Final Programación N-Capas – Seguridad con Spring Security + JWT

Este repositorio contiene un proyecto diseñado para evaluar y practicar los conceptos de seguridad en aplicaciones Spring Boot, utilizando **Spring Security** con **JWT**, roles de usuario, y **Docker** para contenerizar la aplicación.

### Autores:
- **Jose Flavio Jimenez Aguila** - 00239920
- **Alejandro Jose Centeno Vasquez** - 00081320

---

## Objetivo

El objetivo de este proyecto es **agregar autenticación y autorización** utilizando **Spring Security** y **JSON Web Tokens (JWT)**. Además, la aplicación debe ser **contenedorizada** usando **Docker** para facilitar su despliegue y ejecución.

---

## Tecnologías y Herramientas Utilizadas

- **Spring Boot**: Framework principal para la aplicación backend.
- **Spring Security**: Para implementar la seguridad de la aplicación.
- **JWT (JSON Web Token)**: Para manejo de autenticación y autorización.
- **Docker**: Para contenerizar la aplicación y facilitar su despliegue.

## Como generar el contenedor via docker 

- **./mvnw clean package -DskipTests**: Usas este comando cuando quieres generar el artefacto del proyecto (como un .jar) de manera limpia, pero sin esperar a que se ejecuten las pruebas, lo cual puede ahorrar tiempo en compilaciones repetitivas.
- **docker compose up --build**: Este comando inicia todos los contenedores definidos en docker-compose.yml y, antes de eso, reconstruye cualquier imagen que haya cambiado, asegurándose de que los contenedores ejecuten la versión más actualizada de las imágenes.
