package com.example.persona2fix.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.persona2fix.R;

public class MainPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        final CheckBox pemasukan = (CheckBox) findViewById(R.id.Pemasukan);
        final CheckBox pengeluaran=(CheckBox) findViewById(R.id.Pengeluaran);
        Button sumbit=(Button) findViewById(R.id.sumbit);

        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText uang = (EditText) findViewById(R.id.besar);
                EditText date = (EditText) findViewById(R.id.editText);
                EditText tujuan = (EditText) findViewById(R.id.editText3);
                if(uang.getText().toString().isEmpty()|| date.getText().toString().isEmpty()||
                        tujuan.getText().toString().isEmpty()||(!pemasukan.isChecked()&&!pengeluaran.isChecked()))
                {
                    Toast.makeText(getApplicationContext(), "Fill all data", Toast.LENGTH_SHORT).show();
                }
                else if(pemasukan.isChecked()&&pengeluaran.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "pilih hanya 1 jenis", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new
                            Intent(".SecondActivity");
                    Bundle extras = new Bundle();
                    extras.putString("uang", "Rp."+uang.getText().toString());
                    extras.putString("date", date.getText().toString());
                    extras.putString("tujuan", tujuan.getText().toString());
                    if(pemasukan.isChecked())
                    {
                        extras.putString("jenis", "Pemasukan");
                    }
                    else
                    {
                        extras.putString("jenis", "Pengeluaran");
                    }
//---attach the Bundle object to the Intent object---
                    i.putExtras(extras);
//---start the activity to get a result back---
                    setResult(RESULT_OK, i);
//---destroy the current activity---
                    finish();
                }
            }
        });




    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("lifecycle","onStart invoked");
        Toast.makeText(this, "onStart invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("lifecycle","onResume invoked");
        Toast.makeText(this, "onResume invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("lifecycle","onPause invoked");
        Toast.makeText(this, "onPause invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("lifecycle","onStop invoked");
        Toast.makeText(this, "onStop invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart(){
        super.onPause();
        Log.d("lifecycle","onRestart invoked");
        Toast.makeText(this, "onRestart invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");
        Toast.makeText(this, "onDestroy invoked", Toast.LENGTH_SHORT).show();
    }
}
