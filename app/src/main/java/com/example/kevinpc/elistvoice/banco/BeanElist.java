package com.example.kevinpc.elistvoice.banco;

/**
 * Created by kevinPC on 12/07/2016.
 */
public class BeanElist {
    private int id;
    private String nome;
    //DADOS
    private String dados0;
    private String dados;
    private String dados2;
    private String dados3;
    private String dados4;
    private String dados5;
    private String dados6;
    private String dados7;
    private String dados8;
    private String dados9;
    private String dados10;
    private String dados11;
    private String dados12;
    private String dados13;
    private String dados14;
    //PREÇO
    private String preco0;
    private String preco;
    private String preco2;
    private String preco3;
    private String preco4;
    private String preco5;
    private String preco6;
    private String preco7;
    private String preco8;
    private String preco9;
    private String preco10;
    private String preco11;
    private String preco12;
    private String preco13;
    private String numeroItens;
    private int idUsuario;


    public BeanElist(){
        id = 0;
        nome = "";
        //DAODS
        dados0 = "";
        dados = "";
        dados2 = "";
        dados3 = "";
        dados4 = "";
        dados5 = "";
        dados6 = "";
        dados7 = "";
        dados8 = "";
        dados9 = "";
        dados10 = "";
        dados11 = "";
        dados12 = "";
        dados13 = "";
        //PREÇO
        preco0 = "";
        preco = "";
        preco2 = "";
        preco3 = "";
        preco4 = "";
        preco5 = "";
        preco6 = "";
        preco7 = "";
        preco8 = "";
        preco9 = "";
        preco10 = "";
        preco11 = "";
        preco12 = "";
        preco13 = "";
        numeroItens = "";
        //idUsuario = 1;
    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}


//GET e SET Dados
    public String getDados0(){return dados0;}
    public void setDados0(String dados0){this.dados0 = dados0;}

    public String getDados(){return dados;}
    public void setDados(String dados){this.dados = dados;}

    public String getDados2(){return dados2;}
    public void setDados2(String dados2){this.dados2 = dados2;}

    public String getDados3(){return dados3;}
    public void setDados3(String dados3){this.dados3 = dados3;}

    public String getDados4(){return dados4;}
    public void setDados4(String dados4){this.dados4 = dados4;}

    public String getDados5(){return dados5;}
    public void setDados5(String dados5){this.dados5 = dados5;}

    public String getDados6(){return dados6;}
    public void setDados6(String dados6){this.dados6 = dados6;}

    public String getDados7(){return dados7;}
    public void setDados7(String dados7){this.dados7 = dados7;}

    public String getDados8(){return dados8;}
    public void setDados8(String dados8){this.dados8 = dados8;}

    public String getDados9(){return dados9;}
    public void setDados9(String dados9){this.dados9 = dados9;}

    public String getDados10(){return dados10;}
    public void setDados10(String dados10){this.dados10 = dados10;}

    public String getDados11(){return dados11;}
    public void setDados11(String dados11){this.dados11 = dados11;}

    public String getDados12(){return dados12;}
    public void setDados12(String dados12){this.dados12 = dados12;}

    public String getDados13(){return dados13;}
    public void setDados13(String dados13){this.dados13 = dados13;}




    //GET e SET Preço
    public String getPreco0(){return preco0;}
    public void setPreco0(String preco0){this.preco0 = preco0;}

    public String getPreco(){return preco;}
    public void setPreco(String preco){this.preco = preco;}

    public String getPreco2(){return preco2;}
    public void setPreco2(String preco2){this.preco2 = preco2;}

    public String getPreco3(){return preco3;}
    public void setPreco3(String preco3){this.preco3 = preco3;}

    public String getPreco4(){return preco4;}
    public void setPreco4(String preco4){this.preco4 = preco4;}

    public String getPreco5(){return preco5;}
    public void setPreco5(String preco5){this.preco5 = preco5;}

    public String getPreco6(){return preco6;}
    public void setPreco6(String preco6){this.preco6 = preco6;}

    public String getPreco7(){return preco7;}
    public void setPreco7(String preco7){this.preco7 = preco7;}

    public String getPreco8(){return preco8;}
    public void setPreco8(String preco8){this.preco8 = preco8;}

    public String getPreco9(){return preco9;}
    public void setPreco9(String preco9){this.preco9 = preco9;}

    public String getPreco10(){return preco10;}
    public void setPreco10(String preco10){this.preco10 = preco10;}

    public String getPreco11(){return preco11;}
    public void setPreco11(String preco11){this.preco11 = preco11;}

    public String getPreco12(){return preco12;}
    public void setPreco12(String preco12){this.preco12 = preco12;}

    public String getPreco13(){return preco13;}
    public void setPreco13(String preco13){this.preco13 = preco13;}


    public String getNumeroItens(){return numeroItens;}
    public void setNumeroItens(String numeroItens){this.numeroItens = numeroItens;}

    //public int getIdUsuario(){return idUsuario;}
    //public void setIdUsuario(int idUsuario){this.idUsuario = idUsuario;}

    @Override
    public String toString(){return  nome;}
}
