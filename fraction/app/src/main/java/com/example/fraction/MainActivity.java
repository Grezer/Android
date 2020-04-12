package com.example.fraction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstNumerator;
    EditText firstDenominator;
    EditText secondNumerator;
    EditText secondDenominator;
    RadioGroup radioGroup;
    TextView resultText;
    Button resultButton;
    Switch switchDisplayMode;
    Fraction firstInput = new Fraction();
    Fraction secondInput = new Fraction();
    Object result = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* ----------initialization View elements---------- */
        firstNumerator = findViewById(R.id.firstNumerator);
        firstDenominator = findViewById(R.id.firstDenominator);
        secondNumerator = findViewById(R.id.secondNumerator);
        secondDenominator = findViewById(R.id.secondDenominator);
        resultText = findViewById(R.id.resultText);
        resultButton = findViewById(R.id.resultButton);
        switchDisplayMode = findViewById(R.id.switchDisplayMode);

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    firstInput = new Fraction(Integer.parseInt(firstNumerator.getText().toString()), Integer.parseInt(firstDenominator.getText().toString()));
                    secondInput = new Fraction(Integer.parseInt(secondNumerator.getText().toString()), Integer.parseInt(secondDenominator.getText().toString()));
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Only numbers !!!",Toast.LENGTH_SHORT).show();
                    return;
                }

                radioGroup = findViewById(R.id.operator);
                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedOperator = findViewById(checkedId);
                String operator = selectedOperator.getText().toString();

                switch (operator) {
                    case ("+"):
                        if (switchDisplayMode.isChecked())
                            result = Fraction.sum(firstInput, secondInput, true);
                        else
                            result = Fraction.sum(firstInput, secondInput, false);
                        break;
                    case ("-"):
                        if (switchDisplayMode.isChecked())
                            result = Fraction.difference(firstInput, secondInput, true);
                        else
                            result = Fraction.difference(firstInput, secondInput, false);
                        break;
                    case ("*"):
                        if (switchDisplayMode.isChecked())
                            result = Fraction.multiplication(firstInput, secondInput, true);
                        else
                            result = Fraction.multiplication(firstInput, secondInput, false);
                        break;
                    case ("/"):
                        if (switchDisplayMode.isChecked())
                            result = Fraction.divide(firstInput, secondInput, true);
                        else
                            result = Fraction.divide(firstInput, secondInput, false);
                        break;
                    default:
                        break;
                }

                if(switchDisplayMode.isChecked()) {
                    Fraction resultFraction = (Fraction) result;
                    String firstPart = resultFraction.wholePart != 0 ? resultFraction.wholePart + " ": "";
                    String secondPart = " ( " +
                            (resultFraction.numerator < 0 && resultFraction.wholePart < 0 ?  resultFraction.numerator * -1 : resultFraction.numerator)
                            + " / " + resultFraction.denominator + " ) ";
                    resultText.setText(firstPart + secondPart); // add if wholePart = 0 - dont show!!!!
                } else {
                    double resultFraction = (double) result;
                    resultText.setText(Double.toString(resultFraction));
                }
            }
        });
    }
}
