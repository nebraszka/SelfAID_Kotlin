package pl.nebraszka.selfaid.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\'J\u001f\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lpl/nebraszka/selfaid/dao/EJRespondDao;", "", "getRespondsForExercise", "Lkotlinx/coroutines/flow/Flow;", "", "Lpl/nebraszka/selfaid/entities/EJAnswer;", "entryId", "", "page", "exerciseId", "insertAllResponds", "", "responds", "Lpl/nebraszka/selfaid/entities/EJRespond;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertRespond", "respond", "(Lpl/nebraszka/selfaid/entities/EJRespond;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface EJRespondDao {
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.JvmSuppressWildcards()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object insertAllResponds(@org.jetbrains.annotations.NotNull()
    java.util.List<pl.nebraszka.selfaid.entities.EJRespond> responds, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object insertRespond(@org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.entities.EJRespond respond, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT responds.text_answer, suggest.answer FROM (SELECT  text_answer, chosen_answer        FROM TB_EJ_Responds AS responds        INNER JOIN        (SELECT * FROM TB_Entry_Pages AS pages              INNER JOIN TB_EJ_Entries AS entries                 ON pages.entry_id=entries.id ) AS pagesAndEntries        ON responds.page_id=pagesAndEntries.id        WHERE pagesAndEntries.page_number=:page AND        pagesAndEntries.entry_id=:entryId AND        responds.exercise_id=:exerciseId) AS responds LEFT JOIN TB_Answer_Suggest AS suggest ON responds.chosen_answer=suggest.id")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<pl.nebraszka.selfaid.entities.EJAnswer>> getRespondsForExercise(int entryId, int page, int exerciseId);
}