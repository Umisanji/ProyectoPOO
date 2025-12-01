import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaLab {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Equipo> equipos = new ArrayList<>();
    private static List<Incidencia> incidencias = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 1; i <= 41; i++) {
            equipos.add(new Equipo(String.valueOf(i)));
        }

        Estudiante est1 = new Estudiante("1", "Mar Sastre", "mar@uv.mx", "s24016732");
        Estudiante est2 = new Estudiante("2", "Katia Chable", "katia@uv.mx", "s24016733");
        Tecnico tec1 = new Tecnico("T1", "Ing. Irving", "irving@uv.mx", "Tecnico");
        usuarios.add(est1);
        usuarios.add(est2);
        usuarios.add(tec1);

        int opcion = 0;
        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    registrarIncidencia();
                    break;
                case 2:
                    listarIncidencias();
                    break;
                case 3:
                    asignarTecnico();
                    break;
                case 4:
                    cambiarEstadoIncidencia();
                    break;
                case 5:
                    cambiarPrioridadIncidencia();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- SISTEMA DE TICKETING LAB-LIS ---");
        System.out.println("1. Registrar nueva incidencia");
        System.out.println("2. Consultar incidencias");
        System.out.println("3. Asignar tecnico a incidencia");
        System.out.println("4. Cambiar estado de incidencia");
        System.out.println("5. Cambiar prioridad de incidencia");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static void registrarIncidencia() {
        System.out.println("\n--- NUEVA INCIDENCIA ---");

        System.out.println("ingrese matricula: ");
        String matricula = scanner.nextLine();
        Usuario usuario = buscarUsuario(matricula);

        if (usuario == null) {
            System.out.println("Error: matricula no encontrada.");
            return;
        }

        System.out.print("ID del Equipo afectado: ");
        String idEquipo = scanner.nextLine();
        Equipo equipo = buscarEquipo(idEquipo);

        if (equipo == null) {
            System.out.println("Error: Equipo no encontrado.");
            return;
        }

        System.out.print("Descripción del fallo: ");
        String desc = scanner.nextLine();

        System.out.println("Tipo (1.HARDWARE, 2.SOFTWARE, 3.RED): ");
        int tipoOp = Integer.parseInt(scanner.nextLine());
        TipoIncidencia tipo = TipoIncidencia.values()[tipoOp - 1];

        System.out.println("Prioridad (1.BAJA, 2.MEDIA, 3.ALTA, 4.CRITICA): ");
        int prioOp = Integer.parseInt(scanner.nextLine());
        Prioridad prioridad = Prioridad.values()[prioOp - 1];

        Incidencia nueva = new Incidencia(desc, tipo, prioridad, equipo, usuario);
        incidencias.add(nueva);
        System.out.println("¡Incidencia registrada con ID " + nueva.getId() + "!");
    }

    private static void listarIncidencias() {
        System.out.println("\n--- LISTA DE INCIDENCIAS ---");
        if (incidencias.isEmpty()) {
            System.out.println("No hay incidencias registradas.");
        } else {
            for (Incidencia inc : incidencias) {
                System.out.println("------------------------------------------------");
                System.out.println(inc.toString());
            }
        }
    }

    private static void asignarTecnico() {
        System.out.print("\nIngrese ID de la incidencia: ");
        int id = Integer.parseInt(scanner.nextLine());
        Incidencia inc = buscarIncidencia(id);

        if (inc != null) {
            System.out.print("Ingrese ID del técnico: ");
            String idTec = scanner.nextLine();
            Usuario user = buscarUsuario(idTec);

            if (user instanceof Tecnico) {
                inc.setTecnico((Tecnico) user);
                inc.setEstado(EstadoIncidencia.Asignada);
                System.out.println("Técnico asignado correctamente.");
            } else {
                System.out.println("Usuario no encontrado o no es un técnico.");
            }
        } else {
            System.out.println("Incidencia no encontrada.");
        }
    }

    private static void cambiarEstadoIncidencia() {
        System.out.print("\nIngrese ID de la incidencia: ");
        int id = Integer.parseInt(scanner.nextLine());
        Incidencia inc = buscarIncidencia(id);

        if (inc != null) {
            System.out.println("Nuevo estado (1.EN_PROCESO, 2.RESUELTA, 3.CERRADA): ");
            int op = Integer.parseInt(scanner.nextLine());
            EstadoIncidencia nuevoEstado = EstadoIncidencia.values()[op + 1];
            inc.setEstado(nuevoEstado);
            System.out.println("Estado actualizado a: " + nuevoEstado);
        } else {
            System.out.println("Incidencia no encontrada.");
        }
    }

    private static void cambiarPrioridadIncidencia() {
        System.out.print("\nIngrese ID de la incidencia: ");
        int id = Integer.parseInt(scanner.nextLine());
        Incidencia inc = buscarIncidencia(id);

        if (inc != null) {
            System.out.println("Nueva prioridad (1.BAJA, 2.MEDIA, 3.ALTA, 4.CRITICA): ");
            int op = Integer.parseInt(scanner.nextLine());
            Prioridad nuevaPrioridad = Prioridad.values()[op - 1];
            inc.setPrioridad(nuevaPrioridad);
            System.out.println("Prioridad actualizada a: " + nuevaPrioridad);
        } else {
            System.out.println("Incidencia no encontrada.");
        }
    }

    private static Equipo buscarEquipo(String id) {
        return equipos.stream().filter(e -> e.getnMaquina().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    private static Usuario buscarUsuario(String id) {
        return usuarios.stream().filter(u -> {
            if (u.getId().equalsIgnoreCase(id))
                return true;
            if (u instanceof Estudiante) {
                return ((Estudiante) u).getMatricula().equalsIgnoreCase(id);
            }
            return false;
        }).findFirst().orElse(null);
    }

    private static Incidencia buscarIncidencia(int id) {
        return incidencias.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }
}