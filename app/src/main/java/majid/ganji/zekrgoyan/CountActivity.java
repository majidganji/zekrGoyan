package majid.ganji.zekrgoyan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;
import javaClass.CustomProgress;
import javaClass.Week;

public class CountActivity extends AppCompatActivity {

    CustomProgress cusCount;
    TextView txtZekr;
    ViewGroup lytCount1;
    ViewGroup lytCount2;

    private ArrayList<Week> week = new ArrayList<Week>();
    private String[] days = {"شنبه", "یکشنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنجشنبه", "جمعه"};
    private String[] zekrs = {"یا رب العالمین", "یا ذالجلال والاکرام", "یا قاضی الحاجات", "یا ارحم الراحمین",
            "یا حی یا قیوم", "لا اله الا الله الملک الحق المبین", "اللهم صل علی محمد و ال محمد"};

    private void initialize() {
        txtZekr = (TextView) findViewById(R.id.txtZekr);
        cusCount = (CustomProgress) findViewById(R.id.cusCount);
        lytCount1 = (ViewGroup) findViewById(R.id.lytCount1);
        lytCount2 = (ViewGroup) findViewById(R.id.lytCount2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        Bundle bundle = getIntent().getExtras();
        if (!bundle.containsKey("day")) {
            finish();
        }
        int day = bundle.getInt("day");

        initialize();

        for (int i = 0; i < 7; i++) {
            Week week = new Week();
            week.number = i;
            week.name = days[i];
            week.zekr = zekrs[i];
            this.week.add(week);
        }
        getDay(day);

        cusCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click();
            }
        });

        lytCount1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click();
            }
        });

        lytCount2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click();
            }
        });
    }

    private void getDay(int numberDay) {
        txtZekr.setText(this.week.get(numberDay).zekr);
    }

    private void click(){
        int count = cusCount.getPercent();
        if (count < 100){
            cusCount.setPercent(++count);
            if (count == 100){
                //TODO:: Alert message for complite zekr
                new SweetAlertDialog(this)
                        .setTitleText("ماشالله")
                        .setContentText("ذکر امروز تموم شد.")
                        .setConfirmText("خدایا شکر")
                        .show();
            }
        }
    }
}
