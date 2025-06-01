package com.proyecto.velvetCoffee.repository;

import com.proyecto.velvetCoffee.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// inyectamos la dependencia @Repository
@Repository("jpaCafeRepository")
public interface JPACafeRepository extends JpaRepository  <Coffee, Long> {


}
