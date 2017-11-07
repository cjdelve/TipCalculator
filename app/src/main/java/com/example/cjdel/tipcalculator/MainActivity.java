package com.example.cjdel.tipcalculator;


// All items used in the app must be imported.
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //This is where the variables for the app will be defined.
    double preTipCost;
    String tipPercent;
    double tipAmount;
    double totalCost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a final variable for the cost before tipping. This variable
        // will not change after it is set, which is why we're setting it as
        // final.
        final EditText preCost = (EditText)findViewById(R.id.txtInitCost);
        final Spinner tipChoice = (Spinner)findViewById(R.id.tipChoice);
        Button costs = (Button)findViewById(R.id.calcTip);
            // Set things to happen on action.
            costs.setOnClickListener(new View.OnClickListener() {

                // Set the text view that will display the tip based on the chosen
                // percentage.
                final TextView result = ((TextView)findViewById(R.id.tipAmount));

                // Set the text view that displays the final cost including tip.
                final TextView result2 = ((TextView)findViewById(R.id.totalPlusTip));
                @Override
                public void onClick(View view){
                    preTipCost = Double.parseDouble(preCost.getText().toString());
                    // tipPercent = Integer.parseInt(tipChoice.toString());
                    tipPercent = tipChoice.getSelectedItem().toString();
                    DecimalFormat currency = new DecimalFormat("$###,###.00");

                    // Calculate costs.
                    // How much the tip will be, based on percent.
                    tipAmount = preTipCost * ((Double.parseDouble(tipPercent))/100);
                    totalCost = preTipCost + tipAmount;
                    result.setText("Tip: " + currency.format(tipAmount));
                    result2.setText("Total Including Tip: " + currency.format(totalCost));

                }
            });
    }
}
