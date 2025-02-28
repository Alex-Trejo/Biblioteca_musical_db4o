/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibliotecamusicaldb4o;

import bibliotecamusicaldb4o.controller.DatabaseController;
import bibliotecamusicaldb4o.model.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author trejo
 */
public class BibliotecaMusicalDB4O {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // 📌 Crear un álbum
        Album album1 = new Album("Divide", 2017);
        Album album2 = new Album("After Hours", 2020);
        
        // 📌 Crear artista    
        
        List<String> albumsED = new ArrayList<>(Arrays.asList("A Night at the Opera", "Innuendo", "Queen II"));
        List<String> albumsWEE = new ArrayList<>(Arrays.asList("Star boy", "Hurry Up Tomorrow", "Kiss Land"));
        List <String> albumsDa = new ArrayList<>(Arrays.asList("Discovery", "Alive", "Stronger"));

         Artista artista1 = new Artista("Ed Sheeran", "sheeran@gmail.com", albumsED);
         Artista artista2 = new Artista("The Weeknd", "weeknd@gmail.com", albumsWEE);
         Artista artista3 = new Artista("Daft Punk", "punk@gmail.com", albumsDa);
               
        

        // 📌 Crear canciones normales
        Cancion cancion1 = new Cancion("Shape of You", artista1, "Pop", album1);
        Cancion cancion3 = new Cancion("Perfect", artista1, "Pop", album1);
        
        Cancion cancion2 = new Cancion("Blinding Lights", artista2, "R&B", album2);
        
        
        Cancion cancion4 = new Cancion("Get Lucky", artista3, "Electrónica", album1);
        CancionPremium cancion5 = new CancionPremium(" to Dance", artista3, "Electrónica", album1,2.5f ,"FLAC");

        
        // 📌 Crear canciones premium
        CancionPremium  cancionPremium =  new CancionPremium ("Don't stop Me Now",artista1, "Rock", album1,3.2f ,"FLAC" );
                
        
        // Crear una playlist y agregar canciones
        Playlist playlist1 = new Playlist("Electro Hits");
        playlist1.agregarCancion(cancion4);
        playlist1.agregarCancion(cancion5);
        
        
        // 📌 crear usuario
        
        List<Playlist> listas = new ArrayList<>();
        listas.add(playlist1);
        
        Usuario usuario = new Usuario("Carlos", "carlos@email.com", listas);
        
        
         
        // 📌 Guardar en la base de datos
        
        // guardar artista
        System.err.println("\nGuardar artistas:");
        DatabaseController.guardarArtista(artista1);
        DatabaseController.guardarArtista(artista2);
        DatabaseController.guardarArtista(artista3);
        
        // guardar canciones
        System.err.println("\nGuardar canciones:");
        DatabaseController.guardarCancion(cancion1);
        DatabaseController.guardarCancion(cancion2);
        DatabaseController.guardarCancion(cancion3);
        DatabaseController.guardarCancion(cancion4);
        DatabaseController.guardarCancion(cancion5);
        
        DatabaseController.guardarCancion(cancionPremium);
        
        
        // Guardar la playlist en la base de datos
        System.err.println("\nGuardar playlist:");
        DatabaseController.guardarPlaylist(playlist1);
        
        // Guardar usuario
        System.err.println("\nGuardar Usuario:");
        DatabaseController.guardarUsuario(usuario);
        
        
        
        
        // guardar album
        System.err.println("\nGuardar album:");
        DatabaseController.guardarAlbum(album1);
        DatabaseController.guardarAlbum(album2);
        
        
        


        
         
        //Canciones
        // 📌 Listar todas las canciones
        //System.err.println("\nListar canciones:");
        DatabaseController.listarCanciones();
        
        // 📌 Listar solo canciones premium
        System.err.println("\nListar canciones premium:");
        DatabaseController.listarCancionesPremium();
        
        
        // 📌 Listar solo Usuarios
        System.err.println("\nListar usuario:");
        DatabaseController.listarUsuarios();
        
        //📌 Listar solo Albumes
        System.err.println("\nListar album:");
        DatabaseController.listarAlbumes();
        
        //📌 Listar  playlist
        System.err.println("\nlistar playlist:");
        DatabaseController.listarPlaylists();
        
               
        // 📌 Listar artistas
        System.err.println("\nListar artistas:");
        DatabaseController.listarArtistas();
        
        
        
        
        System.err.println("\n-------------------------------------------------");
        System.err.println("\nOPERACIONES");
        // 📌 Buscar canciones por artista
        System.err.println("\nBuscar cancion por artistia : Ed Sheeran :");
        DatabaseController.buscarPorArtista("Ed Sheeran");

        // 📌 Actualizar género de una canción
        System.err.println("\nActualizar género de una canción : ");
        DatabaseController.actualizarCancion("Shape of You", "Pop-Rock");

        // 📌 Listar después de la actualización
        System.err.println("\n Listado de todas las canciones actulizado:");
        DatabaseController.listarCanciones();
        
        // 📌 Listar solo canciones premium
        System.err.println("\n Listado de todas las canciones premium:");
        DatabaseController.listarCancionesPremium();
        

        // 📌 Eliminar una canción
        System.err.println("\n Eliminar cancion: Perfect \n");

        DatabaseController.eliminarCancion("Perfect");

        // 📌 Listar después de la eliminación
        DatabaseController.listarCanciones();
        
        
        // Agregar otra canción a la playlist existente
        System.err.println("\n Agregar otra canción a la playlist existente:Electro Hits  \n");
        
        Cancion cancion6 = new Cancion("One More Time", artista3 , "Electrónica", album1);
        DatabaseController.agregarCancionAPlaylist("Electro Hits", cancion6);
        
         // Verificar que la playlist se actualizó correctamente
        DatabaseController.listarPlaylists();
        
        
        
        
        
    }
    
}
