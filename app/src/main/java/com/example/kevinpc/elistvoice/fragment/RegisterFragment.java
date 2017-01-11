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

import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by kevinPC on 16/08/2016.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener{
    private OnFragmentInteractionListener mListener;
    private EditText mLogin;
    private EditText mSenha;

    @BindView(R.id.textView5) TextView mTextUser;
    @BindView(R.id.txtSenFragment) TextView mTextSenha;

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
       //Inflate layout
       View view = inflater.inflate(R.layout.fragment_criar_conta, container, false);

       ButterKnife.bind(this, view);
       view.findViewById(R.id.btnCadastrar).setOnClickListener(this);

       return view;
   }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        mLogin = (EditText) view.findViewById(R.id.edtUserLogin);
        mSenha = (EditText) view.findViewById(R.id.edtSenha);

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

        if(TextUtils.isEmpty(mLogin.getText().toString())){
            emptyView = mLogin;
        }else if(TextUtils.isEmpty(mSenha.getText().toString())){
            emptyView = mSenha;
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

        if (v.getId() == R.id.edtUserLogin) {
            try {
                mListener.onFragmentInteraction(v);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            if (validateFields()) {
                if (mListener != null) {

                    String username = mLogin.getText().toString();
                    String senha = mSenha.getText().toString();

                    BeanUsuario data = new BeanUsuario();
                   // UserData data = new UserData();
                    data.setUsername(username);
                    data.setSenha(senha);

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
