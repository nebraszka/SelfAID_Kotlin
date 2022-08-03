package pl.nebraszka.selfaid.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'\u00a8\u0006\u0006"}, d2 = {"Lpl/nebraszka/selfaid/dao/EJExerciseDao;", "", "getAllExercises", "Lkotlinx/coroutines/flow/Flow;", "", "Lpl/nebraszka/selfaid/entities/EJExercise;", "app_debug"})
public abstract interface EJExerciseDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM TB_EJ_Exercises")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<pl.nebraszka.selfaid.entities.EJExercise>> getAllExercises();
}