package com.example.day02.bane;

public class Bpment {
 private int progress;
 private long max;

    public Bpment(int progress, long max) {
        this.progress = progress;
        this.max = max;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }
}
