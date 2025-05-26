package com.proyecto.velvetCoffee.model;

import java.util.Date;
import java.util.List;


import jakarta.persistence.*;

@Entity
@Table(name = "coffeeShop")

public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // La anotación del atributo id será Auto Incrementable
    private Integer idCafe;

    //      Hacemos llamamiento de la anotación @Collumn "paisOrigen", no acepta valores nulos (nullable), con un máximo de 70 caracteres (length) estos datos se vinculan con la base de datos de manera automática, una vez sincronice todo lo necesario
    @Column(name = "País de Origen", nullable = false, length = 70)
    private String paisOrigen;

    @Column(name = "Región", nullable = false, length = 100)
    private String regionOrigen;

    @Column(name = "Altitud", nullable = false, length = 50)
    private int altitud;

    @Column(name = "Variedad")
    private Date variedad;

    @Column(name = "Marca", nullable = false, length = 90)
    private String nombreComercial;

    @Column(name = "Descripción del producto", length = 250)
    private String descripcionProducto;

    @Column(name = "Formato", nullable = false)
    private String formatoVenta;

    @Column(name = "Peso unitario", nullable = false)
    private double pesoGramos;

    @Column(name = "Fecha de caducidad", nullable = false)
    private int vidaUtil;

    @Column(name = "Código de Barras", nullable = false)
    private String codigoBarras;

    @Column(name = "Precio/Unidad", nullable = false)
    private Long precioUnitario;

    @Column(name = "Stock disponible")
    private int stockDisponible;

    @Column(name = "Estado", nullable = false)
    private boolean isEstadoActual;

    @Column(name = "Oferta~$")
    private boolean isEnOferta;

    @Column(name = "USD|EUR|YEN|PEN", nullable = false)
    private String tipoMoneda;

    @Column(name = "Aroma", nullable = false)
    private String aroma;

    @Column(name = "Sensación", nullable = false)
    private List<String> SensacionSorber;  // Ej: ["Denso", "Medio"]

    @Column(name = "Dulzor", nullable = false)
    private List<String> Dulzor; // Ej: ["Media", "Brillante", "Alta", "Muy Alta", "Baja", "Muy baja"]

    @Column(name = "Acidez", nullable = false)
    private List<String> Acidez;   // Ej: ["Media", "Brillante", "Alta", "Muy Alta", "Baja", "Muy baja"]

    @Column(name = "Sabores", nullable = false)
    private List <String> Sabor;  // Ej: [Dulce y Frutal --> [Dulce, frutos rojos y miel", "Azúcar moreno, manzana, canela"] , || ÁCIDO Y CÍTRICO --> ["Acidez brillante, limón" , "Mandarina, té verde, floral", Toronja, panela, té jazmín"] || DULCE Y FLORAL --> ["Miel, jazmín, lavanda", "Azúcar moreno, rosa, durazno", "Caramelo, flor de azahar, albaricoque"] || AMARGO Y CHOCOLATEADO --> ["Cacao amargo, nuez, tierra húmeda", "Chocolate oscuro, tabaco, especias", Madera, avellana, café tostado"] || FRUTAL Y ESPECIADO --> ["Frutas tropicales, jengibre", "Mango, pimienta rosa, panela", Papaya, canela, clavo"] || CÍTRICO Y HERBAL --> ["lima, menta, manzanilla", "Pomelo, hierba luisa, albahaca", Cítricos, eucalipto, té verde"] || CUERPO ALTO Y DULZOR INTENSO --> ["Melaza, cacao, pasas", "Dátil, vainilla, chocolate con leche", "Miel espesa, almendra, sirope"]

    @Column(name = "Puntuación Especializada", nullable = false)
    private Double puntajeEspecializado;  // puntuación de catadores sobre 100

    @Column(name = "Análisis sensorial", nullable = false, length = 250)
    private String perfilSensorial;  // descripción breve de cada uno por grupos de List <String> Sabor , por grupos, NO unidades

    @Column(name = "Grado de tostado")
    private String gradoTostado; // EJ: Claro, medio, oscuro

    @Column(name = "Certificaciones",nullable = false)
    private String certificacion;

    @Column(name = "Almacenamiento recomendado", nullable = false)
    private String almacenamientoRecomendado;  // 	Condiciones ideales de conservación (buscar diferentes formas)

    @Column(name = "Método de Preparación Recomendable", nullable = false,length = 250)
    private String metodoPreparacionSugerido;  // aquí, añadiré el método más acorde de preparación de cada uno de los productos. EJ: 	V60, prensa francesa, espresso, etc.


    // getters y setters
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getRegionOrigen() {
        return regionOrigen;
    }

    public void setRegionOrigen(String regionOrigen) {
        this.regionOrigen = regionOrigen;
    }

    public int getAltitud() {
        return altitud;
    }

    public void setAltitud(int altitud) {
        this.altitud = altitud;
    }

    public Date getVariedad() {
        return variedad;
    }

    public void setVariedad(Date variedad) {
        this.variedad = variedad;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getFormatoVenta() {
        return formatoVenta;
    }

    public void setFormatoVenta(String formatoVenta) {
        this.formatoVenta = formatoVenta;
    }

    public double getPesoGramos() {
        return pesoGramos;
    }

    public void setPesoGramos(double pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public boolean isEstadoActual() {
        return isEstadoActual;
    }

    public void setEstadoActual(boolean estadoActual) {
        isEstadoActual = estadoActual;
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

    public List<String> getSensacionSorber() {
        return SensacionSorber;
    }

    public void setSensacionSorber(List<String> sensacionSorber) {
        SensacionSorber = sensacionSorber;
    }

    public List<String> getDulzor() {
        return Dulzor;
    }

    public void setDulzor(List<String> dulzor) {
        Dulzor = dulzor;
    }

    public List<String> getAcidez() {
        return Acidez;
    }

    public void setAcidez(List<String> acidez) {
        Acidez = acidez;
    }

    public List<String> getSabor() {
        return Sabor;
    }

    public void setSabor(List<String> sabor) {
        Sabor = sabor;
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

