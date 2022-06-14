package pl.nebraszka.selfaid.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "TB_EJ_Responds",
    foreignKeys = [
        ForeignKey(
            entity = AnswerSuggestion::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("chosen_answer"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = EntryPage::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("page_id"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = EJExercise::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("exercise_id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class EJRespond(
    @NonNull
    @ColumnInfo(name = "exercise_id", index = true) val exerciseId: Int,
    @NonNull
    @ColumnInfo(name = "page_id", index = true) val pageId: Int,
    @ColumnInfo(name = "chosen_answer", index = true) val choosenAnsw: Int? = null,
    @ColumnInfo(name = "text_answer") val textAnsw: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}