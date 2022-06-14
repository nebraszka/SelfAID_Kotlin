package pl.nebraszka.selfaid.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_Exercise_Types")
data class ExerciseType(
    @NonNull
    @ColumnInfo(name = "exercise_type") val exerciseType: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}