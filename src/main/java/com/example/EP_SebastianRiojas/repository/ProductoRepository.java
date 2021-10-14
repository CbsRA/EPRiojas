/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EP_SebastianRiojas.repository;

import com.example.EP_SebastianRiojas.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sebastian
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
