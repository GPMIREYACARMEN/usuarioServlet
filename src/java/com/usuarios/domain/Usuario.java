
package com.usuarios.domain;

public class Usuario {
    private Integer idUsuario;
    private String usr;
    private String pwd;

    public Usuario() {
    }

    public Usuario(String usr, String pwd) {
        this.usr = usr;
        this.pwd = pwd;
    }
    
    public Usuario(Integer idUsuario, String usr, String pwd) {
        this.idUsuario = idUsuario;
        this.usr = usr;
        this.pwd = pwd;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    
    
}
