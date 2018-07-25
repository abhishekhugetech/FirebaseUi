package com.epiclancers.app.anmio;

public class Boxer {

    public String boxerName;
    public String boxerAge;

    public Boxer(String boxerName, String boxerAge) {
        this.boxerName = boxerName;
        this.boxerAge = boxerAge;
    }

    public Boxer() {
    }

    public String getBoxerName() {
        return boxerName;
    }

    public String getBoxerAge() {
        return boxerAge;
    }

    public void setBoxerName(String boxerName) {
        this.boxerName = boxerName;
    }

    public void setBoxerAge(String boxerAge) {
        this.boxerAge = boxerAge;
    }
}
