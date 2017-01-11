package com.example.kevinpc.elistvoice;

import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.example.kevinpc.elistvoice.adapters.AdapterItemClickListener;
import com.example.kevinpc.elistvoice.adapters.AdapterTeste;
import com.example.kevinpc.elistvoice.banco.BeanElist;
import com.example.kevinpc.elistvoice.banco.DAOElist;
import com.example.kevinpc.elistvoice.dialogs.LoginErroDialog;
import com.example.kevinpc.elistvoice.dialogs.MenuShareDialog;
import com.example.kevinpc.elistvoice.settings.GlobalSettings;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private GlobalSettings mSettings;
    private ListView mListView;
    private AdapterTeste mAdapter;
    private List<BeanElist> lista = null;
    private String mensage;
    private BeanElist beanElist;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mListView = (ListView) findViewById(R.id.lstLista);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        callbackManager = CallbackManager.Factory.create();
        mSettings = new GlobalSettings(this);
        //Carregar listas
        DAOElist daoElist = new DAOElist(getBaseContext());
        try{
            daoElist.open();
        }catch (SQLiteException e){
            e.printStackTrace();
        }
        lista = daoElist.selectTodos();
        daoElist.close();

        AdapterTeste mAdapter = new AdapterTeste(getBaseContext(), R.layout.fragment_list_item, lista);
        mListView.setAdapter(mAdapter);

        // lista
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                BeanElist bean = new BeanElist();
                bean = lista.get(position);

                Intent it = new Intent(getBaseContext(), ListActivity.class);
                Bundle parametros = new Bundle();
                parametros.putInt("id", bean.getId());
                it.putExtras(parametros);
                startActivity(it);
                finish();
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                BeanElist bean = new BeanElist();
                bean = lista.get(position);
                Bundle parametros = new Bundle();
                parametros.putInt("id", bean.getId());
                bean.setId(parametros.getInt("id"));
                //MenuShareDialog dialog = new MenuShareDialog();
                //dialog.show(getFragmentManager(), null);
                final Dialog dialog = new Dialog(Home.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dialog_cad_lista);

                final EditText text = (EditText) dialog.findViewById(R.id.edtTituloDialog);
                text.setText(bean.getNome());
                TextView titulo = (TextView) dialog.findViewById(R.id.txt_dialog_cad);
                titulo.setText("Alterar Titulo");

                Button dialogButton = (Button) dialog.findViewById(R.id.btnCadDialog);
                final BeanElist finalBean = bean;
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mensage = text.getText().toString();

                        DAOElist dao = new DAOElist(getBaseContext());
                        finalBean.setNome(mensage);
                        dao.open();
                        dao.update(finalBean);
                        dao.close();
                        //inserir();

                        startActivity(new Intent(Home.this, Home.class));
                        finish();
                        dialog.dismiss();
                    }
                });

                dialog.show();
                return true;
            }
        });



        //Floating Button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this,ListActivity.class);
                startActivity(i);
                finish();
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                     //   .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
           // super.onBackPressed();
            onBackPressedDois();
        }

    }

    public void onBackPressedDois(){
        startActivity(new Intent(this,FinalActivity.class));
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mSettings.setUserRegistered(false);
            Intent intent = new Intent(this, FinalActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        BeanElist beanElist = new BeanElist();

        int id = item.getItemId();

        if (id == R.id.nav_sua_conta) {
            // Handle the camera action
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
            finish();

        }/* else if (id == R.id.nav_categorias) {

        } else if (id == R.id.nav_configuracao) {

        } else if (id == R.id.nav_sincronizar) {

        } else if (id == R.id.nav_import){

        }*/ else if (id == R.id.nav_share) {
         /*   ArrayList<String> beanElistArrayList = new ArrayList<>();
            beanElist.setId(1);
            beanElistArrayList.add(beanElist.getNome()); // Add your image URIs here
            beanElistArrayList.add(beanElist.getDados());*/
            ShareDialog shareDialog = new ShareDialog(this);
            // List<String> permissionNeeds = Arrays.asList("publish_actions");
            // LoginManager manager = LoginManager.getInstance();
            // manager.logInWithPublishPermissions(this, permissionNeeds);
            if (ShareDialog.canShow(ShareLinkContent.class)) {
                final ShareLinkContent linkContent = new ShareLinkContent.Builder()
                        .setContentTitle("Baixe gratis o app eListVoice!")
                        .setContentDescription("Facilite sua vida ao fazer compras no super-mercado")
                        .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
                        //.setImageUrl();
                        .build();

                shareDialog.show(linkContent, ShareDialog.Mode.FEED);
                shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
                    @Override
                    public void onSuccess(Sharer.Result result) {
                        String postId = result.getPostId();
                        if (postId != null) {
                            // record successful FB share
                           // Log.e(ArremateApp.LOG_TAG, "Sucesso");

                          //  showProgress(true);
                           // requestToken(REQUEST_COMPARTILHAR_CONQUISTA);
                        }
                    }

                    @Override
                    public void onCancel() {
                        //Log.e(ArremateApp.LOG_TAG, "Cancel");
                    }

                    @Override
                    public void onError(FacebookException error) {
                        //Log.e(ArremateApp.LOG_TAG, "Error");
                    }


                });

            }

        }/* else if (id == R.id.nav_notificacao){

        } else if (id == R.id.nav_help) {

        }*/else if(id == R.id.nav_logout){
            mSettings.setUserRegistered(false);
            Intent intent = new Intent(this, FinalActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showDialog(){



    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


   /* @Override
    public void onItemClick(int viewId, int position) {
        BeanElist beanElist = mAdapter.getItem(position);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, beanElist.getNome());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }*/
}
