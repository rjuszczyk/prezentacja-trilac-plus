package pl.pharmaway.prezentacjatrilacplus;

import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class Page5 extends FooterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View page4_1 = findViewById(R.id.p5_1);
        View page4_11 = findViewById(R.id.p5_21);
        View page4_2 = findViewById(R.id.p5_2);
        View page4_3 = findViewById(R.id.p5_3);
        View page4_4 = findViewById(R.id.p5_4);

        if(savedInstanceState == null) {
            setInvisible(
                    page4_1,
                    page4_11,
                    page4_2,
                    page4_3,
                    page4_4
            );
            page4_4.setTranslationY(getResources().getDisplayMetrics().density*500);
            animateIn(500, new Page6.AnimationOpeartor() {
                @Override
                public ViewPropertyAnimator apply(ViewPropertyAnimator animator) {
                    return animator.alpha(1);
                }
            },
                    page4_1,
                    page4_11,
                    page4_2,
                    page4_3,
                    page4_4);
        } else {
            page4_4.setTranslationY(0);
            setVisible(
                    page4_1,
                    page4_11,
                    page4_2,
                    page4_3,
                    page4_4
            );
        }
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page5;
    }

    @Override
    protected Class<?> getNextActivity() {
        return Page6.class;
    }
}
