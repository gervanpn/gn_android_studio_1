import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TodoProvider extends ContentProvider {

    public static final int CODE_TODO = 100;
    public static final int CODE_TODO_WITH_ID = 101;

    private static final UriMatcher sUriMatcher = buildUriMatcher();

    public static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = ToDoContract.CONTENT_AUTHORITY;

        matcher.addURI(authority, ToDoContract.TodoEntry.TABLE_NAME, CODE_TODO);
        matcher.addURI(authority, ToDoContract.TodoEntry.TABLE_NAME + "/#", CODE_TODO_WITH_ID);
    return matcher;
    }


    private TodoDbHelper mOpenHelper;
    @Override
    public boolean onCreate() {
        mOpenHelper = new TodoDbHelper(getContext());
        return mOpenHelper != null;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        switch (sUriMatcher.match(uri)) {
            case CODE_TODO:
                long _id = db.insert(ToDoContract.TodoEntry.TABLE_NAME, null, values);
                if (_id != -1) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                return ToDoContract.TodoEntry.buildTodoUriWithId(_id);
            
            default:
                return null;
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
