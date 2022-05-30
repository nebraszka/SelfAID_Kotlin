package pl.nebraszka.selfaid.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import pl.nebraszka.selfaid.entities.EntryPage

@Dao
interface EntryPageDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPage(page: EntryPage): Long
}