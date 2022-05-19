package pl.nebraszka.selfaid.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.entities.ExerciseType

@Dao
interface ExerciseTypeDao {

    @Query("SELECT * FROM TB_Exercise_Types ")
    fun getExerciseTypes(): Flow<List<ExerciseType>>

}