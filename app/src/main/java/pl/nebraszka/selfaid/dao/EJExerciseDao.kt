package pl.nebraszka.selfaid.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.entities.EJExercise

@Dao
interface EJExerciseDao {
    @Query("SELECT * FROM TB_EJ_Exercises ORDER BY exercise_type ")
        fun getExercises() : Flow<List<EJExercise>> // TODO: zakładamy, że dla każdej emocji są te same
                                                    // ale później można dodać kolumnę z id emocji

}