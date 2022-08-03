package pl.nebraszka.selfaid.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;
import pl.nebraszka.selfaid.entities.Emotion;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EmotionDao_Impl implements EmotionDao {
  private final RoomDatabase __db;

  public EmotionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public Flow<List<Emotion>> getAlphabetizedEmotions() {
    final String _sql = "SELECT * FROM TB_Emotions ORDER BY emotion ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"TB_Emotions"}, new Callable<List<Emotion>>() {
      @Override
      public List<Emotion> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEmotion = CursorUtil.getColumnIndexOrThrow(_cursor, "emotion");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Emotion> _result = new ArrayList<Emotion>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Emotion _item;
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
            _item = new Emotion(_tmpEmotion,_tmpDescription);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
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

  @Override
  public Flow<Emotion> getEmotion(final String name) {
    final String _sql = "SELECT * FROM TB_Emotions WHERE emotion == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"TB_Emotions"}, new Callable<Emotion>() {
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
