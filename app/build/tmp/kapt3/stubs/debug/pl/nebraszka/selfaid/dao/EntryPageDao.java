package pl.nebraszka.selfaid.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lpl/nebraszka/selfaid/dao/EntryPageDao;", "", "getEmotion", "Lkotlinx/coroutines/flow/Flow;", "Lpl/nebraszka/selfaid/entities/Emotion;", "pageId", "", "insertPage", "", "page", "Lpl/nebraszka/selfaid/entities/EntryPage;", "(Lpl/nebraszka/selfaid/entities/EntryPage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface EntryPageDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object insertPage(@org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.entities.EntryPage page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT emotions.* FROM TB_Entry_Pages AS pages INNER JOIN TB_Emotions AS emotions ON pages.emotion_id=emotions.id WHERE pages.id=:pageId")
    public abstract kotlinx.coroutines.flow.Flow<pl.nebraszka.selfaid.entities.Emotion> getEmotion(int pageId);
}