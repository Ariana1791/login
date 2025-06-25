package com.mx.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.login.model.Login;
import com.mx.login.repository.LoginInterfaceRepository;

@Service
public class LoginServiceImpl implements  LoginInterfaceService{

    @Autowired
    LoginInterfaceRepository repository;

    @Override
    public Login crearLogin(Login login) {
        Login result = null;
        try {
            result = repository.save(login);
                
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
         return result;
    }

    @Override
    public Login buscarLogin(Login login) {
         Login resultado = null;
        try {
            resultado = repository.findByUsuario(login.getUsuario());
            if(resultado != null && resultado.getPassword().equals(login.getPassword())){
                return resultado;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    

    @Override
    public Login actualizarLogin(Login login, int idLogin) {
        Login guardar = new Login();
        try {
            boolean recuperado = repository.existsById(idLogin);
            if (recuperado == true) {
                guardar.setIdLogin(idLogin);
                guardar.setUsuario(login.getUsuario());
                guardar.setPassword(login.getPassword());
                guardar.setTipoLogin(login.getTipoLogin());
                guardar.setNombreLogin(login.getNombreLogin());
                guardar = repository.save(guardar);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return guardar;

    }

    @Override
    public void eliminarLogin(int idLogin) {
        int id = (int) idLogin;
        try {
            repository.deleteById(id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

}

}
