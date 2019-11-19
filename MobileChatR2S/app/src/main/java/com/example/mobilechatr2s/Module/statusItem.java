package com.example.mobilechatr2s.Module;

public class statusItem {
    private int imageStatus;
    private String nameStatus;

    public statusItem(int imageStatus, String nameStatus) {
        this.imageStatus = imageStatus;
        this.nameStatus = nameStatus;
    }
    public statusItem(){

    }

    public void setImageStatus(int imageStatus) {
        this.imageStatus = imageStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    public int getImageStatus() {
        return imageStatus;
    }

    public String getNameStatus() {
        return nameStatus;
    }
}
