package pl.nebraszka.selfaid.repositories

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.dao.*
import pl.nebraszka.selfaid.entities.*

class SelfAIDRepository(
    private val emotionDao: EmotionDao,
    private val ejExerciseDao: EJExerciseDao,
    private val ejEntryDao: EJEntryDao,
    private val entryPageDao: EntryPageDao,
    private val ejRespondDao: EJRespondDao
) {
    val allEmotions: Flow<List<Emotion>> = emotionDao.getAlphabetizedEmotions()
    val allExercises: Flow<List<EJExercise>> = ejExerciseDao.getAllExercises()
    val allEntries: Flow<List<EJEntry>> = ejEntryDao.getAllEntries()


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun getEmotion(name: String): Flow<Emotion> {
        return emotionDao.getEmotion(name)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteByEntryId(entryId: Int){
        return ejEntryDao.deleteByEntryId(entryId)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertEntryPage(page: EntryPage): Long {
        return entryPageDao.insertPage(page)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun getEmotionInfo(pageId: Int): Flow<Emotion> {
        return entryPageDao.getEmotion(pageId)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertEntry(entry: EJEntry): Long {
        return ejEntryDao.insert(entry)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun getEntryInfo(entryId: Int): Flow<EJEntry> {
        return ejEntryDao.getEntry(entryId)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun getEntryEmotion(entryId: Int): Flow<Emotion> {
        return ejEntryDao.getEntryEmotion(entryId)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertResponds(responds: List<EJRespond>) {
        ejRespondDao.insertAllResponds(responds)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun getResponds(entryId: Int, page: Int, exerciseId: Int): Flow<List<EJAnswer>> {
        return ejRespondDao.getRespondsForExercise(entryId, page, exerciseId)
    }
}