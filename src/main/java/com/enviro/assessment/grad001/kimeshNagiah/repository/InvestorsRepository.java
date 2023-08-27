package com.enviro.assessment.grad001.kimeshNagiah.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.kimeshNagiah.model.Investors;

@Repository
public interface InvestorsRepository extends CrudRepository<Investors, Integer> {

}
