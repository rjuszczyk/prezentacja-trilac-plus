package pl.pharmaway.prezentacjatrilacplus;

import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class Page3 extends FooterActivity {

    protected long getDelay() {
        return 250;
    }

    protected long getDuration() {
        return 700;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View p3_1 = findViewById(R.id.p3_1);
        View p3_2 = findViewById(R.id.p3_2);
        View p3_4 = findViewById(R.id.p3_4);
        View p3_5 = findViewById(R.id.p3_5);
        View p3_6 = findViewById(R.id.p3_6);
        View p3_7 = findViewById(R.id.p3_7);
        View p3_8 = findViewById(R.id.p3_8);
        View p3_9 = findViewById(R.id.p3_9);
        View p3_10 = findViewById(R.id.p3_10);
        View p3_11 = findViewById(R.id.p3_11);
        View p3_12 = findViewById(R.id.p3_12);
        View p3_13 = findViewById(R.id.p3_13);
        View p3_14 = findViewById(R.id.p3_14);
        View p3_15 = findViewById(R.id.p3_15);
        View p3_16 = findViewById(R.id.p3_16);

        if(savedInstanceState == null) {
            setInvisible(
                    p3_1,
                    p3_2,
                    p3_4,
                    p3_5,
                    p3_6,
                    p3_7,
                    p3_8,
                    p3_9,
                    p3_10,
                    p3_11,
                    p3_12,
                    p3_13,
                    p3_14,
                    p3_15,
                    p3_16
            );
            animateIn(500, new Page6.AnimationOpeartor() {
                @Override
                public ViewPropertyAnimator apply(ViewPropertyAnimator animator) {
                    return animator.alpha(1);
                }
            },
                    p3_1,
                    p3_2,
                    p3_4,
                    p3_5,
                    p3_6,
                    p3_7,
                    p3_8,
                    p3_9,
                    p3_10,
                    p3_11,
                    p3_12,
                    p3_13,
                    p3_14,
                    p3_15,
                    p3_16
            );
        } else {
            setVisible(
                    p3_1,
                    p3_2,
                    p3_4,
                    p3_5,
                    p3_6,
                    p3_7,
                    p3_8,
                    p3_9,
                    p3_10,
                    p3_11,
                    p3_12,
                    p3_13,
                    p3_14,
                    p3_15,
                    p3_16
            );
        }
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page3;
    }

    @Override
    protected Class<?> getNextActivity() {
        return Page4.class;
    }
}
