package pl.nebraszka.selfaid;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pl.nebraszka.selfaid.dao.AnswerSuggestionDao;
import pl.nebraszka.selfaid.dao.AnswerSuggestionDao_Impl;
import pl.nebraszka.selfaid.dao.EJEntryDao;
import pl.nebraszka.selfaid.dao.EJEntryDao_Impl;
import pl.nebraszka.selfaid.dao.EJExerciseDao;
import pl.nebraszka.selfaid.dao.EJExerciseDao_Impl;
import pl.nebraszka.selfaid.dao.EJRespondDao;
import pl.nebraszka.selfaid.dao.EJRespondDao_Impl;
import pl.nebraszka.selfaid.dao.EmotionDao;
import pl.nebraszka.selfaid.dao.EmotionDao_Impl;
import pl.nebraszka.selfaid.dao.EntryPageDao;
import pl.nebraszka.selfaid.dao.EntryPageDao_Impl;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SelfAIDDatabase_Impl extends SelfAIDDatabase {
  private volatile EmotionDao _emotionDao;

  private volatile EJExerciseDao _eJExerciseDao;

  private volatile AnswerSuggestionDao _answerSuggestionDao;

  private volatile EJEntryDao _eJEntryDao;

  private volatile EntryPageDao _entryPageDao;

  private volatile EJRespondDao _eJRespondDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(15) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TB_Emotions` (`emotion` TEXT NOT NULL, `description` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TB_EJ_Exercises` (`topic` TEXT NOT NULL, `exercise_type` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, FOREIGN KEY(`exercise_type`) REFERENCES `TB_Exercise_Types`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_TB_EJ_Exercises_exercise_type` ON `TB_EJ_Exercises` (`exercise_type`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TB_Exercise_Types` (`exercise_type` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TB_Answer_Suggest` (`answer` TEXT, `question_id` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, FOREIGN KEY(`question_id`) REFERENCES `TB_EJ_Exercises`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_TB_Answer_Suggest_question_id` ON `TB_Answer_Suggest` (`question_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TB_EJ_Entries` (`date` TEXT NOT NULL, `title` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TB_Entry_Pages` (`page_number` INTEGER NOT NULL, `emotion_id` INTEGER NOT NULL, `entry_id` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, FOREIGN KEY(`emotion_id`) REFERENCES `TB_Emotions`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`entry_id`) REFERENCES `TB_EJ_Entries`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_TB_Entry_Pages_page_number` ON `TB_Entry_Pages` (`page_number`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_TB_Entry_Pages_emotion_id` ON `TB_Entry_Pages` (`emotion_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_TB_Entry_Pages_entry_id` ON `TB_Entry_Pages` (`entry_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TB_EJ_Responds` (`exercise_id` INTEGER NOT NULL, `page_id` INTEGER NOT NULL, `chosen_answer` INTEGER, `text_answer` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, FOREIGN KEY(`chosen_answer`) REFERENCES `TB_Answer_Suggest`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`page_id`) REFERENCES `TB_Entry_Pages`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`exercise_id`) REFERENCES `TB_EJ_Exercises`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_TB_EJ_Responds_exercise_id` ON `TB_EJ_Responds` (`exercise_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_TB_EJ_Responds_page_id` ON `TB_EJ_Responds` (`page_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_TB_EJ_Responds_chosen_answer` ON `TB_EJ_Responds` (`chosen_answer`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8b966fef1d2ad18e0a5bbb60cc04166b')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `TB_Emotions`");
        _db.execSQL("DROP TABLE IF EXISTS `TB_EJ_Exercises`");
        _db.execSQL("DROP TABLE IF EXISTS `TB_Exercise_Types`");
        _db.execSQL("DROP TABLE IF EXISTS `TB_Answer_Suggest`");
        _db.execSQL("DROP TABLE IF EXISTS `TB_EJ_Entries`");
        _db.execSQL("DROP TABLE IF EXISTS `TB_Entry_Pages`");
        _db.execSQL("DROP TABLE IF EXISTS `TB_EJ_Responds`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTBEmotions = new HashMap<String, TableInfo.Column>(3);
        _columnsTBEmotions.put("emotion", new TableInfo.Column("emotion", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBEmotions.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBEmotions.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTBEmotions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTBEmotions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTBEmotions = new TableInfo("TB_Emotions", _columnsTBEmotions, _foreignKeysTBEmotions, _indicesTBEmotions);
        final TableInfo _existingTBEmotions = TableInfo.read(_db, "TB_Emotions");
        if (! _infoTBEmotions.equals(_existingTBEmotions)) {
          return new RoomOpenHelper.ValidationResult(false, "TB_Emotions(pl.nebraszka.selfaid.entities.Emotion).\n"
                  + " Expected:\n" + _infoTBEmotions + "\n"
                  + " Found:\n" + _existingTBEmotions);
        }
        final HashMap<String, TableInfo.Column> _columnsTBEJExercises = new HashMap<String, TableInfo.Column>(3);
        _columnsTBEJExercises.put("topic", new TableInfo.Column("topic", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBEJExercises.put("exercise_type", new TableInfo.Column("exercise_type", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBEJExercises.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTBEJExercises = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysTBEJExercises.add(new TableInfo.ForeignKey("TB_Exercise_Types", "CASCADE", "NO ACTION",Arrays.asList("exercise_type"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesTBEJExercises = new HashSet<TableInfo.Index>(1);
        _indicesTBEJExercises.add(new TableInfo.Index("index_TB_EJ_Exercises_exercise_type", false, Arrays.asList("exercise_type"), Arrays.asList("ASC")));
        final TableInfo _infoTBEJExercises = new TableInfo("TB_EJ_Exercises", _columnsTBEJExercises, _foreignKeysTBEJExercises, _indicesTBEJExercises);
        final TableInfo _existingTBEJExercises = TableInfo.read(_db, "TB_EJ_Exercises");
        if (! _infoTBEJExercises.equals(_existingTBEJExercises)) {
          return new RoomOpenHelper.ValidationResult(false, "TB_EJ_Exercises(pl.nebraszka.selfaid.entities.EJExercise).\n"
                  + " Expected:\n" + _infoTBEJExercises + "\n"
                  + " Found:\n" + _existingTBEJExercises);
        }
        final HashMap<String, TableInfo.Column> _columnsTBExerciseTypes = new HashMap<String, TableInfo.Column>(2);
        _columnsTBExerciseTypes.put("exercise_type", new TableInfo.Column("exercise_type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBExerciseTypes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTBExerciseTypes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTBExerciseTypes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTBExerciseTypes = new TableInfo("TB_Exercise_Types", _columnsTBExerciseTypes, _foreignKeysTBExerciseTypes, _indicesTBExerciseTypes);
        final TableInfo _existingTBExerciseTypes = TableInfo.read(_db, "TB_Exercise_Types");
        if (! _infoTBExerciseTypes.equals(_existingTBExerciseTypes)) {
          return new RoomOpenHelper.ValidationResult(false, "TB_Exercise_Types(pl.nebraszka.selfaid.entities.ExerciseType).\n"
                  + " Expected:\n" + _infoTBExerciseTypes + "\n"
                  + " Found:\n" + _existingTBExerciseTypes);
        }
        final HashMap<String, TableInfo.Column> _columnsTBAnswerSuggest = new HashMap<String, TableInfo.Column>(3);
        _columnsTBAnswerSuggest.put("answer", new TableInfo.Column("answer", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBAnswerSuggest.put("question_id", new TableInfo.Column("question_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBAnswerSuggest.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTBAnswerSuggest = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysTBAnswerSuggest.add(new TableInfo.ForeignKey("TB_EJ_Exercises", "CASCADE", "NO ACTION",Arrays.asList("question_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesTBAnswerSuggest = new HashSet<TableInfo.Index>(1);
        _indicesTBAnswerSuggest.add(new TableInfo.Index("index_TB_Answer_Suggest_question_id", false, Arrays.asList("question_id"), Arrays.asList("ASC")));
        final TableInfo _infoTBAnswerSuggest = new TableInfo("TB_Answer_Suggest", _columnsTBAnswerSuggest, _foreignKeysTBAnswerSuggest, _indicesTBAnswerSuggest);
        final TableInfo _existingTBAnswerSuggest = TableInfo.read(_db, "TB_Answer_Suggest");
        if (! _infoTBAnswerSuggest.equals(_existingTBAnswerSuggest)) {
          return new RoomOpenHelper.ValidationResult(false, "TB_Answer_Suggest(pl.nebraszka.selfaid.entities.AnswerSuggestion).\n"
                  + " Expected:\n" + _infoTBAnswerSuggest + "\n"
                  + " Found:\n" + _existingTBAnswerSuggest);
        }
        final HashMap<String, TableInfo.Column> _columnsTBEJEntries = new HashMap<String, TableInfo.Column>(3);
        _columnsTBEJEntries.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBEJEntries.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBEJEntries.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTBEJEntries = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTBEJEntries = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTBEJEntries = new TableInfo("TB_EJ_Entries", _columnsTBEJEntries, _foreignKeysTBEJEntries, _indicesTBEJEntries);
        final TableInfo _existingTBEJEntries = TableInfo.read(_db, "TB_EJ_Entries");
        if (! _infoTBEJEntries.equals(_existingTBEJEntries)) {
          return new RoomOpenHelper.ValidationResult(false, "TB_EJ_Entries(pl.nebraszka.selfaid.entities.EJEntry).\n"
                  + " Expected:\n" + _infoTBEJEntries + "\n"
                  + " Found:\n" + _existingTBEJEntries);
        }
        final HashMap<String, TableInfo.Column> _columnsTBEntryPages = new HashMap<String, TableInfo.Column>(4);
        _columnsTBEntryPages.put("page_number", new TableInfo.Column("page_number", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBEntryPages.put("emotion_id", new TableInfo.Column("emotion_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBEntryPages.put("entry_id", new TableInfo.Column("entry_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBEntryPages.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTBEntryPages = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysTBEntryPages.add(new TableInfo.ForeignKey("TB_Emotions", "CASCADE", "NO ACTION",Arrays.asList("emotion_id"), Arrays.asList("id")));
        _foreignKeysTBEntryPages.add(new TableInfo.ForeignKey("TB_EJ_Entries", "CASCADE", "NO ACTION",Arrays.asList("entry_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesTBEntryPages = new HashSet<TableInfo.Index>(3);
        _indicesTBEntryPages.add(new TableInfo.Index("index_TB_Entry_Pages_page_number", false, Arrays.asList("page_number"), Arrays.asList("ASC")));
        _indicesTBEntryPages.add(new TableInfo.Index("index_TB_Entry_Pages_emotion_id", false, Arrays.asList("emotion_id"), Arrays.asList("ASC")));
        _indicesTBEntryPages.add(new TableInfo.Index("index_TB_Entry_Pages_entry_id", false, Arrays.asList("entry_id"), Arrays.asList("ASC")));
        final TableInfo _infoTBEntryPages = new TableInfo("TB_Entry_Pages", _columnsTBEntryPages, _foreignKeysTBEntryPages, _indicesTBEntryPages);
        final TableInfo _existingTBEntryPages = TableInfo.read(_db, "TB_Entry_Pages");
        if (! _infoTBEntryPages.equals(_existingTBEntryPages)) {
          return new RoomOpenHelper.ValidationResult(false, "TB_Entry_Pages(pl.nebraszka.selfaid.entities.EntryPage).\n"
                  + " Expected:\n" + _infoTBEntryPages + "\n"
                  + " Found:\n" + _existingTBEntryPages);
        }
        final HashMap<String, TableInfo.Column> _columnsTBEJResponds = new HashMap<String, TableInfo.Column>(5);
        _columnsTBEJResponds.put("exercise_id", new TableInfo.Column("exercise_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBEJResponds.put("page_id", new TableInfo.Column("page_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBEJResponds.put("chosen_answer", new TableInfo.Column("chosen_answer", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBEJResponds.put("text_answer", new TableInfo.Column("text_answer", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTBEJResponds.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTBEJResponds = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysTBEJResponds.add(new TableInfo.ForeignKey("TB_Answer_Suggest", "CASCADE", "NO ACTION",Arrays.asList("chosen_answer"), Arrays.asList("id")));
        _foreignKeysTBEJResponds.add(new TableInfo.ForeignKey("TB_Entry_Pages", "CASCADE", "NO ACTION",Arrays.asList("page_id"), Arrays.asList("id")));
        _foreignKeysTBEJResponds.add(new TableInfo.ForeignKey("TB_EJ_Exercises", "CASCADE", "NO ACTION",Arrays.asList("exercise_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesTBEJResponds = new HashSet<TableInfo.Index>(3);
        _indicesTBEJResponds.add(new TableInfo.Index("index_TB_EJ_Responds_exercise_id", false, Arrays.asList("exercise_id"), Arrays.asList("ASC")));
        _indicesTBEJResponds.add(new TableInfo.Index("index_TB_EJ_Responds_page_id", false, Arrays.asList("page_id"), Arrays.asList("ASC")));
        _indicesTBEJResponds.add(new TableInfo.Index("index_TB_EJ_Responds_chosen_answer", false, Arrays.asList("chosen_answer"), Arrays.asList("ASC")));
        final TableInfo _infoTBEJResponds = new TableInfo("TB_EJ_Responds", _columnsTBEJResponds, _foreignKeysTBEJResponds, _indicesTBEJResponds);
        final TableInfo _existingTBEJResponds = TableInfo.read(_db, "TB_EJ_Responds");
        if (! _infoTBEJResponds.equals(_existingTBEJResponds)) {
          return new RoomOpenHelper.ValidationResult(false, "TB_EJ_Responds(pl.nebraszka.selfaid.entities.EJRespond).\n"
                  + " Expected:\n" + _infoTBEJResponds + "\n"
                  + " Found:\n" + _existingTBEJResponds);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "8b966fef1d2ad18e0a5bbb60cc04166b", "5b887ac164b75ef2463313b6b3eefed1");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "TB_Emotions","TB_EJ_Exercises","TB_Exercise_Types","TB_Answer_Suggest","TB_EJ_Entries","TB_Entry_Pages","TB_EJ_Responds");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `TB_Emotions`");
      _db.execSQL("DELETE FROM `TB_EJ_Exercises`");
      _db.execSQL("DELETE FROM `TB_Exercise_Types`");
      _db.execSQL("DELETE FROM `TB_Answer_Suggest`");
      _db.execSQL("DELETE FROM `TB_EJ_Entries`");
      _db.execSQL("DELETE FROM `TB_Entry_Pages`");
      _db.execSQL("DELETE FROM `TB_EJ_Responds`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(EmotionDao.class, EmotionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EJExerciseDao.class, EJExerciseDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AnswerSuggestionDao.class, AnswerSuggestionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EJEntryDao.class, EJEntryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EntryPageDao.class, EntryPageDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EJRespondDao.class, EJRespondDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public EmotionDao emotionDao() {
    if (_emotionDao != null) {
      return _emotionDao;
    } else {
      synchronized(this) {
        if(_emotionDao == null) {
          _emotionDao = new EmotionDao_Impl(this);
        }
        return _emotionDao;
      }
    }
  }

  @Override
  public EJExerciseDao exerciseDao() {
    if (_eJExerciseDao != null) {
      return _eJExerciseDao;
    } else {
      synchronized(this) {
        if(_eJExerciseDao == null) {
          _eJExerciseDao = new EJExerciseDao_Impl(this);
        }
        return _eJExerciseDao;
      }
    }
  }

  @Override
  public AnswerSuggestionDao answerSuggestionDao() {
    if (_answerSuggestionDao != null) {
      return _answerSuggestionDao;
    } else {
      synchronized(this) {
        if(_answerSuggestionDao == null) {
          _answerSuggestionDao = new AnswerSuggestionDao_Impl(this);
        }
        return _answerSuggestionDao;
      }
    }
  }

  @Override
  public EJEntryDao ejEntryDao() {
    if (_eJEntryDao != null) {
      return _eJEntryDao;
    } else {
      synchronized(this) {
        if(_eJEntryDao == null) {
          _eJEntryDao = new EJEntryDao_Impl(this);
        }
        return _eJEntryDao;
      }
    }
  }

  @Override
  public EntryPageDao entryPageDao() {
    if (_entryPageDao != null) {
      return _entryPageDao;
    } else {
      synchronized(this) {
        if(_entryPageDao == null) {
          _entryPageDao = new EntryPageDao_Impl(this);
        }
        return _entryPageDao;
      }
    }
  }

  @Override
  public EJRespondDao ejRespondDao() {
    if (_eJRespondDao != null) {
      return _eJRespondDao;
    } else {
      synchronized(this) {
        if(_eJRespondDao == null) {
          _eJRespondDao = new EJRespondDao_Impl(this);
        }
        return _eJRespondDao;
      }
    }
  }
}
