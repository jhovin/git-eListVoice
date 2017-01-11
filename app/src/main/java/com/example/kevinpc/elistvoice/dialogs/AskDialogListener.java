package com.example.kevinpc.elistvoice.dialogs;

import android.view.View;

/**
 * Created by kevinPC on 23/10/2016.
 */
public interface AskDialogListener {
    public static final int BUTTON_CONFIRM = 0;

    public void onClickButton(View view, int button_type, int dialogId, Object object);
}
