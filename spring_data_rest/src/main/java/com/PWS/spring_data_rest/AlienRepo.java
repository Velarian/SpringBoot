package com.PWS.spring_data_rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.PWS.spring_data_rest.model.Alien;

@RepositoryRestResource(collectionResourceRel = "aliens",path = "aliens")
public interface AlienRepo extends JpaRepository<Alien, Integer> {
    
    
    
    

}
