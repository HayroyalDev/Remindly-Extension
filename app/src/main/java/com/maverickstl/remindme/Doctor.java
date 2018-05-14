package com.maverickstl.remindme;

/**
 * Created by robot on 5/14/18.
 */

public class Doctor {
    private int mID;
    private String email;
    private String mPurpose;
    private String mHospital;
    private String mDate;
    private String mTime;
    private String mRepeat;
    private String mRepeatNo;
    private String mRepeatType;
    private String mActive;
    public Doctor(int mID, String email, String mPurpose, String mHospital, String mDate, String mTime, String mRepeat, String mRepeatNo, String mRepeatType, String mActive) {
        this.mID = mID;
        this.email = email;
        this.mPurpose = mPurpose;
        this.mHospital = mHospital;
        this.mDate = mDate;
        this.mTime = mTime;
        this.mRepeat = mRepeat;
        this.mRepeatNo = mRepeatNo;
        this.mRepeatType = mRepeatType;
        this.mActive = mActive;
    }

    public Doctor(){

    }

    public Doctor(String email, String mPurpose, String mHospital, String mDate, String mTime, String mRepeat, String mRepeatNo, String mRepeatType, String mActive) {
        this.email = email;
        this.mPurpose = mPurpose;
        this.mHospital = mHospital;
        this.mDate = mDate;
        this.mTime = mTime;
        this.mRepeat = mRepeat;
        this.mRepeatNo = mRepeatNo;
        this.mRepeatType = mRepeatType;
        this.mActive = mActive;
    }

    public int getID() {
        return mID;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPurpose() {
        return mPurpose;
    }

    public void setPurpose(String mPurpose) {
        this.mPurpose = mPurpose;
    }

    public String getHospital() {
        return mHospital;
    }

    public void setHospital(String mHospital) {
        this.mHospital = mHospital;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String mTime) {
        this.mTime = mTime;
    }

    public String getRepeat() {
        return mRepeat;
    }

    public void setRepeat(String mRepeat) {
        this.mRepeat = mRepeat;
    }

    public String getRepeatNo() {
        return mRepeatNo;
    }

    public void setRepeatNo(String mRepeatNo) {
        this.mRepeatNo = mRepeatNo;
    }

    public String getRepeatType() {
        return mRepeatType;
    }

    public void setRepeatType(String mRepeatType) {
        this.mRepeatType = mRepeatType;
    }

    public String getActive() {
        return mActive;
    }

    public void setActive(String mActive) {
        this.mActive = mActive;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "mID=" + mID +
                ", email='" + email + '\'' +
                ", mPurpose='" + mPurpose + '\'' +
                ", mHospital='" + mHospital + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mTime='" + mTime + '\'' +
                ", mRepeat='" + mRepeat + '\'' +
                ", mRepeatNo='" + mRepeatNo + '\'' +
                ", mRepeatType='" + mRepeatType + '\'' +
                ", mActive='" + mActive + '\'' +
                '}';
    }
}
