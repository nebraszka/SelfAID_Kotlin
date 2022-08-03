package pl.nebraszka.selfaid.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0003H\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\u0007\u001a\u00020\u0004H\'J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0007\u001a\u00020\u0004H\'J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lpl/nebraszka/selfaid/dao/EJEntryDao;", "", "countEntries", "Lkotlinx/coroutines/flow/Flow;", "", "deleteByEntryId", "", "entryId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEntries", "", "Lpl/nebraszka/selfaid/entities/EJEntry;", "getEntry", "getEntryEmotion", "Lpl/nebraszka/selfaid/entities/Emotion;", "insert", "", "ejEntry", "(Lpl/nebraszka/selfaid/entities/EJEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface EJEntryDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.entities.EJEntry ejEntry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM TB_EJ_Entries WHERE id=:entryId")
    public abstract kotlinx.coroutines.flow.Flow<pl.nebraszka.selfaid.entities.EJEntry> getEntry(int entryId);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM TB_EJ_Entries ORDER BY date DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<pl.nebraszka.selfaid.entities.EJEntry>> getAllEntries();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT COUNT(*) FROM TB_EJ_Entries")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> countEntries();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT pagesWithEmotionInfo.emotion_id AS id,pagesWithEmotionInfo.emotion, pagesWithEmotionInfo.description FROM TB_EJ_Entries AS entries INNER JOIN (   SELECT * FROM TB_Entry_Pages AS pages   INNER JOIN TB_Emotions AS emotions       ON pages.emotion_id=emotions.id) AS pagesWithEmotionInfo    ON pagesWithEmotionInfo.entry_id=entries.id WHERE entries.id=:entryId")
    public abstract kotlinx.coroutines.flow.Flow<pl.nebraszka.selfaid.entities.Emotion> getEntryEmotion(int entryId);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM TB_EJ_Entries WHERE id = :entryId")
    public abstract java.lang.Object deleteByEntryId(int entryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}