package com.petarmarijanovic.circleprogressbar;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final ProgressBar progressBar = (ProgressBar) findViewById(R.id.circular_progress_bar);
    final TextView textView = (TextView) findViewById(R.id.text);
    final Random random = new Random();

    findViewById(R.id.butona)
        .setOnClickListener(
            new OnClickListener() {
              @Override
              public void onClick(View v) {
                int progress = progressBar.getProgress();
                int newProgress = random.nextInt(101);

                textView.setText(String.valueOf(newProgress));

                ObjectAnimator anim =
                    ObjectAnimator.ofInt(progressBar, "progress", progress, newProgress);
                anim.setDuration(500);
                anim.setInterpolator(new AccelerateDecelerateInterpolator());
                anim.start();
              }
            });
  }
}
