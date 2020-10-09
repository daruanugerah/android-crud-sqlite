package com.example.sqlite_crud.dblocal;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseNoteHelper extends SQLiteOpenHelper {

    //klik kanan generate constructor, pilih ketiganya lalu sisain satu dan hapus sampai context saja
    public DatabaseNoteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    static String DATABASE_NAME = "dbnote";
    static int DATABASE_VERSION = 1;
    static final String SQL_CREATE_TABLE = String.
            format("CREATE TABLE %s"
                    + "(%s INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "%s TEXT NOT NULL,"
                    + "%s TEXT NOT NULL,"
                    + "%s TEXT NOT NULL)",
                    DatabaseNoteContract.TABLE_NOTE,
                    DatabaseNoteContract.NoteColumn._ID,
                    DatabaseNoteContract.NoteColumn.JUDUL,
                    DatabaseNoteContract.NoteColumn.DESKRIPSI,
                    DatabaseNoteContract.NoteColumn.TANGGAL
            );

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + DatabaseNoteContract.TABLE_NOTE);
        onCreate(sqLiteDatabase);

    }
}
