package com.rps.mananwason.roundcornerprogresssample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;

/**
 * Created by MananWason on 03-07-2015, 10:34.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private IconRoundCornerProgressBar progressOne;
    private TextView textProgressOne;
    private Button btnProgressOneDecrease;
    private Button btnProgressOneIncrease;

    private int progress1 = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressOne = (IconRoundCornerProgressBar) findViewById(R.id.progress_one);
        progressOne.setProgressColor(
                getResources().getColor(R.color.custom_progress_blue_progress),
                getResources().getColor(R.color.custom_progress_blue_progress_half)
        );
        progressOne.setHeaderColor(getResources().getColor(R.color.custom_progress_blue_header));
        progressOne.setBackgroundColor(getResources().getColor(R.color.custom_progress_background));
        textProgressOne = (TextView) findViewById(R.id.text_progress_one);
        btnProgressOneDecrease = (Button) findViewById(R.id.button_progress_one_decrease);
        btnProgressOneDecrease.setOnClickListener(this);
        btnProgressOneIncrease = (Button) findViewById(R.id.button_progress_one_increase);
        btnProgressOneIncrease.setOnClickListener(this);
        updateProgressOne();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button_progress_one_decrease:
                progress1 = (progress1 > 0) ? progress1 - 1 : progress1;
                updateProgressOne();
                break;
            case R.id.button_progress_one_increase:
                progress1 = (progress1 < progressOne.getMax()) ? progress1 + 1 : progress1;
                updateProgressOne();
                break;
        }
    }

    private void updateProgressOne() {
        progressOne.setProgress(progress1);
        progressOne.setSecondaryProgress(progress1 + 1);
        textProgressOne.setText("" + progress1);
    }

}
