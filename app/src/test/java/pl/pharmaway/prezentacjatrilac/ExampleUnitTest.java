package pl.pharmaway.prezentacjatrilac;

import org.junit.Test;

import pl.pharmaway.prezentacjatrilacplus.TimeSpendInApp;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void time16s() throws Exception {
        long time = 16000L;
        String formatted = TimeSpendInApp.format(time);
        assertEquals(formatted, "16s");
    }

    @Test
    public void time1m16s() throws Exception {
        long time = 16000L + 60000L;
        String formatted = TimeSpendInApp.format(time);
        assertEquals(formatted, "1min 16s");
    }

    @Test
    public void time1h1m16s() throws Exception {
        long time = 16000L + 60000L + 60L*60000L;
        String formatted = TimeSpendInApp.format(time);
        assertEquals(formatted, "1h 1min 16s");
    }
}