package com.example.calculationfuel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText massIn;
    Button button;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        massIn = findViewById(R.id.massIn);
        button = findViewById(R.id.button);
        result = findViewById(R.id.result);

        button.setOnClickListener(event -> {
            double cargoWeight = Double.parseDouble(massIn.getText().toString());

            result.setText("Для вывода " + cargoWeight + " кг груза на орбиту марса необходимо "
                    + getCountFuel(cargoWeight) + " кг топлива.");
        });
    }
    /**
     * Метод подчета количества топлива для вывода груза на орбиту марса
     * @return количество топлива в кг
     */
    private static double getCountFuel(double inputWeight) {
        return inputWeight * (Constant.FUEL_RATIO * Constant.MARS_GRAVITY / Constant.EARTH_GRAVITY);
    }
}