package com.programmingsharing.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.programmingsharing.demo.entities.Country;

@Repository
public interface CountryRepository extends CrudRepository<Integer, Country> {

}
