package pl.nebraszka.selfaid.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.entities.Emotion

@Dao
interface EmotionDao {

    @Query("SELECT * FROM TB_Emotions ORDER BY emotion ASC")
        fun getAlphabetizedEmotions() : Flow<List<Emotion>>

}