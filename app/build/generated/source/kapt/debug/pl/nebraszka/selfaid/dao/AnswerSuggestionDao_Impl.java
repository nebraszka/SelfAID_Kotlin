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
import pl.nebraszka.selfaid.entities.AnswerSuggestion;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AnswerSuggestionDao_Impl implements AnswerSuggestionDao {
  private final RoomDatabase __db;

  public AnswerSuggestionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public Flow<List<AnswerSuggestion>> getAllAnswerSuggestions(final int questionId) {
    final String _sql = "SELECT * FROM TB_Answer_Suggest WHERE question_id == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, questionId);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"TB_Answer_Suggest"}, new Callable<List<AnswerSuggestion>>() {
      @Override
      public List<AnswerSuggestion> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "answer");
          final int _cursorIndexOfQuestionId = CursorUtil.getColumnIndexOrThrow(_cursor, "question_id");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<AnswerSuggestion> _result = new ArrayList<AnswerSuggestion>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AnswerSuggestion _item;
            final String _tmpAnswer;
            if (_cursor.isNull(_cursorIndexOfAnswer)) {
              _tmpAnswer = null;
            } else {
              _tmpAnswer = _cursor.getString(_cursorIndexOfAnswer);
            }
            final int _tmpQuestionId;
            _tmpQuestionId = _cursor.getInt(_cursorIndexOfQuestionId);
            _item = new AnswerSuggestion(_tmpAnswer,_tmpQuestionId);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
