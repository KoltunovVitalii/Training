package ru.mfti.koltunov;

public class Time {
    int seconds;
//    int wat;
//    int min;
//    int sec;

    public Time(int seconds) {
        if (seconds > 86400 & seconds > 0) {
            while (seconds > 86400) {
                seconds = seconds - 86400;
            }
            this.seconds = seconds;
        }
    }

    @Override
    public String toString() {
        String result = "";
        if (this.seconds != 0) {
            int wat = (seconds / 60) / 60;
            int min = (seconds - wat * 60 * 60) / 60;
            int sec = (seconds - wat * 60 * 60 - min * 60);

            if (wat < 10) {
                result = result + "0" + wat;
            } else {
                result = result + wat;
            }
            if (min < 10) {
                result = result + ":" + "0" + min;
            } else {
                result = result + ":" + min;
            }
            if (sec < 10) {
                result = result + ":" + "0" + sec;
            } else {
                result = result + ":" + sec;
            }
            if (wat < 10) {
                result = result + "0" + wat;
            } else {
                result = result + wat;
            }
            if (min < 10) {
                result = result + ":" + "0" + min;
            } else {
                result = result + ":" + min;
            }
            if (sec < 10) {
                result = result + ":" + "0" + sec;
            } else {
                result = result + ":" + sec;
            }
        }
        return result;
    }

    public int wat(int x) {
        return (x / 60) / 60;
    }

    public int min(int x) {
        int wat = (x / 60) / 60;
        return (x - wat * 60 * 60) / 60;
    }

    public int sec(int x) {
        int wat = (x / 60) / 60;
        int min = (x - wat * 60 * 60) / 60;
        return (x - wat * 60 * 60 - min * 60);
    }
}
