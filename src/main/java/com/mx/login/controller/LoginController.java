package com.mx.login.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public ResponseEntity<?> crearLogin(@RequestBody Login login) {
        Login recuperado = service.buscarPorUsuario(login.getUsuario());
        if(recuperado == null){
            service.crearLogin(login);
            System.out.println( login.toString());       
        return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("exito","el usuario se a guardado correctamente"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","el usuario ya se encuentra registrado"));
    }
    
    @PostMapping(value = "/buscarLogin")
    public ResponseEntity<?> buscarLogin(@RequestBody Login login) {
            Login buscar = service.buscarLogin(login);
            if (buscar != null) {
            return ResponseEntity.status(HttpStatus.OK).body(buscar);     
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","usuario no encontrado"));
    }

    @PutMapping(value = "actualizarLogin/{idLogin}")
    public ResponseEntity<?> actualizarLogin(@RequestBody Login login, @PathVariable int idLogin) {
        boolean recuperado = service.buscarPorId(idLogin);
        if(recuperado == true){
             service.actualizarLogin(login, idLogin);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("exito","el usuario se a actualizado correctamente"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","usuario no encontrado"));
    }

    

    @DeleteMapping(value = "/eliminarLogin/{idLogin}")
    public ResponseEntity<?> eliminarLogin(@PathVariable int idLogin) {
        boolean recuperado = service.buscarPorId(idLogin);
        if(recuperado == true){
             service.eliminarLogin(idLogin);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("exito","el usuario se a eliminado correctamente"));
        }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","usuario no encontrado"));
    }
}
    
