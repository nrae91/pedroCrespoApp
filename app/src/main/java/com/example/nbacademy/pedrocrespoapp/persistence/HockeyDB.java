package com.example.nbacademy.pedrocrespoapp.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by NBAcademy on 02/11/2017.
 */
public class HockeyDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "HockeyDB.db";

    private static final int DATABASE_VERSION = 1;

    private Context context;

    // Database creation sql statement
    private static final String createTablePlayer = "CREATE TABLE IF NOT EXISTS players (" +
            "  Id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(20) NOT NULL," +
            "  Number INTEGER NOT NULL, PlayerPosition VARCHAR(12)NOT NULL," +
            "  Age INTEGER NOT NULL, Description TEXT NULL," +
            "  Strengths TEXT NULL, ImprovementAspects TEXT     NULL," +
            "  IsInClub TINYINT NOT NULL DEFAULT 1);";

    private static final String createTablePracticeEval = "CREATE TABLE IF NOT EXISTS practiceEval (" +
            "PlayerID INTEGER," +
            "PracticeId INTEGER DEFAULT 0," +
            "Presence TINYINT NOT NULL DEFAULT 0, Efficiency TINYINT NULL," +
            "DedicationLevel TINYINT NULL, Attitude TINYINT NULL," +
            "CONSTRAINT pk_practiceEval PRIMARY KEY(PlayerID,PracticeId)" +
            "CONSTRAINT fk_practiceEval_Player FOREIGN KEY(PlayerID) REFERENCES players(Id)" +
            /*"CONSTRAINT fk_practiceEval_Practice FOREIGN KEY PracticeId REFERENCES Practice(Id)" + */
            ");";

    public HockeyDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(createTablePlayer);
        database.execSQL(createTablePracticeEval);
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        database.execSQL("DROP TABLE IF EXISTS players");
        database.execSQL("DROP TABLE IF EXISTS practiceEval");
        onCreate(database);
    }
}
