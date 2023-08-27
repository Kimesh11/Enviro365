package com.enviro.assessment.grad001.kimeshNagiah.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.enviro.assessment.grad001.kimeshNagiah.model.Products;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Integer>{

	Products findByuserId(int userid);
}
