public class Escultura extends ObraDeArte {
    private String material;

    public Escultura(String titulo, String artista, int anoDeCriacao, String localizacao, String material) {
        super(titulo, artista, anoDeCriacao, "Escultura", localizacao);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + ", Material: " + material;
    }
}
