/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EP_SebastianRiojas.controller;

import com.example.EP_SebastianRiojas.entity.Categoria;
import com.example.EP_SebastianRiojas.repository.CategoriaRepository;
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
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @RequestMapping("/menu")
    public String menu(Model model){
    return "menu";
    }
    @RequestMapping("/categorias")
    public String categoria(Model model){
        model.addAttribute("categorias",categoriaRepository.findAll());
    return "categoria";
    }
    @RequestMapping("/formcate")
    public String createcate(Model model) {
        return "addCategoria";
    }
    @RequestMapping("/addCategoria")
    public String guardarcate(@RequestParam String categoria, Model model) {
        Categoria catego = new Categoria();
        catego.setCategoria(categoria);
        System.out.println("sout:"+catego.getCategoria());
        categoriaRepository.save(catego);
        return "redirect:/categorias";
    }
    @RequestMapping("/delcate/{id}")
    public String deletecate(@PathVariable(value="id") Long id) {
        System.out.println("ID: "+id);
        Categoria produ = categoriaRepository.findById(id).orElse(null);
        categoriaRepository.delete(produ);
        return "redirect:/categorias";
    }
    @RequestMapping("/editcate/{id}")
    public String editcate(@PathVariable(value="id") Long id, Model model) {
        model.addAttribute("categoria", categoriaRepository.findById(id).orElse(null));
        return "editCategoria";
    }
    @RequestMapping("/updatecate")
    public String updatecate(@RequestParam Long id, @RequestParam String categoria) {
        Categoria catego = categoriaRepository.findById(id).orElse(null);
        catego.setCategoria(categoria);
        categoriaRepository.save(catego);
        return "redirect:/categorias";
    }
}
