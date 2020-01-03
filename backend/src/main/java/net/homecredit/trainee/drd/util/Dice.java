package net.homecredit.trainee.drd.util;

import java.util.Random;

public class Dice {

    private Random r;

    public Dice(Random r) {
        this.r = r;
    }

    public synchronized int roll(int nrOfSides) {
        return r.nextInt(nrOfSides) + 1;
    }
}
