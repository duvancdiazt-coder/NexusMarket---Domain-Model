# Guía de estudio — Servicios NexusMarket

## 1. Modelo vs. servicio

`Inventory` guarda el estado de las existencias y protege sus invariantes (`reserve`, `receive`, `sellReserved`). `InventoryService` coordina el caso de uso: comprueba el rol, consulta el inventario a través de un puerto, ejecuta la acción de dominio y solicita guardar el resultado.

## 2. La lógica del profesor: depender de la interfaz

- `IInventoryService` es la interfaz de entrada: exige `reserve`, `receive`, etc.
- `InventoryService implements IInventoryService` cumple el contrato. `@Override` confirma que el método corresponde a la interfaz.
- `InventoryRepositoryPort` es la interfaz de salida: exige `findById`, `save`, `findAll`.
- La variable `private final InventoryRepositoryPort repository` tiene el **tipo de la interfaz**. El constructor recibe una implementación sin acoplar el servicio a MySQL, MongoDB o un repositorio de prueba.
- Si un adaptador añade `specialMethod()` pero la interfaz no lo declara, el servicio no puede llamarlo usando la referencia `repository`. Esto es el polimorfismo explicado en clase.
- La inversión de dependencias es la **D** de SOLID; la **I** es segregación de interfaces.

## 3. Sigue una reserva paso a paso

1. Alguien invoca `IInventoryService.reserve(actor, inventoryId, quantity)`.
2. `requireRole` exige usuario activo con rol SELLER o LOGISTIC_OPERATOR.
3. `repository.findById` consulta mediante la interfaz. Si no existe, se lanza una excepción.
4. `inventory.reserve(quantity)` comprueba cantidad positiva, condición no dañada y disponibilidad suficiente.
5. Descuenta `availableQuantity` y aumenta `reservedQuantity` sin permitir valores negativos.
6. `repository.save(inventory)` solicita guardar. El servicio no sabe dónde se guarda.

## 4. ¿Por qué no setters indiscriminados?

`setAvailableQuantity(-5)` rompería el negocio. `reserve(5)` expresa intención y valida la regla. Igual ocurre con `order.transitionTo(...)`, que impide saltar arbitrariamente a COMPLETED.

## 5. Cómo seguir trabajando

Implementa adaptadores concretos para los puertos, pruebas de integración y transacciones. Antes, acuerda los catálogos incompletos y las reglas de pago, devoluciones y distribución logística. No conviertas una maqueta que compila en una promesa de sistema productivo.
