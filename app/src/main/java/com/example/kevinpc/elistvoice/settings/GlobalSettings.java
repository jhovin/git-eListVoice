package com.example.kevinpc.elistvoice.settings;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ShareActionProvider;

/**
 * Created by kevinPC on 01/09/2016.
 */
public class GlobalSettings {

    private static final String KEY_USERNAME = "username";
    private static final String KEY_SENHA = "senha";
    private static final String KEY_TITULO_LISTA = "nome";
    private static final String KEY_USER_REGISTERED = "user_registered";

    private static final String GLOBAL_SETTINGS = "global_settings";
    private static final String EMPTY = "";
    private SharedPreferences mPrefs;

    public GlobalSettings(Context context){
        mPrefs = context.getSharedPreferences(GLOBAL_SETTINGS, Context.MODE_PRIVATE);
    }

    public String getUsername(){return mPrefs.getString(KEY_USERNAME,EMPTY);}

    public void setUsername(String username){
        mPrefs.edit().putString(KEY_USERNAME, username).apply();
    }

    public String getSenha(){return mPrefs.getString(KEY_SENHA, EMPTY);}

    public void setSenha(String senha){
        mPrefs.edit().putString(KEY_SENHA, senha).apply();
    }

    public void setTituloLista(String tituloLista){mPrefs.edit().putString(KEY_TITULO_LISTA, tituloLista).apply();}

    public void setUserRegistered(boolean registered) {
        mPrefs.edit().putBoolean(KEY_USER_REGISTERED, registered).apply();
    }
    public boolean isUserRegistered() {
        return mPrefs.getBoolean(KEY_USER_REGISTERED, false);
    }
}
