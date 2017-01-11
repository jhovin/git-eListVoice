package com.example.kevinpc.elistvoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kevinPC on 02/08/2016.
 */
public class FinalActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intCloseApp = new Intent(Intent.ACTION_MAIN);
                intCloseApp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intCloseApp.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intCloseApp.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intCloseApp.addCategory(Intent.CATEGORY_HOME);
                intCloseApp.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intCloseApp);
                finish();
                onBackPressed();
            }
        },2000);
    }

    @Override
    public void onBackPressed(){
        Intent intCloseApp = new Intent(Intent.ACTION_MAIN);
        intCloseApp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intCloseApp.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intCloseApp.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intCloseApp.addCategory(Intent.CATEGORY_HOME);
        intCloseApp.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intCloseApp);
        finish();
    }
}
