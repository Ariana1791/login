package com.mx.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.login.model.Login;

public interface LoginInterfaceRepository  extends JpaRepository<Login, Integer>{

    Login findByUsuario(String usuario);


}
