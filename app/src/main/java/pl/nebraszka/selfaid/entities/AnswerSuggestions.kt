package pl.nebraszka.selfaid.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "TB_Answer_Suggestions",
    foreignKeys = arrayOf(
        ForeignKey(entity = Exercise::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("question_id"),
            onDelete = ForeignKey.CASCADE
        )
    ))
data class AnswerSuggestions(
    @ColumnInfo(name = "answer") val answer: String,
    @ColumnInfo(name = "question_id") val questionId: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1
}