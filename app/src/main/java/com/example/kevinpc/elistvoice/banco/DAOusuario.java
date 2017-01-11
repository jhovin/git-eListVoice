package com.example.kevinpc.elistvoice.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kevinPC on 16/08/2016.
 */
public class DAOusuario {
    private SQLiteDatabase banco;
    private GerenciaBanco gerenciaBanco;

    //Colunas
    public static final String ID = "id_usuario";
    public static final String NOME_USER = "nome_user";
    public static final String USERNAME = "username";
    public static final String SENHA = "senha";

    public static final String[] todasAsColunas ={
            ID, NOME_USER, USERNAME, SENHA
    };

    //Tabelas
    public static final String TABELA_USUARIO = "usuario";

    public DAOusuario(Context context){ gerenciaBanco = new GerenciaBanco(context);}

    public void open() throws SQLException {
        banco = gerenciaBanco.getWritableDatabase();
    }

    public void close(){gerenciaBanco.close();}

    public void insert(BeanUsuario item){
        ContentValues valores = new ContentValues();

        valores.put(NOME_USER,item.getNomeUser());
        valores.put(USERNAME, item.getUsername());
        valores.put(SENHA, item.getSenha());

        banco.insert(TABELA_USUARIO, null, valores);
    }

    public void update(BeanUsuario item)
    {
        ContentValues valores = new ContentValues();

        valores.put(ID, item.getId());
        valores.put(NOME_USER, item.getNomeUser());
        valores.put(USERNAME, item.getUsername());
        valores.put(SENHA, item.getSenha());

        banco.update(TABELA_USUARIO, valores, ID + " = " + item.getId(), null);
    }

    public void delete(BeanUsuario item){
        int id = item.getId();
        banco.delete(TABELA_USUARIO, ID + " = " + id, null);
    }

    public BeanUsuario findByLogin(BeanUsuario item) {
        Cursor cursor = banco.query(TABELA_USUARIO,todasAsColunas,USERNAME+" = " + item.getUsername()+"AND"+ SENHA+ item.getSenha(),
                null,null,null,null);
        cursor.moveToFirst();
        return cursorToItem(cursor);
    }

    public BeanUsuario login(String usuario, String senha) {
        String sql = "SELECT * FROM " + TABELA_USUARIO + " WHERE username = ? AND senha = ?";
        String[] selectionArgs = new String[] { usuario, senha };
        Cursor cursor = banco.rawQuery(sql, selectionArgs);
        cursor.moveToFirst();
        return cursorToItem(cursor);
    }

    public BeanUsuario selectUm(BeanUsuario item){
        Cursor cursor = banco.query(
                TABELA_USUARIO,
                todasAsColunas,
                ID + " = " + item.getId(),
                null, null, null, null);

        cursor.moveToFirst();
        return cursorToItem(cursor);

    }


    private BeanUsuario cursorToItem(Cursor cursor){
        BeanUsuario item = new BeanUsuario();

        item.setId(cursor.getInt(0));
        item.setNomeUser(cursor.getString(1));
        item.setUsername(cursor.getString(2));
        item.setSenha(cursor.getString(3));

        return item;
    }
}
