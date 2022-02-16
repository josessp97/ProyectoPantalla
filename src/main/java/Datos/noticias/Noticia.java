/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.noticias;

import Datos.usuarios.*;
import javax.persistence.*;

/**
 *
 * @author Equipo
 */
//MAPEO PARA QUE SE CORRESPONDA CON TU TABLA EN LA BD
@Entity
@Table(name="noticias")
public class Noticia {

    //PARA MAPEAR LOS CAMPOS DE LA TABLA
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //INDICAR CUAL ES LA CLAVE PRIMARIA
    @Column(name="id")
    private int id;
    @Column(name="titulo")
    private String titulo;
    @Column(name="tipo")
    private String tipo;
    @Column(name="informacion")
    private String informacion;
    @Column(name="fechaN")
    private String fechaN;
    @Column(name="imagen")
    private String imagen;

    public Noticia() {
    }

    public Noticia(String titulo, String tipo, String informacion, String fechaN, String imagen) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.informacion = informacion;
        this.fechaN = fechaN;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Noticia{" + "id=" + id + ", titulo=" + titulo + ", tipo=" + tipo + ", informacion=" + informacion + ", fechaN=" + fechaN + ", imagen=" + imagen + '}';
    }
}
