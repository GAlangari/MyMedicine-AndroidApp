package com.example.mymedicine;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {My_Medicine.class}, version = 1)

public abstract class My_Medicine_DB extends RoomDatabase {

    public abstract My_Medicine_DAO My_Medicine_dao ();

}
