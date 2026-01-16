package Modelo;

public abstract class Multimedia {
    private String titulo;
    private int duracionSegundos;

    public Multimedia(String titulo, int duracionSegundos) {
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
    }

    public Multimedia() {
        this.titulo = "Desconocido";
        this.duracionSegundos = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public Multimedia(String titulo) {
        this.titulo = titulo;
        this.duracionSegundos = 0;
    }

    // Este método es abstracto y debe ser implementado por las subclases
    public abstract String getInfo();
}
