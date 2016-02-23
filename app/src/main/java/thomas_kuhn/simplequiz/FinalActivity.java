package thomas_kuhn.simplequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    private int numRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Bundle extras = getIntent().getExtras();
        numRight = extras.getInt("numRight");
        TextView text = (TextView) findViewById(R.id.textView2);
        text.setText("You got " + numRight + " questions out of 2 correct!");
    }

    public void exit(View v){
        finish();
    }

    public void restart(View v){
        Intent go = new Intent(this, QuestionOneActivity.class);
        startActivity(go);
        finish();
    }
}
