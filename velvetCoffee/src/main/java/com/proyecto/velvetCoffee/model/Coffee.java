package com.proyecto.velvetCoffee.model;

import java.util.Date;
import java.util.List;


import jakarta.persistence.*;

@Entity
@Table(name = "coffee_Shop")

public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)// La anotación del atributo id será Auto Incrementable
    private Integer id;

    //      Hacemos llamamiento de la anotación @Collumn "paisOrigen", no acepta valores nulos (nullable), con un máximo de 70 caracteres (length) estos datos se vinculan con la base de datos de manera automática, una vez sincronice todo lo necesario
    @Column(name = "nombre", nullable = false, length = 90)
    private String nombre;

    @Column(name = "pais_Origen", nullable = false, length = 70)
    private String pais_Origen;

    @Column(name = "region", nullable = false, length = 100)
    private String region;

    @Column(name = "altitud", nullable = false, length = 50)
    private int altitud;

    @Column(name = "variedad")
    private String variedad;


    @Column(name = "descripcion", nullable = true, length = 250)
    private String descripcion;

    @Column(name = "formato", nullable = false)
    private String formato;

    @Column(name = "codigo_Barras", nullable = false, scale = 13)
    private String codigo_Barras;

    @Column(name = "precio_Unidad", nullable = false)
    private Long precio_Unidad;
    @Column(name = "peso_Unidad", nullable = false)
    private double peso_Unidad;

    @Temporal(TemporalType.DATE)  // esto me indica que, llegada la fecha de caducidad, se elimina
    @Column(name = "fecha_Caducidad", nullable = false)
    private Date fecha_Caducidad;

    @Column(name = "stock_Disponible")
    private int stock_Disponible;

    @Column(name = "estado_actual", nullable = false)
    private boolean estadoActual;

    @Column(name = "is_En_Oferta")
    private boolean is_En_Oferta;

    @Column(name = "tipo_Moneda", nullable = false)
    private String tipo_Moneda;

    @Column(name = "aroma", nullable = false)
    private String aroma;

    @ElementCollection
    @CollectionTable(name = "coffee_sensacion_paladar", joinColumns = @JoinColumn(name = "coffee_id"))
    @Column(name = "sensacion_paladar", nullable = false)
    private List<String> sensacion_Paladar;  // Ej: ["Denso", "Medio"]

    @ElementCollection
    @CollectionTable(name = "coffee_dulzor", joinColumns = @JoinColumn(name = "coffee_id"))
    @Column(name = "dulzor", nullable = false)
    private List<String> dulzor; // Ej: ["Media", "Brillante", "Alta", "Muy Alta", "Baja", "Muy baja"]

    @Column(name = "acidez", nullable = false)
    private List<String> acidez;   // Ej: ["Media", "Brillante", "Alta", "Muy Alta", "Baja", "Muy baja"]

    @ElementCollection
    @CollectionTable(name = "coffee_sabor", joinColumns = @JoinColumn(name = "coffee_id"))
    @Column(name = "sabor", nullable = false)
    private List <String> sabor;  // Ej: [Dulce y Frutal --> [Dulce, frutos rojos y miel", "Azúcar moreno, manzana, canela"] , || ÁCIDO Y CÍTRICO --> ["Acidez brillante, limón" , "Mandarina, té verde, floral", Toronja, panela, té jazmín"] || DULCE Y FLORAL --> ["Miel, jazmín, lavanda", "Azúcar moreno, rosa, durazno", "Caramelo, flor de azahar, albaricoque"] || AMARGO Y CHOCOLATEADO --> ["Cacao amargo, nuez, tierra húmeda", "Chocolate oscuro, tabaco, especias", Madera, avellana, café tostado"] || FRUTAL Y ESPECIADO --> ["Frutas tropicales, jengibre", "Mango, pimienta rosa, panela", Papaya, canela, clavo"] || CÍTRICO Y HERBAL --> ["lima, menta, manzanilla", "Pomelo, hierba luisa, albahaca", Cítricos, eucalipto, té verde"] || CUERPO ALTO Y DULZOR INTENSO --> ["Melaza, cacao, pasas", "Dátil, vainilla, chocolate con leche", "Miel espesa, almendra, sirope"]

    @Column(name = "puntaje_especializado", nullable = false)
    private Double puntaje_Especializado;  // puntuación de catadores sobre 100

    @Column(name = "perfil_sensorial", nullable = false, length = 250)
    private String perfil_Sensorial;  // descripción breve de cada uno por grupos de List <String> Sabor , por grupos, NO unidades

    @Column(name = "grado_tostado")
    private String grado_tostado; // EJ: Claro, medio, oscuro

    @Column(name = "certificaciones",nullable = false)
    private String certificacion;

    @Column(name = "almacenamiento_recomendado", nullable = false)
    private String almacenamiento_Recomendado;  // 	Condiciones ideales de conservación (buscar diferentes formas)

    @Column(name = "metodo_preparacion_sugerido", nullable = false,length = 250)
    private String metodo_Preparacion_Sugerido;  // aquí, añadiré el método más acorde de preparación de cada uno de los productos. EJ: 	V60, prensa francesa, espresso, etc.



    // getters y setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOrigen() {
        return pais_Origen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.pais_Origen = paisOrigen;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getAltitud() {
        return altitud;
    }

    public void setAltitud(int altitud) {
        this.altitud = altitud;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getCodigo_Barras() {
        return codigo_Barras;
    }

    public void setCodigo_Barras(String codigo_Barras) {
        this.codigo_Barras = codigo_Barras;
    }

    public Long getPrecio_Unidad() {
        return precio_Unidad;
    }

    public void setPrecio_Unidad(Long precio_Unidad) {
        this.precio_Unidad = precio_Unidad;
    }

    public double getPeso_Unidad() {
        return peso_Unidad;
    }

    public void setPeso_Unidad(double peso_Unidad) {
        this.peso_Unidad = peso_Unidad;
    }

    public Date getFecha_Caducidad() {
        return fecha_Caducidad;
    }

    public void setFecha_Caducidad(Date fecha_Caducidad) {
        this.fecha_Caducidad = fecha_Caducidad;
    }

    public int getStock_Disponible() {
        return stock_Disponible;
    }

    public void setStock_Disponible(int stock_Disponible) {
        this.stock_Disponible = stock_Disponible;
    }

    public boolean is_Estado_Actual() {
        return false;
    }


    public void setIs_Estado_Actual(boolean is_Estado_Actual) {
        this.estadoActual = is_Estado_Actual;
    }

    public boolean is_En_Oferta() {
        return is_En_Oferta;
    }

    public void setIs_En_Oferta(boolean is_En_Oferta) {
        this.is_En_Oferta = is_En_Oferta;
    }

    public String getTipo_Moneda() {
        return tipo_Moneda;
    }

    public void setTipoMoneda(String tipo_Moneda) {
        this.tipo_Moneda = tipo_Moneda;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public List<String> getSensacion_Paladar() {
        return sensacion_Paladar;
    }

    public void setSensacion_Paladar(List<String> sensacion_Paladar) {
        this.sensacion_Paladar = sensacion_Paladar;
    }

    public List<String> getDulzor() {
        return dulzor;
    }

    public void setDulzor(List<String> dulzor) {
        this.dulzor = dulzor;
    }

    public List<String> getAcidez() {
        return acidez;
    }

    public void setAcidez(List<String> acidez) {
        this.acidez = acidez;
    }

    public List<String> getSabor() {
        return sabor;
    }

    public void setSabor(List<String> sabor) {
        this.sabor = sabor;
    }

    public Double getPuntaje_Especializado() {
        return puntaje_Especializado;
    }

    public void setPuntaje_Especializado(Double puntaje_Especializado) {
        this.puntaje_Especializado = puntaje_Especializado;
    }

    public String getPerfil_Sensorial() {
        return perfil_Sensorial;
    }

    public void setPerfil_Sensorial(String perfil_Sensorial) {
        this.perfil_Sensorial = perfil_Sensorial;
    }

    public String getGrado_tostado() {
        return grado_tostado;
    }

    public void setGrado_tostado(String grado_tostado) {
        this.grado_tostado = grado_tostado;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    public String getAlmacenamiento_Recomendado() {
        return almacenamiento_Recomendado;
    }

    public void setAlmacenamiento_Recomendado(String almacenamiento_Recomendado) {
        this.almacenamiento_Recomendado = almacenamiento_Recomendado;
    }

    public String getMetodo_Preparacion_Sugerido() {
        return metodo_Preparacion_Sugerido;
    }

    public void setMetodo_Preparacion_Sugerido(String metodo_Preparacion_Sugerido) {
        this.metodo_Preparacion_Sugerido = metodo_Preparacion_Sugerido;
    }
}


