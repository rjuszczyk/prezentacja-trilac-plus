package pl.pharmaway.prezentacjatrilacplus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
import static android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

public abstract class FooterActivity extends AppCompatActivity {
    @Nullable private View buttonNext;
    @Nullable private View buttonPrev;
    TimeSpendInApp timeSpendInApp;
    long startTime;
    private boolean goToSummary;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goToSummary = getIntent().getBooleanExtra("goToSummary", false);
        getWindow().getDecorView().setSystemUiVisibility(
                SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        SYSTEM_UI_FLAG_FULLSCREEN |
                        SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        setContentView(getLayoutResourceId());

        buttonPrev = findViewById(R.id.button_prev);
        buttonNext = findViewById(R.id.button_next);

        timeSpendInApp = new TimeSpendInApp(getSharedPreferences("appPrefs", Context.MODE_PRIVATE));

        if (buttonNext != null) {
            buttonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNextClicked();
                }
            });
        }
        if (buttonPrev != null) {
            buttonPrev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onPrevClicked();
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        startTime = System.currentTimeMillis();
    }

    @Override
    protected void onPause() {
        super.onPause();
        long delta = System.currentTimeMillis() - startTime;
        timeSpendInApp.addTime(delta);
    }

    protected void onNextClicked() {
        Intent intent;
        if(!goToSummary) {
            intent = new Intent(this, getNextActivity());
        } else {
            intent = new Intent(this, Page6.class);
        }
        startActivity(intent);
    }

    protected void onPrevClicked() {
        onBackPressed();
    }

    protected long getDelay() {
        return 500;
    }

    protected long getDuration() {
        return 1500;
    }

    protected void animateIn(long initialDelay, Page6.AnimationOpeartor animationOpeartor, View... paragraphs) {
        long delay = getDelay();
        long duration = getDuration();

        for (int i = 0; i < paragraphs.length; i++) {
            View paragraph = paragraphs[i];

            if(
                paragraph.getId() == R.id.p6_9 ||
                paragraph.getId() == R.id.p6_10 ||
                paragraph.getId() == R.id.p6_11 ||
                paragraph.getId() == R.id.p6_12
                    ) {
                animationOpeartor.apply(paragraph.animate())
                        .translationX(0)
                        .setDuration(duration)
                        .setStartDelay(initialDelay + i * delay + i * duration)
                        .start();
            } else
            if(paragraph.getId() == R.id.p5_4) {
                animationOpeartor.apply(paragraph.animate())
                        .translationY(0)
                        .setDuration(duration)
                        .setStartDelay(initialDelay + i * delay + i * duration)
                        .start();
            } else {

                animationOpeartor.apply(paragraph.animate())
                        .setDuration(duration)
                        .setStartDelay(initialDelay + i * delay + i * duration)
                        .start();
            }
        }
    }

    protected void setInvisible(View... paragraphs) {
        for (View paragraph : paragraphs) {
            paragraph.setAlpha(0);
        }
    }

    protected void setVisible(View... views) {
        for (View view : views) {
            view.setAlpha(1);
        }
    }

    @LayoutRes
    protected abstract int getLayoutResourceId();

    protected abstract Class<?> getNextActivity();
}
