package pl.nebraszka.selfaid.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.entities.EJRespond

@Dao
interface EJRespondDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    @JvmSuppressWildcards
    suspend fun insertAll(responds: List<EJRespond>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRespond(respond: EJRespond)

}