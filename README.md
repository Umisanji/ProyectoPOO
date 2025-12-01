# Sistema de Ticketing Lab-LIS

Este proyecto implementa un sistema de gestión de incidencias para el laboratorio de cómputo (Lab-LIS). Permite a los usuarios reportar fallos en los equipos, y a los administradores asignar técnicos y dar seguimiento al estado de los reportes.

## Funcionalidades

- **Registrar Incidencia**: Permite reportar un fallo asociado a un equipo y un usuario (Estudiante).
- **Consultar Incidencias**: Muestra una lista de todas las incidencias registradas con su estado actual.
- **Asignar Técnico**: Permite asignar un técnico responsable a una incidencia específica.
- **Cambiar Estado**: Permite actualizar el ciclo de vida de la incidencia (Abierta -> En Proceso -> Resuelta -> Cerrada).

## Lista Preliminar de Clases

A continuación se describen las clases principales del sistema y sus responsabilidades:

- **SistemaLab**: Controladora principal. Gestiona la interacción con el usuario (menú), y mantiene las listas en memoria de usuarios, equipos e incidencias.
- **Incidencia**: Entidad que representa un reporte de fallo. Almacena información sobre el equipo afectado, el usuario que reportó, el técnico asignado, y el estado del reporte.
- **Equipo**: Representa un equipo de cómputo dentro del laboratorio, identificado por un número o ID.
- **Usuario**: Clase abstracta que define los atributos comunes (id, nombre, correo) para todos los usuarios del sistema.
- **Estudiante**: Especialización de Usuario. Representa a los alumnos que pueden reportar incidencias. Incluye su matrícula.
- **Tecnico**: Especialización de Usuario. Representa al personal encargado de atender y resolver las incidencias.
- **Enumeraciones (TipoIncidencia, Prioridad, EstadoIncidencia)**: Definen los valores permitidos para clasificar y gestionar el ciclo de vida de las incidencias.

## Cómo Ejecutar

### Prerrequisitos
- Tener instalado el **Java Development Kit (JDK)** (versión 8 o superior).

### Pasos

1. Abre una terminal y navega a la carpeta `src` del proyecto

2. Compila todos los archivos Java

3. Ejecuta la clase principal

