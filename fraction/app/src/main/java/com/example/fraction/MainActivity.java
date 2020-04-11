package com.example.fraction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fraction firstInput = new Fraction();
                Fraction secondInput = new Fraction();
                try {
                    firstInput = new Fraction(Integer.parseInt(firstNumerator.getText().toString()), Integer.parseInt(firstDenominator.getText().toString()));
                    secondInput = new Fraction(Integer.parseInt(secondNumerator.getText().toString()), Integer.parseInt(secondDenominator.getText().toString()));
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Only numbers !!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                Fraction result = new Fraction();

                radioGroup = findViewById(R.id.operator);
                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedOperator = findViewById(checkedId);
                String operator = selectedOperator.getText().toString();

                switch (operator) {
                    case ("+"):
                        result = Fraction.sum(firstInput, secondInput);
                        break;
                    case ("-"):
                        result = Fraction.difference(firstInput, secondInput);
                        break;
                    case ("*"):
                        result = Fraction.multiplication(firstInput, secondInput);
                        break;
                    case ("/"):
                        result = Fraction.divide(firstInput, secondInput);
                        break;
                    default:
                        break;
                }
                resultText.setText(result.numerator + " / " + result.denominator);
            }
        });
    }
}
