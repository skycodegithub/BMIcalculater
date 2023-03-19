package com.example.bmical;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   // Button btnOkay = dialog.findViewById(R.id.btnOkay);
    //private Activity dialog;
   // private Dialog dialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);
        dialog.setCanceledOnTouchOutside(false);

        Button btnOkay = dialog.findViewById(R.id.btnOkay);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Closed", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
        EditText edtWeight ,edtHeightFt , edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;



        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn  = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);
        btnOkay = dialog.findViewById(R.id.btnOkay);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // Dialog dialog = new Dialog(MainActivity.this);
                //dialog.setContentView(R.layout.custom_dialog_layout);
                //dialog.setCanceledOnTouchOutside(false);



                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft * 12 + in;

                double totalCm = totalIn * 2.53;

                double totalIm = totalCm / 100;
                double bmi = wt / (totalIm * totalIm);

                if (bmi > 25) {
                   // Dialog dialog = new Dialog(MainActivity.this);
                   // dialog.setContentView(R.layout.custom_dialog_layout);
                    //dialog.setCanceledOnTouchOutside(false);
                    txtResult.setText("you are Overweight!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                   // Dialog dialog = new Dialog(MainActivity.this);
                    //Toast.makeText(MainActivity.this, "Closed", Toast.LENGTH_SHORT).show();
                    //dialog.dismiss();
                    //dialog.show();

                }else if ( bmi<18) {
                    txtResult.setText("you are Underweight!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));


                }else {
                    txtResult.setText("you are healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));

                }

            }
        });

    }
}