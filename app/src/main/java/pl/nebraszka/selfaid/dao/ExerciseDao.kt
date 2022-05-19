package pl.nebraszka.selfaid.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.entities.Exercise

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM TB_Exercises ORDER BY id ")
        fun getExercises() : Flow<List<Exercise>>

    @Insert(onConflict = OnConflictStrategy.IGNORE )
       suspend fun insert(exercise : Exercise)
}