package com.example.kevinpc.elistvoice;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevinpc.elistvoice.banco.BeanElist;
import com.example.kevinpc.elistvoice.banco.DAOElist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

public class ListActivity extends AppCompatActivity{
    private final int REQ_CODE_SPEECH_INPUT = 100;

    //private GlobalSettings mSettings;
    private BeanElist beanElist = new BeanElist();
    private EditText edtNome0,edtNome, edtNome2, edtNome3, edtNome4, edtNome5, edtNome6, edtNome7, edtNome8, edtNome9, edtNome10, edtNome11, edtNome12, edtNome13;
    private EditText edtPreco0, edtPreco, edtPreco2, edtPreco3, edtPreco4, edtPreco5, edtPreco6, edtPreco7, edtPreco8, edtPreco9, edtPreco10, edtPreco11, edtPreco12, edtPreco13;
    private TextView txtPreco0, txtPreco, txtPreco2, txtPreco3, txtPreco4, txtPreco5, txtPreco6, txtPreco7, txtPreco8, txtPreco9, txtPreco10, txtPreco11, txtPreco12,txtPreco13;
    private TextView txtNome0, txtNome, txtNome2, txtNome3, txtNome4, txtNome5, txtNome6, txtNome7, txtNome8, txtNome9, txtNome10, txtNome11, txtNome12, txtNome13;
    private ImageView img0, img, img2,img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13;
    private int contador = 1, outroContador = 0;
    private boolean mVerdade;
    private int contadorAfterUpdate = 0;

    private String mensage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mVerdade = false;
       // mSettings = new GlobalSettings(this);
        //Imagem checked
        img0 = (ImageView) findViewById(R.id.imageView0);
        img = (ImageView) findViewById(R.id.imageView);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);
        img5 = (ImageView) findViewById(R.id.imageView5);
        img6 = (ImageView) findViewById(R.id.imageView6);
        img7 = (ImageView) findViewById(R.id.imageView7);
        img8 = (ImageView) findViewById(R.id.imageView8);
        img9 = (ImageView) findViewById(R.id.imageView9);
        img10 = (ImageView) findViewById(R.id.imageView10);
        img11 = (ImageView) findViewById(R.id.imageView11);
        img12 = (ImageView) findViewById(R.id.imageView12);
        img13 = (ImageView) findViewById(R.id.imageView13);
        img0.setVisibility(View.INVISIBLE);
        img.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.INVISIBLE);
        img3.setVisibility(View.INVISIBLE);
        img4.setVisibility(View.INVISIBLE);
        img5.setVisibility(View.INVISIBLE);
        img6.setVisibility(View.INVISIBLE);
        img7.setVisibility(View.INVISIBLE);
        img8.setVisibility(View.INVISIBLE);
        img9.setVisibility(View.INVISIBLE);
        img10.setVisibility(View.INVISIBLE);
        img11.setVisibility(View.INVISIBLE);
        img12.setVisibility(View.INVISIBLE);
        img13.setVisibility(View.INVISIBLE);


        //Edit Text de Nomes
        edtNome0 = (EditText) findViewById(R.id.edtNome0);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtNome2 = (EditText)findViewById(R.id.edtNome2);
        edtNome3 = (EditText)findViewById(R.id.edtNome3);
        edtNome4 = (EditText)findViewById(R.id.edtNome4);
        edtNome5 = (EditText)findViewById(R.id.edtNome5);
        edtNome6 = (EditText)findViewById(R.id.edtNome6);
        edtNome7 = (EditText)findViewById(R.id.edtNome7);
        edtNome8 = (EditText)findViewById(R.id.edtNome8);
        edtNome9 = (EditText)findViewById(R.id.edtNome9);
        edtNome10 = (EditText)findViewById(R.id.edtNome10);
        edtNome11 = (EditText)findViewById(R.id.edtNome11);
        edtNome12 = (EditText)findViewById(R.id.edtNome12);
        edtNome13 = (EditText)findViewById(R.id.edtNome13);
        edtNome.setVisibility(View.INVISIBLE);
        edtNome2.setVisibility(View.INVISIBLE);
        edtNome3.setVisibility(View.INVISIBLE);
        edtNome4.setVisibility(View.INVISIBLE);
        edtNome5.setVisibility(View.INVISIBLE);
        edtNome6.setVisibility(View.INVISIBLE);
        edtNome7.setVisibility(View.INVISIBLE);
        edtNome8.setVisibility(View.INVISIBLE);
        edtNome9.setVisibility(View.INVISIBLE);
        edtNome10.setVisibility(View.INVISIBLE);
        edtNome11.setVisibility(View.INVISIBLE);
        edtNome12.setVisibility(View.INVISIBLE);
        edtNome13.setVisibility(View.INVISIBLE);
        //Edit Text de Preços
        edtPreco0 = (EditText)findViewById(R.id.edtPreco0);
        edtPreco = (EditText) findViewById(R.id.edtPreco);
        edtPreco2 = (EditText)findViewById(R.id.edtPreco2);
        edtPreco3 = (EditText)findViewById(R.id.edtPreco3);
        edtPreco4 = (EditText)findViewById(R.id.edtPreco4);
        edtPreco5 = (EditText)findViewById(R.id.edtPreco5);
        edtPreco6 = (EditText)findViewById(R.id.edtPreco6);
        edtPreco7 = (EditText)findViewById(R.id.edtPreco7);
        edtPreco8 = (EditText)findViewById(R.id.edtPreco8);
        edtPreco9 = (EditText)findViewById(R.id.edtPreco9);
        edtPreco10 = (EditText)findViewById(R.id.edtPreco10);
        edtPreco11 = (EditText)findViewById(R.id.edtPreco11);
        edtPreco12 = (EditText)findViewById(R.id.edtPreco12);
        edtPreco13 = (EditText)findViewById(R.id.edtPreco13);
        edtPreco0.setVisibility(View.INVISIBLE);
        edtPreco.setVisibility(View.INVISIBLE);
        edtPreco2.setVisibility(View.INVISIBLE);
        edtPreco3.setVisibility(View.INVISIBLE);
        edtPreco4.setVisibility(View.INVISIBLE);
        edtPreco5.setVisibility(View.INVISIBLE);
        edtPreco6.setVisibility(View.INVISIBLE);
        edtPreco7.setVisibility(View.INVISIBLE);
        edtPreco8.setVisibility(View.INVISIBLE);
        edtPreco9.setVisibility(View.INVISIBLE);
        edtPreco10.setVisibility(View.INVISIBLE);
        edtPreco11.setVisibility(View.INVISIBLE);
        edtPreco12.setVisibility(View.INVISIBLE);
        edtPreco13.setVisibility(View.INVISIBLE);
        //TextView de Nomes
        txtNome = (TextView) findViewById(R.id.txtNome);
        txtNome2 = (TextView) findViewById(R.id.txtNome2);
        txtNome3 = (TextView) findViewById(R.id.txtNome3);
        txtNome4 = (TextView) findViewById(R.id.txtNome4);
        txtNome5 = (TextView) findViewById(R.id.txtNome5);
        txtNome6 = (TextView)findViewById(R.id.txtNome6);
        txtNome7 = (TextView)findViewById(R.id.txtNome7);
        txtNome8 = (TextView)findViewById(R.id.txtNome8);
        txtNome9 = (TextView)findViewById(R.id.txtNome9);
        txtNome10 = (TextView)findViewById(R.id.txtNome10);
        txtNome11 = (TextView)findViewById(R.id.txtNome11);
        txtNome12 = (TextView)findViewById(R.id.txtNome12);
        txtNome13 = (TextView)findViewById(R.id.txtNome13);
        txtNome.setVisibility(View.INVISIBLE);
        txtNome2.setVisibility(View.INVISIBLE);
        txtNome3.setVisibility(View.INVISIBLE);
        txtNome4.setVisibility(View.INVISIBLE);
        txtNome5.setVisibility(View.INVISIBLE);
        txtNome6.setVisibility(View.INVISIBLE);
        txtNome7.setVisibility(View.INVISIBLE);
        txtNome8.setVisibility(View.INVISIBLE);
        txtNome9.setVisibility(View.INVISIBLE);
        txtNome10.setVisibility(View.INVISIBLE);
        txtNome11.setVisibility(View.INVISIBLE);
        txtNome12.setVisibility(View.INVISIBLE);
        txtNome13.setVisibility(View.INVISIBLE);
        //TextView de Preços
        txtPreco0 = (TextView) findViewById(R.id.txtPreco0);
        txtPreco = (TextView) findViewById(R.id.txtPreco);
        txtPreco2 = (TextView) findViewById(R.id.txtPreco2);
        txtPreco3 = (TextView) findViewById(R.id.txtPreco3);
        txtPreco4 = (TextView) findViewById(R.id.txtPreco4);
        txtPreco5 = (TextView) findViewById(R.id.txtPreco5);
        txtPreco6 = (TextView) findViewById(R.id.txtPreco6);
        txtPreco7 = (TextView) findViewById(R.id.txtPreco7);
        txtPreco8 = (TextView) findViewById(R.id.txtPreco8);
        txtPreco9 = (TextView) findViewById(R.id.txtPreco9);
        txtPreco10 = (TextView) findViewById(R.id.txtPreco10);
        txtPreco11 = (TextView) findViewById(R.id.txtPreco11);
        txtPreco12 = (TextView) findViewById(R.id.txtPreco12);
        txtPreco13 = (TextView) findViewById(R.id.txtPreco13);
        txtPreco0.setVisibility(View.INVISIBLE);
        txtPreco.setVisibility(View.INVISIBLE);
        txtPreco2.setVisibility(View.INVISIBLE);
        txtPreco3.setVisibility(View.INVISIBLE);
        txtPreco4.setVisibility(View.INVISIBLE);
        txtPreco5.setVisibility(View.INVISIBLE);
        txtPreco6.setVisibility(View.INVISIBLE);
        txtPreco7.setVisibility(View.INVISIBLE);
        txtPreco8.setVisibility(View.INVISIBLE);
        txtPreco9.setVisibility(View.INVISIBLE);
        txtPreco10.setVisibility(View.INVISIBLE);
        txtPreco11.setVisibility(View.INVISIBLE);
        txtPreco12.setVisibility(View.INVISIBLE);
        txtPreco13.setVisibility(View.INVISIBLE);




        Intent it = getIntent();
        Bundle parametros = it.getExtras();
        if(parametros != null){
            DAOElist dao = new DAOElist(getBaseContext());
            beanElist = new BeanElist();
            beanElist.setId(parametros.getInt("id"));

            dao.open();
            beanElist = dao.selectUm(beanElist);
            dao.close();

            preencheDados();

        }
        //Float Button
        FloatingActionButton plus = (FloatingActionButton) findViewById(R.id.plusButton);
        assert  plus != null;
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (beanElist.getId() == 0) {
                    if (contador == 1) {
                        txtNome.setVisibility(View.VISIBLE);
                        //img.setVisibility(View.VISIBLE);
                        //txtPreco2.setVisibility(View.VISIBLE);
                        edtNome.setVisibility(View.VISIBLE);
                        //edtPreco2.setVisibility(View.VISIBLE);
                        contador++;
                        outroContador++;
                        // contadorItens++;
                        promptSpeechInput();
                    } else if (contador == 2) {
                        txtNome2.setVisibility(View.VISIBLE);
                        //img2.setVisibility(View.VISIBLE);
                        //txtPreco3.setVisibility(View.VISIBLE);
                        edtNome2.setVisibility(View.VISIBLE);
                        //edtPreco3.setVisibility(View.VISIBLE);
                        contador++;
                        outroContador++;
                        // contadorItens++;
                        promptSpeechInput();
                    } else if (contador == 3) {
                        txtNome3.setVisibility(View.VISIBLE);
                        //img3.setVisibility(View.VISIBLE);
                        //txtPreco4.setVisibility(View.VISIBLE);
                        edtNome3.setVisibility(View.VISIBLE);
                        //edtPreco4.setVisibility(View.VISIBLE);
                        contador++;
                        outroContador++;
                        //contadorItens++;
                        promptSpeechInput();
                    } else if (contador == 4) {
                        txtNome4.setVisibility(View.VISIBLE);
                        //img4.setVisibility(View.VISIBLE);
                        //txtPreco5.setVisibility(View.VISIBLE);
                        edtNome4.setVisibility(View.VISIBLE);
                        //edtPreco5.setVisibility(View.VISIBLE);
                        contador++;
                        outroContador++;
                        // contadorItens++;
                        promptSpeechInput();
                    } else if (contador == 5) {
                        txtNome5.setVisibility(View.VISIBLE);
                        //img5.setVisibility(View.VISIBLE);
                        //txtPreco6.setVisibility(View.VISIBLE);
                        edtNome5.setVisibility(View.VISIBLE);
                        //edtPreco6.setVisibility(View.VISIBLE);
                        contador++;
                        outroContador++;
                        // contadorItens++;
                        promptSpeechInput();
                    } else if (contador == 6) {
                        txtNome6.setVisibility(View.VISIBLE);
                        //img6.setVisibility(View.VISIBLE);
                        //txtPreco7.setVisibility(View.VISIBLE);
                        edtNome6.setVisibility(View.VISIBLE);
                        //edtPreco7.setVisibility(View.VISIBLE);
                        contador++;
                        outroContador++;
                        //  contadorItens++;
                        promptSpeechInput();
                    } else if (contador == 7) {
                        txtNome7.setVisibility(View.VISIBLE);
                        //img7.setVisibility(View.VISIBLE);
                        //txtPreco6.setVisibility(View.VISIBLE);
                        edtNome7.setVisibility(View.VISIBLE);
                        //edtPreco6.setVisibility(View.VISIBLE);
                        contador++;
                        outroContador++;
                        // contadorItens++;
                        promptSpeechInput();
                    } else if (contador == 8) {
                        txtNome8.setVisibility(View.VISIBLE);
                        //img8.setVisibility(View.VISIBLE);
                        //txtPreco6.setVisibility(View.VISIBLE);
                        edtNome8.setVisibility(View.VISIBLE);
                        //edtPreco6.setVisibility(View.VISIBLE);
                        contador++;
                        outroContador++;
                        // contadorItens++;
                        promptSpeechInput();
                    } else if (contador == 9) {
                        txtNome9.setVisibility(View.VISIBLE);
                        //img9.setVisibility(View.VISIBLE);
                        //txtPreco6.setVisibility(View.VISIBLE);
                        edtNome9.setVisibility(View.VISIBLE);
                        //edtPreco6.setVisibility(View.VISIBLE);
                        contador++;
                        outroContador++;
                        // contadorItens++;
                        promptSpeechInput();
                    } else if (contador == 10) {
                        txtNome10.setVisibility(View.VISIBLE);
                        //img10.setVisibility(View.VISIBLE);
                        //txtPreco6.setVisibility(View.VISIBLE);
                        edtNome10.setVisibility(View.VISIBLE);
                        //edtPreco6.setVisibility(View.VISIBLE);
                        contador++;
                        outroContador++;
                        // contadorItens++;
                        promptSpeechInput();
                    } else if (contador == 11) {
                        txtNome11.setVisibility(View.VISIBLE);
                        //img11.setVisibility(View.VISIBLE);
                        //txtPreco6.setVisibility(View.VISIBLE);
                        edtNome11.setVisibility(View.VISIBLE);
                        //edtPreco6.setVisibility(View.VISIBLE);
                        contador++;
                        outroContador++;
                        // contadorItens++;
                        promptSpeechInput();
                    } else if (contador == 12) {
                        txtNome12.setVisibility(View.VISIBLE);
                        //img12.setVisibility(View.VISIBLE);
                        //txtPreco6.setVisibility(View.VISIBLE);
                        edtNome12.setVisibility(View.VISIBLE);
                        //edtPreco6.setVisibility(View.VISIBLE);
                        contador++;
                        outroContador++;
                        // contadorItens++;
                        promptSpeechInput();
                    } else if (contador == 13) {
                        txtNome13.setVisibility(View.VISIBLE);
                        //img13.setVisibility(View.VISIBLE);
                        //txtPreco6.setVisibility(View.VISIBLE);
                        edtNome13.setVisibility(View.VISIBLE);
                        //edtPreco6.setVisibility(View.VISIBLE);
                        contador++;
                        outroContador++;
                        // contadorItens++;
                        promptSpeechInput();
                    }
                }  if (beanElist.getId() != 0) {
                        contador = Integer.parseInt(beanElist.getNumeroItens());
                        outroContador = Integer.parseInt(beanElist.getNumeroItens());
                        outroContador --;
                        mVerdade = true;
                        if (contador == 1) {
                            txtNome.setVisibility(View.VISIBLE);
                            //img.setVisibility(View.VISIBLE);
                            //txtPreco2.setVisibility(View.VISIBLE);
                            edtNome.setVisibility(View.VISIBLE);
                            //edtPreco2.setVisibility(View.VISIBLE);
                            contador++;
                            outroContador++;
                            // contadorItens++;
                            promptSpeechInput();
                            updateContador();

                        }else if (contador == 2) {
                            txtNome2.setVisibility(View.VISIBLE);
                            //img2.setVisibility(View.VISIBLE);
                            //txtPreco3.setVisibility(View.VISIBLE);
                            edtNome2.setVisibility(View.VISIBLE);
                            //edtPreco3.setVisibility(View.VISIBLE);
                            contador++;
                            outroContador++;
                            // contadorItens++;
                            promptSpeechInput();
                            updateContador();

                        }else if (contador == 3) {
                            txtNome3.setVisibility(View.VISIBLE);
                            //img3.setVisibility(View.VISIBLE);
                            //txtPreco4.setVisibility(View.VISIBLE);
                            edtNome3.setVisibility(View.VISIBLE);
                            //edtPreco4.setVisibility(View.VISIBLE);
                            contador++;
                            outroContador++;
                            //contadorItens++;
                            promptSpeechInput();
                            updateContador();

                        } else if (contador == 4) {
                            txtNome4.setVisibility(View.VISIBLE);
                            //img4.setVisibility(View.VISIBLE);
                            //txtPreco5.setVisibility(View.VISIBLE);
                            edtNome4.setVisibility(View.VISIBLE);
                            //edtPreco5.setVisibility(View.VISIBLE);
                            contador++;
                            outroContador++;
                            // contadorItens++;
                            promptSpeechInput();
                            updateContador();

                        } else if (contador == 5) {
                            txtNome5.setVisibility(View.VISIBLE);
                            //img5.setVisibility(View.VISIBLE);
                            //txtPreco6.setVisibility(View.VISIBLE);
                            edtNome5.setVisibility(View.VISIBLE);
                            //edtPreco6.setVisibility(View.VISIBLE);
                            contador++;
                            outroContador++;
                            // contadorItens++;
                            promptSpeechInput();
                            updateContador();
                        } else if (contador == 6) {
                            txtNome6.setVisibility(View.VISIBLE);
                            //img6.setVisibility(View.VISIBLE);
                            //txtPreco7.setVisibility(View.VISIBLE);
                            edtNome6.setVisibility(View.VISIBLE);
                            //edtPreco7.setVisibility(View.VISIBLE);
                            contador++;
                            outroContador++;
                            //  contadorItens++;
                            promptSpeechInput();
                            updateContador();
                        } else if (contador == 7) {
                            txtNome7.setVisibility(View.VISIBLE);
                            //img7.setVisibility(View.VISIBLE);
                            //txtPreco6.setVisibility(View.VISIBLE);
                            edtNome7.setVisibility(View.VISIBLE);
                            //edtPreco6.setVisibility(View.VISIBLE);
                            contador++;
                            outroContador++;
                            // contadorItens++;
                            promptSpeechInput();
                            updateContador();
                        } else if (contador == 8) {
                            txtNome8.setVisibility(View.VISIBLE);
                            //img8.setVisibility(View.VISIBLE);
                            //txtPreco6.setVisibility(View.VISIBLE);
                            edtNome8.setVisibility(View.VISIBLE);
                            //edtPreco6.setVisibility(View.VISIBLE);
                            contador++;
                            outroContador++;
                            // contadorItens++;
                            promptSpeechInput();
                            updateContador();
                        } else if (contador == 9) {
                            txtNome9.setVisibility(View.VISIBLE);
                            //img9.setVisibility(View.VISIBLE);
                            //txtPreco6.setVisibility(View.VISIBLE);
                            edtNome9.setVisibility(View.VISIBLE);
                            //edtPreco6.setVisibility(View.VISIBLE);
                            contador++;
                            outroContador++;
                            // contadorItens++;
                            promptSpeechInput();
                            updateContador();
                        } else if (contador == 10) {
                            txtNome10.setVisibility(View.VISIBLE);
                            //img10.setVisibility(View.VISIBLE);
                            //txtPreco6.setVisibility(View.VISIBLE);
                            edtNome10.setVisibility(View.VISIBLE);
                            //edtPreco6.setVisibility(View.VISIBLE);
                            contador++;
                            outroContador++;
                            // contadorItens++;
                            promptSpeechInput();
                            updateContador();
                        } else if (contador == 11) {
                            txtNome11.setVisibility(View.VISIBLE);
                            //img11.setVisibility(View.VISIBLE);
                            //txtPreco6.setVisibility(View.VISIBLE);
                            edtNome11.setVisibility(View.VISIBLE);
                            //edtPreco6.setVisibility(View.VISIBLE);
                            contador++;
                            outroContador++;
                            // contadorItens++;
                            promptSpeechInput();
                            updateContador();
                        } else if (contador == 12) {
                            txtNome12.setVisibility(View.VISIBLE);
                            //img12.setVisibility(View.VISIBLE);
                            //txtPreco6.setVisibility(View.VISIBLE);
                            edtNome12.setVisibility(View.VISIBLE);
                            //edtPreco6.setVisibility(View.VISIBLE);
                            contador++;
                            outroContador++;
                            // contadorItens++;
                            promptSpeechInput();
                            updateContador();
                        } else if (contador == 13) {
                            txtNome13.setVisibility(View.VISIBLE);
                            //img13.setVisibility(View.VISIBLE);
                            //txtPreco6.setVisibility(View.VISIBLE);
                            edtNome13.setVisibility(View.VISIBLE);
                            //edtPreco6.setVisibility(View.VISIBLE);
                             contador++;
                            outroContador++;
                            // contadorItens++;
                            promptSpeechInput();
                            updateContador();
                        }

                }


            }
        });
       // beanElist.setContadorItens(contadorTeste);
        //Float Button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promptSpeechInput();

             //Aqui vai entra a API de voz do gloogle
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                     //   .setAction("Action", null).show();
            }
        });
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void updateContador(){
        DAOElist daoElist = new DAOElist(getBaseContext());

        beanElist.setNumeroItens(Integer.toString(contador));
        daoElist.open();
        daoElist.updateNumeroItem(beanElist);
        daoElist.close();
    }

    public void inserir() throws SQLException{
        DAOElist daoElist = new DAOElist(getBaseContext());


        beanElist.setNome(mensage);
        //DADOS
        beanElist.setDados0(edtNome0.getText().toString());
        beanElist.setDados(edtNome.getText().toString());
        beanElist.setDados2(edtNome2.getText().toString());
        beanElist.setDados3(edtNome3.getText().toString());
        beanElist.setDados4(edtNome4.getText().toString());
        beanElist.setDados5(edtNome5.getText().toString());
        beanElist.setDados6(edtNome6.getText().toString());
        beanElist.setDados7(edtNome7.getText().toString());
        beanElist.setDados8(edtNome8.getText().toString());
        beanElist.setDados9(edtNome9.getText().toString());
        beanElist.setDados10(edtNome10.getText().toString());
        beanElist.setDados11(edtNome11.getText().toString());
        beanElist.setDados12(edtNome12.getText().toString());
        beanElist.setDados13(edtNome13.getText().toString());

        //PREÇO
        beanElist.setPreco0(edtPreco0.getText().toString());
        beanElist.setPreco(edtPreco.getText().toString());
        beanElist.setPreco2(edtPreco2.getText().toString());
        beanElist.setPreco3(edtPreco3.getText().toString());
        beanElist.setPreco4(edtPreco4.getText().toString());
        beanElist.setPreco5(edtPreco5.getText().toString());
        beanElist.setPreco6(edtPreco6.getText().toString());
        beanElist.setPreco7(edtPreco7.getText().toString());
        beanElist.setPreco8(edtPreco8.getText().toString());
        beanElist.setPreco9(edtPreco9.getText().toString());
        beanElist.setPreco10(edtPreco10.getText().toString());
        beanElist.setPreco11(edtPreco11.getText().toString());
        beanElist.setPreco12(edtPreco12.getText().toString());
        beanElist.setPreco13(edtPreco13.getText().toString());
        beanElist.setNumeroItens(Integer.toString(contador));

        daoElist.open();
        daoElist.insert(beanElist);
        daoElist.close();
    }

    public void excluir(){
        DAOElist daoElist = new DAOElist(getBaseContext());
        try{
            daoElist.open();
            daoElist.delete(beanElist);
            daoElist.close();
        }catch (Exception ex){
            android.app.AlertDialog.Builder dlg = new android.app.AlertDialog.Builder(getBaseContext());
            dlg.setMessage("Erro ao deletar" + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }

    }

    private void alterar() throws SQLException{
        DAOElist daoElist = new DAOElist(getBaseContext());


        //beanElist.setNome(edtNome0.getText().toString());
        //DADOS
        beanElist.setDados0(edtNome0.getText().toString());
        beanElist.setDados(edtNome.getText().toString());
        beanElist.setDados2(edtNome2.getText().toString());
        beanElist.setDados3(edtNome3.getText().toString());
        beanElist.setDados4(edtNome4.getText().toString());
        beanElist.setDados5(edtNome5.getText().toString());
        beanElist.setDados6(edtNome6.getText().toString());
        beanElist.setDados7(edtNome7.getText().toString());
        beanElist.setDados8(edtNome8.getText().toString());
        beanElist.setDados9(edtNome9.getText().toString());
        beanElist.setDados10(edtNome10.getText().toString());
        beanElist.setDados11(edtNome11.getText().toString());
        beanElist.setDados12(edtNome12.getText().toString());
        beanElist.setDados13(edtNome13.getText().toString());
        //PREÇO
        beanElist.setPreco0(edtPreco0.getText().toString());
        beanElist.setPreco(edtPreco.getText().toString());
        beanElist.setPreco2(edtPreco2.getText().toString());
        beanElist.setPreco3(edtPreco3.getText().toString());
        beanElist.setPreco4(edtPreco4.getText().toString());
        beanElist.setPreco5(edtPreco5.getText().toString());
        beanElist.setPreco6(edtPreco6.getText().toString());
        beanElist.setPreco7(edtPreco7.getText().toString());
        beanElist.setPreco8(edtPreco8.getText().toString());
        beanElist.setPreco9(edtPreco9.getText().toString());
        beanElist.setPreco10(edtPreco10.getText().toString());
        beanElist.setPreco11(edtPreco11.getText().toString());
        beanElist.setPreco12(edtPreco12.getText().toString());
        beanElist.setPreco13(edtPreco13.getText().toString());
        if(mVerdade == false){
            beanElist.setNumeroItens(Integer.toString(contadorAfterUpdate));
        }else if(mVerdade == true){
            beanElist.setNumeroItens(Integer.toString(contador));
        }

        daoElist.open();
        daoElist.update(beanElist);
        //daoElist.updateNumeroItem(contador);
        daoElist.close();
    }

    private void preencheDados(){

        //DADOS
        edtNome0.setText(beanElist.getDados0());
        edtNome.setText(beanElist.getDados());
        edtNome2.setText(beanElist.getDados2());
        edtNome3.setText(beanElist.getDados3());
        edtNome4.setText(beanElist.getDados4());
        edtNome5.setText(beanElist.getDados5());
        edtNome6.setText(beanElist.getDados6());
        edtNome7.setText(beanElist.getDados7());
        edtNome8.setText(beanElist.getDados8());
        edtNome9.setText(beanElist.getDados9());
        edtNome10.setText(beanElist.getDados10());
        edtNome11.setText(beanElist.getDados11());
        edtNome12.setText(beanElist.getDados12());
        edtNome13.setText(beanElist.getDados13());
        //PREÇO
        edtPreco0.setText(beanElist.getPreco0());
        edtPreco.setText(beanElist.getPreco());
        edtPreco2.setText(beanElist.getPreco2());
        edtPreco3.setText(beanElist.getPreco3());
        edtPreco4.setText(beanElist.getPreco4());
        edtPreco5.setText(beanElist.getPreco5());
        edtPreco6.setText(beanElist.getPreco6());
        edtPreco7.setText(beanElist.getPreco7());
        edtPreco8.setText(beanElist.getPreco8());
        edtPreco9.setText(beanElist.getPreco9());
        edtPreco10.setText(beanElist.getPreco10());
        edtPreco11.setText(beanElist.getPreco11());
        edtPreco12.setText(beanElist.getPreco12());
        edtPreco13.setText(beanElist.getPreco13());
        if(edtNome0.getText().toString().equals("")) {

        }else{
            edtPreco0.setVisibility(View.VISIBLE);
            txtPreco0.setVisibility(View.VISIBLE);
            img0.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;
        }
        if(edtNome.getText().toString().equals("")){

        }else{
            txtNome.setVisibility(View.VISIBLE);
            edtNome.setVisibility(View.VISIBLE);
            edtPreco.setVisibility(View.VISIBLE);
            txtPreco.setVisibility(View.VISIBLE);
            img.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;
        }
        if(edtNome2.getText().toString().equals("")){

        }else {
            txtNome2.setVisibility(View.VISIBLE);
            txtPreco2.setVisibility(View.VISIBLE);
            edtNome2.setVisibility(View.VISIBLE);
            edtPreco2.setVisibility(View.VISIBLE);
            img2.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;
        }
        if(edtNome3.getText().toString().equals("")){
        }else{
            txtNome3.setVisibility(View.VISIBLE);
            txtPreco3.setVisibility(View.VISIBLE);
            edtNome3.setVisibility(View.VISIBLE);
            edtPreco3.setVisibility(View.VISIBLE);
            img3.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;
        }
        if(edtNome4.getText().toString().equals("")){
        }else {
            txtNome4.setVisibility(View.VISIBLE);
            txtPreco4.setVisibility(View.VISIBLE);
            edtNome4.setVisibility(View.VISIBLE);
            edtPreco4.setVisibility(View.VISIBLE);
            img4.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;

        }if(edtNome5.getText().toString().equals("")){
        }else{
            txtNome5.setVisibility(View.VISIBLE);
            txtPreco5.setVisibility(View.VISIBLE);
            edtNome5.setVisibility(View.VISIBLE);
            edtPreco5.setVisibility(View.VISIBLE);
            img5.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;
        }
        if(edtNome6.getText().toString().equals("")){
        }else{
            txtNome6.setVisibility(View.VISIBLE);
            txtPreco6.setVisibility(View.VISIBLE);
            edtNome6.setVisibility(View.VISIBLE);
            edtPreco6.setVisibility(View.VISIBLE);
            img6.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;
        }
        if(edtNome7.getText().toString().equals("")){
        }else{
            txtNome7.setVisibility(View.VISIBLE);
            txtPreco7.setVisibility(View.VISIBLE);
            edtNome7.setVisibility(View.VISIBLE);
            edtPreco7.setVisibility(View.VISIBLE);
            img7.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;
        }
        if(edtNome8.getText().toString().equals("")){
        }else{
            txtNome8.setVisibility(View.VISIBLE);
            txtPreco8.setVisibility(View.VISIBLE);
            edtNome8.setVisibility(View.VISIBLE);
            edtPreco8.setVisibility(View.VISIBLE);
            img8.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;
        }
        if(edtNome9.getText().toString().equals("")){
        }else{
            txtNome9.setVisibility(View.VISIBLE);
            txtPreco9.setVisibility(View.VISIBLE);
            edtNome9.setVisibility(View.VISIBLE);
            edtPreco9.setVisibility(View.VISIBLE);
            img9.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;
        }
        if(edtNome10.getText().toString().equals("")){
        }else{
            txtNome10.setVisibility(View.VISIBLE);
            txtPreco10.setVisibility(View.VISIBLE);
            edtNome10.setVisibility(View.VISIBLE);
            edtPreco10.setVisibility(View.VISIBLE);
            img10.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;
        }
        if(edtNome11.getText().toString().equals("")){
        }else{
            txtNome11.setVisibility(View.VISIBLE);
            txtPreco11.setVisibility(View.VISIBLE);
            edtNome11.setVisibility(View.VISIBLE);
            edtPreco11.setVisibility(View.VISIBLE);
            img11.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;
        }
        if(edtNome12.getText().toString().equals("")){
        }else{
            txtNome12.setVisibility(View.VISIBLE);
            txtPreco12.setVisibility(View.VISIBLE);
            edtNome12.setVisibility(View.VISIBLE);
            edtPreco12.setVisibility(View.VISIBLE);
            img12.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;
        }
        if(edtNome13.getText().toString().equals("")){
        }else{
            txtNome13.setVisibility(View.VISIBLE);
            txtPreco13.setVisibility(View.VISIBLE);
            edtNome13.setVisibility(View.VISIBLE);
            edtPreco13.setVisibility(View.VISIBLE);
            img13.setVisibility(View.VISIBLE);
            contadorAfterUpdate++;
        }

    }

    public void onBackPressed(){
        startActivity(new Intent(this,Home.class));
        finish();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_list_menu, menu);

        if(beanElist.getId() != 0) {
            menu.getItem(1).setVisible(true);
        }

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
                if(beanElist.getId() == 0) {
                    if(validateFields()) {
                        showDialog();
                    }
                }else{
                    if(validateFields()) {
                        try {
                            alterar();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        it = new Intent(getBaseContext(), Home.class);
                        startActivity(it);
                        finish();
                    }
                }


                break;
            case R.id.action_excluir:
                excluir();

            default:
                it = new Intent(getBaseContext(), Home.class);
                startActivity(it);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    if(outroContador == 0){
                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                     edtNome0.append((result.get(0)));
                    }else if(outroContador == 1){
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        edtNome.setText(result.get(0));
                    }else if(outroContador == 2){
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        edtNome2.setText(result.get(0));
                    }else if(outroContador == 3){
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        edtNome3.setText(result.get(0));
                    }else if(outroContador == 4){
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        edtNome4.setText(result.get(0));
                    }else if(outroContador == 5){
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        edtNome5.setText(result.get(0));
                    }else if(outroContador == 6){
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        edtNome6.setText(result.get(0));
                    }else if(outroContador == 7){
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        edtNome7.setText(result.get(0));
                    }else if(outroContador == 8){
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        edtNome8.setText(result.get(0));
                    }else if(outroContador == 9){
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        edtNome9.setText(result.get(0));
                    }else if(outroContador == 10){
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        edtNome10.setText(result.get(0));
                    }else if(outroContador == 11){
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        edtNome11.setText(result.get(0));
                    }else if(outroContador == 12){
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        edtNome12.setText(result.get(0));
                    }else if(outroContador == 13){
                        ArrayList<String> result = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        edtNome13.setText(result.get(0));
                    }
                }else
                    Toast.makeText(ListActivity.this, "No data received", Toast.LENGTH_LONG).show();
                break;
            }

        }



}

        public void showDialog(){
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog_cad_lista);

            final EditText text = (EditText) dialog.findViewById(R.id.edtTituloDialog);


            Button dialogButton = (Button) dialog.findViewById(R.id.btnCadDialog);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mensage = text.getText().toString();
                    try {

                        inserir();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    startActivity(new Intent(ListActivity.this, Home.class));
                    finish();
                    dialog.dismiss();
                }
            });

            dialog.show();


        }

    private boolean validateFields(){
        EditText emptyView = null;
        boolean isvalid = true;

        if(edtNome0.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome0.getText().toString())){
            emptyView = edtNome0;
        }else if(edtNome.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome.getText().toString())){
            emptyView = edtNome;
        }else if(edtNome2.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome2.getText().toString())){
            emptyView = edtNome2;
        }else if(edtNome3.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome3.getText().toString())){
            emptyView = edtNome3;
        }else if(edtNome4.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome4.getText().toString())){
            emptyView = edtNome4;
        }else if(edtNome5.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome5.getText().toString())){
            emptyView = edtNome5;
        }else if(edtNome6.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome6.getText().toString())){
            emptyView = edtNome6;
        }else if(edtNome7.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome7.getText().toString())){
            emptyView = edtNome7;
        }else if(edtNome8.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome8.getText().toString())){
            emptyView = edtNome8;
        }else if(edtNome9.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome9.getText().toString())){
            emptyView = edtNome9;
        }else if(edtNome10.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome10.getText().toString())){
            emptyView = edtNome10;
        }else if(edtNome11.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome11.getText().toString())){
            emptyView = edtNome11;
        }else if(edtNome12.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome12.getText().toString())){
            emptyView = edtNome12;
        }else if(edtNome13.getVisibility() == View.VISIBLE && TextUtils.isEmpty(edtNome13.getText().toString())){
            emptyView = edtNome13;
        }

        if(emptyView != null){
            emptyView.requestFocus();
            emptyView.setError("Campo Vazio");
            isvalid = false;
        }

        return isvalid;

    }



}
