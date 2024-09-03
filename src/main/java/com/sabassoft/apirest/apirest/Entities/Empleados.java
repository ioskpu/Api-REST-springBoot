package com.sabassoft.apirest.apirest.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Agrega esta línea


@Entity
public class Empleados {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private long id;
    private String nombre;
    private String apellido;
    private String puesto;
    private String usuario;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Column(nullable=false)
    private String password;

    
    //Getter and Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {        
        this.password = passwordEncoder.encode(password);
    }
    

}
