package smol.bakalaris;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Smolk on 07.04.2016.
 */
public class DatabaseOperation extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREAT_QUERY="CREAT_TABLE"+ TableData.TableInfo.TABLE_NAME+"("+ TableData.TableInfo.USER_NAME+"TEXT,"+ TableData.TableInfo.USER_PASS+"TEXT);";


    public DatabaseOperation(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations","Database created");
    }

    public void onCreate(SQLiteDatabase sdb){

sdb.execSQL(CREAT_QUERY);
        Log.d("Database operations", "Table created");
    }


    public void onUpgrade(SQLiteDatabase arg0, int arg1,int arg2){


    }

public void putInformation(DatabaseOperation dop,String name ,String pass)
{

    SQLiteDatabase SQ = dop.getWritableDatabase();
    ContentValues cv = new ContentValues();
    cv.put(TableData.TableInfo.USER_NAME,name);
    cv.put(TableData.TableInfo.USER_PASS, pass);
    long k = SQ.insert(TableData.TableInfo.TABLE_NAME,null,cv);
    Log.d("Database operations", "one raw inserted");


}






}
