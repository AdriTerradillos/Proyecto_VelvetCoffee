package com.proyecto.velvetCoffee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


/**
 * --PAUTAS--
 * 1º) generamos las anotaciones correspondientes '@Id' + Atributos de la clase
 * 2º) hacemos llamamiento a método de la clase Usuario()
 * 3º) generamos contructor
 * 4º) getters y setters
 */


@Entity
public class Users {

    // 1º)
    @Id
    private String nombreUsuario;
    private String contraseña;
    private String rol;

    // 2º)
    public Users() {

    }

    // 3º)
   public Users(String nombreUsuario, String contraseña, String rol) {
   this.nombreUsuario = nombreUsuario;
   this.contraseña = contraseña;
   this.rol = rol;
   }


   // 4º)

   public String getNombreUsuario() {
      return nombreUsuario;
   }

   public void setNombreUsuario(String nombreUsuario) {
      this.nombreUsuario = nombreUsuario;
   }

   public String getContraseña() {
      return contraseña;
   }

   public void setContraseña(String contraseña) {
      this.contraseña = contraseña;
   }

   public String getRol() {
      return rol;
   }

   public void setRol(String rol) {
      this.rol = rol;
   }
}



