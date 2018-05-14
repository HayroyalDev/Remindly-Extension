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

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class ReminderDatabase extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "ReminderDatabase";

    // Table name
    private static final String TABLE_REMINDERS = "ReminderTable";
    private static final String TABLE_DOCTOR = "DoctorTable";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DATE = "date";
    private static final String KEY_DOSAGE = "dosage";
    private static final String KEY_TIME = "time";
    private static final String KEY_REPEAT = "repeat";
    private static final String KEY_REPEAT_NO = "repeat_no";
    private static final String KEY_REPEAT_TYPE = "repeat_type";
    private static final String KEY_ACTIVE = "active";
    private static final String KEY_IMAGE = "image";

    private static String D_ID = "id";
    private static String D_EMAIL = "email";
    private static String D_HOS = "hospital";
    private static String D_PURPOSE = "purpose";
    private static final String D_TIME = "time";
    private static final String D_REPEAT = "repeat";
    private static final String D_REPEAT_NO = "repeat_no";
    private static final String D_REPEAT_TYPE = "repeat_type";
    private static String D_DATE = "date";
    private static final String D_ACTIVE = "active";

    public ReminderDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_REMINDERS_TABLE = "CREATE TABLE " + TABLE_REMINDERS +
                "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TITLE + " TEXT,"
                + KEY_DOSAGE + " TEXT,"
                + KEY_DATE + " TEXT,"
                + KEY_TIME + " INTEGER,"
                + KEY_REPEAT + " BOOLEAN,"
                + KEY_REPEAT_NO + " INTEGER,"
                + KEY_REPEAT_TYPE + " TEXT,"
                + KEY_ACTIVE + " BOOLEAN,"
                + KEY_IMAGE + " TEXT,"
                + KEY_EMAIL + " TEXT" + ")";

        String CREATE_DOCTORS_TABLE = "CREATE TABLE " + TABLE_DOCTOR +
                "("
                + D_ID + " INTEGER PRIMARY KEY,"
                + D_EMAIL + " TEXT,"
                + D_PURPOSE + " TEXT,"
                + D_HOS + " TEXT,"
                + D_DATE + " TEXT,"
                + D_TIME + " INTEGER,"
                + D_REPEAT + " BOOLEAN,"
                + D_REPEAT_NO + " INTEGER,"
                + D_REPEAT_TYPE + " TEXT,"
                + D_ACTIVE + " BOOLEAN" + ")";
        db.execSQL(CREATE_REMINDERS_TABLE);
        db.execSQL(CREATE_DOCTORS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        if (oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REMINDERS);

        // Create tables again
        onCreate(db);
    }

    // Adding new Reminder
    public int addReminder(Reminder reminder){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_EMAIL , reminder.getEmail());
        values.put(KEY_TITLE , reminder.getTitle());
        values.put(KEY_DOSAGE , reminder.getDosage());
        values.put(KEY_DATE , reminder.getDate());
        values.put(KEY_TIME , reminder.getTime());
        values.put(KEY_REPEAT , reminder.getRepeat());
        values.put(KEY_REPEAT_NO , reminder.getRepeatNo());
        values.put(KEY_REPEAT_TYPE, reminder.getRepeatType());
        values.put(KEY_ACTIVE, reminder.getActive());
        values.put(KEY_IMAGE, reminder.getImage());
        Log.e("DataSaved", reminder.toString());

        // Inserting Row
        long ID = db.insert(TABLE_REMINDERS, null, values);
        db.close();
        return (int) ID;
    }
    public int addDoctor(Doctor reminder){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(D_EMAIL , reminder.getEmail());
        values.put(D_PURPOSE , reminder.getPurpose());
        values.put(D_HOS , reminder.getHospital());
        values.put(D_DATE , reminder.getDate());
        values.put(D_TIME , reminder.getTime());
        values.put(D_REPEAT , reminder.getRepeat());
        values.put(D_REPEAT_NO , reminder.getRepeatNo());
        values.put(D_REPEAT_TYPE, reminder.getRepeatType());
        values.put(D_ACTIVE, reminder.getActive());
        Log.e("DataSaved", reminder.toString());

        // Inserting Row
        long ID = db.insert(TABLE_DOCTOR, null, values);
        db.close();
        return (int) ID;
    }

    // Getting single Reminder
    public Reminder getReminder(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_REMINDERS, new String[]
                        {
                                KEY_ID,
                                KEY_TITLE,
                                KEY_DOSAGE,
                                KEY_DATE,
                                KEY_TIME,
                                KEY_REPEAT,
                                KEY_REPEAT_NO,
                                KEY_REPEAT_TYPE,
                                KEY_ACTIVE,
                                KEY_IMAGE,
                                KEY_EMAIL
                        }, KEY_ID + "=?",

                new String[] {String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Reminder reminder = new Reminder(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
               cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10));

        return reminder;
    }

    public Doctor getDoctor(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DOCTOR, new String[]
                        {
                                D_ID,
                                D_EMAIL,
                                D_PURPOSE,
                                D_HOS ,
                                D_DATE,
                                D_TIME,
                                D_REPEAT,
                                D_REPEAT_NO,
                                D_REPEAT_TYPE,
                                D_ACTIVE
                        }, KEY_ID + "=?",

                new String[] {String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Doctor reminder = new Doctor(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
               cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9));

        return reminder;
    }

    // Getting all Reminders
    public List<Reminder> getAllReminders(){
        List<Reminder> reminderList = new ArrayList<>();

        // Select all Query
        String selectQuery = "SELECT * FROM " + TABLE_REMINDERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if(cursor.moveToFirst()){
            do{
                Reminder reminder = new Reminder();
                reminder.setID(Integer.parseInt(cursor.getString(0)));
                reminder.setTitle(cursor.getString(1));
                reminder.setDosage(cursor.getString(2));
                reminder.setDate(cursor.getString(3));
                reminder.setTime(cursor.getString(4));
                reminder.setRepeat(cursor.getString(5));
                reminder.setRepeatNo(cursor.getString(6));
                reminder.setRepeatType(cursor.getString(7));
                reminder.setActive(cursor.getString(8));
                reminder.setImage(cursor.getString(9));
                reminder.setEmail(cursor.getString(10));

                // Adding Reminders to list
                reminderList.add(reminder);
            } while (cursor.moveToNext());
        }
        return reminderList;
    }
    public List<Reminder> getAllReminders(String email){
        List<Reminder> reminderList = new ArrayList<>();

        // Select all Query
        String selectQuery = "SELECT * FROM " + TABLE_REMINDERS + " where email = '" + email + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if(cursor.moveToFirst()){
            do{
                Reminder reminder = new Reminder();
                reminder.setID(Integer.parseInt(cursor.getString(0)));
                reminder.setTitle(cursor.getString(1));
                reminder.setDosage(cursor.getString(2));
                reminder.setDate(cursor.getString(3));
                reminder.setTime(cursor.getString(4));
                reminder.setRepeat(cursor.getString(5));
                reminder.setRepeatNo(cursor.getString(6));
                reminder.setRepeatType(cursor.getString(7));
                reminder.setActive(cursor.getString(8));
                reminder.setImage(cursor.getString(9));
                reminder.setEmail(cursor.getString(10));

                // Adding Reminders to list
                reminderList.add(reminder);
            } while (cursor.moveToNext());
        }
        return reminderList;
    }
    public List<Doctor> getAllDoctor(){
        List<Doctor> reminderList = new ArrayList<>();

        // Select all Query
        String selectQuery = "SELECT * FROM " + TABLE_DOCTOR;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if(cursor.moveToFirst()){
            do{
                Doctor reminder = new Doctor();
                reminder.setID(Integer.parseInt(cursor.getString(0)));
                reminder.setEmail(cursor.getString(1));
                reminder.setPurpose(cursor.getString(2));
                reminder.setHospital(cursor.getString(3));
                reminder.setDate(cursor.getString(4));
                reminder.setTime(cursor.getString(5));
                reminder.setRepeat(cursor.getString(6));
                reminder.setRepeatNo(cursor.getString(7));
                reminder.setRepeatType(cursor.getString(8));
                reminder.setActive(cursor.getString(9));

                // Adding Reminders to list
                reminderList.add(reminder);
            } while (cursor.moveToNext());
        }
        return reminderList;
    }
    public List<Doctor> getAllDoctor(String email){
        List<Doctor> reminderList = new ArrayList<>();

        // Select all Query
        String selectQuery = "SELECT * FROM " + TABLE_DOCTOR + " where email = '" + email + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if(cursor.moveToFirst()){
            do{
                Doctor reminder = new Doctor();
                reminder.setID(Integer.parseInt(cursor.getString(0)));
                reminder.setEmail(cursor.getString(1));
                reminder.setPurpose(cursor.getString(2));
                reminder.setHospital(cursor.getString(3));
                reminder.setDate(cursor.getString(4));
                reminder.setTime(cursor.getString(5));
                reminder.setRepeat(cursor.getString(6));
                reminder.setRepeatNo(cursor.getString(7));
                reminder.setRepeatType(cursor.getString(8));
                reminder.setActive(cursor.getString(9));

                // Adding Reminders to list
                reminderList.add(reminder);
            } while (cursor.moveToNext());
        }
        return reminderList;
    }

    // Getting Reminders Count
    public int getRemindersCount(){
        String countQuery = "SELECT * FROM " + TABLE_REMINDERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();

        return cursor.getCount();
    }

    // Updating single Reminder
    public int updateReminder(Reminder reminder){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE , reminder.getTitle());
        values.put(KEY_DOSAGE , reminder.getDosage());
        values.put(KEY_DATE , reminder.getDate());
        values.put(KEY_TIME , reminder.getTime());
        values.put(KEY_REPEAT , reminder.getRepeat());
        values.put(KEY_REPEAT_NO , reminder.getRepeatNo());
        values.put(KEY_REPEAT_TYPE, reminder.getRepeatType());
        values.put(KEY_ACTIVE, reminder.getActive());
        values.put(KEY_IMAGE, reminder.getImage());
        values.put(KEY_EMAIL, reminder.getEmail());
        // Updating row
        return db.update(TABLE_REMINDERS, values, KEY_ID + "=?",
                new String[]{String.valueOf(reminder.getID())});
    }
    public int updateDoctor(Doctor reminder){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(D_EMAIL , reminder.getEmail());
        values.put(D_PURPOSE , reminder.getPurpose());
        values.put(D_HOS , reminder.getHospital());
        values.put(D_DATE , reminder.getDate());
        values.put(D_TIME , reminder.getTime());
        values.put(D_REPEAT , reminder.getRepeat());
        values.put(D_REPEAT_NO , reminder.getRepeatNo());
        values.put(D_REPEAT_TYPE, reminder.getRepeatType());
        values.put(D_ACTIVE, reminder.getActive());
        Log.e("DataSaved", reminder.toString());
        // Updating row
        return db.update(TABLE_DOCTOR, values, D_ID + "=?",
                    new String[]{String.valueOf(reminder.getID())});
    }

    // Deleting single Reminder
    public void deleteReminder(Reminder reminder){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_REMINDERS, KEY_ID + "=?",
                new String[]{String.valueOf(reminder.getID())});
        db.close();
    }

    public void deleteDoctor(Doctor reminder){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DOCTOR, D_ID + "=?",
                new String[]{String.valueOf(reminder.getID())});
        db.close();
    }
}
