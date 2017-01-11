package com.example.kevinpc.elistvoice.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kevinpc.elistvoice.R;
import com.example.kevinpc.elistvoice.banco.BeanUsuario;
import com.example.kevinpc.elistvoice.banco.DAOusuario;

import java.sql.SQLException;

/**
 * Created by kevinPC on 16/08/2016.
 */
public class EntrarFragment extends Fragment implements View.OnClickListener {
    private OnFragmentInteractionListener mListener;
    private EditText mUsername;
    private EditText mPassword;
    private TextView txtLog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate layout
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        view.findViewById(R.id.btnEntrar).setOnClickListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        mUsername = (EditText) view.findViewById(R.id.edtCampoLogin);
        mPassword = (EditText) view.findViewById(R.id.edtCampoSenha);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private boolean validateFields(){
        EditText emptyView = null;
        boolean isvalid = true;

        if(TextUtils.isEmpty(mUsername.getText().toString())){
            emptyView = mUsername;
        }else if(TextUtils.isEmpty(mPassword.getText().toString())){
            emptyView = mPassword;
        }

        if(emptyView != null){
            emptyView.requestFocus();
            emptyView.setError("Campo Vazio");
            isvalid = false;
        }

        return isvalid;

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.edtCampoLogin) {
            try {
                mListener.onFragmentInteraction(v);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            if (validateFields()) {
                if (mListener != null) {

                    String nome = mUsername.getText().toString();
                    String sen = mPassword.getText().toString();

                    BeanUsuario data = new BeanUsuario();
                    // UserData data = new UserData();
                    data.setUsername(nome);
                    data.setSenha(sen);

                    v.setTag(data);

                    try {
                        mListener.onFragmentInteraction(v);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
