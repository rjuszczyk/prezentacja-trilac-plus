package pl.pharmaway.prezentacjatrilacplus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Page2 extends FooterActivity {
    FirstChoice firstChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firstChoice = new FirstChoice(getSharedPreferences("appPrefs", Context.MODE_PRIVATE));

        View skutecznosc = findViewById(R.id.skutecznosc);
        View optymalnaKolonizacja = findViewById(R.id.optymalna_kolonizacja);
        View bezpieczenstwo = findViewById(R.id.bezpieczenstwo);

        skutecznosc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSkutecznosc();
                firstChoice.setFirstChoice("kompleksowość");
            }
        });

        optymalnaKolonizacja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOptymalnaKolonizacja();
                firstChoice.setFirstChoice("nowoczesność");
            }
        });

        bezpieczenstwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBezpieczenstwo();
                firstChoice.setFirstChoice("wygoda stosowania");
            }
        });
    }

    private void openSkutecznosc() {
        startActivity(Page3.class);
    }

    private void openOptymalnaKolonizacja() {
        startActivity(Page4.class);
    }

    private void openBezpieczenstwo() {
        startActivity(Page5.class);
    }

    private void startActivity(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        intent.putExtra("goToSummary", true);
        startActivity(intent);
    }

    @Override
    protected void onNextClicked() {
        firstChoice.setFirstChoice("kompleksowość");
        super.onNextClicked();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page2;
    }

    @Override
    protected Class<?> getNextActivity() {
        return Page3.class;
    }
}
