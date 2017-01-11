package com.example.kevinpc.elistvoice.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevinPC on 12/07/2016.
 */
public class DAOElist {
    private SQLiteDatabase banco;
    private GerenciaBanco gerenciaBanco;

    //Colunas
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String DADOS0 = "dadoszero";
    public static final String DADOS = "dados";
    public static final String DADOS2 = "dadosdois";
    public static final String DADOS3 = "dadostres";
    public static final String DADOS4 = "dadosquatro";
    public static final String DADOS5 = "dadoscinco";
    public static final String DADOS6 = "dadosseis";
    public static final String DADOS7 = "dadossete";
    public static final String DADOS8 = "dadosoito";
    public static final String DADOS9 = "dadosnove";
    public static final String DADOS10 = "dadosdez";
    public static final String DADOS11 = "dadosonze";
    public static final String DADOS12 = "dadosdoze";
    public static final String DADOS13 = "dadostreze";
    //PREÇO
    public static final String PRECO0 = "precozero";
    public static final String PRECO = "preco";
    public static final String PRECO2 = "precodois";
    public static final String PRECO3 = "precotres";
    public static final String PRECO4 = "precoquatro";
    public static final String PRECO5 = "precocinco";
    public static final String PRECO6 = "precoseis";
    public static final String PRECO7 = "precosete";
    public static final String PRECO8 = "precooito";
    public static final String PRECO9 = "preconove";
    public static final String PRECO10 = "precodez";
    public static final String PRECO11 = "precoonze";
    public static final String PRECO12 = "precodoze";
    public static final String PRECO13 = "precotreze";
    public static final String PRECO14 = "precoquatorze";
    public static final String NUMEROITEM = "numero_itens";

    //public static final String ID_USUARIO = "usuario_id";

    public static final String[] todasAsColunas ={
            ID, NOME,
            DADOS0, DADOS, DADOS2, DADOS3, DADOS4, DADOS5, DADOS6, DADOS7, DADOS8, DADOS9, DADOS10, DADOS11, DADOS12, DADOS13,
            PRECO0, PRECO, PRECO2, PRECO3, PRECO4, PRECO5, PRECO6, PRECO7, PRECO8, PRECO9, PRECO10, PRECO11, PRECO12, PRECO13,
            NUMEROITEM //ID_USUARIO
    };

    //Tabelas
    public static final String TABELA_ELIST = "lista";

    public DAOElist(Context context){ gerenciaBanco = new GerenciaBanco(context);}

    public void open() throws SQLException{
        banco = gerenciaBanco.getWritableDatabase();
    }

    public void close(){gerenciaBanco.close();}

    public void insert(BeanElist item){
        ContentValues valores = new ContentValues();

        valores.put(NOME, item.getNome());
        //INSERT DE DADOS
        valores.put(DADOS0, item.getDados0());
        valores.put(DADOS, item.getDados());
        valores.put(DADOS2, item.getDados2());
        valores.put(DADOS3, item.getDados3());
        valores.put(DADOS4, item.getDados4());
        valores.put(DADOS5, item.getDados5());
        valores.put(DADOS6, item.getDados6());
        valores.put(DADOS7, item.getDados7());
        valores.put(DADOS8, item.getDados8());
        valores.put(DADOS9, item.getDados9());
        valores.put(DADOS10, item.getDados10());
        valores.put(DADOS11, item.getDados11());
        valores.put(DADOS12, item.getDados12());
        valores.put(DADOS13, item.getDados13());
        //INSERT DE PREÇOS
        valores.put(PRECO0, item.getPreco0());
        valores.put(PRECO, item.getPreco());
        valores.put(PRECO2, item.getPreco2());
        valores.put(PRECO3, item.getPreco3());
        valores.put(PRECO4, item.getPreco4());
        valores.put(PRECO5, item.getPreco5());
        valores.put(PRECO6, item.getPreco6());
        valores.put(PRECO7, item.getPreco7());
        valores.put(PRECO8, item.getPreco8());
        valores.put(PRECO9, item.getPreco9());
        valores.put(PRECO10, item.getPreco10());
        valores.put(PRECO11, item.getPreco11());
        valores.put(PRECO12, item.getPreco12());
        valores.put(PRECO13, item.getPreco13());

        valores.put(NUMEROITEM, item.getNumeroItens());
        //valores.put(ID_USUARIO, item.getIdUsuario());

        banco.insert(TABELA_ELIST, null, valores);
    }

    public void delete(BeanElist item){
        int id = item.getId();
        banco.delete(TABELA_ELIST, ID + " = " + id, null);
    }

    public void update(BeanElist item)
    {
        ContentValues valores = new ContentValues();

        valores.put(ID, item.getId());
        valores.put(NOME, item.getNome());
        //UPDATE DE DADOS
        valores.put(DADOS0, item.getDados0());
        valores.put(DADOS, item.getDados());
        valores.put(DADOS2, item.getDados2());
        valores.put(DADOS3, item.getDados3());
        valores.put(DADOS4, item.getDados4());
        valores.put(DADOS5, item.getDados5());
        valores.put(DADOS6, item.getDados6());
        valores.put(DADOS7, item.getDados7());
        valores.put(DADOS8, item.getDados8());
        valores.put(DADOS9, item.getDados9());
        valores.put(DADOS10, item.getDados10());
        valores.put(DADOS11, item.getDados11());
        valores.put(DADOS12, item.getDados12());
        valores.put(DADOS13, item.getDados13());
        //UPDATE DE PREÇOS
        valores.put(PRECO0, item.getPreco0());
        valores.put(PRECO, item.getPreco());
        valores.put(PRECO2, item.getPreco2());
        valores.put(PRECO3, item.getPreco3());
        valores.put(PRECO4, item.getPreco4());
        valores.put(PRECO5, item.getPreco5());
        valores.put(PRECO6, item.getPreco6());
        valores.put(PRECO7, item.getPreco7());
        valores.put(PRECO8, item.getPreco8());
        valores.put(PRECO9, item.getPreco9());
        valores.put(PRECO10, item.getPreco10());
        valores.put(PRECO11, item.getPreco11());
        valores.put(PRECO12, item.getPreco12());
        valores.put(PRECO13, item.getPreco13());

        valores.put(NUMEROITEM, item.getNumeroItens());
        //valores.put(ID_USUARIO, item.getIdUsuario());

        banco.update(TABELA_ELIST, valores, ID + " = " + item.getId(), null);
    }

    public void updateNumeroItem(BeanElist item) {
        ContentValues valores = new ContentValues();

        valores.put(NUMEROITEM, item.getNumeroItens());

        banco.update(TABELA_ELIST, valores, ID + " = " + item.getId(), null);

    }

    public List<BeanElist> selectTodos(){
        List<BeanElist> itens = new ArrayList<BeanElist>();
        Cursor cursor = banco.query(TABELA_ELIST,
                todasAsColunas, null, null, null, null, null);
            cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            BeanElist item = cursorToItem(cursor);
            itens.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        return itens;
    }

    public BeanElist selectUm(BeanElist item){
        Cursor cursor = banco.query(
                TABELA_ELIST,
                todasAsColunas,
                ID + " = " + item.getId(),
                null, null, null, null);

        cursor.moveToFirst();
        return cursorToItem(cursor);

    }

    private BeanElist cursorToItem(Cursor cursor){
        BeanElist item = new BeanElist();

        item.setId(cursor.getInt(0));
        item.setNome(cursor.getString(1));
        //CURSOR DE DADOS
        item.setDados0(cursor.getString(2));
        item.setDados(cursor.getString(3));
        item.setDados2(cursor.getString(4));
        item.setDados3(cursor.getString(5));
        item.setDados4(cursor.getString(6));
        item.setDados5(cursor.getString(7));
        item.setDados6(cursor.getString(8));
        item.setDados7(cursor.getString(9));
        item.setDados8(cursor.getString(10));
        item.setDados9(cursor.getString(11));
        item.setDados10(cursor.getString(12));
        item.setDados11(cursor.getString(13));
        item.setDados12(cursor.getString(14));
        item.setDados13(cursor.getString(15));

        //CURSOR DE PREÇOS
        item.setPreco0(cursor.getString(16));
        item.setPreco(cursor.getString(17));
        item.setPreco2(cursor.getString(18));
        item.setPreco3(cursor.getString(19));
        item.setPreco4(cursor.getString(20));
        item.setPreco5(cursor.getString(21));
        item.setPreco6(cursor.getString(22));
        item.setPreco7(cursor.getString(23));
        item.setPreco8(cursor.getString(24));
        item.setPreco9(cursor.getString(25));
        item.setPreco10(cursor.getString(26));
        item.setPreco11(cursor.getString(27));
        item.setPreco12(cursor.getString(28));
        item.setPreco13(cursor.getString(29));

        item.setNumeroItens(cursor.getString(30));
        //item.setIdUsuario(cursor.getInt(3));


        return item;
    }
}
