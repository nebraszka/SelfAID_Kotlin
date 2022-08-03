package pl.nebraszka.selfaid.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import pl.nebraszka.selfaid.entities.EJAnswer;
import pl.nebraszka.selfaid.entities.EJRespond;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EJRespondDao_Impl implements EJRespondDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EJRespond> __insertionAdapterOfEJRespond;

  public EJRespondDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEJRespond = new EntityInsertionAdapter<EJRespond>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `TB_EJ_Responds` (`exercise_id`,`page_id`,`chosen_answer`,`text_answer`,`id`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EJRespond value) {
        stmt.bindLong(1, value.getExerciseId());
        stmt.bindLong(2, value.getPageId());
        if (value.getChoosenAnsw() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getChoosenAnsw());
        }
        if (value.getTextAnsw() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTextAnsw());
        }
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public Object insertAllResponds(final List<EJRespond> responds, final Continuation<Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEJRespond.insert(responds);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertRespond(final EJRespond respond, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEJRespond.insert(respond);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Flow<List<EJAnswer>> getRespondsForExercise(final int entryId, final int page,
      final int exerciseId) {
    final String _sql = "SELECT responds.text_answer, suggest.answer FROM (SELECT  text_answer, chosen_answer        FROM TB_EJ_Responds AS responds        INNER JOIN        (SELECT * FROM TB_Entry_Pages AS pages              INNER JOIN TB_EJ_Entries AS entries                 ON pages.entry_id=entries.id ) AS pagesAndEntries        ON responds.page_id=pagesAndEntries.id        WHERE pagesAndEntries.page_number=? AND        pagesAndEntries.entry_id=? AND        responds.exercise_id=?) AS responds LEFT JOIN TB_Answer_Suggest AS suggest ON responds.chosen_answer=suggest.id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, page);
    _argIndex = 2;
    _statement.bindLong(_argIndex, entryId);
    _argIndex = 3;
    _statement.bindLong(_argIndex, exerciseId);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"TB_EJ_Responds","TB_Entry_Pages","TB_EJ_Entries","TB_Answer_Suggest"}, new Callable<List<EJAnswer>>() {
      @Override
      public List<EJAnswer> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTextAnswer = 0;
          final int _cursorIndexOfAnswer = 1;
          final List<EJAnswer> _result = new ArrayList<EJAnswer>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EJAnswer _item;
            final String _tmpText_answer;
            if (_cursor.isNull(_cursorIndexOfTextAnswer)) {
              _tmpText_answer = null;
            } else {
              _tmpText_answer = _cursor.getString(_cursorIndexOfTextAnswer);
            }
            final String _tmpAnswer;
            if (_cursor.isNull(_cursorIndexOfAnswer)) {
              _tmpAnswer = null;
            } else {
              _tmpAnswer = _cursor.getString(_cursorIndexOfAnswer);
            }
            _item = new EJAnswer(_tmpText_answer,_tmpAnswer);
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
