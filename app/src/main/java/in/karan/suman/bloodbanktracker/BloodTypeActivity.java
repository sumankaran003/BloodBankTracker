package in.karan.suman.bloodbanktracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BloodTypeActivity extends AppCompatActivity {

    Button ap,an,bp,bn,abp,abn,op,on;
    String state,district;
    String bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_type);

        Intent box = getIntent();
        Bundle b = box.getExtras();
        state=b.getString("state");
        district=b.getString("district");

        ap=findViewById(R.id.button1);
        an=findViewById(R.id.button2);
        bp=findViewById(R.id.button3);
        bn=findViewById(R.id.button4);
        abp=findViewById(R.id.button5);
        abn=findViewById(R.id.button6);
        op=findViewById(R.id.button7);
        on=findViewById(R.id.button8);

        ap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodTypeActivity.this,BloodCountActivity.class);
                intent.putExtra("state" , state);
                intent.putExtra("district" , district);
                intent.putExtra("bg","A+");
                startActivity(intent);
            }
        });

        an.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodTypeActivity.this,BloodCountActivity.class);
                intent.putExtra("state" , state);
                intent.putExtra("district" , district);
                intent.putExtra("bg","A-");
                startActivity(intent);
            }
        });

        bp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodTypeActivity.this,BloodCountActivity.class);
                intent.putExtra("state" , state);
                intent.putExtra("district" , district);
                intent.putExtra("bg","B+");
                startActivity(intent);
            }
        });

        bn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodTypeActivity.this,BloodCountActivity.class);
                intent.putExtra("state" , state);
                intent.putExtra("district" , district);
                intent.putExtra("bg","B-");
                startActivity(intent);
            }
        });

        abp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodTypeActivity.this,BloodCountActivity.class);
                intent.putExtra("state" , state);
                intent.putExtra("district" , district);
                intent.putExtra("bg","AB+");
                startActivity(intent);
            }
        });

        abn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodTypeActivity.this,BloodCountActivity.class);
                intent.putExtra("state" , state);
                intent.putExtra("district" , district);
                intent.putExtra("bg","AB-");
                startActivity(intent);
            }
        });

        op.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodTypeActivity.this,BloodCountActivity.class);
                intent.putExtra("state" , state);
                intent.putExtra("district" , district);
                intent.putExtra("bg","O+");
                startActivity(intent);
            }
        });

        on.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodTypeActivity.this,BloodCountActivity.class);
                intent.putExtra("state" , state);
                intent.putExtra("district" , district);
                intent.putExtra("bg","O-");
                startActivity(intent);
            }
        });





    }
}
