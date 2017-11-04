package com.example.nbacademy.pedrocrespoapp.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nbacademy.pedrocrespoapp.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NBAcademy on 02/11/2017.
 */
public class DbManager {

    private HockeyDB dbHelper;
    private SQLiteDatabase database;
    private Context context;

    public final static String EMP_TABLE="Players"; // name of table

    public final static String PLY_ID="Id";
    public final static String PLY_NAME="Name";
    public final static String PLY_NUMBER="Number";
    public final static String PLY_POSITION="PlayerPosition";
    public final static String PLY_AGE="Age";
    public final static String PLY_DESCRIPTION="Description";
    public final static String PLY_STRENGTHS="Strengths";
    public final static String PLY_IMPROVEMENT="ImprovementAspects";
    public final static String PLY_CLUB="IsInClub";

    public DbManager(Context context){
        this.context = context;
        dbHelper = new HockeyDB(context);
        database = dbHelper.getWritableDatabase();
    }

    public long insertPlayer(Player player){
        ContentValues values = new ContentValues();
        values.put(PLY_NAME, player.getName());
        values.put(PLY_NUMBER, player.getNumber());
        values.put(PLY_POSITION, player.getPlayerPosition());
        values.put(PLY_AGE, player.getAge());
        values.put(PLY_DESCRIPTION, player.getDescription());
        values.put(PLY_STRENGTHS, player.getStrengths());
        values.put(PLY_IMPROVEMENT, player.getImprovementAspects());
        values.put(PLY_CLUB, player.isInClub());
        return database.insert(EMP_TABLE, null, values);
    }

    public Player getPlayerById(int id) {
        Cursor mCursor = database.rawQuery("SELECT * FROM players WHERE " + PLY_ID + " = " + id, null);

        Player player = null;

        if (mCursor != null) {
            mCursor.moveToFirst();
            player = new Player(Integer.parseInt(mCursor.getString(mCursor.getColumnIndex("Number"))), mCursor.getString(mCursor.getColumnIndex("Name")), "Field Player", 0, null, null, null, true);
        }
        return player;
    }

    public List<Player> getTeam() {
        Cursor mCursor = database.rawQuery("SELECT * FROM players WHERE IsInClub = 1", null);

        List<Player> lPlayer = new ArrayList<>();

        if (mCursor.moveToFirst()) {
            do {
                boolean active = false;
                String isInClub = mCursor.getString(mCursor.getColumnIndex("IsInClub"));
                if(isInClub.equals("1")){
                    active = true;
                }
                lPlayer.add(new Player(Integer.parseInt(mCursor.getString(mCursor.getColumnIndex("Number"))), mCursor.getString(mCursor.getColumnIndex("Name")), mCursor.getString(mCursor.getColumnIndex("PlayerPosition")), Integer.parseInt(mCursor.getString(mCursor.getColumnIndex("Age"))), mCursor.getString(mCursor.getColumnIndex("Description")), mCursor.getString(mCursor.getColumnIndex("Strengths")), mCursor.getString(mCursor.getColumnIndex("ImprovementAspects")), active));
            } while (mCursor.moveToNext());
        }

        return lPlayer;
    }
}
