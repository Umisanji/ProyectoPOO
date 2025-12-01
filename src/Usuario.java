public abstract class Usuario {
    protected String nombre;
    protected String id;
    protected String correo;

    public Usuario(String id, String nombre, String correo) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }
}