package pl.nebraszka.selfaid.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "TB_Entry_Pages",
    foreignKeys = arrayOf(
        ForeignKey(entity = EmotionsJournal::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("entry_id"),
        onDelete = CASCADE),
        ForeignKey(entity = Emotion::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("emotion_id"),
        onDelete = CASCADE)
    ))
data class EntryPages(
    @ColumnInfo(name = "page_number") val pageNo: Int,
    @ColumnInfo(name = "emotion_id") val emotionId: Int,
    @ColumnInfo(name = "entry_id") val entryId: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1
}