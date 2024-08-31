package com.sabassoft.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sabassoft.apirest.apirest.Entities.Productos;

public interface ProductRepository extends JpaRepository<Productos, Long> {

}
