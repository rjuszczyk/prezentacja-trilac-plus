package pl.pharmaway.prezentacjatrilacplus;

import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class Page6 extends FooterActivity {

    protected long getDelay() {
        return 500;
    }

    protected long getDuration() {
        return 700;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View p6_1 = findViewById(R.id.p6_1);
        View p6_2 = findViewById(R.id.p6_2);
        View p6_3 = findViewById(R.id.p6_3);
        View p6_4 = findViewById(R.id.p6_4);
        View p6_5 = findViewById(R.id.p6_5);
        View p6_6 = findViewById(R.id.p6_6);
        View p6_7 = findViewById(R.id.p6_7);
        View p6_8 = findViewById(R.id.p6_8);
        View p6_9 = findViewById(R.id.p6_9);
        View p6_10 = findViewById(R.id.p6_10);
        View p6_11 = findViewById(R.id.p6_11);
        View p6_12 = findViewById(R.id.p6_12);


        if(savedInstanceState == null) {
            setInvisible(
                    p6_1,
                    p6_2,
                    p6_3,
                    p6_4,
                    p6_5,
                    p6_6,
                    p6_7,
                    p6_8,
                    p6_9,
                    p6_10,
                    p6_11,
                    p6_12
            );

            p6_9.setTranslationX(getResources().getDisplayMetrics().density*500);
            p6_10.setTranslationX(getResources().getDisplayMetrics().density*500);
            p6_11.setTranslationX(getResources().getDisplayMetrics().density*500);
            p6_12.setTranslationX(getResources().getDisplayMetrics().density*500);

            animateIn(500, new Page6.AnimationOpeartor() {
                        @Override
                        public ViewPropertyAnimator apply(ViewPropertyAnimator animator) {
                            return animator.alpha(1);
                        }
                    },
                    p6_1,
                    p6_2,
                    p6_3,
                    p6_4,
                    p6_5,
                    p6_6,
                    p6_7,
                    p6_8,
                    p6_9,
                    p6_10,
                    p6_11,
                    p6_12
            );
        } else {
            p6_9.setTranslationX(0);
            p6_10.setTranslationX(0);
            p6_11.setTranslationX(0);
            p6_12.setTranslationX(0);
            setVisible(
                    p6_1,
                    p6_2,
                    p6_3,
                    p6_4,
                    p6_5,
                    p6_6,
                    p6_7,
                    p6_8,
                    p6_9,
                    p6_10,
                    p6_11,
                    p6_12
            );
        }
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page6;
    }

    @Override
    protected Class<?> getNextActivity() {
        return FormActivity.class;
    }

    interface AnimationOpeartor {
        ViewPropertyAnimator apply(ViewPropertyAnimator animator);
    }
}
