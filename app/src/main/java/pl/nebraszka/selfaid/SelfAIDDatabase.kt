package pl.nebraszka.selfaid

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pl.nebraszka.selfaid.dao.EmotionDao
import pl.nebraszka.selfaid.dao.ExerciseDao
import pl.nebraszka.selfaid.dao.ExerciseTypeDao
import pl.nebraszka.selfaid.entities.*
import java.io.File

@Database(
    entities = [
        //AnswerSuggestions::class,
        Emotion::class,
        Exercise::class,
        ExerciseType::class
        /*EmotionsJournal::class,
        EntryPages::class,
        Responds::class*/
    ], version = 4, exportSchema = false // TODO: Do zmiany potem
)
abstract class SelfAIDDatabase: RoomDatabase() {
    abstract fun emotionDao() : EmotionDao
    abstract fun exerciseDao(): ExerciseDao
    abstract fun exerciseTypeDao(): ExerciseTypeDao

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