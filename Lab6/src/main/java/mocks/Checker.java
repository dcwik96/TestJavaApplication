package mocks;

import java.util.Calendar;

public class Checker {
    private Environmental env;

    public Checker(Environmental anEnv) {
        env = anEnv;
    }

    public void remainder() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(env.getTime());
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour >= 17) {
            env.playWavFile("gwizdek.wav");
        }
    }
}
