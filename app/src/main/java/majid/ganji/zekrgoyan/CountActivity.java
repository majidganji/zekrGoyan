package majid.ganji.zekrgoyan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javaClass.Week;

public class CountActivity extends AppCompatActivity {

    TextView txtCount;
    private ArrayList<Week> week = new ArrayList<Week>();
    private String[] days = {"شنبه", "یکشنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنجشنبه", "جمعه"};
    private String[] zekrs = {"شنبه", "یکشنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنجشنبه", "جمعه"};

    private void initialize(){
        txtCount = (TextView) findViewById(R.id.txtCount);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        Bundle bundle = getIntent().getExtras();
        if (!bundle.containsKey("day")){
            finish();
        }
        int day = bundle.getInt("day");

        initialize();

        for(int i = 0; i < 7; i++){
            Week week = new Week();
            week.number = i;
            week.name = days[i];
            week.zekr = zekrs[i];
            this.week.add(week);
        }

        Toast.makeText(CountActivity.this, days[0], Toast.LENGTH_SHORT).show();
    }

    private void getDay(int numberDay){

    }
}
