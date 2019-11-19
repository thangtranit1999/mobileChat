package com.example.mobilechatr2s.Module;

import android.graphics.Bitmap;

public class Contact {
    private statusItem mStatus;
    private Bitmap mAvatar;
    private String mName,mPhone,mTime;

    public Contact(Bitmap mAvatar, statusItem mStatus, String mName, String mPhone, String mTime) {
        this.mAvatar = mAvatar;
        this.mStatus = mStatus;
        this.mName = mName;
        this.mPhone = mPhone;
        this.mTime = mTime;
    }

    public Contact(String mName, String mPhone, Bitmap mAvatar){
        this.mName = mName;
        this.mPhone = mPhone;
        this.mAvatar = mAvatar;
    }
    public Contact(){

    }
    public void setmAvatar(Bitmap mAvatar) {
        this.mAvatar = mAvatar;
    }

    public void setmStatus(statusItem mStatus) {
        this.mStatus.setImageStatus(mStatus.getImageStatus());
        this.mStatus.setNameStatus(mStatus.getNameStatus());
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }


    public Bitmap getmAvatar() {
        return mAvatar;
    }

    public statusItem getmStatus() {
        return mStatus;
    }

    public String getmName() {
        return mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmTime() {
        return mTime;
    }
}
