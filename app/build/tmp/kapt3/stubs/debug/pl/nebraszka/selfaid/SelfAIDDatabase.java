package pl.nebraszka.selfaid;

import java.lang.System;

@androidx.room.Database(entities = {pl.nebraszka.selfaid.entities.Emotion.class, pl.nebraszka.selfaid.entities.EJExercise.class, pl.nebraszka.selfaid.entities.ExerciseType.class, pl.nebraszka.selfaid.entities.AnswerSuggestion.class, pl.nebraszka.selfaid.entities.EJEntry.class, pl.nebraszka.selfaid.entities.EntryPage.class, pl.nebraszka.selfaid.entities.EJRespond.class}, version = 15, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u0010"}, d2 = {"Lpl/nebraszka/selfaid/SelfAIDDatabase;", "Landroidx/room/RoomDatabase;", "()V", "answerSuggestionDao", "Lpl/nebraszka/selfaid/dao/AnswerSuggestionDao;", "ejEntryDao", "Lpl/nebraszka/selfaid/dao/EJEntryDao;", "ejRespondDao", "Lpl/nebraszka/selfaid/dao/EJRespondDao;", "emotionDao", "Lpl/nebraszka/selfaid/dao/EmotionDao;", "entryPageDao", "Lpl/nebraszka/selfaid/dao/EntryPageDao;", "exerciseDao", "Lpl/nebraszka/selfaid/dao/EJExerciseDao;", "Companion", "app_debug"})
public abstract class SelfAIDDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final pl.nebraszka.selfaid.SelfAIDDatabase.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile pl.nebraszka.selfaid.SelfAIDDatabase INSTANCE;
    
    public SelfAIDDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract pl.nebraszka.selfaid.dao.EmotionDao emotionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract pl.nebraszka.selfaid.dao.EJExerciseDao exerciseDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract pl.nebraszka.selfaid.dao.AnswerSuggestionDao answerSuggestionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract pl.nebraszka.selfaid.dao.EJEntryDao ejEntryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract pl.nebraszka.selfaid.dao.EntryPageDao entryPageDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract pl.nebraszka.selfaid.dao.EJRespondDao ejRespondDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lpl/nebraszka/selfaid/SelfAIDDatabase$Companion;", "", "()V", "INSTANCE", "Lpl/nebraszka/selfaid/SelfAIDDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final pl.nebraszka.selfaid.SelfAIDDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}