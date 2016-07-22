package majid.ganji.zekrgoyan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        Bundle bundle = getIntent().getExtras();
        if (!bundle.containsKey("day")){
            finish();
        }
        int day = bundle.getInt("day");
        Toast.makeText(CountActivity.this, "" + day, Toast.LENGTH_SHORT).show();
    }
}
