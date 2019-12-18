package net.homecredit.trainee.drd.controller;

public class CoinValue {

    private int goldCoins;
    private int silverCoins;
    private int bronzeCoins;

    public CoinValue() {}

    public CoinValue(int goldCoins, int silverCoins, int bronzeCoins) {
        this.goldCoins = goldCoins;
        this.silverCoins = silverCoins;
        this.bronzeCoins = bronzeCoins;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    public int getSilverCoins() {
        return silverCoins;
    }

    public void setSilverCoins(int silverCoins) {
        this.silverCoins = silverCoins;
    }

    public int getBronzeCoins() {
        return bronzeCoins;
    }

    public void setBronzeCoins(int bronzeCoins) {
        this.bronzeCoins = bronzeCoins;
    }
}
