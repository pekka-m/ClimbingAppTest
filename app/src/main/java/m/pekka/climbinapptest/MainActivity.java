package m.pekka.climbinapptest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import m.pekka.climbinapptest.Campus.CampusPresenter;
import m.pekka.climbinapptest.Climb.ClimbPresenter;
import m.pekka.climbinapptest.Hangboard.HangboardPresenter;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private Button button_addClimb;
    private Button button_addCampus;
    private Button button_addHang;
    private Button button_status;
    private EditText editText_input;
    private TextView textView_result;
    private ClimbPresenter climbPresenter;
    private CampusPresenter campusPresenter;
    private HangboardPresenter hangboardPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_addClimb = (Button) findViewById(R.id.button_addClimb);
        button_addCampus = (Button) findViewById(R.id.button_addCampus);
        button_addHang = (Button) findViewById(R.id.button_addHang);
        button_status = (Button) findViewById(R.id.button_status);
        editText_input = (EditText) findViewById(R.id.editText_input);
        textView_result = (TextView) findViewById(R.id.textView_result);
        textView_result.setMovementMethod(new ScrollingMovementMethod());

        button_addClimb.setOnClickListener(addClimb());
        button_addCampus.setOnClickListener(addCampus());
        button_addHang.setOnClickListener(addHang());
        button_status.setOnClickListener(showStatus());

        campusPresenter = new CampusPresenter(this);
        climbPresenter = new ClimbPresenter(this);
        hangboardPresenter = new HangboardPresenter(this);
    }

    @Override
    public void setResultMsg(String msg) {
        textView_result.setText(msg + "\n" + textView_result.getText());
    }

    @Override
    public int getInput() {
        try {
            return Integer.parseInt(editText_input.getText().toString());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    private View.OnClickListener addClimb() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                climbPresenter.addClimb();
            }
        };
    }

    private View.OnClickListener addCampus() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                campusPresenter.addCampus();
            }
        };
    }

    private View.OnClickListener addHang() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                hangboardPresenter.addHang();
            }
        };
    }

    private View.OnClickListener showStatus() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                hangboardPresenter.getTotalHang();
                campusPresenter.getTotalSteps();
                climbPresenter.getAvgGrade();
            }
        };
    }
}
