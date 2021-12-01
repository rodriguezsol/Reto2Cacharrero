/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.Reto2.elCacharrero.crudRepository;

import com.usa.Reto2.elCacharrero.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author solecito
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
     /**
     * 
     * @Es como en Sql select * from user where user_name=""
     * @return 
     */
   public Optional<User> findByName(String name);
   /**
    * 
    * @select * from user where user_email=""
    *  
    */
   public Optional<User> findByEmail(String Email);
    /**
     * select *FROM user WHERE user_name="" or user_email=""
     */
   public List<User> findByNameOrEmail(String name,String email);
   /**
    * 
    * @param email
    * @param password
    * @return 
    */
   
   public Optional<User> findByEmailAndPassword(String email, String password);
}

