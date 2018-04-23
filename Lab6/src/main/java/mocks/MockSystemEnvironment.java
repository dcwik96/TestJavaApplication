package mocks;

public class MockSystemEnvironment implements Environmental {

    private boolean playedWav = false;
    private long currentTime;

    public long getTime() {
        return currentTime;
    }

    public void setTime(long time) {
        currentTime = time;
    }

    public void playWavFile(String filename) {
        playedWav = true;
    }

    public boolean wavWasPlayed() {
        return playedWav;
    }

    public void resetWav() {
        playedWav = false;
    }

}
