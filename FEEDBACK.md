# ☕ Evaluación del proyecto de Adrián

## 🧱 1. Estructura del proyecto y arquitectura por capas
- ✅ Separación clara en capas (Controller, Service, Repository, Entity)
- ✅ Lógica de negocio correctamente ubicada en la capa de servicio
- 🔶 No se mezcla acceso a datos ni lógica de presentación
- **Comentario:** Aunque la estructura por capas es clara, hay desorganización dentro de la carpeta de `repository` (por ejemplo, `ModelCoffee` está en un lugar que no corresponde y no hay consistencia entre los repositorios: unos están con JPA, otros con JDBC, y algunos son interfaces sin implementación). También hay interfaces de servicios sin uso real. Esto genera confusión y rompe la coherencia del diseño.

## 🧩 2. Spring Core – Inyección de dependencias
- ✅ Se evita el uso de `new` para crear dependencias
- ✅ Uso de inyección de dependencias (por constructor o con `@Autowired`)
- ✅ Uso adecuado de `@Component`, `@Service`, `@Repository`
- **Comentario:** Se emplea correctamente la inyección de dependencias y las anotaciones de Spring. Esta parte está bien resuelta.

## 🗃️ 3. Persistencia con JPA
- ✅ Entidades bien definidas y anotadas (`@Entity`, `@Id`, `@Column`)
- ✅ Relaciones modeladas correctamente (`@OneToMany`, `@ManyToOne`, etc.)
- ✅ Consultas por nombre de método (`findByTipo`, etc.)
- ✅ Uso de paginación con `Pageable` y `Page` si procede
- 🔶 Separación lógica entre repositorio y servicio
- **Comentario:** Las entidades están bien definidas y se hace uso de paginación, lo cual es un buen detalle técnico. Sin embargo, hay falta de consistencia en los repositorios y un uso incorrecto del paquete `repository` para alojar clases que no corresponden. Además, la mezcla entre JDBC y JPA sin un criterio claro complica el mantenimiento del código.

## 🛢️ 4. Base de datos
- ✅ Configuración correcta en `application.properties`
- ✅ Conexión establecida con MySQL y persistencia de datos funcional mediante JPA/Hibernate
- **Comentario:** Esta parte está bien configurada y operativa.

## 🌐 5. Spring Web / REST
- 🔶 Endpoints REST bien definidos y nombrados
- ✅ Uso correcto de `@GetMapping`, `@PostMapping`, etc.
- ✅ Uso adecuado de `@PathVariable`, `@RequestBody`, `@RequestParam`
- **Comentario:** No se respetan los estándares de diseño REST. Las rutas deben representarse como recursos en **plural** y en **kebab-case** (por ejemplo: `/orders` en lugar de `/createOrder` o similares). Además, hay endpoints como el de crear pedidos que están vacíos y no contienen lógica implementada, por lo tanto no funcionan.

## 🔐 6. Spring Security
- ✅ Autenticación implementada (por ejemplo, básica o JWT)
- ✅ Rutas protegidas según roles o permisos
- ✅ Configuración clara (`SecurityFilterChain`, filtros, etc.)
- **Comentario:** Bien resuelto. JWT está correctamente integrado, con filtros personalizados y una configuración clara.

## 🧪 7. Testing
- _(Sin evaluar, no presente en el proyecto)_

## 🧼 8. Buenas prácticas y limpieza de código
- ✅ Nombres claros y expresivos
- 🔴 Código sin duplicación ni clases innecesarias
- 🔴 Validaciones, manejo de errores, uso correcto de `Optional`
- **Comentario:** Hay varios aspectos a mejorar:
    - Las clases deben ir en **singular** (`Users` debería ser `User`).
    - Hay código que **no compila**, lo cual es un fallo grave.
    - Hay métodos incompletos y rutas REST sin lógica.
    - Faltan validaciones y manejo de errores.
    - También hay interfaces sin implementación que generan ruido innecesario.  
      Todo esto afecta negativamente a la calidad del código.

## 🎁 9. Extras (no obligatorios, pero suman)
- 🔴 Uso de DTOs
- 🔴 Swagger / documentación de la API
- 🔶 Buen uso de Git (commits claros, ramas, etc.)
- 🔶 Inclusión de un `README.md` claro con instrucciones de ejecución
- **Comentario:**
    - No se han usado DTOs, lo cual hubiera sido recomendable para separar los modelos de dominio de los datos expuestos en la API.
    - No hay Swagger.
    - El uso de Git es muy limitado: **solo hay 6 commits**, lo cual no refleja un flujo de trabajo habitual en proyectos reales.
    - El `README.md` existe, pero podría ser más completo.

---

## 📊 Comentario general
Adrián, el proyecto tiene una base correcta en cuanto a la estructura general, la autenticación y algunas partes de la lógica de negocio, pero hay varios aspectos críticos a corregir:

- **No compila**, lo cual es un bloqueo muy grave.
- Hay endpoints incompletos que no funcionan.
- La nomenclatura de rutas no sigue los estándares REST.
- Falta consistencia en la gestión de repositorios.
- Hay clases mal nombradas (en plural) y servicios declarados sin implementación.
- Tampoco se han implementado DTOs ni documentación Swagger.
- El uso de Git es escaso y no refleja una evolución clara del proyecto.

Para mejorar: revisa las convenciones REST, asegúrate de que el código compile, finaliza todos los endpoints, organiza mejor el código y usa commits frecuentes. Estás en buen camino, pero es importante entregar un proyecto funcional, limpio y coherente.
