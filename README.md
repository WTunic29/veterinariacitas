# Veterinariacitas

Sistema de gestión de citas médicas veterinarias, desarrollado en Java utilizando Swing para la interfaz gráfica y MongoDB como base de datos NoSQL. El sistema está diseñado para permitir el agendamiento, modificación y consulta de citas médicas, así como la gestión de historial médico, validación de conflictos y administración de mascotas.

## Funcionalidades principales

- Agendar, modificar y cancelar citas médicas.
- Validación de fechas y conflictos de agenda.
- Gestión de veterinarios y usuarios con login básico.
- Historial médico por mascota y consulta de información.
- CRUD completo de mascotas (registrar, buscar, actualizar, eliminar).
- Interfaz gráfica intuitiva usando Java Swing.
- Persistencia con MongoDB a través de DAO.

## Patrones de diseño aplicados

| Patrón       | Aplicación                             |
|--------------|----------------------------------------|
| DAO          | `CitaDao`, `MascotaDao`                |
| Command      | `AgendarCitaCommand`                   |
| State        | `EstadoAgendada`, `EstadoCancelada`    |
| Observer     | `DueñoObservador`, `Notificador`       |
| Singleton    | `ConexionMongoDB`                      |
| MVC (modular)| Separación de `modelo`, `vista`, `dao` |

## Requisitos

- Java 17+
- Apache NetBeans (o IDE compatible con Maven)
- MongoDB en ejecución (local o remoto)
- Dependencias configuradas en `pom.xml`

## Ejecución

1. Clona este repositorio o descarga el `.zip`
2. Abre el proyecto en NetBeans.
3. Ejecuta la clase `Veterinariacitas.java`.
4. Inicia sesión como:
   - Usuario: `veterinario` / Clave: `1234`
   - Usuario: `admin` / Clave: `admin`

## Estructura del proyecto

- `modelo/`: Clases del modelo de negocio (`Cita`, `Mascota`, `HistorialMedico`)
- `dao/`: Interfaces e implementaciones DAO con MongoDB
- `vista/`: Interfaces gráficas con Swing
- `validador/`: Lógica de validación de reglas de negocio
- `seguridad/`: Pantalla de login y gestión de credenciales

## Autor

Desarrollado como parte de un caso de estudio académico para gestión de mascotas y veterinarias.
