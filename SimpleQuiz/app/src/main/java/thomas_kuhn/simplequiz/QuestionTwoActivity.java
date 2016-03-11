package thomas_kuhn.simplequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;

public class QuestionTwoActivity extends AppCompatActivity {

    private int numRight;
    private boolean correctSelected;
    private RadioButton radio1, radio2, radio3, radio4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        correctSelected = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        numRight = extras.getInt("numRight");

        radio1 = (RadioButton)findViewById(R.id.radioButton1);
        radio2 = (RadioButton)findViewById(R.id.radioButton2);
        radio3 = (RadioButton)findViewById(R.id.radioButton3);
        radio4 = (RadioButton)findViewById(R.id.radioButton4);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void finalScreen(View v){
        if (correctSelected){
            Intent go = new Intent(this, FinalActivity.class);
            go.putExtra("numRight", numRight + 1);
            startActivity(go);
        } else {
            Intent go = new Intent(this, FinalActivity.class);
            go.putExtra("numRight", numRight);
            startActivity(go);
        }
        finish();
    }

    public void button1(View v){
        radio1.setChecked(true);
        radio2.setChecked(false);
        radio3.setChecked(false);
        radio4.setChecked(false);
        correctSelected = false;

    }

    public void button2(View v){
        radio1.setChecked(false);
        radio2.setChecked(true);
        radio3.setChecked(false);
        radio4.setChecked(false);
        correctSelected = false;

    }

    public void button3(View v){
        radio1.setChecked(false);
        radio2.setChecked(false);
        radio3.setChecked(true);
        radio4.setChecked(false);
        correctSelected = false;
    }

    public void button4(View v){
        radio1.setChecked(false);
        radio2.setChecked(false);
        radio3.setChecked(false);
        radio4.setChecked(true);
        correctSelected = true;
    }

}
