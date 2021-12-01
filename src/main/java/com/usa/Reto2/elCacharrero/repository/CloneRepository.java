/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.Reto2.elCacharrero.repository;

import com.usa.Reto2.elCacharrero.model.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.Reto2.elCacharrero.crudRepository.CloneCrudRepository;

/**
 *
 * @author solecito
 */
@Repository
public class CloneRepository {

    @Autowired
    private CloneCrudRepository repository;

    /**
     * consultar
     *
     * @return
     */

    public List<Clone> getAll() {
        return repository.findAll();
    }

    /**
     * consultar id
     *
     * @param id
     * @return
     */
    public Optional<Clone> getClones(Integer id) {
        return repository.findById(id);
    }

    /**
     * crear clone
     *
     * @param clone
     * @return
     */
    public Clone save(Clone clone) {
        return repository.save(clone);
    }

    /**
     * Actualizar clone
     *
     * @param clone
     */
    public void update(Clone clone) {
        repository.save(clone);
    }

    /**
     * Eliminar clone
     *
     * @param clone
     */

    public void delete(Clone clone) {
        repository.delete(clone);
    }
}
