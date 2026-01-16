package Modelo;

public class BibliotecaMusical {
    private Cancion[] catalogo;
    private int contadorCatalogo; 
    private int maxCatalogo; 

    public BibliotecaMusical(int maxCatalogo) {
        this.maxCatalogo = maxCatalogo;
        this.catalogo = new Cancion[maxCatalogo];
        this.contadorCatalogo = 0;
    }

    public void agregarCancion(Cancion cancion) {
        if (contadorCatalogo < maxCatalogo) {
            catalogo[contadorCatalogo] = cancion;
            contadorCatalogo++;
            System.out.println("Canción agregada al catálogo: " + cancion.getTitulo());
        } else {
            System.out.println("No se pueden agregar más canciones. El catálogo está lleno.");
        }
    }

    public Cancion buscarCancionPorTitulo(String titulo) {
        for (int i = 0; i < contadorCatalogo; i++) {
            if (catalogo[i].getTitulo().equalsIgnoreCase(titulo)) {
                return catalogo[i];
            }
        }
        System.out.println("Canción no encontrada: " + titulo);
        return null;
    }

    public void listarCatalogo() {
        System.out.println("Catálogo de la Biblioteca Municipal:");
        for (int i = 0; i < contadorCatalogo; i++) {
            System.out.println((i + 1) + ". " + catalogo[i].getInfo());
        }
    }
}
