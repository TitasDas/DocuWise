package com.example.sampleapp;

import android.content.res.AssetFileDescriptor;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

public class MainActivity extends AppCompatActivity {

    EditText Question;
    Button Ask,ViewSQL;
    TextView mAnswer, mTokens;
    String proshno;
    SqliteAdapter helper;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dbHelper = new DbHelper(getApplicationContext());
        //dbQueries = new DbQueries(getApplicationContext());
        //need a Db adapters

        helper = new SqliteAdapter(this);
        helper.insertBulkData();

        if (android.os.Build.VERSION.SDK_INT >= 9)    //originally 9 and done to get around "No Network Security config specified , using platform default"
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        mAnswer = findViewById(R.id.Answer);
        mTokens = findViewById(R.id.Tokens);

        Question = findViewById(R.id.Question);
        Question.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                mAnswer.setText("Answer will be displayed here");
                mTokens.setText("Tokens with POS tags will be displayed here");

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                mAnswer.setText("Please press the Ask Button after typing the question");

            }
        });

        Ask = findViewById(R.id.Ask);
        Ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                proshno = Question.getText().toString();

                if(proshno.length()== 0){
                    Toast.makeText(getApplicationContext(),"Please ask a question before pressing the ASK button", Toast.LENGTH_LONG).show();
                }

                else{
                    Log.i("LOG_PROSHNO", proshno);

                    //add a test to check for null value of question using !taskSuccessful

                    StringTokenization();

                    //AnswerQuery(); for returning from the database

                }

            }

        });

        ViewSQL = findViewById(R.id.ViewSQL);

        ViewSQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //Drop down list of the SQL table
            }
        });

    }

/*
    public void AnswerQuery(){

        final ArrayList<String> question = helper.getAnswer(); //helper.getAnswer()
        mAnswer.setText("Dummy answer displayed here");//actual answer

    }*/

    public void StringTokenization(){

        StringReader sr = new StringReader(proshno);
        ArrayList<String> joinTokens =  new ArrayList<>();

        try {
            if (sr.ready()){

                String[] Tokens = proshno.split("\\s");
                for(x=0; x<Tokens.length; x++){

                    joinTokens.add(Tokens[x]);

                    //System.out.println("arr:"+joinTokens);
                    //System.out.println("original tokens:"+Tokens[x]);
                }

                mTokens.setText(joinTokens.toString());

            }
        } catch (IOException e) {
            e.printStackTrace();
            mTokens.setText("StringReader not ready");
        }

        try{
            System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");

            AssetFileDescriptor fileDescriptor = getApplicationContext().getAssets().openFd("en.bin");
            InputStream modelInputStream = fileDescriptor.createInputStream();

            POSModel model = new POSModel(modelInputStream);

            POSTaggerME tagger = new POSTaggerME(model);

            String[] Tokens = proshno.split("\\s");

            String[] tags = tagger.tag(Tokens);

            System.out.println("Tags are:"+Arrays.toString(tags));

            mAnswer.setText(Arrays.toString(tags));

        }

        catch(IOException e){
            e.printStackTrace();

        }
    }
 }
