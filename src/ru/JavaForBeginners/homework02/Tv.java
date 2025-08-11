package ru.JavaForBeginners.homework02;

public class Tv {
    private String brand;
    private String model;
    private short screenSize;
    private boolean isOn;
    private short channelNumber;
    private short volume;

    public Tv(String brand, String model, int screenSize, boolean isOn, int channelNumber, int volume) {
        this.brand = brand;
        this.model = model;
        this.screenSize = (short) screenSize;
        this.isOn = isOn;
        this.channelNumber = (short) channelNumber;
        this.volume = (short) volume;
    }

    public Tv(String brand, String model, int screenSize) {
        this.brand = brand;
        this.model = model;
        this.screenSize = (short) screenSize;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = (short) screenSize;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void setChannelNumber(int channelNumber) {
        this.channelNumber = (short) channelNumber;
    }

    public void setVolume(int volume) {
        this.volume = (short) volume;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public short getScreenSize() {
        return screenSize;
    }

    public boolean isOn() {
        return isOn;
    }

    public short getChannelNumber() {
        return channelNumber;
    }

    public short getVolume() {
        return volume;
    }

    public void turnOn() {
        if (!this.isOn) {
            this.isOn = true;
            System.out.println("TV is on");
        }
    }

    public void turnOn(int channelNumber) {
        if (!this.isOn) {
            this.isOn = true;
            this.channelNumber = (short) channelNumber;
            System.out.println("TV is on");
        }
    }

    public void turnOff() {
        if (this.isOn) {
            this.isOn = false;
            System.out.println("TV is off");
        }
    }

    public void nextChannel() {
        if (this.isOn) {
            this.channelNumber++;
            System.out.println("Channel switched to " + this.channelNumber);
        }
    }

    public void previousChannel() {
        if (this.isOn) {
            this.channelNumber--;
            System.out.println("Channel switched to " + this.channelNumber);
        }
    }

    public void increaseVolume() {
        if (this.isOn) {
            this.volume++;
            System.out.println("Volume set to " + this.volume);
        }
    }

    public void decreaseVolume() {
        if (this.isOn) {
            this.volume--;
            System.out.println("Volume set to " + this.volume);
        }
    }
}