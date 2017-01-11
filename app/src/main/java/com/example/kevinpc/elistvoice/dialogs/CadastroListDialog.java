package com.example.kevinpc.elistvoice.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kevinpc.elistvoice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kevinPC on 23/10/2016.
 */
public class CadastroListDialog extends DialogFragment {


    @BindView(R.id.txt_dialog_cad) TextView mHeadTitle;
    @BindView(R.id.header_menu_dialog) RelativeLayout mHeader;
   // @BindView(R.id.edtTituloDialog) EditText mEdtTitle;
    @BindView(R.id.btnCadDialog) Button mBtnCadastro;
   // private TextView mHeadTitle;
   // private RelativeLayout mHeader;
   // private TextView mTitle;
   // private EditText mEdtTitle;
   // private Button mBtnCadastro;

    private String mensage;
    private String texto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Dialog_MinWidth);

        //mensage = mEdtTitle.getText().toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // View view = inflater.inflate(R.layout.dialog_cad_lista, null);
        View view = inflater.inflate(R.layout.dialog_cad_lista, null);
        setupView(view);

        return view;
    }

    public static CadastroListDialog createInstance(String mensage){
        CadastroListDialog dialog = new CadastroListDialog();
        //BeanElist data = new BeanElist();
        //mensage = data.getNome();
        //data.setNome(dialog.mensage);
        //v.setTag(data);

        return dialog;
    }

    private void setupView(View view){
        ButterKnife.bind(this, view);
        final EditText edt = (EditText) view.findViewById(R.id.edtTituloDialog);
        //mensage = mEdtTitle.getText().toString();


        view.findViewById(R.id.btnCadDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mensage = edt.getText().toString();
                setTexto(mensage);
                getActivity().finish();
                //dismiss();
            }
        });


    }
    public String getText(){return texto;}
    public void setTexto(String texto){ this.texto =texto;}

}

