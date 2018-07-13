package tools.wpfang.sqllitedatabasedemo01;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyCoreDatabase extends SQLiteOpenHelper {
    private static final String DB_NAME="Basket";
    private static final String DB_TABLE="flower";
    private static final int DB_VER=1;
    Context ctx;
    SQLiteDatabase db;
    public MyCoreDatabase(Context context) {
        super(context,DB_NAME,null, DB_VER);
        ctx=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+DB_TABLE+" (id integer primary key " +
                " autoincrement, name text, color text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+ DB_TABLE);
    }
    public void insertFlowerData(String f_name,String f_color)
    {
        db=getWritableDatabase();
        db.execSQL("insert into "+DB_TABLE+ "(name, color) "+
        "values('"+f_name+"','"+f_color+"');");
        Toast.makeText(ctx,"Flower got Add",Toast.LENGTH_SHORT).show();
    }
    public String getAllFlower()
    {
        db=getReadableDatabase();
        String resultString="";
        Cursor cursor=db.rawQuery("Select * from "+DB_TABLE ,null);
        while(cursor.moveToNext())
        {
            String s1=cursor.getString(1);
            String s2=cursor.getString(2);
            resultString+=s1+"      "+s2+"\n";
        }
        return resultString;
    }
}
