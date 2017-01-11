package com.example.kevinpc.elistvoice.banco;

/**
 * Created by kevinPC on 16/08/2016.
 */
public class BeanUsuario {
    private int idUsuario;
    private String nomeUser;
    private String endereco;
    private String username;
    private String senha;


    public BeanUsuario(){
        idUsuario = 1;
        nomeUser = "";
        endereco = "";
        username = "";
        senha = "";
    }

    public int getId(){return idUsuario;}
    public void setId(int id){this.idUsuario = id;}

    public String getNomeUser(){return nomeUser;}
    public void setNomeUser(String nomeUser){this.nomeUser = nomeUser;}

    public String getEndereco(){return endereco;}
    public void setEndereco(String endereco){this.endereco = endereco;}

    public String getUsername(){return username;}
    public void setUsername(String nome){this.username = nome;}

    public String getSenha(){return senha;}
    public void setSenha(String dados){this.senha = dados;}

    @Override
    public String toString(){return  username;}
}
