# Proyecto_final

---

# Control de Stock API

Este repositorio contiene una API para la gestión de inventarios y ventas, diseñada para optimizar el manejo de productos, ventas y stock en tiempo real. El proyecto está desarrollado en **Spring Boot** para el backend y utiliza **MongoDB** como base de datos para la persistencia de datos.

## Objetivos

### Objetivo General

El objetivo principal de esta API es facilitar el control de inventarios, la gestión de productos, el seguimiento de ventas y la actualización de stock de manera eficiente y segura, proporcionando una interfaz RESTful accesible para aplicaciones móviles o web.

### Objetivos Específicos

1. Desarrollar una API RESTful que permita gestionar productos, ventas y stock en tiempo real.
2. Implementar autenticación segura utilizando JWT para garantizar que solo los usuarios autorizados puedan realizar operaciones sensibles.
3. Crear un sistema de gestión de ventas que actualice automáticamente el stock de productos vendidos.
4. Ofrecer un servicio sencillo para la administración de usuarios y su acceso a la API.
5. Desarrollar una documentación clara y accesible para el consumo de la API mediante Swagger UI.

## Alcance

Este proyecto tiene como alcance la creación de una **API RESTful** que permitirá gestionar las siguientes funcionalidades:

1. **Gestión de productos**: Añadir, actualizar, eliminar y consultar productos en el inventario.
2. **Gestión de ventas**: Registrar ventas y actualizarlas en tiempo real, disminuyendo el stock disponible.
3. **Gestión de stock**: Consultar y modificar el stock de productos según las necesidades de negocio.
4. **Autenticación de usuarios**: Implementar autenticación basada en JWT para el acceso seguro a la API.
5. **Gestión de usuarios**: Registrar, actualizar y eliminar usuarios que puedan acceder al sistema.

El alcance no incluye la creación de una interfaz gráfica (UI) para la administración de estos elementos, ya que la API está diseñada para ser consumida por aplicaciones móviles o web que se conecten a la misma.

---

## Requerimientos Funcionales

Los requerimientos funcionales describen las funciones que el sistema debe ser capaz de realizar. A continuación, se detallan los principales:

### 1. **Gestión de Productos**

- **Agregar productos**: El sistema debe permitir crear nuevos productos con un nombre, descripción, precio y cantidad disponible en inventario.
- **Consultar productos**: El sistema debe permitir obtener una lista de todos los productos o consultar un producto específico por su identificador único.
- **Actualizar productos**: El sistema debe permitir actualizar los detalles de un producto, como su precio, cantidad o descripción.
- **Eliminar productos**: El sistema debe permitir eliminar productos del inventario.

### 2. **Gestión de Ventas**

- **Registrar una venta**: El sistema debe permitir registrar una venta, reduciendo el stock de los productos involucrados en la venta.
- **Consultar ventas**: El sistema debe permitir consultar una lista de todas las ventas realizadas y detalles de ventas específicas.
- **Actualizar ventas**: En caso de error en el registro, el sistema debe permitir actualizar las ventas.
  
### 3. **Gestión de Stock**

- **Consultar stock**: El sistema debe permitir consultar el stock disponible de cualquier producto en inventario.
- **Actualizar stock**: El sistema debe permitir modificar la cantidad disponible de un producto en stock, reflejando las ventas o reposiciones.


---


### 2. **Rendimiento**

- **Tiempo de respuesta**: Las solicitudes deben ser atendidas en un tiempo de respuesta inferior a 2 segundos, excepto en casos excepcionales donde el procesamiento sea más largo (como registros de ventas masivas).
- **Optimización de consultas**: Se deben optimizar las consultas a la base de datos para evitar sobrecargar el sistema, utilizando técnicas como índices en campos de búsqueda frecuentes (por ejemplo, `productoId` y `ventaId`).

### 3. **Escalabilidad**

- **Escalabilidad horizontal**: La arquitectura debe ser capaz de escalar horizontalmente. Si se aumenta la carga, el sistema debe poder distribuir el tráfico entre múltiples instancias de la API sin perder rendimiento.
- **Distribución de carga**: Se recomienda el uso de un balanceador de carga para gestionar múltiples instancias de la API.

### 4. **Mantenibilidad**

- **Código limpio y organizado**: El código debe seguir buenas prácticas de desarrollo y estar estructurado de forma que sea fácil de entender y modificar. Se deben utilizar patrones de diseño apropiados (por ejemplo, CQRS para la gestión de comandos y consultas).
- **Documentación de la API**: La API debe estar documentada mediante **Swagger UI** para permitir a los desarrolladores consumirla fácilmente.

### 5. **Disponibilidad**

- **Disponibilidad continua**: La API debe estar disponible el 99.9% del tiempo, con un máximo de 8 horas de inactividad al año.
- **Manejo de fallos**: El sistema debe ser capaz de manejar errores y fallos de manera adecuada, retornando mensajes de error claros y soluciones sugeridas.

---

### Base de Datos

- **MongoDB**: Se recomienda usar MongoDB versión 5.0+.
- **Espacio de almacenamiento**: La base de datos MongoDB debe tener al menos 5 GB de espacio disponible dependiendo del volumen de datos gestionado.

---

## Plan de Implementación

1. **Desarrollo Inicial**: Crear la estructura base del proyecto, configurar Spring Boot, MongoDB y Swagger.
2. **Desarrollo de Funcionalidades**: Implementar las funcionalidades principales (gestión de productos, ventas, stock y usuarios).
3. **Pruebas Unitarias y de Integración**: Asegurar que cada endpoint funcione como se espera y que la integración entre los componentes de la API sea correcta.
4. **Despliegue en Entorno de Producción**: Configurar el servidor, desplegar la API y conectar con la base de datos.
5. **Documentación Final**: Asegurar que toda la documentación esté actualizada, especialmente la de la API mediante Swagger.

---

## Conclusión

Este proyecto está diseñado para ser una solución robusta y escalable para la gestión de inventarios, ventas y usuarios, ofreciendo una API segura y fácil de usar. La implementación de JWT para autenticación, la optimización de consultas y el diseño escalable aseguran un rendimiento adecuado y una alta disponibilidad del sistema.

Este README proporciona una guía completa para la implementación y uso de la API. Si tienes alguna pregunta o necesitas más detalles, no dudes en consultarlo.

--- 


