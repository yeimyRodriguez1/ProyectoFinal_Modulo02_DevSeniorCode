package Modelo;

public class Cancion extends Multimedia implements Reproducible {
    private String artista;

    public Cancion(String titulo, int duracionSegundos, String artista) {
        super(titulo, duracionSegundos);
        this.artista = artista;
    }

    public Cancion() {
        super();
        this.artista = "Desconocido";
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo la canción: " + getTitulo() + " del artista: " + this.artista);
    }

    @Override
    public void detener() {
        System.out.println("Deteniendo la canción: " + getTitulo());

    }

    @Override
    public String getInfo() {
        return "Cancion: " + getTitulo() + " - Artista: " + this.artista + " - Duracion: " + getDuracionSegundos()
                + " segundos.";
    }

    public String toString() {
        return getInfo();
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

}
