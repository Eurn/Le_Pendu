package com.example.pendu_v1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Accueil extends AppCompatActivity {
    private Accueil activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        this.activity=this;


        int delay = 1500;
        for(int i = 0; i<=100;i++) {

            YoYo.with(Techniques.Bounce)
                    .duration(1500)
                    .delay(delay)
                    .playOn(findViewById(R.id.play_bt));
            delay = delay+4000;
        }
        Button play_bt = (Button) findViewById(R.id.play_bt);
        play_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent game = new Intent(Accueil.this, MainActivity.class);
                startActivity(game);
            }
        });



        int delay2 = 3500;
        for(int i = 0; i<=100;i++) {
            YoYo.with(Techniques.Shake)
                    .duration(1500)
                    .delay(delay2)
                    .playOn(findViewById(R.id.play_bt_chrono));
            delay2=delay2+4000;
        }
        Button playChrono_bt = (Button) findViewById(R.id.play_bt_chrono);
        playChrono_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ImageView infoStandard = (ImageView) findViewById(R.id.infoStandard);
        infoStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder PopUp = new AlertDialog.Builder(activity);
                PopUp.setCancelable(false);
                PopUp.setTitle("Mode Standard : information");
                PopUp.setMessage("Le mode standard est le mode le plus simple, joué simplement, vous n'avez aucune restriction :)");
                PopUp.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Bonne chance ;)", Toast.LENGTH_SHORT).show();
                    }
                });
                PopUp.show();
            }
        });


        ImageView infoChrono = (ImageView) findViewById(R.id.infoChrono);
        infoChrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder PopUp = new AlertDialog.Builder(activity);
                PopUp.setCancelable(false);
                PopUp.setTitle("Mode Chrono : information");
                PopUp.setMessage("Indisponible pour le moment :(");
                PopUp.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Bonne chance ;)", Toast.LENGTH_SHORT).show();
                    }
                });
                PopUp.show();
            }
        });

    }


}