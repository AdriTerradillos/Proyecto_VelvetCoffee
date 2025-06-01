package com.proyecto.velvetCoffee.model;

import jakarta.persistence.*;


/**
 * --PAUTAS--
 * 1º) generamos las anotaciones y dependencias correspondientes '@Entity' y @Embeddable + Atributos de la clase
 * 2º) hacemos llamamiento a método de la clase Usuario()
 * 3º) generamos contructor
 * 4º) getters y setters
 */


// 1º)
@Entity
@Embeddable

public class OrderLine {

    private OrderLineId id;
    private double precio;
    private int cantidad;


    @MapsId("orderId")
    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;


    // 2º)
    public OrderLine() {
    }


    // 3º)
    public OrderLine(Order order, String coffeeId, double precio, int cantidad) {
        this.id = new OrderLineId(order.getId(), coffeeId);
        this.precio = precio;
        this.cantidad = cantidad;
    }


    // 4º)
    public OrderLineId getId() {
        return id;
    }

    public void setId(OrderLineId id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

