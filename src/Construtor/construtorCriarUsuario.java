/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Construtor;

/**
 *
 * @author Paulo Ricardo
 */
public class construtorCriarUsuario {

    public construtorCriarUsuario(String n, String u, String p, String t) {
        this.nome = n;
        this.usuario = u;
        this.senha = p;
        this.tipo = t;
    }
    
    
    
    private String nome;
    private String usuario;
    private String senha;
    private String tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
