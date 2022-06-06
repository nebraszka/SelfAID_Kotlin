package pl.nebraszka.selfaid.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "TB_Answer_Suggest",
    foreignKeys = [
        ForeignKey(
            entity = EJExercise::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("question_id"),
            onDelete = ForeignKey.CASCADE
    )]
)
data class AnswerSuggestion(
    @ColumnInfo(name = "answer") val answer: String?,
    @NonNull
    @ColumnInfo(name = "question_id", index = true) val questionId: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}