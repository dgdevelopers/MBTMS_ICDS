package com.dgdev.mbtms.local.preferences.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Centres.class,Visitdata.class}, version = 1)
public abstract class AppLocalDB extends RoomDatabase {

    public abstract CentreDAO centreDAO();
    public abstract VisitDAO visitDAO();

}
