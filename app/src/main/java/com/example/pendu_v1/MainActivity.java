package com.example.pendu_v1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewAutoScrollHelper;

import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout container;
    private ImageView image;
    private TextView letters;
    private TextView indice_text;
    private String word;
    private int found;
    private int error;
    private List<String> list_of_letters = new ArrayList<String>();
    private List<String> list_of_word = new ArrayList<String>();
    private final List<String> indice_list= new ArrayList<String>();
    private boolean win;
    private boolean test;
    private Button indice_button;
    private String indice;


    private ImageButton img_a;
    private ImageButton img_b;
    private ImageButton img_c;
    private ImageButton img_d;
    private ImageButton img_e;
    private ImageButton img_f;
    private ImageButton img_g;
    private ImageButton img_h;
    private ImageButton img_i;
    private ImageButton img_j;
    private ImageButton img_k;
    private ImageButton img_l;
    private ImageButton img_m;
    private ImageButton img_n;
    private ImageButton img_o;
    private ImageButton img_p;
    private ImageButton img_q;
    private ImageButton img_r;
    private ImageButton img_s;
    private ImageButton img_t;
    private ImageButton img_u;
    private ImageButton img_v;
    private ImageButton img_w;
    private ImageButton img_x;
    private ImageButton img_y;
    private ImageButton img_z;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        container = findViewById(R.id.word_container);
        image = findViewById(R.id.iv_pendu);
        letters =  findViewById(R.id.tv_letters);
        indice_text =  findViewById(R.id.indice_text);

        img_a = findViewById(R.id.a);
        img_a.setOnClickListener(this);

        img_b = findViewById(R.id.b);
        img_b.setOnClickListener(this);

        img_c = findViewById(R.id.c);
        img_c.setOnClickListener(this);

        img_d = findViewById(R.id.d);
        img_d.setOnClickListener(this);

        img_e = findViewById(R.id.e);
        img_e.setOnClickListener(this);

        img_f = findViewById(R.id.f);
        img_f.setOnClickListener(this);

        img_g = findViewById(R.id.g);
        img_g.setOnClickListener(this);

        img_h = findViewById(R.id.h);
        img_h.setOnClickListener(this);

        img_i = findViewById(R.id.i);
        img_i.setOnClickListener(this);

        img_j = findViewById(R.id.j);
        img_j.setOnClickListener(this);

        img_k = findViewById(R.id.k);
        img_k.setOnClickListener(this);

        img_l = findViewById(R.id.l);
        img_l.setOnClickListener(this);

        img_m = findViewById(R.id.m);
        img_m.setOnClickListener(this);

        img_n = findViewById(R.id.n);
        img_n.setOnClickListener(this);

        img_o = findViewById(R.id.o);
        img_o.setOnClickListener(this);

        img_p = findViewById(R.id.p);
        img_p.setOnClickListener(this);

        img_q = findViewById(R.id.q);
        img_q.setOnClickListener(this);

        img_r = findViewById(R.id.r);
        img_r.setOnClickListener(this);

        img_s = findViewById(R.id.s);
        img_s.setOnClickListener(this);

        img_t =  findViewById(R.id.t);
        img_t.setOnClickListener(this);

        img_u = findViewById(R.id.u);
        img_u.setOnClickListener(this);

        img_v = findViewById(R.id.v);
        img_v.setOnClickListener(this);

        img_w = findViewById(R.id.w);
        img_w.setOnClickListener(this);

        img_x = findViewById(R.id.x);
        img_x.setOnClickListener(this);

        img_y = findViewById(R.id.y);
        img_y.setOnClickListener(this);

        img_z = findViewById(R.id.z);
        img_z.setOnClickListener(this);


        indice_button= findViewById(R.id.indice_button);
        indice_button.setOnClickListener(this);

        initGame();

    }





    public void initGame() {
        indice = get_indice();
        list_of_word = new ArrayList<>();
        word = generate_word();
        win = false;
        test = true;
        error = 0;
        found = 0;
        letters.setText("");
        indice_text.setText("");
        image.setBackgroundResource(R.drawable.un);
        list_of_letters = new ArrayList<>();

        img_a.setVisibility(View.VISIBLE);
        img_b.setVisibility(View.VISIBLE);
        img_c.setVisibility(View.VISIBLE);
        img_d.setVisibility(View.VISIBLE);
        img_e.setVisibility(View.VISIBLE);
        img_f.setVisibility(View.VISIBLE);
        img_g.setVisibility(View.VISIBLE);
        img_h.setVisibility(View.VISIBLE);
        img_i.setVisibility(View.VISIBLE);
        img_j.setVisibility(View.VISIBLE);
        img_k.setVisibility(View.VISIBLE);
        img_l.setVisibility(View.VISIBLE);
        img_m.setVisibility(View.VISIBLE);
        img_n.setVisibility(View.VISIBLE);
        img_o.setVisibility(View.VISIBLE);
        img_p.setVisibility(View.VISIBLE);
        img_q.setVisibility(View.VISIBLE);
        img_r.setVisibility(View.VISIBLE);
        img_s.setVisibility(View.VISIBLE);
        img_t.setVisibility(View.VISIBLE);
        img_u.setVisibility(View.VISIBLE);
        img_v.setVisibility(View.VISIBLE);
        img_w.setVisibility(View.VISIBLE);
        img_x.setVisibility(View.VISIBLE);
        img_y.setVisibility(View.VISIBLE);
        img_z.setVisibility(View.VISIBLE);

        indice_button.setVisibility(View.VISIBLE);


        container.removeAllViews();
        for (int i = 0; i < word.length(); i++) {
            char c= word.charAt(i);
            switch (String.valueOf(c)) {
                case " ":
                    TextView oneSpace = (TextView) getLayoutInflater().inflate(R.layout.textspace, null);
                    container.addView(oneSpace);

                    break;
                case "'": {
                    TextView oneApo = (TextView) getLayoutInflater().inflate(R.layout.textapostrophe, null);
                    container.addView(oneApo);

                    break;
                }
                case "-": {
                    TextView oneDash = (TextView) getLayoutInflater().inflate(R.layout.textdash, null);
                    container.addView(oneDash);

                    break;
                }
                default:
                    TextView oneLetter = (TextView) getLayoutInflater().inflate(R.layout.textview, null);
                    container.addView(oneLetter);
                    break;
            }
        }
    }





    public void letter_in_word(String letter, String word) {
        for (int i = 0; i < word.length(); i++) {
            if(test){
                char c= word.charAt(i);
                switch (String.valueOf(c)) {
                    case " ":
                        found++;
                        break;
                    case "'":
                        found++;
                        break;
                    case "-":
                        found++;
                        break;
                }
            }
            if (letter.equals(String.valueOf(word.charAt(i)))) {
                TextView tv = (TextView) container.getChildAt(i);
                tv.setText(letter);
                found++;
            }
        }
        test =false;
    }





    public void letter_used(List<String> list_of_letters) {
        String chara = "";
        for (int i = 0; i < list_of_letters.size(); i++) {
            chara += list_of_letters.get(i) + "\n";
        }
        if (!chara.equals("")) {
            letters.setText(chara);
        }
    }





    public  void set_image(int error){
        switch (error){
            case 1:
                image.setBackgroundResource(R.drawable.deux);
                break;
            case 2:
                image.setBackgroundResource(R.drawable.trois);
                break;
            case 3:
                image.setBackgroundResource(R.drawable.quatre);
                break;
            case 4:
                image.setBackgroundResource(R.drawable.cinq);
                break;
            case 5:
                image.setBackgroundResource(R.drawable.six);
                break;
            case 6:
                image.setBackgroundResource(R.drawable.sept);
                break;
            case 7:
                image.setBackgroundResource(R.drawable.huite);
                break;
            case 8:
                image.setBackgroundResource(R.drawable.neuf);
                break;
            case 9:
                image.setBackgroundResource(R.drawable.dix);
                break;
        }
    }





    public void dialog(boolean win){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.ThemeOverlay_AppCompat_Dialog_Alert);
        builder.setTitle("Vous avez gagné !");
        builder.setCancelable(false);

        if (!win){
            builder.setTitle("Vous avez perdu !");
            builder.setMessage("Le mot à trouver était: "+word);
        }
        builder.setPositiveButton(getResources().getString(R.string.rejouer), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                initGame();
            }
        });
        builder.setNeutralButton(getResources().getString(R.string.menu), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent menu = new Intent(MainActivity.this, Accueil.class);
                startActivity(menu);
            }
        });
        builder.create().show();
    }

    public String get_indice(){
        //File repertoire = new File(""+getAssets());
        //File[] files=repertoire.listFiles();
        //Log.d("tete","tous les fichier dans assets: "+files+" rep: "+repertoire);

        indice_list.add("pendu_liste");
        indice_list.add("animaux");
        indice_list.add("complexe");
        indice_list.add("fruit et légume");
        int rand = (int) (Math.floor(Math.random() * indice_list.size()));
        String indice = indice_list.get(rand).trim();
        Log.d("tete","le fichier selectionné est : "+indice);
        return indice;
    }



    public List<String> get_list_of_words(){
        try{
            BufferedReader buffer = new BufferedReader(new InputStreamReader(getAssets().open(indice+".txt")));
            //Log.d("tete","dans get_list_of_words indice = "+indice);
            String line;
            while((line = buffer.readLine())!=null){
                list_of_word.add(line);
            }
            buffer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return list_of_word;
    }





    public String generate_word(){
        list_of_word = get_list_of_words();
        int rand = (int) (Math.floor(Math.random() * list_of_word.size()));
        String generated = list_of_word.get(rand).trim();
        return generated.toUpperCase();
    }




    @Override
    public void onClick(View view) {
        String input_letter;
        switch (view.getId()) {
            case R.id.a: {
                input_letter = "A";
                img_a.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.b: {
                input_letter = "B";
                img_b.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.c: {
                input_letter = "C";
                img_c.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.d: {
                input_letter = "D";
                img_d.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.e: {
                input_letter = "E";
                img_e.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.f: {
                input_letter = "F";
                img_f.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.g: {
                input_letter = "G";
                img_g.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.h: {
                input_letter = "H";
                img_h.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.i: {
                input_letter = "I";
                img_i.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.j: {
                input_letter = "J";
                img_j.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.k: {
                input_letter = "K";
                img_k.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.l: {
                input_letter = "L";
                img_l.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.m: {
                input_letter = "M";
                img_m.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.n: {
                input_letter = "N";
                img_n.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.o: {
                input_letter = "O";
                img_o.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.p: {
                input_letter = "P";
                img_p.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.q: {
                input_letter = "Q";
                img_q.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.r: {
                input_letter = "R";
                img_r.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.s: {
                input_letter = "S";
                img_s.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.t: {
                input_letter = "T";
                img_t.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.u: {
                input_letter = "U";
                img_u.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.v: {
                input_letter = "V";
                img_v.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.w: {
                input_letter = "W";
                img_w.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.x: {
                input_letter = "X";
                img_x.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.y: {
                input_letter = "Y";
                img_y.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.z: {
                input_letter = "Z";
                img_z.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.indice_button: {
                input_letter = "";
                indice_button.setVisibility(View.INVISIBLE);
                indice_text.setText(indice);
                //Log.d("tete","dans le onClick indice = "+indice);
                break;
            }
            default:
                input_letter = "";
        }

        letter_in_word(input_letter, word);
        list_of_letters.add(input_letter);
        //Log.d("tete","found = "+found+" et word length = "+word.length());
        if (found == word.length()) {
            win = true;
            dialog(win);
        }
        if (!word.contains((input_letter))) {
            error++;
        }
        set_image(error);
        if (error == 9) {
            win = false;
            dialog(win);
        }

        letter_used(list_of_letters);


    }
}