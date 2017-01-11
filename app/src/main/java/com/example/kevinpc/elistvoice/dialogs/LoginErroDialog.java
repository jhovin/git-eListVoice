package com.example.kevinpc.elistvoice.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kevinpc.elistvoice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kevinPC on 26/10/2016.
 */
public class LoginErroDialog extends DialogFragment {
    @BindView(R.id.header_menu_dialog) RelativeLayout mHeader;
    @BindView(R.id.txt_dialog_erro) TextView mHeaderText;
    @BindView(R.id.btnConfirmDialog) Button mButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Dialog_MinWidth);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_login_fail, null);
        setupView(view);

        return view;
    }

    private void setupView(View view){
        ButterKnife.bind(this, view);

        view.findViewById(R.id.btnConfirmDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // getActivity().recreate();
                dismiss();
            }
        });
    }
}
