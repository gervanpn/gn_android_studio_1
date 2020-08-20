import android.net.Uri;
import android.provider.BaseColumns;

public class ToDoContract {
    public static String CONTENT_AUTHORITY;

    public static final class TodoEntry implements BaseColumns {
        public static final String TABLE_NAME = "todo";  // Table name
        public static final String COLUMN_DATE = "date"; // Date of task
        public static final String COLUMN_TASK = "task"; // Description of task
        public static final String COLUMN_STATUS = "status"; // Status of task
        public static final String CONTENT_AUTHORITY = "com.assignments.mytimer";
        public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(TABLE_NAME)
                .build();

        public static Uri buildTodoUriWithId(long id) {
            return CONTENT_URI.buildUpon()
                    .appendPath(Long.toString(id))
                    .build();
        }
    }
}
