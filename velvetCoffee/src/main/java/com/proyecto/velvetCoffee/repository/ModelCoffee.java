package com.proyecto.velvetCoffee.repository;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


/*@Entity
@Table(name = "cafes")*/


public class ModelCoffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombres")
    private String name;

    @Column(name = "nombre", nullable = false, length = 90)
    private String nombre;

    @Column(name = "pais_Origen", nullable = false, length = 70)
    private String paisOrigen;

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
    private String codigoBarras;

    @Column(name = "precio_Unidad", nullable = false)
    private double precioUnidad;

    @Column(name = "peso_Unidad", nullable = false)
    private double peso_Unidad;

    @Temporal(TemporalType.DATE)  // esto me indica que, llegada la fecha de caducidad, se elimina
    @Column(name = "fecha_Caducidad", nullable = false)
    private Date fechaCaducidad;

    @Column(name = "stock_Disponible")
    private int stockDisponible;

    @Column(name = "estado_actual", nullable = false)
    private boolean estadoActual;

    @Column(name = "is_en_Oferta")
    private boolean isEnOferta;

    @Column(name = "tipo_Moneda", nullable = false)
    private String tipoMoneda;

    @Column(name = "aroma", nullable = false)
    private String aroma;

    @ElementCollection
    @CollectionTable(name = "coffee_sensacion_paladar", joinColumns = @JoinColumn(name = "coffee_id"))
    @Column(name = "sensacion_paladar", nullable = false)
    private List<String> sensacionPaladar;  // Ej: ["Denso", "Medio"]

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
    private Double puntajeEspecializado;  // puntuación de catadores sobre 100

    @Column(name = "perfil_sensorial", nullable = false, length = 250)
    private String perfilSensorial;  // descripción breve de cada uno por grupos de List <String> Sabor , por grupos, NO unidades

    @Column(name = "grado_tostado")
    private String gradoTostado; // EJ: Claro, medio, oscuro

    @Column(name = "certificaciones",nullable = false)
    private String certificacion;

    @Column(name = "almacenamiento_recomendado", nullable = false)
    private String almacenamientoRecomendado;  // 	Condiciones ideales de conservación (buscar diferentes formas)

    @Column(name = "metodo_preparacion_sugerido", nullable = false,length = 250)
    private String metodoPreparacionSugerido;  // aquí, añadiré el método más acorde de preparación de cada uno de los productos. EJ: 	V60, prensa francesa, espresso, etc.


    // 3º)
    public void Cafe(Long id, String nombre, String paisOrigen, String region, int altitud,
                     String variedad, String descripcion, String formato, String codigoBarras,
                     double precioUnidad, double peso_Unidad, Date fechaCaducidad, int stockDisponible,
                     boolean estadoActual, boolean isEnOferta, String tipoMoneda, String aroma,
                     List<String> sensacionPaladar, List<String> dulzor, List<String> acidez, List<String> sabor,
                     Double puntajeEspecializado, String perfilSensorial, String gradoTostado, String certificacion,
                     String almacenamientoRecomendado, String metodoPreparacionSugerido) {


        this.id = id;
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.region = region;
        this.altitud = altitud;
        this.variedad = variedad;
        this.descripcion = descripcion;
        this.formato = formato;
        this.codigoBarras = codigoBarras;
        this.precioUnidad = precioUnidad;
        this.peso_Unidad = peso_Unidad;
        this.fechaCaducidad = fechaCaducidad;
        this.stockDisponible = stockDisponible;
        this.estadoActual = estadoActual;
        this.isEnOferta = isEnOferta;
        this.tipoMoneda = tipoMoneda;
        this.aroma = aroma;
        this.sensacionPaladar = sensacionPaladar;
        this.dulzor = dulzor;
        this.acidez = acidez;
        this.sabor = sabor;
        this.puntajeEspecializado = puntajeEspecializado;
        this.perfilSensorial = perfilSensorial;
        this.gradoTostado = gradoTostado;
        this.certificacion = certificacion;
        this.almacenamientoRecomendado = almacenamientoRecomendado;
        this.metodoPreparacionSugerido = metodoPreparacionSugerido;
    }


    // 4º)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
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

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public double getPeso_Unidad() {
        return peso_Unidad;
    }

    public void setPeso_Unidad(double peso_Unidad) {
        this.peso_Unidad = peso_Unidad;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public boolean isEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(boolean estadoActual) {
        this.estadoActual = estadoActual;
    }

    public boolean isEnOferta() {
        return isEnOferta;
    }

    public void setEnOferta(boolean enOferta) {
        isEnOferta = enOferta;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public List<String> getSensacionPaladar() {
        return sensacionPaladar;
    }

    public void setSensacionPaladar(List<String> sensacionPaladar) {
        this.sensacionPaladar = sensacionPaladar;
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

    public Double getPuntajeEspecializado() {
        return puntajeEspecializado;
    }

    public void setPuntajeEspecializado(Double puntajeEspecializado) {
        this.puntajeEspecializado = puntajeEspecializado;
    }

    public String getPerfilSensorial() {
        return perfilSensorial;
    }

    public void setPerfilSensorial(String perfilSensorial) {
        this.perfilSensorial = perfilSensorial;
    }

    public String getGradoTostado() {
        return gradoTostado;
    }

    public void setGradoTostado(String gradoTostado) {
        this.gradoTostado = gradoTostado;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    public String getAlmacenamientoRecomendado() {
        return almacenamientoRecomendado;
    }

    public void setAlmacenamientoRecomendado(String almacenamientoRecomendado) {
        this.almacenamientoRecomendado = almacenamientoRecomendado;
    }

    public String getMetodoPreparacionSugerido() {
        return metodoPreparacionSugerido;
    }

    public void setMetodoPreparacionSugerido(String metodoPreparacionSugerido) {
        this.metodoPreparacionSugerido = metodoPreparacionSugerido;
    }

}
