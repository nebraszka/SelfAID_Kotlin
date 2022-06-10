package pl.nebraszka.selfaid.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.entities.EJEntry
import pl.nebraszka.selfaid.entities.Emotion

@Dao
interface EJEntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ejEntry: EJEntry): Long

    @Query("SELECT * FROM TB_EJ_Entries WHERE id=:entryId")
    fun getEntry(entryId: Int): Flow<EJEntry>

    @Query("SELECT * FROM TB_EJ_Entries ORDER BY date DESC")
    fun getAllEntries(): Flow<List<EJEntry>>

    @Query("SELECT COUNT(*) FROM TB_EJ_Entries")
    fun countEntries(): Flow<Int>

    @Query(
        "SELECT pagesWithEmotionInfo.emotion_id AS id," +
                "pagesWithEmotionInfo.emotion, pagesWithEmotionInfo.description " +
                "FROM TB_EJ_Entries AS entries " +
                "INNER JOIN (" +
                "   SELECT * FROM TB_Entry_Pages AS pages" +
                "   INNER JOIN TB_Emotions AS emotions" +
                "       ON pages.emotion_id=emotions.id" +
                ") AS pagesWithEmotionInfo " +
                "   ON pagesWithEmotionInfo.entry_id=entries.id " +
                "WHERE entries.id=:entryId"
    )
    fun getEntryEmotion(entryId: Int): Flow<Emotion>

    @Query("DELETE FROM TB_EJ_Entries WHERE id = :entryId")
    suspend fun deleteByEntryId(entryId: Int)
}