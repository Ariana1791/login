package com.mx.login.service;

import com.mx.login.model.Login;

public interface LoginInterfaceService {

    Login crearLogin(Login login);

    Login buscarLogin(Login login);

    Login actualizarLogin(Login login, int idLogin);

    void eliminarLogin(int idLogin);

    boolean buscarPorId(int id);

    Login buscarPorUsuario(String  usuario);
}
