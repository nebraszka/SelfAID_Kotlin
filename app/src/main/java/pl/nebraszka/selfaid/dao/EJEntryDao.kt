package pl.nebraszka.selfaid.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.entities.EJEntry

@Dao
interface EJEntryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ejEntry: EJEntry): Long

    @Query("SELECT * FROM TB_EJ_Entries")
    fun getEntries(): Flow<List<EJEntry>>

    @Query("SELECT COUNT(*) FROM TB_EJ_Entries")
    fun countEntries(): Flow<Int>
}