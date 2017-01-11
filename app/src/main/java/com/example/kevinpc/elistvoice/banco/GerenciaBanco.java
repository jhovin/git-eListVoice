package com.example.kevinpc.elistvoice.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kevinPC on 12/07/2016.
 */
public class GerenciaBanco extends SQLiteOpenHelper {
    //dados do banco
    private static final String NOME_BANCO = "db_elist";
    private static final int VERSAO_BANCO = 1;

    public static final String TB_USUARIO =
            "CREATE TABLE usuario("+
                    "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome_user VARCHAR(200), " +
                    "username VARCHAR(20) NOT NULL, " +
                    "senha VARCHAR(20) NOT NULL " +
                    ");";

    public static final String TB_ELIST =
            "CREATE TABLE lista ("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome VARCHAR(200), " +
                    //DADOS
                    "dadoszero VARCHAR(200), " +
                    "dados VARCHAR(200), " +
                    "dadosdois VARCHAR(200), " +
                    "dadostres VARCHAR(200), " +
                    "dadosquatro VARCHAR(200), " +
                    "dadoscinco VARCHAR(200), " +
                    "dadosseis VARCHAR(200), " +
                    "dadossete VARCHAR(200), " +
                    "dadosoito VARCHAR(200), " +
                    "dadosnove VARCHAR(200), " +
                    "dadosdez VARCHAR(200), " +
                    "dadosonze VARCHAR(200), " +
                    "dadosdoze VARCHAR(200), " +
                    "dadostreze VARCHAR(200), " +
                    //PREÇO
                    "precozero VARCHAR(200), " +
                    "preco VARCHAR(200), " +
                    "precodois VARCHAR(200), " +
                    "precotres VARCHAR(200), " +
                    "precoquatro VARCHAR(200), " +
                    "precocinco VARCHAR(200), " +
                    "precoseis VARCHAR(200), " +
                    "precosete VARCHAR(200), " +
                    "precooito VARCHAR(200), " +
                    "preconove VARCHAR(200), " +
                    "precodez VARCHAR(200), " +
                    "precoonze VARCHAR(200), " +
                    "precodoze VARCHAR(200), " +
                    "precotreze VARCHAR(200), " +
                    "numero_itens VARCHAR(17) " +
                    ");";

    public GerenciaBanco (Context context){super(context, NOME_BANCO, null, VERSAO_BANCO);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TB_USUARIO);
        db.execSQL(TB_ELIST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
