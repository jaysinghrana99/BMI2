package eu.tutorials.bmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView Result;
        EditText edtweight,edtHeightFt,edtHeightIn;
        Button btncalculate;
        LinearLayout llMain;

        edtweight = findViewById(R.id.edtweight);
        edtHeightFt= findViewById(R.id.edtHeightFt);
        edtHeightIn= findViewById(R.id.edtHeightIn);
        btncalculate= findViewById(R.id.btncalculate);
        Result=findViewById(R.id.textresult);
        llMain = findViewById(R.id.llMain);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtweight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft*12 + in;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if (bmi > 25) {
                       Result.setText("you are OverWeight!");
                       llMain.setBackgroundColor(getResources().getColor(R.color.red));
                }else if (bmi<18){
                    Result.setText("you are UnderWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.yellow));
                }else {
                    Result.setText("you are Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.green));
                }

            }
        });

    }
}