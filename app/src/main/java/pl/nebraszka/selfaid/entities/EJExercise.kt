package pl.nebraszka.selfaid.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "TB_EJ_Exercises",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = ExerciseType::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("exercise_type"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class EJExercise(
    @NonNull
    @ColumnInfo(name = "topic") val topic: String,
    @NonNull
    @ColumnInfo(name = "exercise_type", index = true) val exerciseType: Int,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}