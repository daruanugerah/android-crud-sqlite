package com.example.sqlite_crud.dblocal;

import android.provider.BaseColumns;

public class DatabaseNoteContract {
    static String TABLE_NOTE = "note";

    static final class NoteColumn implements BaseColumns{
        static String JUDUL = "judul";
        static String DESKRIPSI = "deskripsi";
        static String TANGGAL = "tanggal";

    }

}
