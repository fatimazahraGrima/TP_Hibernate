/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.dao;

import java.util.List;

public interface IDao<T> {
    
    boolean create(T o);     // Method to create a new entity

    T getById(int id);       // Method to retrieve an entity by its ID

    List<T> getAll();        // Method to retrieve all entities
}

