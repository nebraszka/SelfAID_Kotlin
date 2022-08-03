package pl.nebraszka.selfaid.repositories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0014H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\u0019\u0010\'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*J\u001f\u0010+\u001a\u00020\u001a2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u000fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010.R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006/"}, d2 = {"Lpl/nebraszka/selfaid/repositories/SelfAIDRepository;", "", "emotionDao", "Lpl/nebraszka/selfaid/dao/EmotionDao;", "ejExerciseDao", "Lpl/nebraszka/selfaid/dao/EJExerciseDao;", "ejEntryDao", "Lpl/nebraszka/selfaid/dao/EJEntryDao;", "entryPageDao", "Lpl/nebraszka/selfaid/dao/EntryPageDao;", "ejRespondDao", "Lpl/nebraszka/selfaid/dao/EJRespondDao;", "(Lpl/nebraszka/selfaid/dao/EmotionDao;Lpl/nebraszka/selfaid/dao/EJExerciseDao;Lpl/nebraszka/selfaid/dao/EJEntryDao;Lpl/nebraszka/selfaid/dao/EntryPageDao;Lpl/nebraszka/selfaid/dao/EJRespondDao;)V", "allEmotions", "Lkotlinx/coroutines/flow/Flow;", "", "Lpl/nebraszka/selfaid/entities/Emotion;", "getAllEmotions", "()Lkotlinx/coroutines/flow/Flow;", "allEntries", "Lpl/nebraszka/selfaid/entities/EJEntry;", "getAllEntries", "allExercises", "Lpl/nebraszka/selfaid/entities/EJExercise;", "getAllExercises", "deleteByEntryId", "", "entryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEmotion", "name", "", "getEntryEmotion", "getEntryInfo", "insertEntry", "", "entry", "(Lpl/nebraszka/selfaid/entities/EJEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertEntryPage", "page", "Lpl/nebraszka/selfaid/entities/EntryPage;", "(Lpl/nebraszka/selfaid/entities/EntryPage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertResponds", "responds", "Lpl/nebraszka/selfaid/entities/EJRespond;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SelfAIDRepository {
    private final pl.nebraszka.selfaid.dao.EmotionDao emotionDao = null;
    private final pl.nebraszka.selfaid.dao.EJExerciseDao ejExerciseDao = null;
    private final pl.nebraszka.selfaid.dao.EJEntryDao ejEntryDao = null;
    private final pl.nebraszka.selfaid.dao.EntryPageDao entryPageDao = null;
    private final pl.nebraszka.selfaid.dao.EJRespondDao ejRespondDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<pl.nebraszka.selfaid.entities.Emotion>> allEmotions = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<pl.nebraszka.selfaid.entities.EJExercise>> allExercises = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<pl.nebraszka.selfaid.entities.EJEntry>> allEntries = null;
    
    public SelfAIDRepository(@org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.dao.EmotionDao emotionDao, @org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.dao.EJExerciseDao ejExerciseDao, @org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.dao.EJEntryDao ejEntryDao, @org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.dao.EntryPageDao entryPageDao, @org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.dao.EJRespondDao ejRespondDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<pl.nebraszka.selfaid.entities.Emotion>> getAllEmotions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<pl.nebraszka.selfaid.entities.EJExercise>> getAllExercises() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<pl.nebraszka.selfaid.entities.EJEntry>> getAllEntries() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final kotlinx.coroutines.flow.Flow<pl.nebraszka.selfaid.entities.Emotion> getEmotion(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object deleteByEntryId(int entryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insertEntryPage(@org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.entities.EntryPage page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insertEntry(@org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.entities.EJEntry entry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final kotlinx.coroutines.flow.Flow<pl.nebraszka.selfaid.entities.EJEntry> getEntryInfo(int entryId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final kotlinx.coroutines.flow.Flow<pl.nebraszka.selfaid.entities.Emotion> getEntryEmotion(int entryId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insertResponds(@org.jetbrains.annotations.NotNull()
    java.util.List<pl.nebraszka.selfaid.entities.EJRespond> responds, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}