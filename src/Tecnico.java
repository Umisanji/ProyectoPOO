public class Tecnico extends Usuario {
    private String area;

    public Tecnico(String id, String nombre, String correo, String area) {
        super(id, nombre, correo);
        this.area = area;
    }

}
