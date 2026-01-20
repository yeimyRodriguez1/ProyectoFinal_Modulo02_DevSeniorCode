package Modelo;

public class CuentaSpotify {
    private String usuario;
    private String password;
    private Playlist[] playlists;
    private BibliotecaMusical biblioteca;
    private boolean sesionIniciada;

    private int capacidadBiblioteca;
    private int capacidadPlaylists;
    private int contadorPlaylists;

    public CuentaSpotify(String usuario, String password, int capacidadBiblioteca, int capacidadPlaylists) {
        this.usuario = usuario;
        this.password = password;
        this.playlists = new Playlist[capacidadPlaylists];
        this.biblioteca = new BibliotecaMusical(capacidadBiblioteca);
        this.sesionIniciada = false;
        this.capacidadBiblioteca = capacidadBiblioteca;
        this.capacidadPlaylists = capacidadPlaylists;
    }

    public CuentaSpotify(String string, String string2, String string3) {
        // TODO Auto-generated constructor stub
    }

    public BibliotecaMusical getBiblioteca() {
        return biblioteca;
    }

    public void iniciarSesion(String usuario, String password) {
        if (this.usuario.equals(usuario) && this.password.equals(password)) {
            this.sesionIniciada = true;
            System.out.println("Sesión iniciada correctamente.");
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    public void agregarPlaylist(Playlist nuevPlaylist) {
        if (sesionIniciada && contadorPlaylists < capacidadPlaylists) {
            playlists[contadorPlaylists] = nuevPlaylist;
            contadorPlaylists++;
            System.out.println("Playlist agregada: " + nuevPlaylist.getNombre());
        } else {
            System.out.println(
                    "Debe iniciar sesión para agregar una playlist. Verifique si la sesion está iniciada o si ha alcanzado el límite de playlists.");
        }
    }

    public void agregarCancionAPlaylist(String nombrePlaylist, Cancion cancion) {
        // 1.Buscar la playlist en el arreglo de playlist
        // 2.Si la encuentra, invocar el metodo agregarCancion de la playlist
        for (int i = 0; i < contadorPlaylists; i++) {
            if (playlists[i].getNombre().equalsIgnoreCase(nombrePlaylist)) {
                playlists[i].agregarCancion(cancion);
                System.out.println("Canción agregada a la playlist: " + nombrePlaylist);
                return;
            }
        }
    }

    public void reproducir(String nombrePlaylist, int indiceCancion) {
        for (int i = 0; i < contadorPlaylists; i++) {
            if (playlists[i].getNombre().equalsIgnoreCase(nombrePlaylist)) {
                playlists[i].reproducirCancion(indiceCancion);
                return;
            }
        }
        System.out.println("Playlist no encontrada: " + nombrePlaylist);
    }

    public void cerrarSesion() {
        this.sesionIniciada = false;
        System.out.println("Sesión cerrada.");
    }

    public void listarPlaylists() {
        System.out.println("\n--- PLAYLISTS DISPONIBLES ---");
        for (int i = 0; i < contadorPlaylists; i++) {
            System.out.println("[" + i + "] " + playlists[i].getNombre());
        }
    }

    public Playlist getPlaylistPorNombre(String nombre) {
        for (int i = 0; i < contadorPlaylists; i++) {
            if (playlists[i].getNombre().equalsIgnoreCase(nombre)) {
                return playlists[i];
            }
        }
        return null;
    }

}