package pl.nebraszka.selfaid.repositories

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.dao.EmotionDao
import pl.nebraszka.selfaid.dao.ExerciseDao
import pl.nebraszka.selfaid.dao.ExerciseTypeDao
import pl.nebraszka.selfaid.entities.Emotion
import pl.nebraszka.selfaid.entities.Exercise
import pl.nebraszka.selfaid.entities.ExerciseType

class SelfAIDRepository( // TODO: czy da sie bez tego?
    private val emotionDao: EmotionDao,
    private val exerciseDao: ExerciseDao,
    private val exerciseTypeDao: ExerciseTypeDao
    )
{
    val allEmotions: Flow<List<Emotion>> = emotionDao.getAlphabetizedEmotions()
    val allExerciseTypes: Flow<List<ExerciseType>> = exerciseTypeDao.getExerciseTypes()
    val allExercises: Flow<List<Exercise>> = exerciseDao.getExercises()

}