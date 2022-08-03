package pl.nebraszka.selfaid.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import pl.nebraszka.selfaid.entities.Emotion;
import pl.nebraszka.selfaid.entities.EntryPage;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EntryPageDao_Impl implements EntryPageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EntryPage> __insertionAdapterOfEntryPage;

  public EntryPageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEntryPage = new EntityInsertionAdapter<EntryPage>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `TB_Entry_Pages` (`page_number`,`emotion_id`,`entry_id`,`id`) VALUES (?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EntryPage value) {
        stmt.bindLong(1, value.getPageNo());
        stmt.bindLong(2, value.getEmotionId());
        stmt.bindLong(3, value.getEntryId());
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public Object insertPage(final EntryPage page, final Continuation<? super Long> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfEntryPage.insertAndReturnId(page);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Flow<Emotion> getEmotion(final int pageId) {
    final String _sql = "SELECT emotions.* FROM TB_Entry_Pages AS pages INNER JOIN TB_Emotions AS emotions ON pages.emotion_id=emotions.id WHERE pages.id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, pageId);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"TB_Entry_Pages","TB_Emotions"}, new Callable<Emotion>() {
      @Override
      public Emotion call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEmotion = CursorUtil.getColumnIndexOrThrow(_cursor, "emotion");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final Emotion _result;
          if(_cursor.moveToFirst()) {
            final String _tmpEmotion;
            if (_cursor.isNull(_cursorIndexOfEmotion)) {
              _tmpEmotion = null;
            } else {
              _tmpEmotion = _cursor.getString(_cursorIndexOfEmotion);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _result = new Emotion(_tmpEmotion,_tmpDescription);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _result.setId(_tmpId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
