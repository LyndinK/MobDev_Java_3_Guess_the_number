package com.example.number;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    Button bExit;
    Random randomchik = new Random();
    int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bExit = findViewById(R.id.button2);
        bControl = findViewById(R.id.button);
        random = randomchik.nextInt(100-0+1);

    }


    @SuppressLint("SetTextI18n")
    public void onClick(View view) {

        if (etInput.getText().length() != 0) {

            int value = Integer.parseInt(etInput.getText().toString());

            if (value >= 101 || value == 0) {
                tvInfo.setText(getString(R.string.errorrr));
            }
            else {

                if (value < random) {
                    tvInfo.setText(getString(R.string.niz));
                }
                if (value > random) {
                    tvInfo.setText(getString(R.string.verx));
                }
                if (value == random) {
                    tvInfo.setText(getString(R.string.pobeda));
                }
            }
        }
        else {
            tvInfo.setText(getString(R.string.errorr));
        }

        View.OnClickListener clickListenerE = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        };

        bExit.setOnClickListener(clickListenerE);


    }
}
