package m.pekka.climbinapptest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import m.pekka.climbinapptest.Campus.CampusActivity;
import m.pekka.climbinapptest.Campus.CampusPresenter;
import m.pekka.climbinapptest.Climb.ClimbActivity;
import m.pekka.climbinapptest.Climb.ClimbPresenter;
import m.pekka.climbinapptest.Hangboard.HangboardActivity;
import m.pekka.climbinapptest.Hangboard.HangboardPresenter;

public class MainActivity extends AppCompatActivity implements ActivityInterface {

    private Context context;
    private Button button_moveToClimb;
    private Button button_moveToCampus;
    private Button button_moveToHangboard;
    private Button button_status;
    private TextView textView_result;
    private ClimbPresenter climbPresenter;
    private CampusPresenter campusPresenter;
    private HangboardPresenter hangboardPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = getApplicationContext();

        button_moveToClimb = (Button) findViewById(R.id.button_moveToClimb);
        button_moveToCampus = (Button) findViewById(R.id.button_moveToCampus);
        button_moveToHangboard = (Button) findViewById(R.id.button_moveToHangboard);
        button_status = (Button) findViewById(R.id.button_status);
        textView_result = (TextView) findViewById(R.id.textView_result);
        textView_result.setMovementMethod(new ScrollingMovementMethod());

        button_moveToClimb.setOnClickListener(moveToClimb());
        button_moveToCampus.setOnClickListener(moveToCampus());
        button_moveToHangboard.setOnClickListener(moveToHangboard());
        button_status.setOnClickListener(showStatus());

        campusPresenter = new CampusPresenter(this);
        climbPresenter = new ClimbPresenter(this);
        hangboardPresenter = new HangboardPresenter(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        hangboardPresenter.getHangboardCount();
        campusPresenter.getCampusCount();
        climbPresenter.getClimbCount();
    }

    @Override
    public void setResultMsg(String msg) {
        msg = msg + "\n" + textView_result.getText();
        textView_result.setText(msg);
    }

    @Override
    public Context getContext() {
        return this;
    }

    private View.OnClickListener moveToClimb() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                Intent climbIntent = new Intent(context, ClimbActivity.class);
                startActivity(climbIntent);
            }
        };
    }

    private View.OnClickListener moveToCampus() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                Intent campusIntent = new Intent(context, CampusActivity.class);
                startActivity(campusIntent);
            }
        };
    }

    private View.OnClickListener moveToHangboard() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                Intent hangboardIntent = new Intent(context, HangboardActivity.class);
                startActivity(hangboardIntent);
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
