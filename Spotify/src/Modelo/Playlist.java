package Modelo;

public class Playlist {

    private String nombre;
    private Cancion[] canciones;

    //atributos auxiliares para manejar el arreglo
    private int contadorCanciones;
    private int maxCanciones = 100; //Representa la longitud de canciones

    public Playlist(String nombre, int maxCanciones) {
        this.nombre = nombre;
        this.maxCanciones = maxCanciones;
        this.canciones = new Cancion[maxCanciones];
        this.contadorCanciones = 0;
    }

    public void agregarCancion(Cancion cancion) {
        if (contadorCanciones < maxCanciones) {
            canciones[contadorCanciones] = cancion;
            contadorCanciones++;
            System.out.println("Canción agregada: " + cancion.getTitulo());
        } else {
            System.out.println("No se pueden agregar más canciones. La playlist está llena.");
        }
    }

    public void listarCanciones() {
        System.out.println("Playlist: " + nombre);
        for (int i = 0; i < contadorCanciones; i++) {
            System.out.println((i + 1) + ". " + canciones[i].getTitulo() + " - " + canciones[i].getArtista());
        }
    }

    public void reproducirCancion(int indice) {
        if (indice >= 0 && indice < contadorCanciones) {
            canciones[indice].reproducir();
        } else {
            System.out.println("Índice de canción inválido.");
        }
    }

    public boolean estarLlena() {
        return contadorCanciones >= maxCanciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cancion[] getCanciones() {
        return canciones;
    }

    public void setCanciones(Cancion[] canciones) {
        this.canciones = canciones;
    }

    public int getContadorCanciones() {
        return contadorCanciones;
    }

    public void setContadorCanciones(int contadorCanciones) {
        this.contadorCanciones = contadorCanciones;
    }

    public int getMaxCanciones() {
        return maxCanciones;
    }

    public void setMaxCanciones(int maxCanciones) {
        this.maxCanciones = maxCanciones;
    }

}
