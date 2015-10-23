package m.pekka.climbinapptest.Hangboard;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import m.pekka.climbinapptest.ActivityInterface;
import m.pekka.climbinapptest.R;

/**
 * Created by Pekka Melgin on 23.10.2015.
 */
public class HangboardActivity extends AppCompatActivity implements ActivityInterface {

    private Button button_addHang;
    private EditText editText_hangboardTime;
    private TextView textView_hangboardResult;
    private HangboardPresenter hangboardPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangboard);

        button_addHang = (Button) findViewById(R.id.button_addHang);
        button_addHang.setOnClickListener(addHang());

        editText_hangboardTime = (EditText) findViewById(R.id.editText_hangboardTime);
        textView_hangboardResult = (TextView) findViewById(R.id.textView_hangboardResult);

        hangboardPresenter = new HangboardPresenter(this);
    }

    @Override
    public void setResultMsg(String msg) {
        textView_hangboardResult.setText(msg);
    }

    @Override
    public Context getContext() {
        return this;
    }

    private View.OnClickListener addHang() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                hangboardPresenter.addHang(editText_hangboardTime.getText().toString());
            }
        };
    }
}
