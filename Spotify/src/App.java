import java.util.Scanner;
import Modelo.*;

public class App {

    private static Reproducible reproduccionActual = null;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CuentaSpotify cuenta = new CuentaSpotify("Yeimy", "1234", 100, 10);

        // Canciones de prueba
        BibliotecaMusical biblioteca = cuenta.getBiblioteca();
        biblioteca.agregarCancion(new Cancion("Cuart", 240, "YUY"));
        biblioteca.agregarCancion(new Cancion("Más rik", 210, "CARKS"));
        biblioteca.agregarCancion(new Cancion("Colombia", 290, "FER"));
        biblioteca.agregarCancion(new Cancion("Destino Final", 300, "Yeison"));

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MINI-SPOTIFY ===");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Gestionar Biblioteca Musical");
            System.out.println("3. Gestionar Playlists");
            System.out.println("4. Reproducir Canciones");
            System.out.println("5. Cerrar sesión");
            System.out.println("6. Salir del programa");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("\n--- INICIAR SESIÓN ---");
                    System.out.print("Usuario: ");
                    String u = sc.nextLine();
                    System.out.print("Contraseña: ");
                    String p = sc.nextLine();
                    cuenta.iniciarSesion(u, p);
                    pausa(sc);
                    break;

                case 2:
                    menuBiblioteca(sc, cuenta);
                    break;

                case 3:
                    menuPlaylists(sc, cuenta);
                    break;

                case 4:
                    menuReproduccion(sc, cuenta);
                    break;

                case 5:
                    cuenta.cerrarSesion();
                    break;

                case 6:
                    salir = true;
                    System.out.println("Gracias por usar Mini-Spotify. ¡Hasta pronto!");
                    break;
            }
        }
        sc.close();
    }

    // ================= BIBLIOTECA =================
    private static void menuBiblioteca(Scanner sc, CuentaSpotify cuenta) {
        BibliotecaMusical b = cuenta.getBiblioteca();
        int op;

        do {
            System.out.println("\n--- GESTIÓN DE BIBLIOTECA ---");
            System.out.println("1. Listar canciones");
            System.out.println("2. Agregar canción");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Volver");
            System.out.print("Seleccione: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    b.listarCatalogoDetallado();
                    pausa(sc);
                    break;

                case 2:
                    System.out.println("\n--- AGREGAR CANCIÓN ---");
                    System.out.print("Título: ");
                    String t = sc.nextLine();
                    System.out.print("Artista: ");
                    String a = sc.nextLine();
                    System.out.print("Duración en segundos: ");
                    int d = sc.nextInt();
                    sc.nextLine();
                    b.agregarCancion(new Cancion(t, d, a));
                    System.out.println("Canción agregada exitosamente a la biblioteca.");
                    pausa(sc);
                    break;

                case 3:
                    System.out.println("\n--- BUSCAR CANCIÓN ---");
                    System.out.print("Ingrese nombre o fragmento: ");
                    String bus = sc.nextLine();
                    Cancion c = b.buscarCancionPorTitulo(bus);
                    if (c != null) {
                        System.out.println("Resultado encontrado:");
                        System.out.println(c.getTitulo() + " - " + c.getArtista()
                                + " (" + c.getDuracionSegundos() + "s)");
                    }
                    pausa(sc);
                    break;
            }

        } while (op != 4);

        System.out.println("\nVolviendo al menú principal...");
    }

    // ================= PLAYLISTS =================
    private static void menuPlaylists(Scanner sc, CuentaSpotify cuenta) {

        int op;
        do {
            System.out.println("\n--- GESTIÓN DE PLAYLISTS ---");
            System.out.println("1. Crear playlist");
            System.out.println("2. Listar playlists");
            System.out.println("3. Agregar canción a playlist");
            System.out.println("4. Ver canciones de una playlist");
            System.out.println("5. Volver");
            System.out.print("Seleccione: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("\n--- CREAR PLAYLIST ---");
                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine();
                    cuenta.agregarPlaylist(new Playlist(nombre, 50));
                    System.out.println("Playlist creada correctamente.");
                    pausa(sc);
                    break;

                case 3:
                    System.out.println("\n--- AGREGAR CANCIÓN A PLAYLIST ---");
                    System.out.print("Nombre de la playlist: ");
                    String pl = sc.nextLine();

                    BibliotecaMusical b = cuenta.getBiblioteca();
                    b.listarCatalogoDetallado();
                    System.out.print("Ingrese índice de canción: ");
                    int idx = sc.nextInt();
                    sc.nextLine();

                    Cancion c = b.getCancionPorIndice(idx);
                    if (c != null) {
                        cuenta.agregarCancionAPlaylist(pl, c);
                    }
                    pausa(sc);
                    break;
            }

        } while (op != 5);

        System.out.println("\nVolviendo al menú principal...");
    }

    // ================= REPRODUCCIÓN =================
    private static void menuReproduccion(Scanner sc, CuentaSpotify cuenta) {

        System.out.println("\n--- REPRODUCCIÓN ---");
        System.out.println("1. Reproducir canción desde playlist");
        System.out.println("2. Detener reproducción");
        System.out.println("3. Volver");
        System.out.print("Seleccione: ");

        int op = sc.nextInt();
        sc.nextLine();

        if (op == 2 && reproduccionActual != null) {
            reproduccionActual.detener();
            System.out.println("Reproducción detenida.");
        }
    }

    private static void pausa(Scanner sc) {
        System.out.println("\nPresione ENTER para continuar...");
        sc.nextLine();
    }
}
