package pl.nebraszka.selfaid

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.nebraszka.selfaid.dao.AnswerSuggestionDao
import pl.nebraszka.selfaid.dao.EmotionDao
import pl.nebraszka.selfaid.dao.EJExerciseDao
import pl.nebraszka.selfaid.dao.EJRespondDao
import pl.nebraszka.selfaid.entities.*

@Database(
    entities = [
        Emotion::class,
        EJExercise::class,
        ExerciseType::class,
        AnswerSuggestion::class
    ], version = 6, exportSchema = false // TODO: Do zmiany potem
)
abstract class SelfAIDDatabase: RoomDatabase() {
    abstract fun emotionDao() : EmotionDao
    abstract fun exerciseDao(): EJExerciseDao
    abstract fun answerSuggestionDao(): AnswerSuggestionDao

    companion object{

        @Volatile
        private var INSTANCE : SelfAIDDatabase? = null

        fun getDatabase(context: Context) : SelfAIDDatabase{

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SelfAIDDatabase::class.java,
                    "SelfAID.db"
                )
                    .createFromAsset("database/selfaid.db")
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}