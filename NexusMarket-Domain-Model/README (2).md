# NexusMarket — Domain Model + Spring Boot + MySQL + MongoDB

Proyecto académico acumulativo. Conserva el modelo de dominio, los 14 servicios, los 14 puertos de entrada y las 41 operaciones públicas implementadas. Se incorpora una base ejecutable de Spring Boot y una primera integración real de persistencia.

## Tecnologías

- Java 21 y Spring Boot 3.5.7.
- Maven como gestor de dependencias y construcción.
- MySQL 8.4 para datos transaccionales del negocio. En esta entrega se persiste el agregado `User` y su unicidad; los demás adaptadores relacionales siguen pendientes.
- MongoDB 8.0 para documentos de auditoría técnica y trazabilidad. No se replica allí la información transaccional de MySQL.
- Flyway para versionar el esquema SQL.
- Docker Compose para levantar la aplicación y las dos bases de datos.

## Arquitectura

Se mantiene el enfoque de **DDD + Arquitectura Hexagonal (Ports and Adapters)**:

- `domain/model`: entidades y comportamientos del negocio.
- `domain/valueobject`: objetos de valor y catálogos.
- `domain/ports/in`: casos de uso disponibles para los actores.
- `domain/ports/out`: contratos que necesita el dominio para consultar y guardar información.
- `domain/services`: reglas y coordinación del dominio.
- `application`: límites transaccionales y puerto de auditoría.
- `infrastructure/persistence/mysql`: entidades JPA, repositorios Spring Data y adaptador que implementa los puertos de usuario.
- `infrastructure/persistence/mongodb`: documentos y adaptador para guardar eventos de auditoría.

La dirección de dependencias es hacia el dominio: el dominio no importa Spring, JPA, MongoDB ni controladores HTTP.

## Ejecutar con Docker

1. Instala Docker Desktop y asegúrate de que Docker Engine esté iniciado.
2. Copia `.env.example` como `.env` y cambia las contraseñas para tu entorno.
3. Desde la carpeta raíz ejecuta:

```bash
docker compose up --build
```

4. Comprueba el estado de la aplicación en `http://localhost:8080/actuator/health`.
5. Para detener los contenedores:

```bash
docker compose down
```

Los datos permanecen en los volúmenes `mysql_data` y `mongo_data`. Para borrar también los datos locales de desarrollo: `docker compose down -v`.

## Ejecutar sin Docker

Requiere JDK 21+, Maven 3.9+ y servicios MySQL/MongoDB disponibles. Configura `MYSQL_URL`, `MYSQL_USER`, `MYSQL_PASSWORD` y `MONGODB_URI`; después ejecuta:

```bash
mvn clean test
mvn spring-boot:run
```

## Estado real de implementación

Esta entrega **no debe presentarse como un marketplace terminado**. Se incorporó:

- Arranque de Spring Boot y configuración externa.
- MySQL con migración Flyway y adaptador JPA funcional para `UserRepositoryPort` y `UserUniquenessPort`.
- MongoDB con `AuditTrailPort`, adaptador de persistencia y eventos de registro/cambio de estado de usuario después del commit SQL.
- Límite transaccional de aplicación para los casos de uso de usuario.
- Prueba unitaria de validación del evento de auditoría.

Aún faltan adaptadores MySQL para los otros repositorios de dominio, integración de auditoría desde los demás casos de uso, control de concurrencia de inventario, autenticación/autorización técnica, API de negocio, pruebas de integración con ambas bases y definición de reglas de pago, impuestos, devoluciones y logística que el documento funcional no especifica. El endpoint de Actuator es técnico; no es una interfaz de negocio.

La especificación funcional excluye la interfaz gráfica y no define tecnologías, arquitectura ni almacenamiento. Spring Boot, MySQL y MongoDB son decisiones técnicas de esta implementación académica, no requisitos textuales del negocio.

## Verificación del dominio sin Spring

Con JDK 21 o superior, puedes compilar el dominio y la prueba de humo existente con PowerShell:

```powershell
New-Item -ItemType Directory -Force build/classes | Out-Null
$files = Get-ChildItem src/main/java/com/nexusmarket/domain,tests -Recurse -Filter *.java | ForEach-Object FullName
javac -d build/classes $files
java -cp build/classes DomainSmokeTest
```

## GitHub

Copia el contenido de esta carpeta dentro de la raíz de tu repositorio existente, conservando la carpeta `.git`. Revisa `git status` y `git diff` antes de confirmar los cambios. No reemplaces `.git`.
