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
import com.example.kevinpc.elistvoice.banco.BeanElist;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kevinPC on 27/10/2016.
 */
public class MenuShareDialog extends DialogFragment implements View.OnClickListener {
    /*@BindView(R.id.header_menu_dialog) RelativeLayout mHeader;
    @BindView(R.id.txt_dialog_menu) TextView mHeaderTitle;
    @BindView(R.id.txt_whats_dialog) TextView mWhats;
    @BindView(R.id.txt_face_dialog) TextView mFace;
    @BindView(R.id.btnShareConfirm) Button mBtnShare;*/

    public interface ImageSelectListener{
        public void onShareWhatsapp();
        public void onShareFacebook();
        public void onChangeTitle();
    }

    private ImageSelectListener mListener;

    public void setListener(ImageSelectListener listener){mListener = listener;}

    public static MenuShareDialog newInstance(ImageSelectListener listener){
        MenuShareDialog dialog = new MenuShareDialog();
        dialog.mListener = listener;

        return dialog;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Dialog_MinWidth);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_menu_share, null);
        //setupView(view);

        view.findViewById(R.id.txt_whats_dialog).setOnClickListener(this);
        view.findViewById(R.id.txt_face_dialog).setOnClickListener(this);
        view.findViewById(R.id.txt_change_title).setOnClickListener(this);
       // view.findViewById(R.id.btnShareConfirm).setOnClickListener(this);

        return view;
    }

   /* private void setupView(View view){
                ButterKnife.bind(this, view);

                view.findViewById(R.id.btnShareConfirm).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity();
                        dismiss();
            }
        });
    }*/
   @Override
   public void onClick(View v) {
       BeanElist bean = new BeanElist();
        final int id = v.getId();
       if(id == R.id.txt_whats_dialog){

       }else if(id == R.id.txt_face_dialog){

       }else if(id == R.id.txt_change_title){

       }
       dismiss();
   }
}
