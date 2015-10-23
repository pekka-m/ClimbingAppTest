package m.pekka.climbinapptest.Campus;

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
public class CampusActivity extends AppCompatActivity implements ActivityInterface {

    private Button button_addCampus;
    private EditText editText_campusSteps;
    private TextView textView_campusResult;
    private CampusPresenter campusPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);

        button_addCampus = (Button) findViewById(R.id.button_addCampus);
        button_addCampus.setOnClickListener(addCampus());

        editText_campusSteps = (EditText) findViewById(R.id.editText_campusSteps);
        textView_campusResult = (TextView) findViewById(R.id.textView_campusResult);

        campusPresenter = new CampusPresenter(this);

    }

    @Override
    public void setResultMsg(String msg) {
        textView_campusResult.setText(msg);
    }

    @Override
    public Context getContext() {
        return this;
    }

    private View.OnClickListener addCampus() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                campusPresenter.addCampus(getSteps());
            }
        };
    }

    private int getSteps() {
        try {
            return Integer.parseInt(editText_campusSteps.getText().toString());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
