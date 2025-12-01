public class Equipo {
    private String nMaquina;
    private boolean operativo;

    public Equipo(String nMaquina) {
        this.nMaquina = nMaquina;
        this.operativo = true;
    }

    public String getnMaquina() {
        return nMaquina;
    }
}
