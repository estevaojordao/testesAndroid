package dao;

import android.content.Context;  
import android.database.sqlite.SQLiteDatabase;  
import android.database.sqlite.SQLiteOpenHelper;  
  
/** 
* @author Cristian Chies 10/12/2012 
*  
*/  
public class DataBase extends SQLiteOpenHelper {  
    private final static int VERSAO = 1;  
    private final static String NOME = "nomebanco.sqlite";  
    private static final String CREATE = "CREATE TABLE usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario VARCHAR( 20 ) NOT NULL, senha VARCHAR( 8 ));";  
    protected SQLiteDatabase database;  
  
    public DataBase(Context context) {  
    super(context, NOME, null, VERSAO);  
    }  
  
    @Override  
    public void onCreate(SQLiteDatabase db) {  
    db.execSQL(CREATE);   
  
    }  
  
    @Override  
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  
    // TODO Auto-generated method stub  
  
    }  
  
    public SQLiteDatabase getDatabase() {  
    if (database == null) {  
        database = getWritableDatabase();  
    }  
    return database;  
    }  
  
}  