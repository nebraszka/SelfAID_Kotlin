package pl.nebraszka.selfaid.repositories

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.dao.*
import pl.nebraszka.selfaid.entities.*

class SelfAIDRepository(
    private val emotionDao: EmotionDao,
    private val ejExerciseDao: EJExerciseDao,
    private val answerSuggestionDao: AnswerSuggestionDao,
    private val ejEntryDao: EJEntryDao,
    private val entryPageDao: EntryPageDao,
    private val ejRespondDao: EJRespondDao
) {
    val allEmotions: Flow<List<Emotion>> = emotionDao.getAlphabetizedEmotions()
    val allExercises: Flow<List<EJExercise>> = ejExerciseDao.getExercises()
    val allEntries: Flow<List<EJEntry>> = ejEntryDao.getEntries()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun countEntries(): Flow<Int>{
        return ejEntryDao.countEntries()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun getEmotion(name: String): Flow<Emotion> {
        return emotionDao.getEmotion(name)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun getAnswerSuggestions(questionId: Int): Flow<List<AnswerSuggestion>> {
        return answerSuggestionDao.getAllAnswerSuggestions(questionId)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertEntryPage(page: EntryPage): Long {
        return entryPageDao.insertPage(page)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertEntry(entry: EJEntry): Long {
        return ejEntryDao.insert(entry)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertResponds(responds: List<EJRespond>) {
        ejRespondDao.insertAll(responds)
    }
}