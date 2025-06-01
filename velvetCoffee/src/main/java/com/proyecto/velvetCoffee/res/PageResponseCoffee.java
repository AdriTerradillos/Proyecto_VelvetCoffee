package com.proyecto.velvetCoffee.res;

import com.proyecto.velvetCoffee.model.Coffee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// importar librerías lombok, lo utilizamos para decirle al código que no hace falta sobreescribir el contructor, getters y setters de la clase

@Data
@NoArgsConstructor
@AllArgsConstructor;

public class PageResponseCoffee {

    // generamos atributos

    private List<Coffee> cafes;
    private int totalElementos;
    private int totalPaginas;
    private int paginaActual;





}
