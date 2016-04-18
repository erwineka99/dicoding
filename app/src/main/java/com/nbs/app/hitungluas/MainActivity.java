package com.nbs.app.hitungluas;

import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    private EditText edtPanjang, edtLebar;
    private Button btnHitung;
    private TextView txtLuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Hitung Luas Persegi Panjang");

        edtPanjang = (EditText) findViewById(R.id.edt_panjang);
        edtLebar = (EditText) findViewById(R.id.edt_lebar);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        txtLuas = (TextView) findViewById(R.id.txt_luas);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String panjang = edtPanjang.getText().toString().trim();
                String lebar = edtLebar.getText().toString().trim();

                //Cek Valdasi Kosong, Titik

                //jika validasi berhasil maka lakukan hitung
                if (cek_validasi_kosong_nol_titik(panjang, lebar) == true) {
                    hitung_luas(panjang, lebar);
                }


            }
        });


    }

    boolean cek_validasi_kosong_nol_titik(String panjang, String lebar) {
        boolean cek_valid = false;
        if (panjang.equalsIgnoreCase("0") || lebar.equalsIgnoreCase("0") || panjang.equalsIgnoreCase("") || lebar.equalsIgnoreCase("")) {
            Toast.makeText(MainActivity.this, "Harus di isi tidak boleh kosong ataupun bernilai nol", Toast.LENGTH_SHORT).show();
        } else if (panjang.equalsIgnoreCase(".") || lebar.equalsIgnoreCase(".")) {
            Toast.makeText(MainActivity.this, "Tidak boleh di isi hanya dengan titik", Toast.LENGTH_SHORT).show();
        } else {

            cek_valid = true;
        }
        return cek_valid;
    }

    void hitung_luas(String panjang, String lebar) {
        double p = Double.parseDouble(panjang);
        double l = Double.parseDouble(lebar);

        double luas = p * l;

        txtLuas.setText("Luas : " + luas);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
