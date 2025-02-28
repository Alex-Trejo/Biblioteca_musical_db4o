/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecamusicaldb4o.model;

/**
 *
 * @author trejo
 */
public class Cancion {
    private String titulo;
    private Artista artista;
    private String genero;
    private Album album;

    public Cancion(String titulo, Artista artista, String genero, Album album) {
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.album = album;
    }

    public String getTitulo() { return titulo; }
    public Artista getArtista() { return artista; }
    public String getGenero () { return genero; }
    public Album getAlbum() { return album; }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
    

    @Override
    public String toString() {
        return titulo + " - " + artista.getNombre() + " (" + genero + "), " + album;
    }
}
