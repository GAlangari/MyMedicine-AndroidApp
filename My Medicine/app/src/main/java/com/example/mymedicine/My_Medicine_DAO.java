package com.example.mymedicine;

//import android.arch.lifecycle.LiveData;
import androidx.room.*;
import java.util.List;

@Dao
public interface My_Medicine_DAO {

    @Insert
    void insertAll ( My_Medicine M);

    @Query("Select * from My_Medicine")
    List<My_Medicine> getAll();




}
