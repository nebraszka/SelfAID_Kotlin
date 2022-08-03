package pl.nebraszka.selfaid.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\t"}, d2 = {"Lpl/nebraszka/selfaid/dao/EmotionDao;", "", "getAlphabetizedEmotions", "Lkotlinx/coroutines/flow/Flow;", "", "Lpl/nebraszka/selfaid/entities/Emotion;", "getEmotion", "name", "", "app_debug"})
public abstract interface EmotionDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM TB_Emotions ORDER BY emotion ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<pl.nebraszka.selfaid.entities.Emotion>> getAlphabetizedEmotions();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM TB_Emotions WHERE emotion == :name")
    public abstract kotlinx.coroutines.flow.Flow<pl.nebraszka.selfaid.entities.Emotion> getEmotion(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
}