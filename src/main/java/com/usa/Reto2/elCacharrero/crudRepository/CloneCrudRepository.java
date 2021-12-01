/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.Reto2.elCacharrero.crudRepository;


import com.usa.Reto2.elCacharrero.model.Clone;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author solecito
 */
public interface CloneCrudRepository extends MongoRepository<Clone, Integer> {
    
}
