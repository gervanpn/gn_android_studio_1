import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TodoDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "mytodolist.db";
    private static final int DATABASE_VERSION = 1;
    public TodoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_TODO_TABLE =
                "CREATE TABLE " + ToDoContract.TodoEntry.TABLE_NAME + " (" +
                        ToDoContract.TodoEntry._ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        ToDoContract.TodoEntry.COLUMN_DATE       + " INTEGER NOT NULL, "                 +
                        ToDoContract.TodoEntry.COLUMN_TASK       + " TEXT NOT NULL,"                  +
                        ToDoContract.TodoEntry.COLUMN_STATUS     + " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ToDoContract.TodoEntry.TABLE_NAME);
        onCreate(db);
    }
}
