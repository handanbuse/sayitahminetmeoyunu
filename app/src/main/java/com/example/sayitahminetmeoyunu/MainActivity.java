package com.example.sayitahminetmeoyunu;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private TextView textviewkalanhak, txtsonuc;
    private EditText edittxtsayi;
    private String gelendeger;
    private int kalanhak=3, randomsayi;
    private Random number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // kullanıcının 3 hakkı olacak
        textviewkalanhak=findViewById(R.id.textkalanhak);
        txtsonuc=findViewById(R.id.txtsonuc);
        edittxtsayi=findViewById(R.id.edittxtsayi);

        number=new Random();
        randomsayi= number.nextInt(5);
        System.out.println("random sayı :" +randomsayi);


    }
    public  void btntahminet(View v){

        gelendeger=edittxtsayi.getText().toString();
        // gelen değerin boş olmadığını kontrol etmek için oluşur
        if(!TextUtils.isEmpty(gelendeger)){
            if(kalanhak>0){ // 0dan büyükse bunları yap
                if(gelendeger.equals(String.valueOf(randomsayi)))

                    sonucuGöster("tebrikler doğru tahminde bulundunuz");
                else {
                    kalanhak--;
                    txtsonuc.setText("yanlış tahminde bulunudunuz");
                }

                textviewkalanhak.setText("kalanhak:" + kalanhak);




                if(kalanhak==0)
                    sonucuGöster("tahmin hakkınız bitti");


            }
            else txtsonuc.setText("oyun bitti");
        }
        else txtsonuc.setText("girilen değer boş olamaz");
    }

    private void sonucuGöster(String mesaj) {
        edittxtsayi.setEnabled(false);
        txtsonuc.setText(mesaj);

    }
}