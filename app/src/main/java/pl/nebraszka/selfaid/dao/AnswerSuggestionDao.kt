package pl.nebraszka.selfaid.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.entities.AnswerSuggestion

@Dao
interface AnswerSuggestionDao {
    @Query("SELECT * FROM TB_Answer_Suggest" )
        fun getAllAnswerSuggestions(): Flow<List<AnswerSuggestion>>
}