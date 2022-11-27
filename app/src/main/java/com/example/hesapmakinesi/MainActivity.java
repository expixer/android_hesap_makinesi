package com.example.hesapmakinesi;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView islem,sonuc;
    EditText ilk_sayi,ikinci_sayi;

    public void sonucuGuncelle(){
        if (ilk_sayi.getText().toString().equals("") || ikinci_sayi.getText().toString().equals("") || islem.getText().toString().equals(""))
            return;
        double islem_sonucu = 0;
        switch (islem.getText().toString()){
            case "/":
                islem_sonucu = Double.parseDouble(ilk_sayi.getText().toString()) / Double.parseDouble(ikinci_sayi.getText().toString());
                break;
            case "+":
                islem_sonucu = Double.parseDouble(ilk_sayi.getText().toString()) + Double.parseDouble(ikinci_sayi.getText().toString());
                break;
            case "-":
                islem_sonucu = Double.parseDouble(ilk_sayi.getText().toString()) - Double.parseDouble(ikinci_sayi.getText().toString());
                break;
            case "*":
                islem_sonucu = Double.parseDouble(ilk_sayi.getText().toString()) * Double.parseDouble(ikinci_sayi.getText().toString());
                break;
            case "mod":
                islem_sonucu = Double.parseDouble(ilk_sayi.getText().toString()) % Double.parseDouble(ikinci_sayi.getText().toString());
                break;
        }
        sonuc.setText(String.valueOf(islem_sonucu));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_0 = (Button) findViewById(R.id.button_0);
        Button button_1 = (Button) findViewById(R.id.button_1);
        Button button_2 = (Button) findViewById(R.id.button_2);
        Button button_3 = (Button) findViewById(R.id.button_3);
        Button button_4 = (Button) findViewById(R.id.button_4);
        Button button_5 = (Button) findViewById(R.id.button_5);
        Button button_6 = (Button) findViewById(R.id.button_6);
        Button button_7 = (Button) findViewById(R.id.button_7);
        Button button_8 = (Button) findViewById(R.id.button_8);
        Button button_9 = (Button) findViewById(R.id.button_9);
        Button button_arti = (Button) findViewById(R.id.button_arti);
        Button button_eksi = (Button) findViewById(R.id.button_eksi);
        Button button_carpi = (Button) findViewById(R.id.button_carpi);
        Button button_bolum = (Button) findViewById(R.id.button_bolum);
        Button button_mod_al = (Button) findViewById(R.id.button_mod_al);
        Button button_sifrla = (Button) findViewById(R.id.button_sifirla);
        islem = (TextView) findViewById(R.id.islem);
        sonuc = (TextView) findViewById(R.id.sonuc);
        ilk_sayi = (EditText) findViewById(R.id.ilk_sayi);
        ikinci_sayi = (EditText) findViewById(R.id.ikinci_sayi);

        View.OnClickListener sayiDinle = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                if (islem.getText().toString().equals("")) {
                    ilk_sayi.setText(ilk_sayi.getText() + button.getText().toString());
                } else {
                    ikinci_sayi.setText(ikinci_sayi.getText() + button.getText().toString());
                }
                sonucuGuncelle();
            }
        };
        button_0.setOnClickListener(sayiDinle);
        button_1.setOnClickListener(sayiDinle);
        button_2.setOnClickListener(sayiDinle);
        button_3.setOnClickListener(sayiDinle);
        button_4.setOnClickListener(sayiDinle);
        button_5.setOnClickListener(sayiDinle);
        button_6.setOnClickListener(sayiDinle);
        button_7.setOnClickListener(sayiDinle);
        button_8.setOnClickListener(sayiDinle);
        button_9.setOnClickListener(sayiDinle);

        View.OnClickListener islemDinle = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                islem.setText(button.getText().toString());
                sonucuGuncelle();
            }
        };

        button_arti.setOnClickListener(islemDinle);
        button_eksi.setOnClickListener(islemDinle);
        button_carpi.setOnClickListener(islemDinle);
        button_bolum.setOnClickListener(islemDinle);
        button_mod_al.setOnClickListener(islemDinle);

        button_sifrla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                islem.setText("");
                ilk_sayi.setText("");
                ikinci_sayi.setText("");
                sonuc.setText("");
            }
        });

        TextWatcher textDinle = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sonucuGuncelle();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        ilk_sayi.addTextChangedListener(textDinle);
        ikinci_sayi.addTextChangedListener(textDinle);

    }


}