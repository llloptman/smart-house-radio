package ru.netology;

public class Radio {
    private  int radioStation;
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume<0){
            return;
        }
        if (volume>10){
            return;
        }
        this.volume = volume;
    }

    public int getRadioStation() {
        return radioStation;
    }

    public void setRadioStation(int radioStation) {
        if (radioStation<0){
            return;
        }
        if (radioStation>9){
            return;
        }
        this.radioStation = radioStation;
    }

    public void nextRadioStation (int radioStation){
        if (radioStation == 9){
            this.radioStation = 0;
        }
        this.setRadioStation(radioStation + 1);
    }

    public void previousRadioStation (int radioStation){
        if (radioStation == 0){
            this.radioStation = 9;
        }
        this.setRadioStation(radioStation - 1);
    }

    public void addSomeNoize (int currentVolume){
        if (currentVolume == 10){
            this.setVolume(currentVolume);
        }else {
            this.setVolume(currentVolume + 1);
        }
    }

    public void removeSomeNoize (int currentVolume){
        if (currentVolume == 0){
            this.setVolume(currentVolume);
        }else {
            this.setVolume(currentVolume - 1);
        }
    }
}
