package com.WebApp.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.WebApp.demo.model.Alien;



public interface AlienRepo extends JpaRepository<Alien, Integer>{
  List<Alien> findBylanguage(String language);
  List<Alien> findByaidGreaterThan(int aid);
  List<Alien> findByaidLessThan(int aid);
  
  @Query("from Alien where language=?1 order by aname")
  List<Alien> findBylanguageSorted(String language);
  

}
