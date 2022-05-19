package pl.nebraszka.selfaid.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "TB_Responds",
    foreignKeys = arrayOf(
        ForeignKey(entity = Exercise::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("exercise_id"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(entity = EntryPages::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("page_id"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(entity = AnswerSuggestions::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("chosen_answer"),
            onDelete = ForeignKey.CASCADE
        )
    ))
data class Responds(
    @ColumnInfo(name = "exercise_id") val exerciseId: Int,
    @ColumnInfo(name = "page_id") val pageId: Int,
    @ColumnInfo(defaultValue = "NULL", name = "chosen_answer") val choosenAnsw: String?,
    @ColumnInfo(defaultValue = "NULL", name = "text_answer") val textAnsw: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1
}