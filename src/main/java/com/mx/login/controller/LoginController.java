package com.mx.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mx.login.model.Login;
import com.mx.login.service.LoginInterfaceService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class LoginController {

    
    @Autowired
    LoginInterfaceService service;
    @PostMapping(value = "/crearLogin")
    public Login crearLogin(@RequestBody Login login) {
        Login crear = null;
        try {
            crear = service.crearLogin(login);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return crear;
    }

    @GetMapping(value = "/buscarLogin")
    public Login buscarLogin(@RequestBody Login login) {
        Login buscar = null;
        try {
            buscar = service.buscarLogin(login);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return buscar;
    }

    @PutMapping(value = "actualizarLogin/{idLogin}")
    public Login actualizarLogin(@RequestBody Login login, @PathVariable int idLogin) {
        Login actualizar = null;
        try {
            actualizar = service.actualizarLogin(login, idLogin);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actualizar;

    }

    @DeleteMapping(value = "/eliminarLogin/{idLogin}")
    public void eliminarLogin(@PathVariable int idLogin) {
        try {
            service.eliminarLogin(idLogin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}