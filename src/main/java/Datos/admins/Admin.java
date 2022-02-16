/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.admins;

import javax.persistence.*;

/**
 *
 * @author Equipo
 */
//MAPEO PARA QUE SE CORRESPONDA CON TU TABLA EN LA BD
@Entity
@Table(name="admins")
public class Admin {

    //PARA MAPEAR LOS CAMPOS DE LA TABLA
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //INDICAR CUAL ES LA CLAVE PRIMARIA
    @Column(name="id")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="email")
    private String email;
    @Column(name="contrasenia")
    private String contrasenia;

    public Admin() {
    }

    public Admin(String nombre, String apellidos, String email, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", contrasenia=" + contrasenia + '}';
    }
}
