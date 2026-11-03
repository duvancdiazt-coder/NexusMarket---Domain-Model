# Guía de aprendizaje — cómo está organizado NexusMarket

## 1. ¿Qué problema resuelve el proyecto?

NexusMarket es un intermediario de comercio electrónico. Conecta compradores y vendedores y coordina catálogo, inventario, carrito, pedidos, facturación, envíos, devoluciones y reportes. El documento funcional describe qué necesita el negocio; no impone cómo programarlo.

## 2. ¿Por qué DDD?

Domain-Driven Design (DDD) organiza el software alrededor de conceptos y reglas del negocio. Por eso existen clases como `Buyer`, `Seller`, `Product`, `Inventory` y `Order`. No son tablas de base de datos: representan conceptos del dominio y sus comportamientos.

## 3. ¿Por qué arquitectura hexagonal?

La arquitectura hexagonal separa las reglas del negocio de las tecnologías externas:

- Un **puerto de entrada** (`ports/in`) expresa una operación que el sistema permite realizar.
- Un **servicio de dominio** implementa las reglas para esa operación.
- Un **puerto de salida** (`ports/out`) expresa lo que el dominio necesita de afuera, por ejemplo consultar o guardar un usuario.
- Un **adaptador** conecta ese puerto con una tecnología real, como Spring Data JPA/MySQL o Spring Data MongoDB.

Así, cambiar MySQL por otra tecnología no debería obligar a reescribir las reglas del dominio.

## 4. ¿Por qué usamos dos bases?

La decisión de esta entrega es separar responsabilidades, no duplicar datos:

- **MySQL** es la fuente de verdad para datos estructurados y transaccionales. La primera integración implementada guarda usuarios, su rol, estado, correo e identificación.
- **MongoDB** guarda documentos de auditoría técnica (`audit_events`), que pueden crecer como registros de eventos. No almacena una copia de usuarios, pedidos ni inventario.

La especificación funcional no exige auditoría documental ni dos bases de datos. MongoDB se incorpora por decisión técnica del proyecto y su uso debe mantenerse acotado.

## 5. Recorrido de un caso de uso de usuario

1. Un actor invoca `IUserService`, que es el contrato de entrada.
2. `UserApplicationService` abre el límite transaccional con `@Transactional`.
3. `UserService` valida las reglas del dominio: el actor debe tener rol administrador y la identificación/correo no deben estar duplicados.
4. `UserService` usa `UserRepositoryPort` y `UserUniquenessPort`; no conoce JPA ni SQL.
5. `UserPersistenceAdapter` implementa esos puertos y traduce `User` a `UserJpaEntity`.
6. Spring Data JPA escribe en MySQL.

## 6. Recorrido de auditoría

La capa de aplicación expresa un `AuditEvent` y utiliza `AuditTrailPort`. `MongoAuditTrailAdapter` lo transforma en `AuditEventDocument`, y `SpringDataAuditRepository` lo guarda en la colección `audit_events` de MongoDB. La conexión está implementada y los casos de uso de registro/cambio de estado de usuario generan eventos después de confirmar la transacción MySQL. La consulta no genera un evento en esta entrega.

**No guardes** contraseñas, tokens JWT, números completos de tarjetas ni secretos dentro de los eventos.

## 7. ¿Qué hace Docker Compose?

Docker Compose describe tres contenedores: aplicación, MySQL y MongoDB. Los volúmenes conservan los datos entre reinicios. Las variables de entorno permiten cambiar credenciales sin escribirlas en el código.

## 8. ¿Qué falta y por qué no se inventa?

El documento funcional no define proveedor de pago, cálculo de impuestos, costo de envío, criterios de aprobación de devoluciones, catálogo completo de estados ni reglas de envío multi-vendedor. Esas decisiones deben aclararse con el negocio antes de codificarlas. También falta completar los adaptadores de persistencia de los demás repositorios y probar los flujos con bases reales.
