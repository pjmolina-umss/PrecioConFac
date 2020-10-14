package com.example.precioconfac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView twcf;
    private EditText etsf;
    private RadioButton rbBs,rbDol;
    private DecimalFormat formato=new DecimalFormat("#.##");
    private TextView twtipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etsf=(EditText)findViewById(R.id.textSinFac);
        twcf=(TextView)findViewById(R.id.textConFac);
        rbBs=(RadioButton)findViewById(R.id.radioButtonBs);
        rbDol=(RadioButton)findViewById(R.id.radioButtonDol);
        twtipo=(TextView)findViewById(R.id.textTipo);


    }

    public void conIva(View view){
        String precioSF=etsf.getText().toString();
        int pSF=Integer.parseInt(precioSF);
        double iva=0;
        double pcf;
        iva=(0.14/(1-0.14)*pSF);
        pcf=pSF+iva;

        if(rbBs.isChecked()==true) {
            String piva = String.valueOf(formato.format(pcf));
            twcf.setText(piva);
            twtipo.setText("Bs.");
        }else if(rbDol.isChecked()==true){
            pcf=pcf/6.95;
            String piva= String.valueOf(formato.format(pcf));
            twcf.setText(piva);
            twtipo.setText("$us.");

        }
    }
}