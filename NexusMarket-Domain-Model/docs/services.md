# Responsabilidad de las bases de datos

| Base | Responsabilidad | Datos de esta entrega | Fuente de verdad |
|---|---|---|---|
| MySQL | Persistencia relacional transaccional | Usuarios, identificación, nombre, email, rol y estado | Sí, para el agregado User implementado |
| MongoDB | Registro documental de auditoría técnica | Eventos con actor, acción, recurso, descripción y fecha | Sí, para los documentos de auditoría |

No se replica el mismo agregado en ambas bases. No se ha implementado sincronización distribuida ni transacciones ACID entre MySQL y MongoDB. Los casos de uso de usuario programan el evento MongoDB después del commit SQL. La escritura MongoDB es independiente de la transacción SQL: si MongoDB falla después del commit, el cambio de usuario permanece y el evento puede faltar. Para garantías fuertes se debe implementar Outbox y reintentos.

## Próximas integraciones MySQL

Implementar adaptadores para Buyer, Seller, Warehouse, Product, Inventory, Cart, Order, Payment, Invoice, Shipment, Return y Refund, respetando sus relaciones y evitando serializar grafos de objetos con referencias circulares.

## Riesgos que deben resolverse

- Si una operación SQL necesita registrar auditoría en MongoDB, una caída de Mongo puede dejar el evento sin persistir. Para garantías fuertes se debe evaluar patrón Outbox en MySQL y un publicador/reintento.
- Las reglas de concurrencia de inventario requieren transacciones y bloqueo optimista/pesimista según el diseño final.
- La auditoría no debe almacenar secretos ni datos personales innecesarios.
