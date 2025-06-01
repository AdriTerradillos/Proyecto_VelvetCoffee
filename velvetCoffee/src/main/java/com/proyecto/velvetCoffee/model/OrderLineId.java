package com.proyecto.velvetCoffee.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class OrderLineId implements Serializable {


    // generamos los atributos de la clase OrderLineId

    private String orderId;
    private String coffeeId;


    // hacenmos llamamiento al método OrderLineId()

    public OrderLineId() {}


    // generamos contructor

    public OrderLineId(String orderId, String coffeeId) {
        this.orderId = orderId;
        this.coffeeId = coffeeId;
    }


    // getters y setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(String coffeeId) {
        this.coffeeId = coffeeId;
    }


    // sobreescribimos método(s) @Override

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderLineId that)) return false;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(coffeeId, that.coffeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, coffeeId);
    }
}


