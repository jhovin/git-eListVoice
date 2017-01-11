package com.example.kevinpc.elistvoice;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.kevinpc.elistvoice.banco.BeanElist;
import com.example.kevinpc.elistvoice.banco.BeanUsuario;
import com.example.kevinpc.elistvoice.banco.DAOElist;
import com.example.kevinpc.elistvoice.banco.DAOusuario;
import com.example.kevinpc.elistvoice.dialogs.LoginErroDialog;
import com.example.kevinpc.elistvoice.fragment.OnFragmentInteractionListener;
import com.example.kevinpc.elistvoice.fragment.RegisterFragment;
import com.example.kevinpc.elistvoice.fragment.EntrarFragment;
import com.example.kevinpc.elistvoice.fragment.StartFragment;
import com.example.kevinpc.elistvoice.settings.GlobalSettings;

import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity implements OnFragmentInteractionListener{

    private GlobalSettings mSettings;
    private FrameLayout mFrameLayout;
    private Fragment frag;
    private BeanUsuario mBeanUser;
    private DAOusuario usuarioDAO;
    private Context context;
    private AlertDialog.Builder alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFrameLayout = (FrameLayout) findViewById(R.id.fragment_container);
        mSettings = new GlobalSettings(this);



        if(mSettings.isUserRegistered()){
            login();
        }else{
            Fragment fragment = new StartFragment();
            frag = fragment;
            getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment)
                    .commit();
        }

        context = this;

    }


    @Override
    public void onBackPressed() {
        if (frag != null) {
            frag = null;
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new StartFragment())
                    .commit();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentInteraction(View view) throws SQLException {
        Intent it;
        DAOusuario daoUsuario = new DAOusuario(getBaseContext());
        BeanUsuario beanUsuario =  new BeanUsuario();
        DAOElist daoElist = new DAOElist(getBaseContext());
        BeanElist beanElist = new BeanElist();
        switch (view.getId()){
            case R.id.btnCadastro:
                Fragment fragment = new RegisterFragment();
                frag = fragment;
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                        .commit();
                break;
            case R.id.btnCadastrar:
                    mBeanUser = (BeanUsuario) view.getTag();
                //DAOusuario daoUsuario = new DAOusuario(getBaseContext());
                //BeanUsuario beanUsuario =  new BeanUsuario();

                final String user = mBeanUser.getUsername();
                final String sen = mBeanUser.getSenha();

                beanUsuario.setUsername(user);
                beanUsuario.setSenha(sen);

                mSettings.setUsername(user);
                mSettings.setSenha(sen);
                try {
                    daoUsuario.open();
                    daoUsuario.insert(beanUsuario);
                    daoUsuario.close();
                } catch (Exception e){
                    android.app.AlertDialog.Builder dlg = new android.app.AlertDialog.Builder(getBaseContext());
                    dlg.setMessage("Erro ao Cadastrar" + e.getMessage());
                    dlg.setNeutralButton("OK", null);
                    dlg.show();
                }
                onBackPressed();
                Toast.makeText(LoginActivity.this, "Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnLogin:
                Fragment fragment2 = new EntrarFragment();
                frag = fragment2;
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment2)
                        .commit();
                break;
            case R.id.btnEntrar:
                mBeanUser = (BeanUsuario) view.getTag();

                final String userLogin = mBeanUser.getUsername();
                final String senLogin = mBeanUser.getSenha();

                beanUsuario.setUsername(userLogin);
                beanUsuario.setSenha(senLogin);
                try {
                    daoUsuario.open();
                    daoUsuario.login(userLogin, senLogin);
                    daoUsuario.close();
                    mSettings.setUserRegistered(true);
                    Toast.makeText(LoginActivity.this, "Bem vindo!", Toast.LENGTH_SHORT).show();
                    it = new Intent(getBaseContext(), Home.class);
                    startActivity(it);
                    finish();
                } catch (Exception e){
                    //android.app.AlertDialog.Builder dlg = new android.app.AlertDialog.Builder(getBaseContext());
                    //dlg.setMessage("Erro ao Entrar" + e.getMessage());
                    //dlg.setNeutralButton("OK", null);
                    //dlg.show();
                   // exibeDialogo("Usuario ou Senha invalidos");
                    LoginErroDialog dialog = new LoginErroDialog();
                    dialog.show(getFragmentManager(), null);
                    e.printStackTrace();
                }
                /*try {
                    boolean isValid = validaLogin(userLogin, senLogin);
                    if (isValid) {
                        exibeDialogo("Usuario e senha validados com sucesso!");
                    } else {
                        exibeDialogo("Verifique usuario e senha!");
                    }
                } catch (Exception e) {
                    exibeDialogo("Erro validando usuario e senha");
                    e.printStackTrace();
                }*/

                break;
            default:
                break;
        }
    }

    public void cadastrar() throws SQLException{
        DAOusuario daoUsuario = new DAOusuario(getBaseContext());
        BeanUsuario beanUsuario =  new BeanUsuario();

        beanUsuario.getUsername();
        beanUsuario.getSenha();
        try {
        daoUsuario.open();
        daoUsuario.insert(beanUsuario);
        daoUsuario.close();
        } catch (Exception e){
            android.app.AlertDialog.Builder dlg = new android.app.AlertDialog.Builder(getBaseContext());
            dlg.setMessage("Erro ao deletar" + e.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
        Fragment fragment2 = new StartFragment();
        frag = fragment2;
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment2)
                .commit();
    }

    public boolean validaLogin(String usuario, String senha) throws Exception {
        BeanUsuario user = usuarioDAO.login(usuario, senha);
        if (user == null || user.getUsername() == null || user.getSenha() == null) {
            return false;
        }
        String informado = usuario + senha;
        String esperado = user.getUsername() + user.getSenha();
        if (informado.equals(esperado)) {
            return true;
        }
        return false;
    }

    public void exibeDialogo(String mensagem) {
        alert = new AlertDialog.Builder(context);
        alert.setPositiveButton("OK", null);
        alert.setMessage(mensagem);
        alert.create().show();
    }

    private void login() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }

}
