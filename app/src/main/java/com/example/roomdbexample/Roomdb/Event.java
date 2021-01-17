package com.example.roomdbexample.Roomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Event {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate=true)
    public int _id;

    @ColumnInfo(name = "Title")
    public String Title;

    @ColumnInfo(name = "Date")
    public String Date;

    @ColumnInfo(name = "img_id")
    public int img_id;

    public Event(){}

    public Event(String title, String date, int imgid){
        this.Title = title;
        this.Date = date;
        this.img_id = imgid;
    }


}
