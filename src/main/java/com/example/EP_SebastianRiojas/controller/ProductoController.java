/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EP_SebastianRiojas.controller;

import com.example.EP_SebastianRiojas.entity.Producto;
import com.example.EP_SebastianRiojas.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Sebastian
 */
@Controller
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;
    @RequestMapping("/productos")
    public String producto(Model model){
        model.addAttribute("productos",productoRepository.findAll());
    return "producto";
    }
    @RequestMapping("/formprodu")
    public String create(Model model) {
        return "addProducto";
    }
    @RequestMapping("/addProducto")
    public String guardarprodu(@RequestParam String producto, @RequestParam double precio,@RequestParam int stock, Model model) {
        Producto produ = new Producto();
        produ.setProducto(producto);
        produ.setPrecio(precio);
        produ.setStock(stock);
        System.out.println("sout:"+produ.getProducto()+" / "+produ.getPrecio()+" / "+produ.getStock());
        productoRepository.save(produ);
        return "redirect:/productos";
    }
    @RequestMapping("/delprodu/{id}")
    public String deleteprodu(@PathVariable(value="id") Long id) {
        System.out.println("ID: "+id);
        Producto produ = productoRepository.findById(id).orElse(null);
        productoRepository.delete(produ);
        return "redirect:/productos";
    }
    @RequestMapping("/editprodu/{id}")
    public String editprodu(@PathVariable(value="id") Long id, Model model) {
        model.addAttribute("producto", productoRepository.findById(id).orElse(null));
        return "editProducto";
    }
    @RequestMapping("/updateprodu")
    public String updateprodu(@RequestParam Long id, @RequestParam String producto, @RequestParam double precio,@RequestParam int stock) {
        Producto produ = productoRepository.findById(id).orElse(null);
        produ.setProducto(producto);
        produ.setPrecio(precio);
        produ.setStock(stock);
        productoRepository.save(produ);
        return "redirect:/productos";
    }
    
    
    
    
}
