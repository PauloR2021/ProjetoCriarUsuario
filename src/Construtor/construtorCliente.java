/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Construtor;

/**
 *
 * @author Paulo Ricardo
 */
public class construtorCliente {

    public construtorCliente(String n, String u, String s) {
    
        this.nome = n;
        this.usuario = u;
        this.senha = s;
    }

    private String nome;
    private String usuario;
    private String senha;

    
    
    
   
   
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
    
}
