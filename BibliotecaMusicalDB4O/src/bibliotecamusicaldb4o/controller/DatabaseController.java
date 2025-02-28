/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecamusicaldb4o.controller;

import bibliotecamusicaldb4o.model.*;
import com.db4o.*;
import com.db4o.query.Query;
import java.util.List;

/**
 *
 * @author trejo
 */
public class DatabaseController {
    private static final String DB_FILE = "biblioteca.db4o";
    private static ObjectContainer db = null;

     // Abrir la base de datos
    private static void abrirDB() {
        if (db == null || db.ext().isClosed()) {
            db = Db4oEmbedded.openFile(DB_FILE);
        }
    }
    
    // Cerrar la base de datos
    public static void cerrarDB() {
        if (db != null) {
            db.close();
            db = null;
            System.out.println("🚀 Base de datos cerrada correctamente.");
        }
    }
    
    
    
    // Guardar album
    public static void guardarAlbum (Album album){
        abrirDB();
        try {
            db.store(album);
            db.close();
            System.out.println("✅ Album Registrado: " + album);
            
        } finally {
        cerrarDB();
        }
    }
    
    
    // Guardar artista
    public static void guardarArtista (Artista artista){
        abrirDB();
        try {
            db.store(artista);
            db.close();
            System.out.println("✅ Artista Registrado: " + artista);
            
        } finally {
        cerrarDB();
        }
    }
    
     // Guardar una canción en db4o (normal o premium)
    public static void guardarCancion(Cancion cancion) {
        abrirDB();
        try {
            db.store(cancion);
            db.commit();
            System.out.println("✅ Cancion guardada: " + cancion);
        } finally {
            cerrarDB();
        }
    }
    
    // Guardar una playlist
    public static void guardarPlaylist(Playlist playlist) {
        abrirDB();
        try {
            db.store(playlist);
            db.commit();
            System.err.println("✅ Playlist guardada correctamente: " + playlist.getNombre());
        } finally {
            cerrarDB();
        }
    }
    
    // Listar todas las playlists almacenadas
    public static void listarPlaylists() {
        abrirDB();
        try {
            ObjectSet<Playlist> playlists = db.query(Playlist.class);
            System.err.println("\n🎼 Playlists en la base de datos:");
            for (Playlist p : playlists) {
                System.out.println(p);
            }
        } finally {
            cerrarDB();
        }
    }
    
     // Obtener todas los albumes
    public static void listarAlbumes() {
        abrirDB();
        try {
            List<Album> albumes = db.query(Album.class);
            System.err.println("\n📀 Albumes en la biblioteca:");
            for (Album c : albumes) {
                System.out.println(c);
            }
        } finally {
            cerrarDB();
        }
    }
    
   // Obtener todas las canciones
    public static void listarCanciones() {
        abrirDB();
        try {
            List<Cancion> canciones = db.query(Cancion.class);
            System.err.println("\n📀 Canciones en la biblioteca:");
            for (Cancion c : canciones) {
                System.out.println(c);
            }
        } finally {
            cerrarDB();
        }
    }
    
    
    // Obtener todos los artista
    public static void listarArtistas() {
        abrirDB();
        try {
            List<Artista> artistas = db.query(Artista.class);
            System.err.println("\n📀 Artistas en la biblioteca:");
            for (Artista c : artistas) {
                System.out.println(c);
            }
        } finally {
            cerrarDB();
        }
    }
    
    
    
    // Buscar una playlist por nombre
    public static Playlist buscarPlaylistPorNombre(String nombre) {
        abrirDB();
        try {
            ObjectSet<Playlist> resultados = db.queryByExample(new Playlist(nombre));
            return resultados.isEmpty() ? null : resultados.get(0);
        } finally {
            cerrarDB();
        }
    }
    
    
    // Agregar una canción a una playlist específica
    public static void agregarCancionAPlaylist(String nombrePlaylist, Cancion cancion) {
    abrirDB(); // Asegurar que la base de datos está abierta
    try {
        ObjectSet<Playlist> resultados = db.queryByExample(new Playlist(nombrePlaylist));
        if (!resultados.isEmpty()) {
            Playlist playlist = resultados.get(0);
            playlist.agregarCancion(cancion);
            db.store(playlist); // Guardar cambios en la base de datos
            db.commit();
            System.out.println("✅ Canción añadida a la playlist: " + nombrePlaylist);
        } else {
            System.out.println("❌ No se encontró la playlist: " + nombrePlaylist);
        }
    } finally {
        cerrarDB(); // Cerrar la base de datos después de completar la operación
    }
}

    
    
    
    // obtener solo canciones premium
    public static  void listarCancionesPremium () {
        abrirDB();
        try {
            List <CancionPremium> cancionesPremium = db.query(CancionPremium.class);
            System.err.println("\n  Canciones Premium en la biblioteca:");
            for (CancionPremium c : cancionesPremium){
                System.out.println(c);
            }
            
        } finally {
        cerrarDB();
        }
    }
    
    
    // Guardar un usuario en db40
    public static  void guardarUsuario (Usuario usuario){
        abrirDB();
        try {
            db.store(usuario);
            db.commit();
            System.out.println("\n ✅ Usuario guardado:" + usuario);
            
        } finally {
            cerrarDB();
        }
    
    }
    
    //obtener todos los usuarios
    public static void listarUsuarios(){
        abrirDB();
        try {
            List <Usuario> usuarios = db.query(Usuario.class);
            System.out.println("\n Usuarios registrados:");
            
            for (Usuario c : usuarios){
                System.out.println(c);
            }
            
        } finally {
            cerrarDB();
        }
    
    }
    
    
    
     // Buscar canciones por artista
    public static void buscarPorArtista(String artista) {
        abrirDB();
        try {
            Query query = db.query();
            query.constrain(Cancion.class);
            query.descend("artista").constrain(artista);
            List<Cancion> resultado = query.execute();

            System.out.println("\n🔍 Canciones de " + artista + ":");
            for (Cancion c : resultado) {
                System.out.println(c);
            }
        } finally {
            cerrarDB();
        }
    }
    
    
    // Actualizar una canción (por título)
    public static void actualizarCancion(String titulo, String nuevoGenero) {
        abrirDB();
        try {
            Query query = db.query();
            query.constrain(Cancion.class);
            query.descend("titulo").constrain(titulo);
            List<Cancion> resultado = query.execute();

            if (!resultado.isEmpty()) {
                Cancion c = resultado.get(0);
                c.setGenero(nuevoGenero);
                db.store(c);
                db.commit();
                System.out.println("✅ Canción actualizada: " + c);
            } else {
                System.out.println("⚠ No se encontró la canción.");
            }
        } finally {
            cerrarDB();
        }
    }
    
    
    
    // Eliminar una canción (por título)
    public static void eliminarCancion(String titulo) {
        abrirDB();
        try {
            Query query = db.query();
            query.constrain(Cancion.class);
            query.descend("titulo").constrain(titulo);
            List<Cancion> resultado = query.execute();

            if (!resultado.isEmpty()) {
                db.delete(resultado.get(0));
                db.commit();
                System.out.println("🗑 Canción eliminada: " + titulo);
            } else {
                System.out.println("⚠ No se encontró la canción.");
            }
        } finally {
            cerrarDB();
        }
    }
    
    
    
    
    
    
    
    
}



