package com.mx.login.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

    @Id
    @Column(name = "id_login")
    private int idLogin;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "password")
    private String password;
    @Column(name = "tipo_login")
    private String tipoLogin;
    @Column(name ="nombre_login")
    private String nombreLogin;


    public Login(){
        
    }


    public Login(int idLogin, String usuario, String password, String tipoLogin, String nombreLogin) {
        this.idLogin = idLogin;
        this.usuario = usuario;
        this.password = password;
        this.tipoLogin = tipoLogin;
        this.nombreLogin = nombreLogin;
    }


    public int getIdLogin() {
        return idLogin;
    }


    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }


    public String getUsuario() {
        return usuario;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getTipoLogin() {
        return tipoLogin;
    }


    public void setTipoLogin(String tipoLogin) {
        this.tipoLogin = tipoLogin;
    }


    public String getNombreLogin() {
        return nombreLogin;
    }


    public void setNombreLogin(String nombreLogin) {
        this.nombreLogin = nombreLogin;
    }

}
