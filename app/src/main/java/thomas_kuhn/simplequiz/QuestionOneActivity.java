package thomas_kuhn.simplequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class QuestionOneActivity extends AppCompatActivity {

    private String editAns = "Please Put Answer Here";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final EditText editAnswer = (EditText) findViewById(R.id.answer);
        editAnswer.setText( editAns, TextView.BufferType.EDITABLE);

        editAnswer.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                editAns = s.toString();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void startQuestionTwo(View v){
        if ((editAns.toLowerCase()).equals("barney")){
            Intent go = new Intent(this, QuestionTwoActivity.class);
            go.putExtra("numRight", 1);
            startActivity(go);
        } else {
            Intent go = new Intent(this, QuestionTwoActivity.class);
            go.putExtra("numRight", 0);
            startActivity(go);
        }

        finish();
    }

}
