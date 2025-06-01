package com.proyecto.velvetCoffee.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_header")

public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String idUsuario;
    private double precioTotal;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderLine> orderLines;

    public Order() {
    }

    public Order(String id, String IdUsuario, List<OrderLine> orderLines) {
        this.id = id;
        this.idUsuario = IdUsuario;
        this.orderLines = orderLines;
        this.precioTotal = calculateprecioTotal(orderLines);
    }

    private double calculateprecioTotal(List<OrderLine> orderLines) {
        return 0;
    }

    private double calculateTotalAmount(List<OrderLine> orderLines ) {
        return orderLines.stream()
                .mapToDouble(line -> line.getPrecio() * line.getCantidad())
                .sum();
    }



 // getters and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}


