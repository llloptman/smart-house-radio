package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {
    private int radioStation;
    private int maxRadioStation = 10;
    private int volume;
    private int maxVolume = 100;

    public Radio(int volume, int maxVolume) {
        this.volume = volume;
        this.maxVolume = maxVolume;
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            return;
        }
        if (volume > this.maxVolume) {
            return;
        }
        this.volume = volume;
    }

    public void setRadioStation(int radioStation) {
        if (radioStation < 0) {
            return;
        }
        if (radioStation > this.maxRadioStation) {
            return;
        }
        this.radioStation = radioStation;
    }

    public void setMaxRadioStation(int maxRadioStation) {
        if (maxRadioStation <= 0) {
            return;
        }

        this.maxRadioStation = maxRadioStation;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        if (maxVolume <= 0) {
            return;
        }
        this.maxVolume = maxVolume;
    }

    public void nextRadioStation(int radioStation) {
        if (radioStation == this.maxRadioStation) {
            this.radioStation = 0;
        }
        this.setRadioStation(radioStation + 1);
    }

    public void previousRadioStation(int radioStation) {
        if (radioStation == 0) {
            this.radioStation = this.maxRadioStation;
        }
        this.setRadioStation(radioStation - 1);
    }

    public void addSomeNoize(int currentVolume) {
        if (currentVolume == this.maxVolume) {
            this.setVolume(currentVolume);
        } else {
            this.setVolume(currentVolume + 1);
        }
    }

    public void removeSomeNoize(int currentVolume) {
        if (currentVolume == 0) {
            this.setVolume(currentVolume);
        } else {
            this.setVolume(currentVolume - 1);
        }
    }
}
