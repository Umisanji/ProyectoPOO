public class Estudiante extends Usuario {
    private String matricula;

    public Estudiante(String id, String nombre, String correo, String matricula) {
        super(id, nombre, correo);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

}
