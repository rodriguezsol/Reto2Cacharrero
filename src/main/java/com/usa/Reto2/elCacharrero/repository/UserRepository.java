/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.Reto2.elCacharrero.repository;

import com.usa.Reto2.elCacharrero.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.Reto2.elCacharrero.crudRepository.UserCrudRepository;

/**
 *
 * @author solecito
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * consultar usuario
     *
     * @return
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * usuario por id
     *
     * @param id
     * @return
     */
    public Optional<User> getUserById(Integer id) {
        return userCrudRepository.findById(id);
    }

    /**
     * crear usuarios
     *
     * @param user
     * @return
     */

    public User save(User user) {
        return userCrudRepository.save(user);
    }

    /**
     * Actualizar usuarios
     *
     * @param user
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }

    /**
     * Eliminar usuario
     *
     * @param user
     */
    public void deleteById(Integer id) {
        userCrudRepository.deleteById(id);
    }

    /**
     * validar si existe email
     *
     * @param email
     * @return
     */
    public boolean getUserByEmail(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    /**
     * para consultar la autenticacion de email y password
     *
     * @param email
     * @param password
     * @return
     */
    public Optional<User> getUserEmailAndPassword(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

}
