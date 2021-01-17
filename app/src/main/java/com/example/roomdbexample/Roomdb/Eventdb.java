package com.example.roomdbexample.Roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Event.class}, version = 1)
public abstract class Eventdb extends RoomDatabase{
    public final static  String DATABASE_NAME = "EventsRoomDB";
    public abstract EventDao eventDao();
}
