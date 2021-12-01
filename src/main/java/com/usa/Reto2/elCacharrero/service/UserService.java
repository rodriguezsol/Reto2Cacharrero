/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.Reto2.elCacharrero.service;

import com.usa.Reto2.elCacharrero.model.User;
import com.usa.Reto2.elCacharrero.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Aqui va la logica de negocios "las validaciones"
 * @author solecito
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * consultar
     *
     * @return
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<User> getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    /**
     * crear usuarios
     *
     * @param user
     * @return
     */
     public User save(User user) {
        if (user.getIdentification()== null ||user.getName() == null || user.getEmail() == null || user.getPassword() == null || user.getType()== null) {
            return user;
        } else {
            Optional<User> existUser = userRepository.getUserById(user.getId());
            if (existUser.isEmpty()) {
                if (getUserByEmail(user.getEmail()) == false) {
                    return userRepository.save(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
     }
 

    

    /**
     * Actualizar usuarios
     *
     * @param user
     * @return
     */
    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userExist = userRepository.getUserById(user.getId());
            if (!userExist.isEmpty()) {
                if (user.getIdentification() != null) {
                    userExist.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userExist.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userExist.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userExist.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userExist.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userExist.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userExist.get().setZone(user.getZone());
                }

               return userRepository.save(userExist.get());
                
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     * Eliminar Usuarios
     *
     * @param userId
     * @return
     */
    public boolean deleteById(Integer id) {
        Boolean aBoolean = getUserById(id).map(user -> {
            userRepository.deleteById(id);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * validar si existe email
     *
     * @param email
     * @return
     */
    public boolean getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    /**
     * Autenticación
     *
     * @param email
     * @param password
     * @return
     */
    public User getByEmailPass(String email, String password) {
        Optional<User> userExist = userRepository.getUserEmailAndPassword(email, password);

        if (userExist.isPresent()) {
            return userExist.get();
            
        } else {
           return new User(); 
        }
    }

}
