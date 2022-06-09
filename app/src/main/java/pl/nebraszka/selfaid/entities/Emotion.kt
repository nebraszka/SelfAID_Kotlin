package pl.nebraszka.selfaid.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_Emotions")
data class Emotion(
    @NonNull
    @ColumnInfo(name = "emotion") val emotion: String,
    @NonNull
    @ColumnInfo(name = "description") val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}