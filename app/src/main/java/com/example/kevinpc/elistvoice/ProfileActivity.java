package com.example.kevinpc.elistvoice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.kevinpc.elistvoice.banco.BeanElist;
import com.example.kevinpc.elistvoice.banco.BeanUsuario;
import com.example.kevinpc.elistvoice.banco.DAOElist;
import com.example.kevinpc.elistvoice.banco.DAOusuario;

import java.sql.SQLException;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private EditText edtNome, edtLogin, edtSenha;
    private BeanUsuario beanUsuario = new BeanUsuario();
    private List<BeanUsuario> mList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtLogin =(EditText) findViewById(R.id.edtUserLogin);
        edtSenha = (EditText) findViewById(R.id.edtUserSenha);

        //Intent it = getIntent();
        //Bundle parametros = it.getExtras();
        Bundle parametros = new Bundle();
        parametros.putInt("id", beanUsuario.getId());
        if(parametros != null){
            DAOusuario dao = new DAOusuario(getBaseContext());
            beanUsuario = new BeanUsuario();
            beanUsuario.setId(parametros.getInt("id"));

            dao.open();
            beanUsuario = dao.selectUm(beanUsuario);
            dao.close();

            preencheDados();

        }


    }

    private void preencheDados() {

        edtNome.setText(beanUsuario.getNomeUser());
        edtLogin.setText(beanUsuario.getUsername());
        edtSenha.setText(beanUsuario.getSenha());
    }

    private void alterar() throws SQLException{
        DAOusuario daOusuario = new DAOusuario(getBaseContext());

        beanUsuario.setNomeUser(edtNome.getText().toString());
        beanUsuario.setUsername(edtLogin.getText().toString());
        beanUsuario.setSenha(edtSenha.getText().toString());

        daOusuario.open();
        daOusuario.update(beanUsuario);
        daOusuario.close();
    }
    public void onBackPressed(){
        startActivity(new Intent(this,Home.class));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_profile_menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it;
        switch (item.getItemId()) {
            case android.R.id.home:
                // this takes the user 'back', as if they pressed the left-facing triangle icon on the main android toolbar.
                // if this doesn't work as desired, another possibility is to call `finish()` here.
                onBackPressed();
                return true;
            case R.id.action_save:
                try {
                    alterar();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                it = new Intent(getBaseContext(), Home.class);
                startActivity(it);
                finish();
            default:
                it = new Intent(getBaseContext(), Home.class);
                startActivity(it);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
