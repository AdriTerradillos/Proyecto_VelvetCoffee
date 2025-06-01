package com.proyecto.velvetCoffee.controller;

public class AuthResponse {

    // atributos
    private String jwt;


    // contructor
    public  AuthResponse(String jwt) {
        this.jwt = jwt;
    }


    // getter y setter
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
