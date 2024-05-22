public class Pintura extends ObraDeArte {
    private String meio;

    public Pintura(String titulo, String artista, int anoDeCriacao, String localizacao, String meio) {
        super(titulo, artista, anoDeCriacao, "Pintura", localizacao);
        this.meio = meio;
    }

    public String getMeio() {
        return meio;
    }

    public void setMeio(String meio) {
        this.meio = meio;
    }

    @Override
    public String toString() {
        return super.toString() + ", Meio: " + meio;
    }
}
