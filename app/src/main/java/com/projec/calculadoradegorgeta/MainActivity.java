package com.projec.calculadoradegorgeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView txtGorgeta, txtTotal, txtPorcent;
    private EditText editText;
    private SeekBar seekBar;
    String inputTxt;
    float PorcentTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.EditText);
        txtGorgeta = findViewById(R.id.txtGorgeta);
        txtTotal = findViewById(R.id.Total);
        txtPorcent = findViewById(R.id.textPorcent);
        seekBar = findViewById(R.id.seekBar);

        txtPorcent.setText(seekBar.getProgress()+ "%");
        txtTotal.setText("R$ 0 ");

        txtGorgeta.setText("R$ " +seekBar.getProgress());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                inputTxt = editText.getText().toString();
                if ( !inputTxt.isEmpty() ){

                    float numFloat = Float.parseFloat(inputTxt);
                    int numInt = Integer.parseInt(inputTxt);

                    txtPorcent.setText(i+"%");
                    txtGorgeta.setText("R$ " + numInt * seekBar.getProgress() / 100);

                    PorcentTotal = numInt + (numFloat * seekBar.getProgress() / 100);
             // Formatar numero  com duas casas decimais
                    String TOTAL = new DecimalFormat("#,##0.00").format(PorcentTotal);
                    txtTotal.setText("R$ "+TOTAL);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (inputTxt.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Digite um valor acima",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}