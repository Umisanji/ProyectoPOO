import java.util.Date;

public class Incidencia {
    private static int contadorIds;
    private int id;
    private String descripcion;
    private Date fechaReporte;
    private Date fechaResolucion;
    private TipoIncidencia tipo;
    private Prioridad prioridad;
    private EstadoIncidencia estado;
    private Equipo equipo;
    private Usuario reportadoPor;
    private Tecnico asignadoA;

    public Incidencia(String descripcion, TipoIncidencia tipo, Prioridad prioridad, Equipo equipo,
            Usuario reportadoPor) {
        this.id = contadorIds += 1;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.equipo = equipo;
        this.reportadoPor = reportadoPor;
        this.fechaReporte = new Date();
        this.estado = EstadoIncidencia.Abierta;

    }

    public int getId() {
        return id;
    }

    public EstadoIncidencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoIncidencia estado) {
        this.estado = estado;
        if (this.estado == EstadoIncidencia.Resuelta) {
            this.fechaResolucion = new Date();
        }
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public void setTecnico(Tecnico tecnico) {
        this.asignadoA = tecnico;
    }

    @Override
    public String toString() {
        String tecnicoNombre = (asignadoA != null) ? asignadoA.getNombre() : "Sin asignar";
        return "Incidencia " + id + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Tipo: " + tipo + "\n" +
                "Fecha de reporte: " + fechaReporte + "\n" +
                "Fecha de resolución: " + fechaResolucion + "\n" +
                "Prioridad: " + prioridad + "\n" +
                "Estado: " + estado + "\n" +
                "Equipo: " + equipo.getnMaquina() + "\n" +
                "Reportado por: " + reportadoPor.getNombre() + "\n" +
                "Asignado a: " + tecnicoNombre;
    }
}
