package com.proyecto.velvetCoffee.service;


import com.proyecto.velvetCoffee.model.Coffee;
import com.proyecto.velvetCoffee.repository.JPACafeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.lang.Long;


@Service
public class ServiceCoffee {


    // atributo
    private final JPACafeRepository coffeeRepository;


    // constructor
    public ServiceCoffee(@Qualifier("jpaCafeRepository") JPACafeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public Coffee save(Coffee cafe) {
        return coffeeRepository.save(cafe);

    }

    public Coffee deleteCafe(Long cafeId) {
        Coffee cafe = coffeeRepository.findById(cafeId)
                .orElseThrow(() -> new RuntimeException("Cafe no encontrado con id: " + cafeId + "."));
                coffeeRepository.deleteById(cafeId);

        return cafe;
    }



    public Optional<Coffee> getById(Long cafeId) {
        return coffeeRepository.findById(cafeId);

    }

    public List<Coffee> getAll() {
        return (List<Coffee>) coffeeRepository.findAll();
    }

    public static Page<Coffee> getAll(int page, int pageFormato) {
        Pageable pageable = PageRequest.of(page, pageFormato);
        return coffeeRepository.findAll(pageable);
    }

    public Coffee update(Long id, Coffee coffee) {
        Coffee cafeExistente = getById(id).orElseThrow(() ->
                new NoSuchElementException("Café con id " + id + " no encontrado."));


        BeanUtils.copyProperties(coffee, cafeExistente, "id");

        return coffeeRepository.save(cafeExistente);
    }


        // Actualizamos los campos, la anotación de aquí arriba
        // 'BeanUtils.copyProperties(coffee, cafeExistente, "id"', sobreescribe los atributos sin necesidad de escribirlos uno a uno


       /** cafeExistente.setNombre(coffee.getNombre());
        cafeExistente.setPaisOrigen(coffee.getPaisOrigen());
        cafeExistente.setRegion(coffee.getRegion());
        cafeExistente.setAltitud(coffee.getAltitud());
        cafeExistente.setVariedad(cafeExistente.getVariedad());
        cafeExistente.setDescripcion(coffee.getDescripcion());
        cafeExistente.setFormato(coffee.getFormato());
        cafeExistente.setCodigoBarras(coffee.getCodigoBarras());
        cafeExistente.setPrecioUnidad(coffee.getPrecioUnidad());
        cafeExistente.setPeso_Unidad(coffee.getPeso_Unidad());
        cafeExistente.setFechaCaducidad(coffee.getFechaCaducidad());
        cafeExistente.setStockDisponible(coffee.getStockDisponible());
        cafeExistente.setEstadoActual(coffee.isEstadoActual());
        cafeExistente.setEnOferta(coffee.isEnOferta());
        cafeExistente.setTipoMoneda(coffee.getTipoMoneda());
        cafeExistente.setAroma(coffee.getAroma());
        cafeExistente.setSensacionPaladar(coffee.getSensacionPaladar());
        cafeExistente.setDulzor(coffee.getDulzor());
        cafeExistente.setAcidez(coffee.getAcidez());
        cafeExistente.setSabor(coffee.getSabor());
        cafeExistente.setPuntajeEspecializado(coffee.getPuntajeEspecializado());
        cafeExistente.setPerfilSensorial(coffee.getPerfilSensorial());
        cafeExistente.setGradoTostado(coffee.getGradoTostado());
        cafeExistente.setCertificacion(coffee.getCertificacion());
        cafeExistente.setAlmacenamientoRecomendado(coffee.getAlmacenamientoRecomendado());
        cafeExistente.setMetodoPreparacionSugerido(coffee.getMetodoPreparacionSugerido());
*/


    }




