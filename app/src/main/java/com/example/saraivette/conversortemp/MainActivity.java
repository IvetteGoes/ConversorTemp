package com.example.saraivette.conversortemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends Activity {

    double recibeTemperatura = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtRecibetemp = (TextView)findViewById(R.id.txtRecibetemp);
        final TextView txtFarenheit = (TextView)findViewById(R.id.txtFarenheit);
        final TextView txtKelven = (TextView)findViewById(R.id.txtKelven);

        final SeekBar seekBar1 = (SeekBar)findViewById(R.id.seekBar);
        seekBar1.setMax(3000);
        seekBar1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                recibeTemperatura = (double) (progress / 10.0);
                String texto = formatNumber(progress / 10.0);
                texto += " °C";
                txtRecibetemp.setText(texto);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final Button btnConvertir = (Button)findViewById(R.id.btnConvertir);
       btnConvertir.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View view) {

               double Farenheut = (((recibeTemperatura) * 9 / 5) + 32);
               String texto = formatNumber(Farenheut);
               texto += "°F";
               txtFarenheit.setText(texto);
               double Kelvin = (recibeTemperatura + 273);
               String texto2 = formatNumber(Kelvin);
               texto2 += "K";
               txtKelven.setText(texto2);
           }
       });
    }

    private String formatNumber (double valor){
        return String.format(Locale.FRANCE,"%2f", valor);
    }
}
