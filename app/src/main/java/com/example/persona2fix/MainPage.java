package com.example.persona2fix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
}
