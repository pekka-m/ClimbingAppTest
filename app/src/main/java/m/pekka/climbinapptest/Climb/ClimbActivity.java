package m.pekka.climbinapptest.Climb;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import m.pekka.climbinapptest.ActivityInterface;
import m.pekka.climbinapptest.R;

/**
 * Created by Pekka Melgin on 23.10.2015.
 */
public class ClimbActivity extends AppCompatActivity implements ActivityInterface {

    private Button button_addClimb;
    private EditText editText_gradeNumber;
    private EditText editText_gradeLetter;
    private TextView textView_climbResult;
    private ClimbPresenter climbPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_climb);

        button_addClimb = (Button) findViewById(R.id.button_addClimb);
        button_addClimb.setOnClickListener(addClimb());

        editText_gradeNumber = (EditText) findViewById(R.id.editText_gradeNumber);
        editText_gradeLetter = (EditText) findViewById(R.id.editText_gradeLetter);
        textView_climbResult = (TextView) findViewById(R.id.textView_climbResult);

        climbPresenter = new ClimbPresenter(this);

    }

    @Override
    public void setResultMsg(String msg) {
        textView_climbResult.setText(msg);
    }

    @Override
    public Context getContext() {
        return this;
    }

    private View.OnClickListener addClimb() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                climbPresenter.addClimb(getGrade());
            }
        };
    }

    private String getGrade() {
        return editText_gradeNumber.getText().toString() + editText_gradeLetter.getText().toString();
    }
}
