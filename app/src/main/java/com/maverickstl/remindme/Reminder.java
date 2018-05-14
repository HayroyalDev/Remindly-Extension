/*
 * Copyright 2015 Blanyal D'Souza.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.maverickstl.remindme;

// Reminder class
public class Reminder {
    private String email;
    private int mID;
    private String mTitle;
    private String mDosage;
    private String mDate;
    private String mTime;
    private String mRepeat;
    private String mRepeatNo;
    private String mRepeatType;
    private String mActive;
    private String mImage;




    public Reminder(int ID, String Title, String Dosage, String Date, String Time, String Repeat, String RepeatNo, String RepeatType, String Active, String Image,String email){
        this.email = email;
        mID = ID;
        mTitle = Title;
        mDosage = Dosage;
        mDate = Date;
        mTime = Time;
        mRepeat = Repeat;
        mRepeatNo = RepeatNo;
        mRepeatType = RepeatType;
        mActive = Active;
        mImage = Image;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Reminder(String Title, String Dosage, String Date, String Time, String Repeat, String RepeatNo, String RepeatType, String Active, String Image, String email){
        this.email = email;

        mTitle = Title;
        mDosage = Dosage;
        mDate = Date;
        mTime = Time;
        mRepeat = Repeat;
        mRepeatNo = RepeatNo;
        mRepeatType = RepeatType;
        mActive = Active;
        mImage = Image;
    }

    public Reminder(){}


    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDosage(){return mDosage; }

    public void setDosage(String dosage){mDosage = dosage;}

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getRepeatType() {
        return mRepeatType;
    }

    public void setRepeatType(String repeatType) {
        mRepeatType = repeatType;
    }

    public String getRepeatNo() {
        return mRepeatNo;
    }

    public void setRepeatNo(String repeatNo) {
        mRepeatNo = repeatNo;
    }

    public String getRepeat() {
        return mRepeat;
    }

    public void setRepeat(String repeat) {
        mRepeat = repeat;
    }

    public String getActive() {
        return mActive;
    }

    public void setActive(String active) {
        mActive = active;
    }

    public String getImage() {return mImage;}

    public void setImage(String image) {mImage = image;}

    @Override
    public String toString() {
        return "Reminder{" +
                "mID=" + mID +
                ", mTitle='" + mTitle + '\'' +
                ", mDosage='" + mDosage + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mTime='" + mTime + '\'' +
                ", mRepeat='" + mRepeat + '\'' +
                ", mRepeatNo='" + mRepeatNo + '\'' +
                ", mRepeatType='" + mRepeatType + '\'' +
                ", mActive='" + mActive + '\'' +
                ", mImage='" + mImage + '\'' +
                '}';
    }
}
