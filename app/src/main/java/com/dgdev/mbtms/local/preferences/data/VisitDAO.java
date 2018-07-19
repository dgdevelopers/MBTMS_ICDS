package com.dgdev.mbtms.local.preferences.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface VisitDAO {

    @Insert
    void insert_visit(Visitdata visit);

    @Delete
    void delete_visit(Visitdata visit);

    @Query("delete from Visitdata")
    void delete_all_Visitdata();

    @Query("select * from Visitdata")
    List<Visitdata> select_all_visits();


}
