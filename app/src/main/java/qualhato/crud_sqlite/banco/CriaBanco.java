package qualhato.crud_sqlite.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "crud.db";
    private static final int DATABASE_VERSION = 1;


    private final String CREATE_TABLE = "CREATE TABLE Pessoa(" +
            "                           ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "                           Nome TEXT NOT NULL, " +
            "                           Idade TEXT, " +
            "                           Sexo TEXT NOT NULL," +
            "                           Endereco TEXT NOT NULL);";

    public CriaBanco(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion){
        db.execSQL("DROP TABLE Pessoa");
        }
    }
}
