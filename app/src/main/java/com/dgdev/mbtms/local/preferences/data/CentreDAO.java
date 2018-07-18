package com.dgdev.mbtms.local.preferences.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CentreDAO {

    @Insert
    void insert_centre(Centres centre);

    @Delete
    void delete_centre(Centres centres);

    @Query("delete from Centres")
    void delete_all_centres();

    @Query("select * from Centres order by Centre_name")
    List<Centres> select_all_centres();

}
