package pl.nebraszka.selfaid.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.entities.EJExercise

@Dao
interface EJExerciseDao {
    @Query("SELECT * FROM TB_EJ_Exercises")
    fun getAllExercises(): Flow<List<EJExercise>>
}